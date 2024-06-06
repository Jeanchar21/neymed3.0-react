package com.neymed.neyapi.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.neymed.neyapi.DTO.PrestadorResponseDTO;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tb_prestador")
public class Prestador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private String cpfval;
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

    public Prestador() {
    }

    public Prestador(Long id, String nome, String nomeusual, String email, Integer contrato, Date atv, String tppessoa, String sexo, String cpfval, String cnpjval, String cel, Date dt_inscricao, String tipo, String estadocivil, Date desl, String mtvdesl,String chave) {
        this.id = id;
        this.nome = nome;
        this.nomeusual = nomeusual;
        this.email = email;
        this.contrato = contrato;
        this.atv = atv;
        this.tppessoa = tppessoa;
        this.sexo = sexo;
        this.cpfval = cpfval;
        this.cnpjval = cnpjval;
        this.cel = cel;
        this.dt_inscricao = dt_inscricao;
        this.tipo = tipo;
        this.estadocivil = estadocivil;
        this.desl = desl;
        this.mtvdesl = mtvdesl;
        this.chave = chave;
    }

    public Prestador(PrestadorResponseDTO dto){
        this.id = dto.getId();
        this.nome = dto.getNome();
        this.nomeusual = dto.getNomeusual();
        this.email = dto.getEmail();
        this.contrato = dto.getContrato();
        this.atv = dto.getAtv();
        this.tppessoa = dto.getTppessoa();
        this.sexo = dto.getSexo();
        this.cpfval = dto.getCpfval();
        this.cnpjval = dto.getCnpjval();
        this.cel = dto.getCel();
        this.dt_inscricao = dto.getDt_inscricao();
        this.tipo = dto.getTipo();
        this.estadocivil = dto.getEstadocivil();
        this.desl = dto.getDesl();
        this.mtvdesl = dto.getMtvdesl();
        this.chave = dto.getChave();
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

    @Override
    public String toString() {
        return "Prestador{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", nomeusual='" + nomeusual + '\'' +
                ", email='" + email + '\'' +
                ", contrato=" + contrato +
                ", atv=" + atv +
                ", tppessoa='" + tppessoa + '\'' +
                ", sexo='" + sexo + '\'' +
                ", cpfval='" + cpfval + '\'' +
                ", cnpjval='" + cnpjval + '\'' +
                ", cel='" + cel + '\'' +
                ", dt_inscricao=" + dt_inscricao +
                ", tipo='" + tipo + '\'' +
                ", estadocivil='" + estadocivil + '\'' +
                ", desl=" + desl +
                ", mtvdesl='" + mtvdesl + '\'' +
                ", chave='" + chave + '\'' +
                '}';
    }
}
