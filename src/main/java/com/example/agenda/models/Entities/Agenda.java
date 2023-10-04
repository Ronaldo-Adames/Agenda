package com.example.agenda.models.Entities;

import com.example.agenda.enums.Horario;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tb_agenda")
public class Agenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medicoId;

    @Column(nullable = false)
    private String pacienteNome;

    @Column(nullable = false)
    private String tipoConsulta;

    @Column(nullable = false)
    private Date dataConsulta;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Horario inicio;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Horario fim;


    public Agenda() {

    }

    public Agenda(Long id, Medico medicoId, String pacienteNome, String tipoConsulta, Date dataConsulta, Horario inicio, Horario fim) {
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

    public Medico getMedicoId() {
        return medicoId;
    }

    public void setMedicoId(Medico medicoId) {
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
        return "Agenda{" +
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





