package br.edu.ifpb.mt.dac.dao;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;


import com.autoescola.cliente.model.Aluno;



public class AlunoDAO extends DAO {

	public void save(Aluno aluno) throws PersistenciaDacException {
		EntityManager em = getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		try {
			em.persist(aluno);
			transaction.commit();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			if (transaction.isActive()) {
				transaction.rollback();
			}
			throw new PersistenciaDacException("Ocorreu algum erro ao tentar salvar o usuário.", pe);
		} finally {
			em.close();
		}
	}

	public Aluno update(Aluno aluno) throws PersistenciaDacException {
		EntityManager em = getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		Aluno resultado = aluno;
		try {
			resultado = em.merge(aluno);
			transaction.commit();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			if (transaction.isActive()) {
				transaction.rollback();
			}
			throw new PersistenciaDacException("Ocorreu algum erro ao tentar atualizar o usuário.", pe);
		} finally {
			em.close();
		}
		return resultado;
	}
	
	public void delete(Object user) throws PersistenciaDacException {
		EntityManager em = getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		try {
			user = em.find(Aluno.class, ((Aluno) user).getId());
			em.remove(user);
			transaction.commit();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			if (transaction.isActive()) {
				transaction.rollback();
			}
			throw new PersistenciaDacException("Ocorreu algum erro ao tentar remover o usuário.", pe);
		} finally {
			em.close();
		}
	}
	
	public List<Aluno> getAll() throws PersistenciaDacException {
		EntityManager em = getEntityManager();
		List<Aluno> resultado = null;
		
		try {
			TypedQuery<Aluno> query = em.createQuery("SELECT u FROM Aluno u", Aluno.class);
			resultado = query.getResultList();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			throw new PersistenciaDacException("Ocorreu algum erro ao tentar recuperar todos os usuários.", pe);
		} finally {
			em.close();
		}
		return resultado;
	}
	
	public List<Aluno> getCPF(int cpf) throws PersistenciaDacException {
		EntityManager em = getEntityManager();
		List<Aluno> resultado = null;
		
		try {
			TypedQuery<Aluno> query = em.createQuery("SELECT u FROM Aluno u where cpf ="+ cpf, Aluno.class);
			resultado = query.getResultList();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			throw new PersistenciaDacException("Ocorreu algum erro ao tentar recuperar todos os usuários.", pe);
		} finally {
			em.close();
		}
		return resultado;
	}
	
	
	public Aluno getByID(long userId) throws PersistenciaDacException {
		EntityManager em = getEntityManager();
		Aluno resultado = null;
		
		try {
			resultado = em.find(Aluno.class, userId);
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			throw new PersistenciaDacException("Ocorreu algum erro ao tentar recuperar o usuário com base no ID.", pe);
		} finally {
			em.close();
		}

		return resultado;
	}


	
}

