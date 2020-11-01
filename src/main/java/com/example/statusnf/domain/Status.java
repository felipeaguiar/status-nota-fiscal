package com.example.statusnf.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class Status {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Getter
	private Long id;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "id_status")
	private List<Item> itens = new ArrayList<>();
	
	@Column(nullable = false)
	@Getter @Setter
	private LocalDateTime timestamp;
	
	public void addItens(Item item) {
		itens.add(item);
	}

	public void removeItens(Item item) {
		itens.remove(item);
	}

	public List<Item> getItens() {
		return Collections.unmodifiableList(itens);
	}

}
