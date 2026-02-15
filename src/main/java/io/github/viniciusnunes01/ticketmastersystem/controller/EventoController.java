package io.github.viniciusnunes01.ticketmastersystem.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.viniciusnunes01.ticketmastersystem.dto.EventoDTO;
import io.github.viniciusnunes01.ticketmastersystem.service.EventoService;

@RestController
@RequestMapping("/eventos")
public class EventoController {

	private final EventoService eventoService;

	public EventoController(EventoService eventoService) {
		this.eventoService = eventoService;
	}

	@PostMapping
	public ResponseEntity<EventoDTO> cadastrarEvento(@RequestBody EventoDTO eventoDTO) {
		EventoDTO novoEvento = eventoService.salvar(eventoDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(novoEvento);
	}

	@GetMapping
	public ResponseEntity<List<EventoDTO>> listarEvento() {
		return ResponseEntity.ok(eventoService.listarTodos());
	}

	@GetMapping("/{id}")
	public ResponseEntity<EventoDTO> buscarPorId(@PathVariable Integer id) {

		EventoDTO dto = eventoService.buscarPorId(id);
		return ResponseEntity.ok(dto);

	}
}
