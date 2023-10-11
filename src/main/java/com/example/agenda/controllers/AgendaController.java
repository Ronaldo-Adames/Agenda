package com.example.agenda.controllers;

import com.example.agenda.models.DTO.AgendaDTO;
import com.example.agenda.models.Entities.Agenda;
import com.example.agenda.services.AgendaService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/agenda")
public class AgendaController {

    @Autowired
    AgendaService agendaService;

    @PostMapping
    public ResponseEntity<Object> criarUmHorario(@Valid @RequestBody AgendaDTO agendaDTO) throws Exception {

        try {
            return ResponseEntity.ok(agendaService.criarUmHorario(agendaDTO));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<Object> atualizarHorario(@Valid @RequestBody AgendaDTO agendaDTO) throws Exception {
        //Verificando se o horário existe
        AgendaDTO existeAgenda = agendaService.procurarUmHorarioById(agendaDTO.getId());

        if (existeAgenda == null) {
            return ResponseEntity.notFound().build();
        }

        try {
            // Copie os atributos de agendaDTO para o existe Agenda usando o BeanUtils
            BeanUtils.copyProperties(agendaDTO, existeAgenda);
            // Salvar a atualização no banco de dados
            return ResponseEntity.ok(agendaService.atualizarHorario(existeAgenda));

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping(value = "/{id}")
    public void deletarHorario(@PathVariable Long id) {
        agendaService.deletarHorario(id);
    }

    @GetMapping(value = "/lista-horarios")
    public List<AgendaDTO> listaHorarios(@RequestParam(name = "dataConsulta") String dataConsulta,
                                         @RequestParam(name = "id") Long id) {
        return agendaService.listaHorarios(dataConsulta, id);
    }

    @GetMapping("/list-all")
    public List<Agenda> listaAgenda() {

        return agendaService.listaAgenda();
    }
    @GetMapping
    public AgendaDTO procurarUmHorario(@RequestParam(name = "pacienteNome") String pacienteNome,
                                           @RequestParam(name = "medicoId") Long medicoId) throws Exception {

        try {
            return agendaService.procurarUmHorario(pacienteNome, medicoId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

