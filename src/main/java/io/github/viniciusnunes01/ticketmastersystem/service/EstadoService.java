package io.github.viniciusnunes01.ticketmastersystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import io.github.viniciusnunes01.ticketmastersystem.model.Estado;
import io.github.viniciusnunes01.ticketmastersystem.repository.EstadoRepository;

@Service
public class EstadoService {

	private final EstadoRepository estadoRepository;

	public EstadoService(EstadoRepository estadoRepository) {
		this.estadoRepository = estadoRepository;
	}

	public Estado salvar(Estado estado) {
		return estadoRepository.save(estado);
	}

	public List<Estado> listarTodos() {
		return estadoRepository.findAll();
	}
}
