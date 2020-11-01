package com.example.statusnf.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.statusnf.domain.Item;
import com.example.statusnf.domain.Status;
import com.example.statusnf.dto.EstadoDto;
import com.example.statusnf.dto.StatusFilter;
import com.example.statusnf.service.StatusService;

@RestController
@RequestMapping("/status")
public class StatusResource {
	
	@Autowired
	private StatusService statusService;
	
	@GetMapping
	public Page<Status> listar(StatusFilter filter, Pageable pageable) {
		List<Status> lancamentos = statusService.filtrar(filter, pageable);		
		Long count = statusService.count(filter);

		return new PageImpl<>(lancamentos, pageable, count);
	}
	
	@GetMapping("/status-atual")
	public ResponseEntity<Status> obterStatusAtual() {
		Status status = statusService.obterStatusAtual();
		return ResponseEntity.ok(status);
	}
	
	@GetMapping("/status-atual-por-estado/{uf}")
	public ResponseEntity<Item> obterStatusAtualPorEstado(@PathVariable String uf) {
		Item item = statusService.obterStatusAtualPorEstado(uf);
		return ResponseEntity.ok(item);
	}
	
	@GetMapping("/obter-estado-com-maior-indisponibilidade")
	public ResponseEntity<EstadoDto> obterEstadoComMaiorIndisponibilidade() {
		EstadoDto estado = statusService.obterEstadoComMaiorIndisponibilidade();
		return ResponseEntity.ok(estado);
	}
	
	

}
