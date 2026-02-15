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

import io.github.viniciusnunes01.ticketmastersystem.dto.ClienteDTO;
import io.github.viniciusnunes01.ticketmastersystem.service.ClienteService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	private final ClienteService clienteService;

	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}

	@PostMapping
	public ResponseEntity<ClienteDTO> cadastrarCliente(@RequestBody @Valid ClienteDTO clienteDTO) {
		ClienteDTO novoCliente = clienteService.salvar(clienteDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(novoCliente);
	}

	@GetMapping
	public ResponseEntity<List<ClienteDTO>> listarCliente() {
		return ResponseEntity.ok(clienteService.listarTodos());
	}

	@GetMapping("/{id}")
	public ResponseEntity<ClienteDTO> buscarPorId(@PathVariable Integer id) {
		ClienteDTO dto = clienteService.buscarPorId(id);
		return ResponseEntity.ok(dto);
	}
}