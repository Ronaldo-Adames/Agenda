package com.example.agenda.repositories;

import com.example.agenda.models.Entities.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository  extends JpaRepository<Medico, Long> {

    Medico findByNome(String nome);

}
