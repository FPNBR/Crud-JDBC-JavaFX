package com.fpnbr.crudjdbcjavafx.models.dto;

import javafx.beans.property.*;

public abstract class PessoaDTO {

    protected LongProperty id;
    protected StringProperty nome;
    protected StringProperty dataNascimento;
    protected IntegerProperty idade;

    public PessoaDTO()
    {
        id = new SimpleLongProperty(this, "id");
        nome = new SimpleStringProperty(this, "nome");
        dataNascimento = new SimpleStringProperty(this, "datanascimento");
        idade = new SimpleIntegerProperty(this, "idade");
    }

    public LongProperty idProperty() {
        return id;
    }

    public long getId() {
        return id.get();
    }

    public void setId(Long newId) {
        id.set(newId);
    }

    public StringProperty nomeProperty() {
        return nome;
    }

    public String getNome() {
        return nome.get();
    }

    public void setNome(String newNome) {
        nome.set(newNome);
    }

    public StringProperty dataNascimento() {
        return dataNascimento;
    }

    public String getDataNascimento() {
        return dataNascimento.get();
    }

    public void setDataNascimento(String newDataNascimento) {
        dataNascimento.set(newDataNascimento);
    }

    public IntegerProperty idade() {
        return idade;
    }

    public int getIdade() {
        return idade.get();
    }

    public void setIdade(Integer newIdade) {
        idade.set(newIdade);
    }
}