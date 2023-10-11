package com.example.agenda.services;

import com.example.agenda.consts.ExceptionConsts;
import com.example.agenda.models.DTO.MedicoDTO;
import com.example.agenda.models.Entities.Medico;
import com.example.agenda.services.impl.MedicoServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.agenda.repositories.MedicoRepository;

import java.util.List;

@Service
public class MedicoService implements MedicoServiceImpl {

    @Autowired
    MedicoRepository repository;
    @Autowired
    ModelMapper mapper;

    @Override
    public Long adicionarMedico(MedicoDTO medicoDTO) throws Exception {

        try {
            //  Verificar se já existe um médico com o mesmo nome cadastrado
            if (repository.findByNome(medicoDTO.getNome()) != null) {
                throw new Exception(ExceptionConsts.MEDICO_ERRO_AO_INSERIR_NOME);
            }

            return salvar(medicoDTO);
        } catch (Exception e) {
            throw new Exception(ExceptionConsts.MEDICO_ERRO_AO_INSERIR_NOME);
        }
    }


    @Override
    public Long atualizarMedico(MedicoDTO medicoDTO) throws Exception {
        return salvar(medicoDTO);
    }

    @Override
    public void deletarMedico(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<MedicoDTO> listarMedicos() {
        return repository.findAll().stream()
                .map(e -> mapper.map(e, MedicoDTO.class)).toList();

    }

    @Override
    public MedicoDTO procurarUmMedico(String name) throws Exception {
        try {
            MedicoDTO procurarMedico = mapper.map(repository.findByNome(name), MedicoDTO.class);
            if (procurarMedico == null) {
                throw new Exception(ExceptionConsts.MEDICO_ERRO_AO_PROCURAR);
            }

            return procurarMedico;
        } catch (Exception e) {
            throw new RuntimeException(ExceptionConsts.MEDICO_ERRO_AO_PROCURAR);
        }
    }

    @Override
    public MedicoDTO procurarUmMedicoById(Long id) {
        return mapper.map(repository.findById(id), MedicoDTO.class);
    }


    public Long salvar(MedicoDTO medicoDTO) throws Exception {
        Boolean tenhaMesmoNome = false;
        try {

            Medico medico = mapper.map(medicoDTO, Medico.class);
            Medico adicionar = repository.save(medico);
            return adicionar.getId();
        } catch (Exception e) {
            throw new Exception(ExceptionConsts.MEDICO_ERRO_AO_INSERIR_NOME);
        }
    }
}

