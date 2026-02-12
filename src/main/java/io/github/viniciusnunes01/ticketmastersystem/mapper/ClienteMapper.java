package io.github.viniciusnunes01.ticketmastersystem.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import io.github.viniciusnunes01.ticketmastersystem.dto.ClienteDTO;
import io.github.viniciusnunes01.ticketmastersystem.model.Cliente;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

	@Mapping(source = "endereco.cidade.nome", target = "endereco.cidade")
	@Mapping(source = "endereco.cidade.estado.sigla", target = "endereco.estado")
	ClienteDTO toDTO(Cliente cliente);

	@Mapping(target = "endereco.cidade", ignore = true)
	@Mapping(target = "endereco.idEndereco", ignore = true)
	@Mapping(target = "idCliente", ignore = true)
	Cliente toEntity(ClienteDTO dto);
}