package io.github.viniciusnunes01.ticketmastersystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEndereco;

	private String logradouro;
	private String numero;
	private String bairro;
	private String cep;
	private String complemento;

	@ManyToOne
	@JoinColumn(name = "id_cidade")
	private Cidade cidade;

}
