package io.github.viniciusnunes01.ticketmastersystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {

	private Integer idCliente;

	private String nome;
	private String cpf;
	private String email;
	private String telefone;
	private LocalDate dataNascimento;

	private EnderecoDTO endereco;
}