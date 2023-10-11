package com.example.agenda.services;

import com.example.agenda.models.DTO.AgendaDTO;

import java.util.List;

public interface AgendaServiceImpl {

    Long criarUmHorario(AgendaDTO agendaDTO) throws Exception;
    Long atualizarHorario(AgendaDTO agenda) throws Exception;
    void deletarHorario(Long id) throws Exception;
    List<AgendaDTO> listaHorarios(String dataConsulta, Long medicoId);
    AgendaDTO procurarUmHorario(String pacienteNome, Long medicoId) throws Exception;
}
