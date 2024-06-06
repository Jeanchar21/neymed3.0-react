package com.neymed.neyapi.DTO;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.neymed.neyapi.models.Beneficiario;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import org.hibernate.validator.constraints.br.CPF;

import java.util.Date;

public class BeneficiarioResponseDTO {
    private Long id;
    private String nome;
    private String nomesocial;
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date nasc;
    //@CPF
    private String cpfval;
    private String rg;
    private String sexo;
    private String estadocivil;
    private String escolaridade;
    private String email;
    private String nmpai;
    private String nmmae;
    private String cel;
    private String tp_ben;
    private String ufemissor;
    private String endr;
    private String cdd;
    private String bairro;
    private String comp;
    private String pais;
    private String uf;
    private String oem;
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dt_inscricao;
    private String tipo;
    private String chave;


    public BeneficiarioResponseDTO(){
    }

    public BeneficiarioResponseDTO(Beneficiario beneficiario) {
        this.id = beneficiario.getId();
        this.nome = beneficiario.getNome();
        this.nomesocial= beneficiario.getNomesocial();
        this.nasc = beneficiario.getNasc();
        this.cpfval = beneficiario.getCpfval();
        this.rg = beneficiario.getRg();
        this.sexo = beneficiario.getSexo();
        this.estadocivil = beneficiario.getEstadocivil();
        this.escolaridade = beneficiario.getEscolaridade();
        this.email = beneficiario.getEmail();
        this.nmpai = beneficiario.getNmpai();
        this.nmmae = beneficiario.getNmmae();
        this.cel = beneficiario.getCel();
        this.tp_ben = beneficiario.getTp_ben();
        this.ufemissor = beneficiario.getUfemissor();
        this.endr = beneficiario.getEndr();
        this.cdd = beneficiario.getCdd();
        this.bairro = beneficiario.getBairro();
        this.comp = beneficiario.getComp();
        this.pais = beneficiario.getPais();
        this.uf = beneficiario.getUf();
        this.oem = beneficiario.getOem();
        this.dt_inscricao = beneficiario.getDt_inscricao();
        this.tipo = beneficiario.getTipo();
        this.chave = beneficiario.getChave();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public String getNomesocial() { return nomesocial; }

    public void setNomesocial(String nomesocial) {
        this.nomesocial = nomesocial;
    }

    public Date getNasc() {
        return nasc;
    }

    public void setNasc(Date nasc) {
        this.nasc = nasc;
    }
    
    public String getCpfval() {
        return cpfval;
    }

    public void setCpfval(String cpfval) {
        this.cpfval = cpfval;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEstadocivil() {
        return estadocivil;
    }

    public void setEstadocivil(String estadocivil) {
        this.estadocivil = estadocivil;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    public String getCel() {
        return cel;
    }

    public void setCel(String cel) {
        this.cel = cel;
    }

    public String getTp_ben() {
        return tp_ben;
    }

    public void setTp_ben(String tp_ben) {
        this.tp_ben = tp_ben;
    }

    public String getUfemissor() {
        return ufemissor;
    }

    public void setUfemissor(String ufemissor) {
        this.ufemissor = ufemissor;
    }

    public String getCdd() {
        return cdd;
    }

    public void setCdd(String cdd) {
        this.cdd = cdd;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComp() {
        return comp;
    }

    public void setComp(String comp) {
        this.comp = comp;
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

    public String getOem() {
        return oem;
    }

    public void setOem(String oem) {
        this.oem = oem;
    }

    public Date getDt_inscricao() {
        return dt_inscricao;
    }

    public void setDt_inscricao(Date dt_inscricao) {
        this.dt_inscricao = dt_inscricao;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
    @JsonIgnore
    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNmpai() {
        return nmpai;
    }

    public void setNmpai(String nmpai) {
        this.nmpai = nmpai;
    }

    public String getNmmae() {
        return nmmae;
    }

    public void setNmmae(String nmmae) {
        this.nmmae = nmmae;
    }

    public String getEndr() {
        return endr;
    }

    public void setEndr(String endr) {
        this.endr = endr;
    }
}
