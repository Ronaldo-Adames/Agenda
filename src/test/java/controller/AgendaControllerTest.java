package controller;

import com.example.agenda.controllers.AgendaController;
import com.example.agenda.models.DTO.AgendaDTO;
import com.example.agenda.services.interfaces.AgendaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AgendaControllerTest {

    @InjectMocks
    private AgendaController agendaController;

    @Mock
    private AgendaService agendaService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void criarUmHorario() throws Exception {
        AgendaDTO agendaDTO = new AgendaDTO();
        when(agendaService.criarUmHorario(agendaDTO)).thenReturn(1l);

        ResponseEntity<Object> response = agendaController.criarUmHorario(agendaDTO);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void atualizarHorario() throws Exception {
        AgendaDTO agendaDTO = new AgendaDTO();
        agendaDTO.setId(1L);
        when(agendaService.procurarUmHorarioById(1L)).thenReturn(agendaDTO);
        OngoingStubbing<Long> longOngoingStubbing = when(agendaService.atualizarHorario(agendaDTO)).thenReturn((long) 1l);

        ResponseEntity<Object> response = agendaController.atualizarHorario(agendaDTO);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void deletarHorario() {
        Long id = 1L;
        agendaController.deletarHorario(id);

        verify(agendaService, times(1)).deletarHorario(id);
    }

    @Test
    public void listaHorarios() {
        String dataConsulta = "2023-10-09";
        Long id = 1L;
        List<AgendaDTO> horarios = new ArrayList<>();
        when(agendaService.listaHorarios(dataConsulta, id)).thenReturn(horarios);

        List<AgendaDTO> result = agendaController.listaHorarios(dataConsulta, id);

        assertEquals(horarios, result);
    }

    @Test
    public void procurarUmHorario() throws Exception {
        String pacienteNome = "João";
        Long medicoId = 1L;
        AgendaDTO agendaDTO = new AgendaDTO();
        when(agendaService.procurarUmHorario(pacienteNome, medicoId)).thenReturn(agendaDTO);

        AgendaDTO result = agendaController.procurarUmHorario(pacienteNome, medicoId);

        assertEquals(agendaDTO, result);
    }
}

