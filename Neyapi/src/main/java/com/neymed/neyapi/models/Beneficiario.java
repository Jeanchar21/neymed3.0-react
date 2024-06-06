package com.neymed.neyapi.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.neymed.neyapi.DTO.BeneficiarioResponseDTO;
import jakarta.persistence.*;
import org.hibernate.validator.constraints.br.CPF;

import java.util.Date;

@Entity
@Table(name = "tb_beneficiario")
public class Beneficiario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public String getKey() {
        return chave;
    }

    public void setKey(String chave) {
        this.chave = chave;
    }

    public Beneficiario(){
    }
    public Beneficiario(Long id,String nome, String nomesocial, Date nasc, String cpfval, String rg, String sexo, String estadocivil, String escolaridade, String email, String nmpai, String nmmae, String cel, String tp_ben, String ufemissor, String endr, String cdd, String bairro, String comp, String pais, String uf, String oem, Date dt_inscricao, String tipo,String chave) {
        this.id = id;
        this.nome = nome;
        this.nomesocial= nomesocial;
        this.nasc = nasc;
        this.cpfval = cpfval;
        this.rg = rg;
        this.sexo = sexo;
        this.estadocivil = estadocivil;
        this.escolaridade = escolaridade;
        this.email = email;
        this.nmpai = nmpai;
        this.nmmae = nmmae;
        this.cel = cel;
        this.tp_ben = tp_ben;
        this.ufemissor = ufemissor;
        this.endr = endr;
        this.cdd = cdd;
        this.bairro = bairro;
        this.comp = comp;
        this.pais = pais;
        this.uf = uf;
        this.oem = oem;
        this.dt_inscricao = dt_inscricao;
        this.tipo = tipo;
        this.chave = chave;
    }

    public Beneficiario(BeneficiarioResponseDTO dto) {
        this.id = dto.getId();
        this.nome = dto.getNome();
        this.nomesocial= dto.getNomesocial();
        this.nasc = dto.getNasc();
        this.cpfval = dto.getCpfval();
        this.rg = dto.getRg();
        this.sexo = dto.getSexo();
        this.estadocivil = dto.getEstadocivil();
        this.escolaridade = dto.getEscolaridade();
        this.email = dto.getEmail();
        this.nmpai = dto.getNmpai();
        this.nmmae = dto.getNmmae();
        this.cel = dto.getCel();
        this.tp_ben = dto.getTp_ben();
        this.ufemissor = dto.getUfemissor();
        this.endr = dto.getEndr();
        this.cdd = dto.getCdd();
        this.bairro = dto.getBairro();
        this.comp = dto.getComp();
        this.pais = dto.getPais();
        this.uf = dto.getUf();
        this.oem = dto.getOem();
        this.dt_inscricao = dto.getDt_inscricao();
        this.tipo = dto.getTipo();
        this.chave = dto.getChave();
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
