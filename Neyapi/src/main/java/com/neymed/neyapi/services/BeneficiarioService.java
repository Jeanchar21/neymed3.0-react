package com.neymed.neyapi.services;

import com.neymed.neyapi.DTO.BeneficiarioResponseDTO;
import com.neymed.neyapi.models.Beneficiario;
import com.neymed.neyapi.repositories.BeneficiarioRepository;
import com.neymed.neyapi.services.exceptions.DataIntegretionException;
import com.neymed.neyapi.services.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class BeneficiarioService {
    @Autowired
    private BeneficiarioRepository repository;

    public List<Beneficiario> findAll(){
        List<Beneficiario> beneficiarios = repository.findAll();
        return beneficiarios;
    }

    public BeneficiarioResponseDTO findById(Long id) {
        Optional<Beneficiario> result = repository.findById(id);

        result.orElseThrow(() -> new NotFoundException(id));

        return new BeneficiarioResponseDTO(result.get());
    }

    public Beneficiario save(BeneficiarioResponseDTO dto){

        this.verificaCpfExistente(dto.getCpfval());
        this.validCpf(dto.getCpfval());
        Beneficiario beneficiario = new Beneficiario(dto);
        this.gerarChave(beneficiario);

        repository.save(beneficiario);

        return beneficiario;
    }

    public Beneficiario update( Long id, Beneficiario beneficiario){

        Beneficiario beneficiarioBanco = repository.findById(id).get();

        beneficiarioBanco.setNome(beneficiario.getNome() != null ? beneficiario.getNome() : beneficiarioBanco.getNome());
        beneficiarioBanco.setNomesocial(beneficiario.getNomesocial() != null ? beneficiario.getNomesocial() : beneficiarioBanco.getNomesocial());
        beneficiarioBanco.setNasc(beneficiario.getNasc() != null ? beneficiario.getNasc() : beneficiarioBanco.getNasc());
        beneficiarioBanco.setCpfval(beneficiario.getCpfval() != null ? beneficiario.getCpfval() : beneficiarioBanco.getCpfval());
        beneficiarioBanco.setRg(beneficiario.getRg() != null ? beneficiario.getRg() : beneficiarioBanco.getRg());
        beneficiarioBanco.setSexo(beneficiario.getSexo() != null ? beneficiario.getSexo() : beneficiarioBanco.getSexo());
        beneficiarioBanco.setEstadocivil(beneficiario.getEstadocivil() != null ? beneficiario.getEstadocivil() : beneficiarioBanco.getEstadocivil());
        beneficiarioBanco.setEscolaridade(beneficiario.getEscolaridade() != null ? beneficiario.getEscolaridade() : beneficiarioBanco.getEscolaridade());
        beneficiarioBanco.setCel(beneficiario.getCel() != null ? beneficiario.getCel() : beneficiarioBanco.getCel());
        beneficiarioBanco.setTp_ben(beneficiario.getTp_ben() != null ? beneficiario.getTp_ben() : beneficiarioBanco.getTp_ben());
        beneficiarioBanco.setUfemissor(beneficiario.getUfemissor() != null ? beneficiario.getUfemissor() : beneficiarioBanco.getUfemissor());
        beneficiarioBanco.setCdd(beneficiario.getCdd() != null ? beneficiario.getCdd() : beneficiarioBanco.getCdd());
        beneficiarioBanco.setBairro(beneficiario.getBairro() != null ? beneficiario.getBairro() : beneficiarioBanco.getBairro());
        beneficiarioBanco.setUf(beneficiario.getUf() != null ? beneficiario.getUf() : beneficiarioBanco.getUf());
        beneficiarioBanco.setOem(beneficiario.getOem() != null ? beneficiario.getOem() : beneficiarioBanco.getOem());
        beneficiarioBanco.setDt_inscricao(beneficiario.getDt_inscricao() != null ? beneficiario.getDt_inscricao() : beneficiarioBanco.getDt_inscricao());
        beneficiarioBanco.setEmail(beneficiario.getEmail() != null ? beneficiario.getEmail() : beneficiarioBanco.getEmail());
        beneficiarioBanco.setNmpai(beneficiario.getNmpai() != null ? beneficiario.getNmpai() : beneficiarioBanco.getNmpai());
        beneficiarioBanco.setNmmae(beneficiario.getNmmae() != null ? beneficiario.getNmmae() : beneficiarioBanco.getNmmae());
        beneficiarioBanco.setEndr(beneficiario.getEndr() != null ? beneficiario.getEndr() : beneficiarioBanco.getEndr());
        beneficiarioBanco.setComp(beneficiario.getComp() != null ? beneficiario.getComp() : beneficiarioBanco.getComp());
        beneficiarioBanco.setPais(beneficiario.getPais() != null ? beneficiario.getPais() : beneficiarioBanco.getPais());
        this.validCpf(beneficiario.getCpfval());

        repository.saveAndFlush(beneficiarioBanco);

        return  beneficiarioBanco;

    }

    public void delete(Long id){
        if(repository.existsById(id)){
            repository.deleteById(id);
        }
    }
    private void gerarChave(Beneficiario beneficiario) {

        int comprimento = 3;

        StringBuilder chave = new StringBuilder();
        String caracteresPermitidos = "0123456789";

        Random random = new Random();

        for (int i = 0; i < comprimento; i++) {
            int index = random.nextInt(caracteresPermitidos.length());
            char caractere = caracteresPermitidos.charAt(index);
            chave.append(caractere);
        }

        beneficiario.setChave(chave.toString());
    }

    private void validCpf(String cpfval){//129.880.594 - 54 = 12988059454
        var cpf = cpfval.replaceAll("-", "");
            cpf = cpf.replaceAll(" ", "");
            cpf = cpf.replaceAll("\\.", "");
        if (cpf.equals("00000000000") ||
                cpf.equals("11111111111") ||
                cpf.equals("22222222222") || cpf.equals("33333333333") ||
                cpf.equals("44444444444") || cpf.equals("55555555555") ||
                cpf.equals("66666666666") || cpf.equals("77777777777") ||
                cpf.equals("88888888888") || cpf.equals("99999999999") ||
                (cpf.length() != 11))
            throw new DataIntegretionException("cpf inválido!");

        char dig10, dig11;
        int sm, i, r, num, peso;

        try {
            sm = 0;
            peso = 10;
            for (i=0; i<9; i++) {
                num = (int)(cpf.charAt(i) - 48);
                sm += (num * peso);
                peso--;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = 0;
            else dig10 = (char)(r + 48);

            sm = 0;
            peso = 11;
            for(i=0; i<10; i++) {
                num = (int)(cpf.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig11 = 0;
            else dig11 = (char)(r + 48);

            if ((dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10))){
                //gera
            }else {
                throw new DataIntegretionException("cpf inválido!");
            }
        } catch (InputMismatchException erro) {
            throw new DataIntegretionException("cpf inválido!");
        }
    }

    private void verificaCpfExistente(String cpfval){
        if (repository.existsBycpfval(cpfval)){
            throw new DataIntegretionException("cpf já cadastrado!");
        }
    }
}
