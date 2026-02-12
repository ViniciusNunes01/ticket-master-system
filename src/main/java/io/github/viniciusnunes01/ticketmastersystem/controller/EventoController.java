package io.github.viniciusnunes01.ticketmastersystem.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.viniciusnunes01.ticketmastersystem.model.Evento;
import io.github.viniciusnunes01.ticketmastersystem.service.EventoService;

@RestController
@RequestMapping("/evento")
public class EventoController {

	private final EventoService eventoService;

	public EventoController(EventoService eventoService) {
		this.eventoService = eventoService;
	}

	@PostMapping
	public Evento cadastrarEvento(@RequestBody Evento evento) {
		return eventoService.salvar(evento);
	}

	@GetMapping
	public List<Evento> listarEvento() {
		return eventoService.listarTodos();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Evento> buscarPorId(@PathVariable Integer id) {

		Evento evento = eventoService.buscarPorId(id);
		return ResponseEntity.ok(evento);

	}
}
