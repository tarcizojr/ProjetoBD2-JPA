package com.autoescola.cliente.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TB_Instrutor")
public class Instrutor extends Pessoa {
	public Instrutor(){}
	
	//FK 1:N
	@OneToMany(mappedBy = "instrutor", cascade = CascadeType.ALL)
	private List<Veiculo> veiculos;
	
	@ElementCollection
	private List<Materia> materias;
	
	@ManyToOne
	@JoinColumn(name = "Pratica")
	private Pratica pratica;
	
	@ManyToOne
	@JoinColumn(name = "teorica")
	private Teorica teorica;

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}


	public List<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
	}

	public Pratica getPratica() {
		return pratica;
	}

	public void setPratica(Pratica pratica) {
		this.pratica = pratica;
	}

	public Teorica getTeorica() {
		return teorica;
	}

	public void setTeorica(Teorica teorica) {
		this.teorica = teorica;
	}
	
	
}
