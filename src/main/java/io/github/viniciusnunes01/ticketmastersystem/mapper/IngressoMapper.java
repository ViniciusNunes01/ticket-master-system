package io.github.viniciusnunes01.ticketmastersystem.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import io.github.viniciusnunes01.ticketmastersystem.dto.IngressoResponseDTO;
import io.github.viniciusnunes01.ticketmastersystem.model.Ingresso;

@Mapper(componentModel = "spring")
public interface IngressoMapper {

	@Mapping(source = "cliente.nome", target = "nomeCliente")
	@Mapping(source = "evento.nome", target = "nomeEvento")
	@Mapping(source = "evento.data", target = "dataEvento")
	IngressoResponseDTO toResponseDTO(Ingresso entity);
}