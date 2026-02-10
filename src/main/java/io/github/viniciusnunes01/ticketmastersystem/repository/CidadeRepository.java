package io.github.viniciusnunes01.ticketmastersystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.viniciusnunes01.ticketmastersystem.model.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

}
