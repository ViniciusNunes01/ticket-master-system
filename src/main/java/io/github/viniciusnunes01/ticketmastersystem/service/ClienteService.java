package io.github.viniciusnunes01.ticketmastersystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import io.github.viniciusnunes01.ticketmastersystem.dto.ClienteDTO;
import io.github.viniciusnunes01.ticketmastersystem.exception.ResourceNotFoundException;
import io.github.viniciusnunes01.ticketmastersystem.mapper.ClienteMapper;
import io.github.viniciusnunes01.ticketmastersystem.model.Cidade;
import io.github.viniciusnunes01.ticketmastersystem.model.Cliente;
import io.github.viniciusnunes01.ticketmastersystem.repository.CidadeRepository;
import io.github.viniciusnunes01.ticketmastersystem.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteService {

	private final ClienteRepository clienteRepository;
	private final CidadeRepository cidadeRepository;
	private final ClienteMapper clienteMapper;

	@Transactional
	public ClienteDTO salvar(ClienteDTO dto) {

		Cliente cliente = clienteMapper.toEntity(dto);

		if (dto.getEndereco() != null && dto.getEndereco().getCidade() != null) {
			Cidade cidade = cidadeRepository.findByNome(dto.getEndereco().getCidade());

			if (cidade == null) {
				throw new ResourceNotFoundException("Cidade não encontrada: " + dto.getEndereco().getCidade());
			}

			cliente.getEndereco().setCidade(cidade);
		}

		cliente = clienteRepository.save(cliente);
		return clienteMapper.toDTO(cliente);
	}

	public List<ClienteDTO> listarTodos() {
		return clienteRepository.findAll().stream().map(clienteMapper::toDTO).toList();
	}

	public ClienteDTO buscarPorId(Integer id) {
		return clienteRepository.findById(id).map(clienteMapper::toDTO)
				.orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado!"));
	}

}
