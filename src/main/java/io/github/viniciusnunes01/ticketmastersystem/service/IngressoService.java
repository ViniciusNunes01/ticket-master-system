package io.github.viniciusnunes01.ticketmastersystem.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import io.github.viniciusnunes01.ticketmastersystem.dto.IngressoRequestDTO;
import io.github.viniciusnunes01.ticketmastersystem.dto.IngressoResponseDTO;
import io.github.viniciusnunes01.ticketmastersystem.exception.ResourceNotFoundException;
import io.github.viniciusnunes01.ticketmastersystem.mapper.IngressoMapper;
import io.github.viniciusnunes01.ticketmastersystem.model.Cliente;
import io.github.viniciusnunes01.ticketmastersystem.model.Evento;
import io.github.viniciusnunes01.ticketmastersystem.model.Ingresso;
import io.github.viniciusnunes01.ticketmastersystem.repository.ClienteRepository;
import io.github.viniciusnunes01.ticketmastersystem.repository.EventoRepository;
import io.github.viniciusnunes01.ticketmastersystem.repository.IngressoRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class IngressoService {

	private final IngressoRepository ingressoRepository;
	private final EventoRepository eventoRepository;
	private final ClienteRepository clienteRepository;
	private final IngressoMapper ingressoMapper;

	@Transactional
	public IngressoResponseDTO comprarIngresso(IngressoRequestDTO request) {
		Cliente cliente = clienteRepository.findById(request.getIdCliente())
				.orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado!"));

		Evento evento = eventoRepository.findById(request.getIdEvento())
				.orElseThrow(() -> new ResourceNotFoundException("Evento não encontrado!"));

		long ingressosComprados = ingressoRepository.countByClienteAndEvento(cliente, evento);

		if (ingressosComprados >= 5) {
			throw new IllegalArgumentException("Não é possível comprar mais que 5 ingressos por pessoa!");
		}

		if (evento.getIngressosRestantes() <= 0) {
			throw new IllegalArgumentException("Ingressos esgotados!");
		}

		evento.setIngressosRestantes(evento.getIngressosRestantes() - 1);
		eventoRepository.save(evento);

		Ingresso ingresso = Ingresso.builder().valorPago(evento.getPrecoBase()).cliente(cliente).evento(evento)
				.dataCompra(LocalDateTime.now()).build();

		ingresso = ingressoRepository.save(ingresso);

		return ingressoMapper.toResponseDTO(ingresso);
	}

	@Transactional
	public IngressoResponseDTO cancelarCompraIngresso(Integer idIngresso) {
		Ingresso ingresso = ingressoRepository.findById(idIngresso)
				.orElseThrow(() -> new ResourceNotFoundException("Ingresso não encontrado!"));

		Evento evento = ingresso.getEvento();
		evento.setIngressosRestantes(evento.getIngressosRestantes() + 1);
		eventoRepository.save(evento);

		IngressoResponseDTO response = ingressoMapper.toResponseDTO(ingresso);

		ingressoRepository.delete(ingresso);

		return response;
	}

	public List<IngressoResponseDTO> listarTodos() {
		return ingressoRepository.findAll().stream().map(ingressoMapper::toResponseDTO).toList();
	}
}