package com.fpnbr.crudjdbcjavafx.models.dto;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PacienteDTO extends PessoaDTO {
    private StringProperty patologia;
    private StringProperty medico;

    public PacienteDTO()
    {
        id = new SimpleLongProperty(this, "id");
        nome = new SimpleStringProperty(this, "nome");
        dataNascimento = new SimpleStringProperty(this, "datanascimento");
        idade = new SimpleIntegerProperty(this, "idade");
        patologia = new SimpleStringProperty(this, "patologia");
        medico = new SimpleStringProperty(this, "medico");
    }

    public StringProperty patologiaProperty() {
        return patologia;
    }

    public String getPatologia() {
        return patologia.get();
    }

    public void setPatologia(String newPatologia) {
        patologia.set(newPatologia);
    }

    public StringProperty medicoProperty() {
        return medico;
    }

    public String getMedico() {
        return medico.get();
    }

    public void setMedico(String newMedico) {
        medico.set(newMedico);
    }
}