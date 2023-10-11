package com.example.agenda.models.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
public class MedicoDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 23L;
    private Long id;

    @NotBlank(message = "O campo nome não pode estar em branco.")
    @NotEmpty(message = "O campo nome não pode estar vazio.")
    private String nome;

    @NotNull(message = "Por favor selecione a especialidade.")
    private  String especialidade;

    private List<AgendaDTO> listaDeHorario;

    private Boolean isActive = true;
}
