package org.example.domain;

import org.example.domain.enums.StatusTarefa;
public class Tarefa {

    private final Long id;
    private String nome;
    private String descricao;
    private StatusTarefa status;

    public Tarefa(long id, String nome, String descricao, StatusTarefa status) {
        this.descricao = descricao;
        this.nome = nome;
        this.status = status;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public StatusTarefa getStatus() {
        return status;
    }

    public void setStatus(StatusTarefa status) {
        this.status = status;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }
}
