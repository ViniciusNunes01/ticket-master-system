package io.github.viniciusnunes01.ticketmastersystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDTO {
	private String logradouro;
	private String numero;
	private String bairro;
	private String cep;
	private String complemento;
	private String cidade;
	private String estado;
}