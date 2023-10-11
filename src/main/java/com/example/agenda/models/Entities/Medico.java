package com.example.agenda.models.Entities;

import com.example.agenda.enums.Especialidades;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_medico")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Enumerated(value = EnumType.STRING)
    private Especialidades especialidade;

    @OneToMany(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    private List<Agenda> listaDeHorario;

    @Column(nullable = false)
    private Boolean isActive;

}

