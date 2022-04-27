package com.autoescola.cliente.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name= "TB_ALUNO")
public class Aluno extends Pessoa {
	public Aluno() {}
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Pratica pratica;
	
	@ManyToMany(mappedBy = "aluno", cascade = CascadeType.ALL)
	private List<Teorica> teoricas;
	
	@Column(name = "MateriaPendentes")
	@Enumerated(EnumType.STRING)
	private Materia materiasPendentes;
	
	@Column(name = "MateriaPagas")
	@Enumerated(EnumType.STRING)
	private Materia materiasPagas;

	public Materia getMateriasPendentes() {
		return materiasPendentes;
	}

	public void setMateriasPendentes(Materia materiasPendentes) {
		this.materiasPendentes = materiasPendentes;
	}

	public Materia getMateriasPagas() {
		return materiasPagas;
	}

	public void setMateriasPagas(Materia materiasPagas) {
		this.materiasPagas = materiasPagas;
	}
	
	public Pratica getPratica() {
		return pratica;
	}

	public void setPratica(Pratica pratica) {
		this.pratica = pratica;
	}

	public List<Teorica> getTeorica() {
		return teoricas;
	}

	public void setTeorica(List<Teorica> teorica) {
		this.teoricas = teorica;
	}

}
