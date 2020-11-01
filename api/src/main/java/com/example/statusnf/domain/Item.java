package com.example.statusnf.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class Item {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Getter
	private Long id;
	
	@Column(nullable = false)
	@Getter @Setter
	private String autorizador;
	
	@Enumerated()
	@Getter @Setter
	private Disponibilidade autorizacao;
	   
	@Enumerated
	@Column(name = "retorno_autorizacao")
	@Getter @Setter
	private Disponibilidade retornoAutorizacao;
	   
	@Enumerated
	@Getter @Setter
	private Disponibilidade inutilizacao;
	   
	@Enumerated
	@Column(name = "consulta_protocolo")
	@Getter @Setter
	private Disponibilidade consultaProtocolo;
	   
	@Enumerated
	@Column(name = "status_servico")
	@Getter @Setter
	private Disponibilidade statusServico;
	   
	@Enumerated
	@Column(name = "consulta_cadastro")
	@Getter @Setter
	private Disponibilidade consultaCadastro;
	   
	@Enumerated
	@Column(name = "recepcao_evento")
	@Getter @Setter
	private Disponibilidade recepcaoEvento;

}

