package com.example.agenda.models.Entities;

import com.example.agenda.enums.Especialidades;
import jakarta.persistence.*;

import java.util.List;

@Entity
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

    public Medico() {

    }

    public Medico(Long id, String nome, Especialidades especialidade, List<Agenda> listaDeHorario, Boolean isActive) {
        this.id = id;
        this.nome = nome;
        this.especialidade = especialidade;
        this.listaDeHorario = listaDeHorario;
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

    public Especialidades getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidades especialidade) {
        this.especialidade = especialidade;
    }

    public List<Agenda> getListaDeHorario() {
        return listaDeHorario;
    }

    public void setListaDeHorario(List<Agenda> listaDeHorario) {
        this.listaDeHorario = listaDeHorario;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "Medico{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", especialidade='" + especialidade + '\'' +
                ", listaDeHorario=" + listaDeHorario +
                ", isActive=" + isActive +
                '}';
    }
}

