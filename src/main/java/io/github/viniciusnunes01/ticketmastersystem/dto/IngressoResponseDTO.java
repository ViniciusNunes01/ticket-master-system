package io.github.viniciusnunes01.ticketmastersystem.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IngressoResponseDTO {
	
	private Integer idIngresso;
	private String nomeCliente;
	private String nomeEvento;
	private LocalDateTime dataEvento;
	private BigDecimal valorPago;
	private LocalDateTime dataCompra;
}