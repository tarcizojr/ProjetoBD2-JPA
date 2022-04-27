package com.autoescola.cliente.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Veiculo")
public class Veiculo {
	
	//PK
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private long id;
	
	@Column(name = "Placa_do_Veiculo")
	private String placa;
	
	//Enumared	
	@Column(name = "Tipo_do_Veiculo")
	@Enumerated(EnumType.STRING)
	private TipoVeiculo Tipo;
	
	
	@ManyToMany(mappedBy = "veiculo", cascade = CascadeType.ALL)	
	private List<Pratica> pratica;
	
	//FK 1:N
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "instrutor")	
	private Instrutor instrutor;
	
	public Instrutor getInstrutor() {
		return instrutor;
	}


	public void setInstrutor(Instrutor instrutor) {
		this.instrutor = instrutor;
	}


	public List<Pratica> getPratica() {
		return pratica;
	}


	public void setPratica(List<Pratica> pratica) {
		this.pratica = pratica;
	}

	@Column(name = "Modelo")
	private String modelo;
	
	private Disponibilidade disponiblidade;
	

	

	
	public String getPlaca() {
		return placa;
	}
	
	
	public Disponibilidade getDisponiblidade() {
		return disponiblidade;
	}


	public void setDisponiblidade(Disponibilidade disponiblidade) {
		this.disponiblidade = disponiblidade;
	}


	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public TipoVeiculo getTipo() {
		return Tipo;
	}

	public void setTipo(TipoVeiculo tipo) {
		Tipo = tipo;
	}



}
