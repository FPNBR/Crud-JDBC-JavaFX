package com.fpnbr.crudjdbcjavafx.models.dto;

import javafx.beans.property.StringProperty;

public class MedicoDTO extends PessoaDTO {
    private StringProperty crm;
    private StringProperty especialidade;

    public String getCrm() {
        return crm.get();
    }

    public StringProperty crmProperty() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm.set(crm);
    }

    public String getEspecialidade() {
        return especialidade.get();
    }

    public StringProperty especialidadeProperty() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade.set(especialidade);
    }

    @Override
    public String toString() {
        return "Medico{" +
                "crm=" + crm +
                ", especialidade=" + especialidade +
                ", nome=" + nome +
                ", dataNascimento=" + dataNascimento +
                ", idade=" + idade +
                '}';
    }
}