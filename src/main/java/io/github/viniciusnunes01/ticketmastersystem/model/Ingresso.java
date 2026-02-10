package io.github.viniciusnunes01.ticketmastersystem.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Ingresso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idIngresso;

	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;

	@ManyToOne
	@JoinColumn(name = "id_evento")
	private Evento evento;

	private BigDecimal valorPago;
	private LocalDateTime dataCompra;

	public Ingresso() {

	}

	public Ingresso(Cliente cliente, Evento evento, BigDecimal valorPago) {
		super();

		if (cliente == null) {
			throw new IllegalArgumentException("É necessário um cliente");
		}
		this.cliente = cliente;

		if (evento == null) {
			throw new IllegalArgumentException("É necessário um evento");
		}
		this.evento = evento;

		if (valorPago.compareTo(BigDecimal.ZERO) < 0) {
			throw new IllegalArgumentException("O valor pago não pode ser negativo");
		}
		this.valorPago = valorPago;
		this.dataCompra = LocalDateTime.now();
	}

	public Integer getIdIngresso() {
		return idIngresso;
	}

	public void setIdIngresso(Integer idIngresso) {
		this.idIngresso = idIngresso;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public BigDecimal getValorPago() {
		return valorPago;
	}

	public void setValorPago(BigDecimal valorPago) {
		this.valorPago = valorPago;
	}

	public LocalDateTime getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(LocalDateTime dataCompra) {
		this.dataCompra = dataCompra;
	}

}
