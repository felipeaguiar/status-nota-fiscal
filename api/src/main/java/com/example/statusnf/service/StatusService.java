package com.example.statusnf.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.statusnf.domain.Item;
import com.example.statusnf.domain.Status;
import com.example.statusnf.dto.EstadoDto;
import com.example.statusnf.dto.StatusFilter;
import com.example.statusnf.exception.NaoHaEstadosException;
import com.example.statusnf.repository.StatusRepository;

@Service
public class StatusService {
	
	@Autowired
	private StatusRepository statusRepository;
	
	public Status obterStatusAtual() {
		return statusRepository.findFirstByOrderByTimestampAsc()
			.orElseThrow(() -> new EmptyResultDataAccessException(1));
		
	}
	
	public List<Status> filtrar(StatusFilter filter, Pageable pageable) {
		return statusRepository.filtrar(filter, pageable);
	}
	
	public Long count(StatusFilter filter) {
		return statusRepository.count(filter);
	}

	public Item obterStatusAtualPorEstado(String uf) {
		Status status = statusRepository.findFirstByOrderByTimestampAsc()
			.orElseThrow(() -> new EmptyResultDataAccessException(1));
		
		Optional<Item> item = status.getItens().stream()
			.filter(e -> e.getAutorizador().equalsIgnoreCase(uf))
			.findAny();
		
		return item.orElseThrow(() -> new EmptyResultDataAccessException(1));
	}
	
	public EstadoDto obterEstadoComMaiorIndisponibilidade() {
		List<EstadoDto> resumo = statusRepository.obterResumoDisponibilidade();
		return resumo.stream().max(Comparator.comparing(EstadoDto::getQuantidade))
			.orElseThrow(NaoHaEstadosException::new);
	}
	
}
