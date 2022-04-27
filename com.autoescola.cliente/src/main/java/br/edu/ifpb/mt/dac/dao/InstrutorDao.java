package br.edu.ifpb.mt.dac.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.autoescola.cliente.model.Aluno;
import com.autoescola.cliente.model.Instrutor;

public class InstrutorDao extends DAO{
	public List<Instrutor> getAll() throws PersistenciaDacException {
		EntityManager em = getEntityManager();
		List<Instrutor> resultado = null;
		
		try {
			TypedQuery<Instrutor> query = em.createQuery("SELECT u FROM Instrutor u", Instrutor.class);
			resultado = query.getResultList();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			throw new PersistenciaDacException("Ocorreu algum erro ao tentar recuperar todos os usuários.", pe);
		} finally {
			em.close();
		}
		return resultado;
	}
	
	public List<Instrutor> getCPF(int cpf) throws PersistenciaDacException {
		EntityManager em = getEntityManager();
		List<Instrutor> resultado = null;
		
		try {
			TypedQuery<Instrutor> query = em.createQuery("SELECT i FROM Instrutor i where cpf ="+ cpf, Instrutor.class);
			resultado = query.getResultList();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			throw new PersistenciaDacException("Ocorreu algum erro ao tentar recuperar todos os usuários.", pe);
		} finally {
			em.close();
		}
		return resultado;
	}
	public Instrutor update(Instrutor instrutor) throws PersistenciaDacException {
		EntityManager em = getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		Instrutor resultado = instrutor;
		try {
			resultado = em.merge(instrutor);
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
}
