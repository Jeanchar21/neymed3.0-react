package com.neymed.neyapi.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.neymed.neyapi.models.Prestador;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import java.util.Date;

public class PrestadorResponseDTO {
    private Long id;
    private String nome;
    private String nomeusual;
    private String email;
    private Integer contrato;
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date atv;
    private String tppessoa;
    private String sexo;
    @CPF
    private String cpfval;
    @CNPJ
    private String cnpjval;
    private String cel;
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dt_inscricao;
    private String tipo;
    private String estadocivil;
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date desl;
    private String mtvdesl;

    private String chave;

    public PrestadorResponseDTO() {
    }

    public PrestadorResponseDTO(Prestador prestador) {
        this.id = prestador.getId();
        this.nome = prestador.getNome();
        this.nomeusual = prestador.getNomeusual();
        this.email = prestador.getEmail();
        this.contrato = prestador.getContrato();
        this.atv = prestador.getAtv();
        this.tppessoa = prestador.getTppessoa();
        this.sexo = prestador.getSexo();
        this.cpfval = prestador.getCpfval();
        this.cnpjval = prestador.getCnpjval();
        this.cel = prestador.getCel();
        this.dt_inscricao = prestador.getDt_inscricao();
        this.tipo = prestador.getTipo();
        this.estadocivil = prestador.getEstadocivil();
        this.desl = prestador.getDesl();
        this.mtvdesl = prestador.getMtvdesl();
        this.chave = prestador.getChave();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeusual() {
        return nomeusual;
    }

    public void setNomeusual(String nomeusual) {
        this.nomeusual = nomeusual;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getContrato() {
        return contrato;
    }

    public void setContrato(Integer contrato) {
        this.contrato = contrato;
    }

    public Date getAtv() {
        return atv;
    }

    public void setAtv(Date atv) {
        this.atv = atv;
    }

    public String getTppessoa() {
        return tppessoa;
    }

    public void setTppessoa(String tppessoa) {
        this.tppessoa = tppessoa;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCpfval() {
        return cpfval;
    }

    public void setCpfval(String cpfval) {
        this.cpfval = cpfval;
    }

    public String getCnpjval() {
        return cnpjval;
    }

    public void setCnpjval(String cnpjval) {
        this.cnpjval = cnpjval;
    }

    public String getCel() {
        return cel;
    }

    public void setCel(String cel) {
        this.cel = cel;
    }

    public Date getDt_inscricao() {
        return dt_inscricao;
    }

    public void setDt_inscricao(Date dt_inscricao) {
        this.dt_inscricao = dt_inscricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstadocivil() {
        return estadocivil;
    }

    public void setEstadocivil(String estadocivil) {
        this.estadocivil = estadocivil;
    }

    public Date getDesl() {
        return desl;
    }

    public void setDesl(Date desl) {
        this.desl = desl;
    }

    public String getMtvdesl() {
        return mtvdesl;
    }

    public void setMtvdesl(String mtvdesl) {
        this.mtvdesl = mtvdesl;
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }
}
