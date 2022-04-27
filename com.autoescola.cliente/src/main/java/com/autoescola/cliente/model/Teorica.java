package com.autoescola.cliente.model;


import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Aula_Teorica")
public class Teorica{
	public Teorica() {}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private long id;
	
	//FK 1:N
	@OneToMany(mappedBy = "teorica")
	private List<Instrutor> instrutor;
	
	//FK N:N
	@ManyToMany
	@JoinTable(name ="TB_Teorica",
			joinColumns = @JoinColumn(name = "Teorica_FK"),
			inverseJoinColumns = @JoinColumn(name = "Aluno_FK"))	
	private List<Aluno> aluno;
	
	@Column(name = "Materia")
	@Enumerated(EnumType.STRING)
	private Materia materia;	
	
	@Column(name = "Status")
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@Temporal(TemporalType.DATE)
	private Date dataHoraInicio; 
	@Temporal(TemporalType.DATE)
	private Date dataHoraTermino;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public List<Instrutor> getInstrutor() {
		return instrutor;
	}
	public void setInstrutor(List<Instrutor> instrutor) {
		this.instrutor = instrutor;
	}
	public List<Aluno> getAluno() {
		return aluno;
	}
	public void setAluno(List<Aluno> aluno) {
		this.aluno = aluno;
	}
	public Materia getMateria() {
		return materia;
	}
	public void setMateria(Materia materia) {
		this.materia = materia;
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
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	} 

	
}
