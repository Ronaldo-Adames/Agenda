package com.example.agenda.models.DTO;

import com.example.agenda.enums.Horario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

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

    @NotNull(message = "Selecione uma data para fazer a consulta.")
    private Date dataConsulta;

    @NotNull(message = "Selecione uma Horário de Início para fazer a consulta.")
    private Horario inicio;

    @NotNull(message = "Selecione uma Horário de Fim para fazer o agendamento.")
    private Horario fim;

    public AgendaDTO() {

    }

    public AgendaDTO(Long id, Long medicoId, String pacienteNome, String tipoConsulta, Date dataConsulta, Horario inicio, Horario fim) {
        this.id = id;
        this.medicoId = medicoId;
        this.pacienteNome = pacienteNome;
        this.tipoConsulta = tipoConsulta;
        this.dataConsulta = dataConsulta;
        this.inicio = inicio;
        this.fim = fim;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMedicoId() {
        return medicoId;
    }

    public void setMedicoId(Long medicoId) {
        this.medicoId = medicoId;
    }

    public String getPacienteNome() {
        return pacienteNome;
    }

    public void setPacienteNome(String pacienteNome) {
        this.pacienteNome = pacienteNome;
    }

    public String getTipoConsulta() {
        return tipoConsulta;
    }

    public void setTipoConsulta(String tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }

    public Date getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(Date dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public Horario getInicio() {
        return inicio;
    }

    public void setInicio(Horario inicio) {
        this.inicio = inicio;
    }

    public Horario getFim() {
        return fim;
    }

    public void setFim(Horario fim) {
        this.fim = fim;
    }

    @Override
    public String toString() {
        return "AgendaDTO{" +
                "id=" + id +
                ", medicoId=" + medicoId +
                ", pacienteNome='" + pacienteNome + '\'' +
                ", tipoConsulta='" + tipoConsulta + '\'' +
                ", dataConsulta=" + dataConsulta +
                ", inicio=" + inicio +
                ", fim=" + fim +
                '}';
    }
}

