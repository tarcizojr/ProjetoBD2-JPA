package com.autoescola.cliente.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Endereco")
public class Endereco {
	public Endereco() {}
	
	@Id
	@GeneratedValue(generator = "inc")
	@GenericGenerator(name = "inc", strategy = "increment")
	private long id;
	
	@Column(name = "CEP")
	private String cep; 
	
	@Column(name = "RUA")
	private String rua;
	
	@Column(name = "Numero_Da_Casa")
	private String numeroCasa;
	
	@Column(name = "Complemento")
	private String complemento;
	
	@Column(name = "Cidade")
	private String cidade;
	
	//Enumared 
	@Enumerated(EnumType.STRING)
	@Column(name = "Estado")
	private Estado estado;
	
	//1:1
	@OneToOne(mappedBy = "endereco")	
	private Pessoa pessoa;
	
	public long getID() {
		return id;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}


	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumeroCasa() {
		return numeroCasa;
	}

	public void setNumeroCasa(String numeroCasa) {
		this.numeroCasa = numeroCasa;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	
}
