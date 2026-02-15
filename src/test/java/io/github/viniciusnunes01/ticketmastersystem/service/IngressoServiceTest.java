package io.github.viniciusnunes01.ticketmastersystem.service;

import io.github.viniciusnunes01.ticketmastersystem.dto.IngressoRequestDTO;
import io.github.viniciusnunes01.ticketmastersystem.dto.IngressoResponseDTO;
import io.github.viniciusnunes01.ticketmastersystem.mapper.IngressoMapper;
import io.github.viniciusnunes01.ticketmastersystem.model.Cliente;
import io.github.viniciusnunes01.ticketmastersystem.model.Evento;
import io.github.viniciusnunes01.ticketmastersystem.model.Ingresso;
import io.github.viniciusnunes01.ticketmastersystem.repository.ClienteRepository;
import io.github.viniciusnunes01.ticketmastersystem.repository.EventoRepository;
import io.github.viniciusnunes01.ticketmastersystem.repository.IngressoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class IngressoServiceTest {

    @InjectMocks
    private IngressoService ingressoService;

    @Mock
    private IngressoRepository ingressoRepository;

    @Mock
    private EventoRepository eventoRepository;

    @Mock
    private ClienteRepository clienteRepository;

    @Mock
    private IngressoMapper ingressoMapper;

    @Test
    @DisplayName("Deve comprar ingresso com sucesso")
    void deveComprarIngressoComSucesso() {
        
        IngressoRequestDTO request = new IngressoRequestDTO();
        request.setIdCliente(1);
        request.setIdEvento(1);

        Cliente cliente = new Cliente();
        cliente.setIdCliente(1);

        Evento evento = new Evento();
        evento.setIdEvento(1);
        evento.setIngressosRestantes(10);
        evento.setPrecoBase(new BigDecimal("100.00"));

        Ingresso ingressoSalvo = new Ingresso();
        ingressoSalvo.setIdIngresso(1);

        IngressoResponseDTO dtoEsperado = new IngressoResponseDTO();
        dtoEsperado.setIdIngresso(1);

        when(clienteRepository.findById(1)).thenReturn(Optional.of(cliente));
        when(eventoRepository.findById(1)).thenReturn(Optional.of(evento));

        when(ingressoRepository.countByClienteAndEvento(cliente, evento)).thenReturn(0L);
        when(ingressoRepository.save(any(Ingresso.class))).thenReturn(ingressoSalvo);
        when(ingressoMapper.toResponseDTO(ingressoSalvo)).thenReturn(dtoEsperado);

        IngressoResponseDTO resultado = ingressoService.comprarIngresso(request);

        assertNotNull(resultado);
        assertEquals(1, resultado.getIdIngresso());
        verify(eventoRepository, times(1)).save(evento);
    }

    @Test
    @DisplayName("Deve lançar erro quando limite excedido")
    void deveLancarErroQuandoLimiteExcedido() {
        IngressoRequestDTO request = new IngressoRequestDTO();
        request.setIdCliente(1);
        request.setIdEvento(1);

        Cliente cliente = new Cliente();
        Evento evento = new Evento();

        when(clienteRepository.findById(1)).thenReturn(Optional.of(cliente));
        when(eventoRepository.findById(1)).thenReturn(Optional.of(evento));
        
        when(ingressoRepository.countByClienteAndEvento(cliente, evento)).thenReturn(5L);

        assertThrows(IllegalArgumentException.class, () -> {
            ingressoService.comprarIngresso(request);
        });
    }
}