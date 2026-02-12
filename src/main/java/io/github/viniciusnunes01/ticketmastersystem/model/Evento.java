package io.github.viniciusnunes01.ticketmastersystem.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Evento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEvento;

	private String nome;
	private LocalDateTime data;
	private Integer capacidadeMaxima;
	private Integer ingressosRestantes;
	private BigDecimal precoBase;

}
