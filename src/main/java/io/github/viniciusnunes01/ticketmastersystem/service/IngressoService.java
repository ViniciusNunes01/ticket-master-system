package io.github.viniciusnunes01.ticketmastersystem.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

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
}