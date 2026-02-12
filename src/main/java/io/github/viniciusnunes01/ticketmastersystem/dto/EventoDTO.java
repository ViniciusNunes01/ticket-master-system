package io.github.viniciusnunes01.ticketmastersystem.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventoDTO {

	private Integer idEvento;
	private String nome;
	private LocalDateTime data;
	private Integer capacidadeMaxima;
	private Integer ingressosRestantes;
	private BigDecimal precoBase;
}
