package io.github.viniciusnunes01.ticketmastersystem.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.viniciusnunes01.ticketmastersystem.dto.IngressoRequestDTO;
import io.github.viniciusnunes01.ticketmastersystem.dto.IngressoResponseDTO;
import io.github.viniciusnunes01.ticketmastersystem.service.IngressoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/ingressos")
@RequiredArgsConstructor
public class IngressoController {

    private final IngressoService ingressoService;

    @Operation(summary = "Realizar compra de ingresso", description = "Registra a compra de um ingresso para um cliente em um evento específico.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Compra realizada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro de validação (ex: sem estoque, limite excedido)"),
            @ApiResponse(responseCode = "404", description = "Cliente ou Evento não encontrados")
    })
    @PostMapping
    public ResponseEntity<IngressoResponseDTO> comprar(@RequestBody IngressoRequestDTO request) {
        IngressoResponseDTO response = ingressoService.comprarIngresso(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<IngressoResponseDTO>> listar() {
        return ResponseEntity.ok(ingressoService.listarTodos());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelar(@PathVariable Integer id) {
        ingressoService.cancelarCompraIngresso(id);
        return ResponseEntity.noContent().build();
    }
}