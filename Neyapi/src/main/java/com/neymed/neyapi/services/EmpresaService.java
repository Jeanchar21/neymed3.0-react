package com.neymed.neyapi.services;

import com.neymed.neyapi.DTO.EmpresaResponseDTO;
import com.neymed.neyapi.models.Empresa;
import com.neymed.neyapi.repositories.EmpresaRepository;
import com.neymed.neyapi.services.exceptions.DataIntegretionException;
import com.neymed.neyapi.services.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class EmpresaService {
    @Autowired
    private EmpresaRepository repository;

    public List<Empresa> findAll(){
        List<Empresa> empresas = repository.findAll();
        return empresas;
    }

    public EmpresaResponseDTO findById(Long id) {
        Optional<Empresa> result = repository.findById(id);

        result.orElseThrow(() -> new NotFoundException(id));

        return new EmpresaResponseDTO(result.get());
    }

    public EmpresaResponseDTO save(EmpresaResponseDTO dto){

        this.verificaCnpjExistente(dto.getCnpjval());
        Empresa empresa = new Empresa(dto);
        this.gerarChave(empresa);
        repository.save(empresa);

        return new EmpresaResponseDTO(empresa);
    }

    public Empresa update( Long id, Empresa empresa){

        Empresa empresaBanco = repository.findById(id).get();

        empresaBanco.setNome(empresa.getNome() != null ? empresa.getNome() : empresaBanco.getNome());
        empresaBanco.setDt_inscricao(empresa.getDt_inscricao() != null ? empresa.getDt_inscricao() : empresaBanco.getDt_inscricao());
        empresaBanco.setAtivo(empresa.getAtivo() != null ? empresa.getAtivo() : empresaBanco.getAtivo());
        empresaBanco.setTpjur(empresa.getTpjur() != null ? empresa.getTpjur() : empresaBanco.getTpjur());
        empresaBanco.setCnpjval(empresa.getCnpjval() != null ? empresa.getCnpjval() : empresaBanco.getCnpjval());
        empresaBanco.setEmailjur(empresa.getEmailjur() != null ? empresa.getEmailjur() : empresaBanco.getEmailjur());
        empresaBanco.setFantjur(empresa.getFantjur() != null ? empresa.getFantjur() : empresaBanco.getFantjur());
        empresaBanco.setEndrjur(empresa.getEndrjur() != null ? empresa.getEndrjur() : empresaBanco.getEndrjur());
        empresaBanco.setBairrojur(empresa.getBairrojur() != null ? empresa.getBairrojur() : empresaBanco.getBairrojur());
        empresaBanco.setCddjur(empresa.getCddjur() != null ? empresa.getCddjur() : empresaBanco.getCddjur());
        empresaBanco.setCompjur(empresa.getCompjur() != null ? empresa.getCompjur() : empresaBanco.getCompjur());
        empresaBanco.setUf(empresa.getUf() != null ? empresa.getUf() : empresaBanco.getUf());
        empresaBanco.setNomerep(empresa.getNomerep() != null ? empresa.getNomerep() : empresaBanco.getNomerep());
        empresaBanco.setPais(empresa.getPais() != null ? empresa.getPais() : empresaBanco.getPais());
        empresaBanco.setCeljur(empresa.getCeljur() != null ? empresa.getCeljur() : empresaBanco.getCeljur());
        empresaBanco.setRecad(empresa.getRecad() != null ? empresa.getRecad() : empresaBanco.getRecad());
        this.validCnpj(empresa.getCnpjval());

        repository.saveAndFlush(empresaBanco);

        return  empresaBanco;

    }

    public void delete(Long id){
        if(repository.existsById(id)){
            repository.deleteById(id);
        }
    }
    private void gerarChave(Empresa empresa) {

        int comprimento = 3;

        StringBuilder chave = new StringBuilder();
        String caracteresPermitidos = "0123456789";

        Random random = new Random();

        for (int i = 0; i < comprimento; i++) {
            int index = random.nextInt(caracteresPermitidos.length());
            char caractere = caracteresPermitidos.charAt(index);
            chave.append(caractere);
        }

        empresa.setChave(chave.toString());
    }

    private void verificaCnpjExistente(String cnpjval){
        if (repository.existsBycnpjval(cnpjval)){
            throw new DataIntegretionException("Cnpj já cadastrado");
        }
    }

    private void validCnpj(String cnpjval){
        var cnpj = cnpjval.replaceAll("-", "");
        cnpj = cnpj.replaceAll(" ", "");
        cnpj = cnpj.replaceAll("\\.", "");
        cnpj = cnpj.replaceAll("/", "");

        if (cnpj.equals("00000000000000") || cnpj.equals("11111111111111") ||
                cnpj.equals("22222222222222") || cnpj.equals("33333333333333") ||
                cnpj.equals("44444444444444") || cnpj.equals("55555555555555") ||
                cnpj.equals("66666666666666") || cnpj.equals("77777777777777") ||
                cnpj.equals("88888888888888") || cnpj.equals("99999999999999") ||
                (cnpj.length() != 14))
            throw new DataIntegretionException("cnpj inválido!");

        char dig13, dig14;
        int sm, i, r, num, peso;

        try {
            sm = 0;
            peso = 2;
            for (i=11; i>=0; i--) {
                num = (int)(cnpj.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso + 1;
                if (peso == 10)
                    peso = 2;
            }

            r = sm % 11;
            if ((r == 0) || (r == 1))
                dig13 = 0;
            else dig13 = (char)((11-r) + 48);

            sm = 0;
            peso = 2;
            for (i=12; i>=0; i--) {
                num = (int)(cnpj.charAt(i)- 48);
                sm = sm + (num * peso);
                peso = peso + 1;
                if (peso == 10)
                    peso = 2;
            }

            r = sm % 11;
            if ((r == 0) || (r == 1))
                dig14 = 0;
            else dig14 = (char)((11-r) + 48);

            if ((dig13 == cnpj.charAt(12)) && (dig14 == cnpj.charAt(13))) {
                //gera
            }else {
                throw new DataIntegretionException("cnpj inválido!");
            }
        } catch (InputMismatchException erro) {
            throw new DataIntegretionException("cnpj inválido!");
        }
    }
}
