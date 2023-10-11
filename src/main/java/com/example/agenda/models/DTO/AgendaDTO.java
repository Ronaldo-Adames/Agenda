package com.example.agenda.models.DTO;

import com.example.agenda.enums.Horario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Data
public class AgendaDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 23L;
    private Long id;

    @NotNull
    private Long medicoId;

    @NotBlank(message = "O campo nome do Paciente não pode estar em branco.")
    @NotEmpty(message = "O campo nome do Paciente não pode estar vazio.")
    private String pacienteNome;

    @NotBlank(message = "O campo a Especialidade da Consulta não pode estar em branco.")
    @NotEmpty(message = "O campo Especialidade da Consulta não pode estar vazio.")
    private String tipoConsulta;

    @NotNull(message = "Por favor selecione uma data para fazer a consulta.")
    private Date dataConsulta;

    @NotNull(message = "Por favor selecione uma Horário de Início para fazer a consulta.")
    private Horario inicio;

    @NotNull(message = "Por favor selecione uma Horário de Fim para fazer o agendamento.")
    private Horario fim;

}

