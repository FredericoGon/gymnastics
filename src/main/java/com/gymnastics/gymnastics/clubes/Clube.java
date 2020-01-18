package com.gymnastics.gymnastics.clubes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.gymnastics.gymnastics.atletas.Atleta;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name="clubes")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Clube {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clube_id;
    private String nome;
    private String cnpj;
    private String email;
    private Integer telefone;
    private String cidade;

    @OneToMany(mappedBy = "clube",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties("clube")
    private Set<Atleta> atletas = new HashSet<>();

//    private String logradouro;
//    private String complemento;
//    private String bairro;
//    private String cep;

    public Long getClubeId() {
        return clube_id;
    }

    public void setClubeId(Long clube_id) {
        this.clube_id = clube_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getTelefone() {
        return telefone;
    }

    public void setTelefone(Integer telefone) {
        this.telefone = telefone;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

//    public String getLogradouro() {
//        return logradouro;
//    }
//
//    public void setLogradouro(String logradouro) {
//        this.logradouro = logradouro;
//    }
//
//    public String getComplemento() {
//        return complemento;
//    }
//
//    public void setComplemento(String complemento) {
//        this.complemento = complemento;
//    }
//
//    public String getBairro() {
//        return bairro;
//    }
//
//    public void setBairro(String bairro) {
//        this.bairro = bairro;
//    }
//
//    public String getCep() {
//        return cep;
//    }
//
//    public void setCep(String cep) {
//        this.cep = cep;
//    }


    public Set<Atleta> getAtletas() {
        return atletas;
    }

    public void setAtletas(Set<Atleta> atletas) {
        this.atletas = atletas;
    }
}
