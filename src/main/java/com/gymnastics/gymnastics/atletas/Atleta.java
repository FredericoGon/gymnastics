package com.gymnastics.gymnastics.atletas;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.gymnastics.gymnastics.clubes.Clube;

import javax.persistence.*;
import java.util.Date;

@Entity(name="atletas")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Atleta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long atleta_id;
    private String nome;
    private String cpf;
    private String codigo_fgsc;
    private Date nascimento;
    private String cidade;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clube_id")
    @JsonIgnoreProperties("atletas")
    private Clube clube;

    public Long getAtletaId() {
        return atleta_id;
    }

    public void setAtletaId(Long atleta_id) {
        this.atleta_id = atleta_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCodigoFgsc() {
        return codigo_fgsc;
    }

    public void setCodigoFgsc(String codigo_fgsc) {
        this.codigo_fgsc = codigo_fgsc;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Clube getClube() {
        return clube;
    }

    public void setClube(Clube clube) {
        this.clube = clube;
    }
}
