package com.example.agenda.services.interfaces;

import com.example.agenda.consts.ExceptionConsts;
import com.example.agenda.models.DTO.MedicoDTO;
import com.example.agenda.models.Entities.Medico;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.agenda.repositories.MedicoRepository;

import java.util.List;

@Service
public class MedicoService implements IMedicoService {

    @Autowired
    MedicoRepository repository;
    @Autowired
    ModelMapper mapper;

    @Override
    public Long adicionarMedico(MedicoDTO medicoDTO) throws Exception {

        try {
            //  Verificar se já existe um médico com o mesmo nome cadastrado
            if (repository.findByNome(medicoDTO.getNome()) != null) {
                throw new Exception(ExceptionConsts.ERRO_AO_INSERIR_NOME_DO_MEDICO);
            }

            return salvar(medicoDTO);
        } catch (Exception e) {
            throw new Exception(ExceptionConsts.ERRO_AO_INSERIR_NOME_DO_MEDICO);
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
        List<MedicoDTO> medicos = repository.findAll().stream()
                .map(e -> mapper.map(e, MedicoDTO.class)).toList();

        return medicos;

    }

    @Override
    public MedicoDTO procurarUmMedico(String name) throws Exception {
        try {
            MedicoDTO procurarMedico = mapper.map(repository.findByNome(name), MedicoDTO.class);
            if (procurarMedico == null) {
                throw new Exception(ExceptionConsts.ERRO_AO_INSERIR_NOME_DO_MEDICO);
            }

            return procurarMedico;
        } catch (Exception e) {
            throw new Exception(ExceptionConsts.ERRO_AO_INSERIR_NOME_DO_MEDICO);
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
            throw new Exception(ExceptionConsts.ERRO_AO_INSERIR_NOME_DO_MEDICO);
        }
    }
}

