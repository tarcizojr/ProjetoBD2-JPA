package com.autoescola.cliente.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Pessoa {
	public Pessoa() {}
	
	//PK
	@Id
	@GeneratedValue(generator = "inc")
	@GenericGenerator(name = "inc", strategy = "increment")
	private long id;
	
	@Column(name ="Matricula", unique = true)
	private String matricula;
	
	@Column(name = "CPF", unique = true)
	private int cpf;
	
	@Column(name = "Nome")
	private String nome;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "Sexo")
	private Sexo sexo;

	//Temporal
	@Temporal(TemporalType.DATE)
	@Column(name = "Data_De_Nascimento")
	private Date dataNascimento;
	
	//FK 1:N
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL ,mappedBy = "pessoa")
	private List<Telefone> telefone;
	
	//FK 1:1
	@OneToOne(cascade = CascadeType.ALL)
	private Endereco endereco;
	
	
	

	public long getId() {
		return id;
	}



	public List<Telefone> getTelefone() {
		return telefone;
	}

	public void setTelefone(List<Telefone> telefone) {
		this.telefone = telefone;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}



	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	

}
