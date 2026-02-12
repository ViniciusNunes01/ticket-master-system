package io.github.viniciusnunes01.ticketmastersystem.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.viniciusnunes01.ticketmastersystem.dto.CompraDTO;
import io.github.viniciusnunes01.ticketmastersystem.model.Cliente;
import io.github.viniciusnunes01.ticketmastersystem.model.Evento;
import io.github.viniciusnunes01.ticketmastersystem.model.Ingresso;
import io.github.viniciusnunes01.ticketmastersystem.repository.ClienteRepository;
import io.github.viniciusnunes01.ticketmastersystem.repository.EventoRepository;
import io.github.viniciusnunes01.ticketmastersystem.service.IngressoService;

@RestController
@RequestMapping("/ingresso")
public class IngressoController {

	private final IngressoService ingressoService;
	private final ClienteRepository clienteRepository;
	private final EventoRepository eventoRepository;

	public IngressoController(IngressoService ingressoService, ClienteRepository clienteRepository,
			EventoRepository eventoRepository) {
		super();
		this.ingressoService = ingressoService;
		this.clienteRepository = clienteRepository;
		this.eventoRepository = eventoRepository;
	}

	@PostMapping
	public ResponseEntity<Object> comprar(@RequestBody CompraDTO compraDTO) {

		Cliente cliente = clienteRepository.findById(compraDTO.getIdCliente())
				.orElseThrow(() -> new RuntimeException("Cliente não encontrado!"));

		Evento evento = eventoRepository.findById(compraDTO.getIdEvento())
				.orElseThrow(() -> new RuntimeException("Evento não encontrado!"));

		try {
			Ingresso novoIngresso = ingressoService.comprarIngresso(evento, cliente);
			return ResponseEntity.ok(novoIngresso);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> removerCompra(@PathVariable("id") Integer idIngresso) {

		try {
			ingressoService.cancelarCompraIngresso(idIngresso);
			return ResponseEntity.noContent().build();

		} catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}

	}
	
	@GetMapping
	public List<Ingresso> listarIngressos(){
		return ingressoService.listarTodos();
	}

}
