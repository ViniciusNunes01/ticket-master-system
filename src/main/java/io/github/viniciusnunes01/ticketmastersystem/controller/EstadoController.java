package io.github.viniciusnunes01.ticketmastersystem.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.viniciusnunes01.ticketmastersystem.model.Estado;
import io.github.viniciusnunes01.ticketmastersystem.service.EstadoService;

@RestController
@RequestMapping("/estados")
public class EstadoController {

	private final EstadoService estadoService;

	public EstadoController(EstadoService estadoService) {
		this.estadoService = estadoService;
	}

	@PostMapping
	public Estado cadastrarEstado(@RequestBody Estado estado) {
		return estadoService.salvar(estado);
	}

	@GetMapping
	public List<Estado> listarEstado() {
		return estadoService.listarTodos();
	}

}
