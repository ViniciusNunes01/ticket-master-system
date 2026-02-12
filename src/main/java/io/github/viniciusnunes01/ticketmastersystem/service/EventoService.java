package io.github.viniciusnunes01.ticketmastersystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import io.github.viniciusnunes01.ticketmastersystem.dto.EventoDTO;
import io.github.viniciusnunes01.ticketmastersystem.exception.ResourceNotFoundException;
import io.github.viniciusnunes01.ticketmastersystem.mapper.EventoMapper;
import io.github.viniciusnunes01.ticketmastersystem.model.Evento;
import io.github.viniciusnunes01.ticketmastersystem.repository.EventoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EventoService {

	private final EventoRepository eventoRepository;
	private final EventoMapper eventoMapper;

	public EventoDTO salvar(EventoDTO dto) {

		Evento evento = eventoMapper.toEntity(dto);
		evento = eventoRepository.save(evento);
		return eventoMapper.toDTO(evento);
	}

	public List<EventoDTO> listarTodos() {
		return eventoRepository.findAll().stream().map(eventoMapper::toDTO).toList();
	}

	public EventoDTO buscarPorId(Integer id) {
        return eventoRepository.findById(id)
                .map(eventoMapper::toDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Evento não encontrado! ID: " + id));
    }
}
