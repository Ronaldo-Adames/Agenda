package services;

import com.example.agenda.models.DTO.AgendaDTO;
import com.example.agenda.models.Entities.Agenda;
import com.example.agenda.repositories.AgendaRepository;
import com.example.agenda.services.interfaces.AgendaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AgendaServiceTest {

    @InjectMocks
    private AgendaService agendaService;

    @Mock
    private AgendaRepository agendaRepository;

    @Mock
    private ModelMapper modelMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void criarUmHorarioSucesso() throws Exception {
        AgendaDTO agendaDTO = new AgendaDTO();

        when(agendaRepository.verificaMesmoHorario(anyString(), anyString(), anyString(), anyLong())).thenReturn(null);
        when(modelMapper.map(agendaDTO, Agenda.class)).thenReturn(new Agenda());
        when(agendaRepository.save(any(Agenda.class))).thenReturn(new Agenda());

        Long id = agendaService.criarUmHorario(agendaDTO);

        assertNotNull(id);
    }

    @Test
    public void criarUmHorarioDuplicarHorario() {
        AgendaDTO agendaDTO = new AgendaDTO();

        when(agendaRepository.verificaMesmoHorario(anyString(), anyString(), anyString(), anyLong())).thenReturn(new Agenda());

        assertThrows(Exception.class, () -> agendaService.criarUmHorario(agendaDTO));
    }

    @Test
    public void atualizarHorarioSucesso() throws Exception {
        AgendaDTO agendaDTO = new AgendaDTO();

        when(modelMapper.map(agendaDTO, Agenda.class)).thenReturn(new Agenda());
        when(agendaRepository.save(any(Agenda.class))).thenReturn(new Agenda());

        Long id = agendaService.atualizarHorario(agendaDTO);

        assertNotNull(id);
    }

    @Test
    public void deletarHorario() {
        Long id = 1L;

        agendaService.deletarHorario(id);

        verify(agendaRepository, times(1)).deleteById(id);
    }

    @Test
    public void listaHorarios() {
        String dataConsulta = "2023-10-09";
        Long medicoId = 1L;
        List<Agenda> horarios = new ArrayList<>();
        when(agendaRepository.listaConsultas(dataConsulta, medicoId)).thenReturn(horarios);
        when(modelMapper.map(any(Agenda.class), eq(AgendaDTO.class))).thenReturn(new AgendaDTO());

        List<AgendaDTO> result = agendaService.listaHorarios(dataConsulta, medicoId);

        assertNotNull(result);
        assertEquals(0, result.size());
    }

    @Test
    public void procurarUmHorario_Success() throws Exception {
        String pacienteNome = "João";
        Long medicoId = 1L;
        Agenda agenda = new Agenda();

        when(agendaRepository.procurarUmHorario(pacienteNome, medicoId)).thenReturn(agenda);
        when(modelMapper.map(agenda, AgendaDTO.class)).thenReturn(new AgendaDTO());

        AgendaDTO agendaDTO = agendaService.procurarUmHorario(pacienteNome, medicoId);

        assertNotNull(agendaDTO);
    }

    @Test
    public void procurarUmHorario_NotFound() {
        String pacienteNome = "João";
        Long medicoId = 1L;

        when(agendaRepository.procurarUmHorario(pacienteNome, medicoId)).thenReturn(null);

        assertThrows(Exception.class, () -> agendaService.procurarUmHorario(pacienteNome, medicoId));
    }

    @Test
    public void procurarUmHorarioById_Success() {
        Long id = 1L;
        Agenda agenda = new Agenda();

        when(agendaRepository.findById(id)).thenReturn(java.util.Optional.of(agenda));
        when(modelMapper.map(agenda, AgendaDTO.class)).thenReturn(new AgendaDTO());

        AgendaDTO agendaDTO = agendaService.procurarUmHorarioById(id);

        assertNotNull(agendaDTO);
    }

    @Test
    public void procurarUmHorarioById_NotFound() {
        Long id = 1L;

        when(agendaRepository.findById(id)).thenReturn(java.util.Optional.empty());

        AgendaDTO agendaDTO = agendaService.procurarUmHorarioById(id);

        assertNull(agendaDTO);
    }
}
