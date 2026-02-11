package io.github.viniciusnunes01.ticketmastersystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import io.github.viniciusnunes01.ticketmastersystem.model.Pais;
import io.github.viniciusnunes01.ticketmastersystem.repository.PaisRepository;

@Service
public class PaisService {

	private final PaisRepository paisRepository;

	public PaisService(PaisRepository paisRepository) {
		this.paisRepository = paisRepository;
	}

	public Pais salvar(Pais pais) {
		return paisRepository.save(pais);
	}

	public List<Pais> listarTodos() {
		return paisRepository.findAll();
	}
}
