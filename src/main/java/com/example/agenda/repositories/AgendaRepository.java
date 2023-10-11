package com.example.agenda.repositories;

import com.example.agenda.enums.Horario;
import com.example.agenda.models.Entities.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface AgendaRepository extends JpaRepository<Agenda, Long> {

    /* Pesquisar pelo nome do paciente e profissional */
    @Query("select a from Agenda a where a.pacienteNome = ?1 and a.medicoId.id = ?2")
    Agenda procurarUmHorario(String pacienteNome, Long id);

    /* Listar horários pela Data e médico */
    @Query("select a from Agenda a where a.dataConsulta = ?1 and a.medicoId.id = ?2")
    List<Agenda> listaConsultas(String dataConsulta, Long id);


    /* Verificar se já existe um horário agendado numa data para um profissional  */
    @Query(nativeQuery = true, value = """
             SELECT * FROM tb_agenda s
             WHERE s.inicio = :inicio
             AND s.fim = :fim 
             AND s.data_consulta = CAST(:dataConsulta AS timestamp)
             AND s.medico_id = :medicoId
            """)
    Agenda verificaMesmoHorario(String inicio, String fim, String dataConsulta, Long medicoId);
    


}


