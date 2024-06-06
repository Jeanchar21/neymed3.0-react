package com.neymed.neyapi.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.neymed.neyapi.models.Empresa;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import org.hibernate.validator.constraints.br.CNPJ;

import java.util.Date;

public class EmpresaResponseDTO {
    private Long id;
    private String nome;
    private String fantjur;
    private String emailjur;
    private String celjur;
    private String nomerep;
    @CNPJ
    private String cnpjval;
    private String ativo;
    private String tpjur;
    private String endrjur;
    private String cddjur;
    private String bairrojur;
    private String compjur;
    private String pais;
    private String uf;
    private String recad;
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dt_inscricao;
    private String tipo;

    private String chave;

    public String getKey() {
        return chave;
    }

    public void setKey(String chave) {
        this.chave = chave;
    }

    public EmpresaResponseDTO() {
    }

    public EmpresaResponseDTO(Empresa empresa) {
        this.id = empresa.getId();
        this.nome = empresa.getNome();
        this.fantjur = empresa.getFantjur();
        this.emailjur = empresa.getEmailjur();
        this.celjur = empresa.getCeljur();
        this.nomerep = empresa.getNomerep();
        this.cnpjval = empresa.getCnpjval();
        this.ativo = empresa.getAtivo();
        this.tpjur = empresa.getTpjur();
        this.endrjur = empresa.getEndrjur();
        this.cddjur = empresa.getCddjur();
        this.bairrojur = empresa.getBairrojur();
        this.compjur = empresa.getCompjur();
        this.pais = empresa.getPais();
        this.uf = empresa.getUf();
        this.dt_inscricao = empresa.getDt_inscricao();
        this.tipo = empresa.getTipo();
        this.recad = empresa.getRecad();
        this.chave = empresa.getChave();
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

    public String getFantjur() {
        return fantjur;
    }

    public void setFantjur(String fantjur) {
        this.fantjur = fantjur;
    }

    public String getEmailjur() {
        return emailjur;
    }

    public void setEmailjur(String emailjur) {
        this.emailjur = emailjur;
    }

    public String getNomerep() {
        return nomerep;
    }

    public void setNomerep(String nomerep) {
        this.nomerep = nomerep;
    }

    public String getCnpjval() {
        return cnpjval;
    }

    public void setCnpjval(String cnpjval) {
        this.cnpjval = cnpjval;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
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

    public String getCeljur() {
        return celjur;
    }

    public void setCeljur(String celjur) {
        this.celjur = celjur;
    }

    public String getTpjur() {
        return tpjur;
    }

    public void setTpjur(String tpjur) {
        this.tpjur = tpjur;
    }

    public String getEndrjur() {
        return endrjur;
    }

    public void setEndrjur(String endrjur) {
        this.endrjur = endrjur;
    }

    public String getCddjur() {
        return cddjur;
    }

    public void setCddjur(String cddjur) {
        this.cddjur = cddjur;
    }

    public String getBairrojur() {
        return bairrojur;
    }

    public void setBairrojur(String bairrojur) {
        this.bairrojur = bairrojur;
    }

    public String getCompjur() {
        return compjur;
    }

    public void setCompjur(String compjur) {
        this.compjur = compjur;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getRecad() {
        return recad;
    }
    public void setRecad(String recad) {
        this.recad = recad;
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }
}
