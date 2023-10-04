package com.example.agenda.repositories;

import com.example.agenda.models.Entities.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AgendaRepository extends JpaRepository<Agenda, Long> {

    /* Pesquisar pelo nome do cliente e profissional */
    @Query(nativeQuery = true, value = """
             SELECT * FROM tb_agenda s
             WHERE s.pacienteNome = :pacienteNome AND s.medico_id = :medicoId
            """)
    Agenda procurarUmHorario(String pacienteNome, Long medicoId);

    /* Listar horários pela Data e médico */
    @Query(nativeQuery = true, value = """
             SELECT * FROM tb_agenda s
             WHERE s.data_consulta = CAST(:dataConsulta AS timestamp) AND s.medico_id = :medicoId
             ORDER BY s.data_consulta DESC
            """)
    List<Agenda> listaConsultas(String dataConsulta, Long medicoId);

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


