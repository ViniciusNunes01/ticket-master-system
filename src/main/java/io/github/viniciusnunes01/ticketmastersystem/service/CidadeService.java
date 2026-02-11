package io.github.viniciusnunes01.ticketmastersystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import io.github.viniciusnunes01.ticketmastersystem.model.Cidade;
import io.github.viniciusnunes01.ticketmastersystem.repository.CidadeRepository;

@Service
public class CidadeService {

	private final CidadeRepository cidadeRepository;

	public CidadeService(CidadeRepository cidadeRepository) {
		this.cidadeRepository = cidadeRepository;
	}

	public Cidade salvar(Cidade cidade) {
		return cidadeRepository.save(cidade);
	}

	public List<Cidade> listarTodos() {
		return cidadeRepository.findAll();
	}
}
