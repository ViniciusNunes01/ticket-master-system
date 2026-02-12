package io.github.viniciusnunes01.ticketmastersystem.mapper;

import org.mapstruct.Mapper;

import io.github.viniciusnunes01.ticketmastersystem.dto.EventoDTO;
import io.github.viniciusnunes01.ticketmastersystem.model.Evento;

@Mapper(componentModel = "spring")
public interface EventoMapper {

	EventoDTO toDTO(Evento evento);

	Evento toEntity(EventoDTO dto);

}
