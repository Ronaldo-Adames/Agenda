package com.example.agenda.services.interfaces;

import com.example.agenda.models.DTO.MedicoDTO;

import java.util.List;

public interface IMedicoService {
    Long adicionarMedico(MedicoDTO medicoDTO) throws Exception;

    void deletarMedico(Long id);

    Long atualizarMedico(MedicoDTO medicoDTO) throws Exception;

    List<MedicoDTO> listarMedicos();

    MedicoDTO procurarUmMedico(String name) throws Exception;

    MedicoDTO procurarUmMedicoById(Long id);

}
