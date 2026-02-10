package io.github.viniciusnunes01.ticketmastersystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.viniciusnunes01.ticketmastersystem.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
