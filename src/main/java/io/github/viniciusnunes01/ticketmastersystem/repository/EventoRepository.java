package io.github.viniciusnunes01.ticketmastersystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.viniciusnunes01.ticketmastersystem.model.Evento;

public interface EventoRepository extends JpaRepository<Evento, Integer> {

}
