package io.github.viniciusnunes01.ticketmastersystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.viniciusnunes01.ticketmastersystem.model.Ingresso;
import io.github.viniciusnunes01.ticketmastersystem.model.Cliente;
import io.github.viniciusnunes01.ticketmastersystem.model.Evento;



public interface IngressoRepository extends JpaRepository<Ingresso, Integer> {
	
	long countByClienteAndEvento(Cliente cliente, Evento evento);
}
