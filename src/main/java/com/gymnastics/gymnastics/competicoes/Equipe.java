package com.gymnastics.gymnastics.competicoes;

import com.gymnastics.gymnastics.atletas.Atleta;

import javax.persistence.*;
import java.util.List;

@Entity
public class Equipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long equipeId;
    private String cidade;
    private Long clubeId;
    private Categoria categoria;
    private Long competicaoId;
    @ManyToMany
    @JoinTable(
            name = "equipe_atletas",
            joinColumns = @JoinColumn(name = "equipeId"),
            inverseJoinColumns = @JoinColumn(name = "atletaId")
    )
    private List<Atleta> atletas;

    public Long getEquipeId() {
        return equipeId;
    }

    public void setEquipeId(Long equipeId) {
        this.equipeId = equipeId;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Atleta> getAtletas() {
        return atletas;
    }

    public void setAtletas(List<Atleta> atletas) {
        this.atletas = atletas;
    }

    public Long getClubeId() {
        return clubeId;
    }

    public void setClubeId(Long clubeId) {
        this.clubeId = clubeId;
    }

    public Long getCompeticaoId() {
        return competicaoId;
    }

    public void setCompeticaoId(Long competicaoId) {
        this.competicaoId = competicaoId;
    }
}
