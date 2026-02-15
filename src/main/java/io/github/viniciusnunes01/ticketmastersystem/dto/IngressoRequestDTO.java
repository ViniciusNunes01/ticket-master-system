package io.github.viniciusnunes01.ticketmastersystem.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class IngressoRequestDTO {

	@Schema(description = "ID do Cliente que está comprando", example = "1")
	private Integer idCliente;
	
	@Schema(description = "ID do Evento desejado", example = "5")
	private Integer idEvento;
}