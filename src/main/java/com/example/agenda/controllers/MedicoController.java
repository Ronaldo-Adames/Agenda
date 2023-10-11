package com.example.agenda.controllers;

import com.example.agenda.models.DTO.MedicoDTO;
import com.example.agenda.services.MedicoService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/medico")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @PostMapping
    public ResponseEntity<Object> adicionarMedico(@Valid @RequestBody MedicoDTO medicoDTO) {

        try {
            return ResponseEntity.ok(medicoService.adicionarMedico(medicoDTO));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping(value = "/{id}")
    public void deletarMedico(@PathVariable Long id) {
        medicoService.deletarMedico(id);
    }

    @PutMapping
    public ResponseEntity<Object> atualizarMedico(@Valid @RequestBody MedicoDTO medicoDTO) {
        //Verificando se o existe médico
        MedicoDTO existeUmMedico = medicoService.procurarUmMedicoById(medicoDTO.getId());

        if (existeUmMedico == null) {
            return ResponseEntity.notFound().build();
        }

        try {
            // Copie os atributos de medicoDTO para o existe um médico usando o BeanUtils
            BeanUtils.copyProperties(medicoDTO, existeUmMedico);
            // Salve a atualização no banco de dados
            return ResponseEntity.ok(medicoService.atualizarMedico(existeUmMedico));

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/list-all")
    public List<MedicoDTO> listaDeMedicos() {
        return medicoService.listarMedicos();
    }

    @GetMapping
    public MedicoDTO procurarUmMedico(@RequestParam(name = "medicoNome") String medicoNome) {

        try {
            return medicoService.procurarUmMedico(medicoNome);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}


