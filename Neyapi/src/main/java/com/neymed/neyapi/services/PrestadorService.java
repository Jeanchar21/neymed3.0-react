package com.neymed.neyapi.services;

import com.neymed.neyapi.DTO.PrestadorResponseDTO;
import com.neymed.neyapi.models.Prestador;
import com.neymed.neyapi.repositories.PrestadorRepository;
import com.neymed.neyapi.services.exceptions.DataIntegretionException;
import com.neymed.neyapi.services.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class PrestadorService {
    @Autowired
    private PrestadorRepository repository;

    public List<Prestador> findAll(){
        List<Prestador> prestadores = repository.findAll();
        return prestadores;
    }

    public PrestadorResponseDTO findById(Long id) {
        Optional<Prestador> result = repository.findById(id);

        result.orElseThrow(() -> new NotFoundException(id));

        return new PrestadorResponseDTO(result.get());
    }

    public PrestadorResponseDTO save(PrestadorResponseDTO dto){
        if (dto.getCpfval() != null) {
            this.verificaCpfExistente(dto.getCpfval());
            this.validCpf(dto.getCpfval());
        }else if (dto.getCnpjval() != null) {
            this.verificaCnpjExistente(dto.getCnpjval());
            this.validCnpj(dto.getCnpjval());
        }
        Prestador prestador = new Prestador(dto);
        this.gerarChave(prestador);
        repository.save(prestador);

        return new PrestadorResponseDTO(prestador);
    }

    public Prestador update( Long id, Prestador prestador){

        Prestador prestadorBanco = repository.findById(id).get();

        prestadorBanco.setNome(prestador.getNome() != null ? prestador.getNome() : prestadorBanco.getNome());
        prestadorBanco.setCpfval(prestador.getCpfval() != null ? prestador.getCpfval() : prestadorBanco.getCpfval());
        prestadorBanco.setCnpjval(prestador.getCnpjval() != null ? prestador.getCnpjval() : prestadorBanco.getCnpjval());
        prestadorBanco.setEstadocivil(prestador.getEstadocivil() != null ? prestador.getEstadocivil() : prestadorBanco.getEstadocivil());
        prestadorBanco.setCel(prestador.getCel() != null ? prestador.getCel() : prestadorBanco.getCel());
        prestadorBanco.setDt_inscricao(prestador.getDt_inscricao() != null ? prestador.getDt_inscricao() : prestadorBanco.getDt_inscricao());
        prestadorBanco.setAtv(prestador.getAtv() != null ? prestador.getAtv() : prestadorBanco.getAtv());
        prestadorBanco.setContrato(prestador.getContrato() != null ? prestador.getContrato() : prestadorBanco.getContrato());
        prestadorBanco.setDesl(prestador.getDesl() != null ? prestador.getDesl() : prestadorBanco.getDesl());
        prestadorBanco.setEmail(prestador.getEmail() != null ? prestador.getEmail() : prestadorBanco.getEmail());
        prestadorBanco.setTppessoa(prestador.getTppessoa() != null ? prestador.getTppessoa() : prestadorBanco.getTppessoa());
        prestadorBanco.setTipo(prestador.getTipo() != null ? prestador.getTipo() : prestadorBanco.getTipo());
        prestadorBanco.setSexo(prestador.getSexo() != null ? prestador.getSexo() : prestadorBanco.getSexo());
        prestadorBanco.setMtvdesl(prestador.getMtvdesl() != null ? prestador.getMtvdesl() : prestadorBanco.getMtvdesl());
        prestadorBanco.setNomeusual(prestador.getNomeusual() != null ? prestador.getNomeusual() : prestadorBanco.getNomeusual());

        if(prestador.getTppessoa().equals("Fisica")){
            prestadorBanco.setCnpjval(null);
        }else if (prestador.getTppessoa().equals("Juridica")){
            prestadorBanco.setCpfval(null);
        }

        if (prestador.getCpfval() != null) {
            this.validCpf(prestador.getCpfval());
        }else if (prestador.getCnpjval() != null) {
            this.validCnpj(prestador.getCnpjval());
        }

        repository.saveAndFlush(prestadorBanco);

        return  prestadorBanco;

    }

    public void delete(Long id){
        if(repository.existsById(id)){
            repository.deleteById(id);
        }
    }
    private void gerarChave(Prestador prestador) {

        int comprimento = 3;

        StringBuilder chave = new StringBuilder();
        String caracteresPermitidos = "0123456789";

        Random random = new Random();

        for (int i = 0; i < comprimento; i++) {
            int index = random.nextInt(caracteresPermitidos.length());
            char caractere = caracteresPermitidos.charAt(index);
            chave.append(caractere);
        }

        prestador.setChave(chave.toString());
    }

    private void verificaCpfExistente(String cpfval){
        if (repository.existsBycpfval(cpfval)){
            throw new DataIntegretionException("cpf já cadastrado!");
        }
    }

    private void verificaCnpjExistente(String cnpjval){
        if (repository.existsBycnpjval(cnpjval)){
            throw new DataIntegretionException("Cnpj já cadastrado!");
        }
    }

    private void validCpf(String cpfval){
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
