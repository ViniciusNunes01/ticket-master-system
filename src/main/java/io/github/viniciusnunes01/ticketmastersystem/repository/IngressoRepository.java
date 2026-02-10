package io.github.viniciusnunes01.ticketmastersystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.viniciusnunes01.ticketmastersystem.model.Ingresso;

public interface IngressoRepository extends JpaRepository<Ingresso, Integer> {

}
