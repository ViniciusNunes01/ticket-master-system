package io.github.viniciusnunes01.ticketmastersystem.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.viniciusnunes01.ticketmastersystem.model.Cidade;
import io.github.viniciusnunes01.ticketmastersystem.service.CidadeService;

@RestController
@RequestMapping("/cidade")
public class CidadeController {

	private final CidadeService cidadeService;

	public CidadeController(CidadeService cidadeService) {
		this.cidadeService = cidadeService;
	}

	@PostMapping
	public Cidade cadastrarCidade(@RequestBody Cidade cidade) {
		return cidadeService.salvar(cidade);
	}

	@GetMapping
	public List<Cidade> listarCidade() {
		return cidadeService.listarTodos();
	}
}
