package com.autoescola.cliente.model;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "Telefone")
public class Telefone {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	
	public Telefone() {}
	
	private String numero;
		
	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}

	//FK 1:N
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Pessoa_fk")	
	private Pessoa pessoa;
	
	public int getId() {
		return id;
	}


	public Pessoa getPessoa() {
		return pessoa;
	}


	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	


	
	
}
