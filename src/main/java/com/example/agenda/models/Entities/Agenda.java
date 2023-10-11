package com.example.agenda.models.Entities;

import com.example.agenda.enums.Horario;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data // anotação para getters e setters equals e hashCode, toString
@NoArgsConstructor  // construtor sem argumentos
@AllArgsConstructor // construtor com todos os argumentos
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

    @JsonFormat(pattern = "dd/MM/YYYY")
    @Column(nullable = false)
    private Date dataConsulta;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Horario inicio;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Horario fim;
}





