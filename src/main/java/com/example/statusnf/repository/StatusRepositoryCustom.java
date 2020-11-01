package com.example.statusnf.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.example.statusnf.domain.Status;
import com.example.statusnf.dto.EstadoDto;
import com.example.statusnf.dto.StatusFilter;

public interface StatusRepositoryCustom {
	
	public List<Status> filtrar(StatusFilter filter, Pageable pageable);
	public Long count(StatusFilter filter);
	public List<EstadoDto> obterResumoDisponibilidade(); 

}
