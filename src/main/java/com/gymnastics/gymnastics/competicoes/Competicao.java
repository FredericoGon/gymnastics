package com.gymnastics.gymnastics.competicoes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Competicao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long competicaoId;
    private String nome;
    private Naipe naipe;
    private Categoria categoria;
    private String cidadeSede;
    private boolean fesporte;
    private Regulamento regulamento;

    public Long getCompeticaoId() {
        return competicaoId;
    }

    public void setCompeticaoId(Long competicaoId) {
        this.competicaoId = competicaoId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Naipe getNaipe() {
        return naipe;
    }

    public void setNaipe(Naipe naipe) {
        this.naipe = naipe;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getCidadeSede() {
        return cidadeSede;
    }

    public void setCidadeSede(String cidadeSede) {
        this.cidadeSede = cidadeSede;
    }

    public boolean isFesporte() {
        return fesporte;
    }

    public void setFesporte(boolean fesporte) {
        this.fesporte = fesporte;
    }

    public Regulamento getRegulamento() {
        return regulamento;
    }

    public void setRegulamento(Regulamento regulamento) {
        this.regulamento = regulamento;
    }
}
