package io.github.viniciusnunes01.ticketmastersystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import io.github.viniciusnunes01.ticketmastersystem.model.Evento;
import io.github.viniciusnunes01.ticketmastersystem.repository.EventoRepository;

@Service
public class EventoService {

	private final EventoRepository eventoRepository;

	public EventoService(EventoRepository eventoRepository) {
		this.eventoRepository = eventoRepository;
	}

	public Evento salvar(Evento evento) {
		return eventoRepository.save(evento);
	}

	public List<Evento> listarTodos() {
		return eventoRepository.findAll();
	}

	public Evento buscarPorId(Integer id) {
		return eventoRepository.findById(id).orElseThrow(() -> new RuntimeException("Evento não encontrado!"));
	}

}
