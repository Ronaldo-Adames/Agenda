package services;

import com.example.agenda.models.DTO.MedicoDTO;
import com.example.agenda.models.Entities.Medico;
import com.example.agenda.repositories.MedicoRepository;
import com.example.agenda.services.MedicoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MedicoServiceTest {

    @InjectMocks
    private MedicoService medicoService;

    @Mock
    private MedicoRepository medicoRepository;

    @Mock
    private ModelMapper modelMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAdicionarMedico_Success() throws Exception {
        MedicoDTO medicoDTO = new MedicoDTO();
        medicoDTO.setNome("Dr. Smith");

        when(medicoRepository.findByNome("Dr. Smith")).thenReturn(null);
        when(modelMapper.map(medicoDTO, Medico.class)).thenReturn(new Medico());
        when(medicoRepository.save(any(Medico.class))).thenReturn(new Medico());

        Long id = medicoService.adicionarMedico(medicoDTO);

        assertNotNull(id);
    }

    @Test
    public void testAdicionarMedico_DuplicateName() {
        MedicoDTO medicoDTO = new MedicoDTO();
        medicoDTO.setNome("Dr. Smith");

        when(medicoRepository.findByNome("Dr. Smith")).thenReturn(new Medico());

        assertThrows(Exception.class, () -> medicoService.adicionarMedico(medicoDTO));
    }

    @Test
    public void testAtualizarMedico_Success() throws Exception {
        MedicoDTO medicoDTO = new MedicoDTO();

        when(modelMapper.map(medicoDTO, Medico.class)).thenReturn(new Medico());
        when(medicoRepository.save(any(Medico.class))).thenReturn(new Medico());

        Long id = medicoService.atualizarMedico(medicoDTO);

        assertNotNull(id);
    }

    @Test
    public void testDeletarMedico() {
        Long id = 1L;

        medicoService.deletarMedico(id);

        verify(medicoRepository, times(1)).deleteById(id);
    }

    @Test
    public void testListarMedicos() {
        List<Medico> medicos = new ArrayList<>();
        when(medicoRepository.findAll()).thenReturn(medicos);
        when(modelMapper.map(any(Medico.class), eq(MedicoDTO.class))).thenReturn(new MedicoDTO());

        List<MedicoDTO> result = medicoService.listarMedicos();

        assertNotNull(result);
        assertEquals(0, result.size());
    }

    @Test
    public void testProcurarUmMedico_Success() throws Exception {
        String nome = "Dr. Smith";
        Medico medico = new Medico();
        medico.setNome(nome);

        when(medicoRepository.findByNome(nome)).thenReturn(medico);
        when(modelMapper.map(medico, MedicoDTO.class)).thenReturn(new MedicoDTO());

        MedicoDTO medicoDTO = medicoService.procurarUmMedico(nome);

        assertNotNull(medicoDTO);
        assertEquals(nome, medicoDTO.getNome());
    }

    @Test
    public void testProcurarUmMedico_NotFound() {
        String nome = "Dr. Smith";

        when(medicoRepository.findByNome(nome)).thenReturn(null);

        assertThrows(Exception.class, () -> medicoService.procurarUmMedico(nome));
    }

    @Test
    public void testProcurarUmMedicoById_Success() {
        Long id = 1L;
        Medico medico = new Medico();
        medico.setId(id);

        when(medicoRepository.findById(id)).thenReturn(Optional.of(medico));
        when(modelMapper.map(medico, MedicoDTO.class)).thenReturn(new MedicoDTO());

        MedicoDTO medicoDTO = medicoService.procurarUmMedicoById(id);

        assertNotNull(medicoDTO);
        assertEquals(id, medicoDTO.getId());
    }

    @Test
    public void testProcurarUmMedicoById_NotFound() {
        Long id = 1L;

        when(medicoRepository.findById(id)).thenReturn(Optional.empty());

        MedicoDTO medicoDTO = medicoService.procurarUmMedicoById(id);

        assertNull(medicoDTO);
    }
}

