package com.example.agenda.models.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;

public class MedicoDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 23L;
    private Long id;

    @NotBlank(message = "O campo nome não pode estar em branco.")
    @NotEmpty(message = "O campo nome não pode estar vazio.")
    private String nome;

    @NotNull(message = "Selecione a especialidade.")
    private  String especialidade;

    private Boolean isActive = true;

    public MedicoDTO() {

    }

    public MedicoDTO(Long id, String nome, String especialidade, Boolean isActive) {
        this.id = id;
        this.nome = nome;
        this.especialidade = especialidade;
        this.isActive = isActive;
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

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "MedicoDTO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", especialidade='" + especialidade + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
