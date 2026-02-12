package io.github.viniciusnunes01.ticketmastersystem.controller;

import io.github.viniciusnunes01.ticketmastersystem.dto.IngressoRequestDTO;
import io.github.viniciusnunes01.ticketmastersystem.dto.IngressoResponseDTO;
import io.github.viniciusnunes01.ticketmastersystem.service.IngressoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ingressos")
@RequiredArgsConstructor
public class IngressoController {

    private final IngressoService ingressoService;

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