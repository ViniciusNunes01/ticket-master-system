package io.github.viniciusnunes01.ticketmastersystem.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import io.github.viniciusnunes01.ticketmastersystem.exception.ResourceNotFoundException;
import io.github.viniciusnunes01.ticketmastersystem.model.Cliente;
import io.github.viniciusnunes01.ticketmastersystem.model.Evento;
import io.github.viniciusnunes01.ticketmastersystem.model.Ingresso;
import io.github.viniciusnunes01.ticketmastersystem.repository.EventoRepository;
import io.github.viniciusnunes01.ticketmastersystem.repository.IngressoRepository;
import jakarta.transaction.Transactional;

@Service
public class IngressoService {

	private final IngressoRepository ingressoRepository;
	private final EventoRepository eventoRepository;

	public IngressoService(IngressoRepository ingressoRepository, EventoRepository eventoRepository) {
		this.ingressoRepository = ingressoRepository;
		this.eventoRepository = eventoRepository;
	}

	@Transactional
	public Ingresso comprarIngresso(Evento evento, Cliente cliente) {
		
		long ingressosComprados = ingressoRepository.countByClienteAndEvento(cliente, evento);
		
		if(ingressosComprados >= 5) {
			throw new IllegalArgumentException("Não é possível comprar mais que 5 ingressos por pessoa!");
		}

		if (evento.getIngressosRestantes() <= 0) {
			throw new IllegalArgumentException("Ingressos esgotados!");
		}

		evento.setIngressosRestantes(evento.getIngressosRestantes() - 1);
		eventoRepository.save(evento);

		Ingresso ingresso = new Ingresso();
		ingresso.setValorPago(evento.getPrecoBase());
		ingresso.setCliente(cliente);
		ingresso.setEvento(evento);
		ingresso.setDataCompra(LocalDateTime.now());

		return ingressoRepository.save(ingresso);
	}

	@Transactional
	public void cancelarCompraIngresso(Integer idIngresso) {

		Ingresso ingresso = ingressoRepository.findById(idIngresso)
				.orElseThrow(() -> new ResourceNotFoundException("Ingresso não encontrado!"));

		Evento evento = ingresso.getEvento();

		evento.setIngressosRestantes(evento.getIngressosRestantes() + 1);
		eventoRepository.save(evento);

		ingressoRepository.delete(ingresso);
	}
	
	public List<Ingresso> listarTodos(){
		return ingressoRepository.findAll();
	}
}