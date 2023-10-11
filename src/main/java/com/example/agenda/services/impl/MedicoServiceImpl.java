package com.example.agenda.services.impl;

import com.example.agenda.models.DTO.MedicoDTO;

import java.util.List;

public interface MedicoServiceImpl {
    Long adicionarMedico(MedicoDTO medicoDTO) throws Exception;

    void deletarMedico(Long id);

    Long atualizarMedico(MedicoDTO medicoDTO) throws Exception;

    List<MedicoDTO> listarMedicos();

    MedicoDTO procurarUmMedico(String name) throws Exception;

    MedicoDTO procurarUmMedicoById(Long id);

}
