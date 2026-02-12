package io.github.viniciusnunes01.ticketmastersystem.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.viniciusnunes01.ticketmastersystem.model.Pais;
import io.github.viniciusnunes01.ticketmastersystem.service.PaisService;

@RestController
@RequestMapping("/api/paises")
public class PaisController {

	private final PaisService paisService;

	public PaisController(PaisService paisService) {
		this.paisService = paisService;
	}
	
	@PostMapping
	public Pais cadastrarPais(@RequestBody Pais pais) {
		return paisService.salvar(pais);
	}
	
	@GetMapping
	public List<Pais> listarPais(){
		return paisService.listarTodos();
	}

}
