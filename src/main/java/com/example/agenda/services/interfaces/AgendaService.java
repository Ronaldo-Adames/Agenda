package com.example.agenda.services.interfaces;

import com.example.agenda.consts.ExceptionConsts;
import com.example.agenda.models.DTO.AgendaDTO;
import com.example.agenda.models.Entities.Agenda;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.agenda.repositories.AgendaRepository;

import java.util.List;

@Service
public class AgendaService implements IAgendaService {

    @Autowired
    AgendaRepository repository;
    @Autowired
    ModelMapper mapper;

    @Override
    public Long criarUmHorario(AgendaDTO agendaDTO) throws Exception {
        // Verificando se já existe um cliente agendado neste horário
        Agenda existeAgenda = repository.verificaMesmoHorario(agendaDTO.getInicio().toString(), agendaDTO.getFim().toString(), agendaDTO.getDataConsulta().toString(), agendaDTO.getMedicoId());

        try {
            if (existeAgenda != null) {
                throw new Exception(ExceptionConsts.ERROR_TEM_O_MESMO_HORARIO);
            }

            return salvar(agendaDTO);
        } catch (Exception e) {
            throw new Exception(ExceptionConsts.ERROR_TEM_O_MESMO_HORARIO);
        }


    }

    @Override
    public Long atualizarHorario(AgendaDTO agenda) throws Exception {
        return salvar(agenda);
    }

    @Override
    public void deletarHorario(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<AgendaDTO> listaHorarios(String dataConsulta, Long medicoId) {
        List<AgendaDTO> horarios = repository.listaConsultas(dataConsulta, medicoId).stream().map(s -> mapper
                .map(s, AgendaDTO.class)).toList();

        return horarios;
    }

    @Override
    public AgendaDTO procurarUmHorario(String pacienteNome, Long medicoId) throws Exception {
        try {

            return mapper.map(repository.procurarUmHorario(pacienteNome, medicoId), AgendaDTO.class);
        } catch (Exception e) {
            throw new Exception(ExceptionConsts.ERRO_DE_INSERCAO_DE_AGENDAMENTO);
        }

    }

    public Long salvar(AgendaDTO agendaDTO) throws Exception {

        try {

            Agenda agendado = mapper.map(agendaDTO, Agenda.class);
            Agenda created = repository.save(agendado);
            return created.getId();

        } catch (Exception e) {
            throw new Exception(ExceptionConsts.ERRO_DE_INSERCAO_DE_AGENDAMENTO);
        }
    }

    public AgendaDTO procurarUmHorarioById(Long id) {
        return mapper.map(repository.findById(id), AgendaDTO.class);
    }
}


