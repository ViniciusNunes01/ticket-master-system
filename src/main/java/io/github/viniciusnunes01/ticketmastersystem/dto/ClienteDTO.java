package io.github.viniciusnunes01.ticketmastersystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {

	private Integer idCliente;

	@NotBlank(message = "O nome é obrigatório.")
	private String nome;
	
	@NotBlank(message = "O CPF é obrigatório.")
	@CPF(message = "CPF INVÁLIDO.")
	private String cpf;
	
	@NotBlank(message = "O e-mail é obrigatório.")
	@Email(message = "E-MAIL INVÁLIDO.")
	private String email;
	private String telefone;
	private LocalDate dataNascimento;

	private EnderecoDTO endereco;
}