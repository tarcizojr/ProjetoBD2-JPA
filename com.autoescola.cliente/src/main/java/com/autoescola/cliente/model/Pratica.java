package com.autoescola.cliente.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Aula_Pratica")
public class Pratica {
	public Pratica() {}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private long id;
	
	//FK 1:N
	@OneToMany(mappedBy = "pratica",cascade = CascadeType.ALL)
	private List<Instrutor> instrutor;
	
	//FK 1:1
	@OneToOne(fetch = FetchType.EAGER, mappedBy = "pratica")
	private Aluno aluno;
	
	//FK N:N

	
	@ManyToMany
	@JoinTable(name ="TB_Veiculo_Pratica",
			joinColumns = @JoinColumn(name = "Pratica_FK"),
			inverseJoinColumns = @JoinColumn(name = "Veiculo_FK"))	
	private List<Veiculo> veiculo;
	
	@Temporal(TemporalType.DATE)
	private Date dataHoraInicio; 
	
	@Temporal(TemporalType.DATE)
	private Date dataHoraTermino;

	public List<Instrutor> getInstrutor() {
		return instrutor;
	}

	public void setInstrutor(List<Instrutor> instrutor) {
		this.instrutor = instrutor;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public List<Veiculo> getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(List<Veiculo> veiculo) {
		this.veiculo = veiculo;
	}

	public Date getDataHoraInicio() {
		return dataHoraInicio;
	}

	public void setDataHoraInicio(Date dataHoraInicio) {
		this.dataHoraInicio = dataHoraInicio;
	}

	public Date getDataHoraTermino() {
		return dataHoraTermino;
	}

	public void setDataHoraTermino(Date dataHoraTermino) {
		this.dataHoraTermino = dataHoraTermino;
	}

	public long getId() {
		return id;
	} 
	
	
}
