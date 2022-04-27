package br.edu.ifpb.mt.dac.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

import com.autoescola.cliente.model.Aluno;
import com.autoescola.cliente.model.Endereco;

public class EnderecoDao extends DAO{
	public Endereco update(Endereco endereco) throws PersistenciaDacException {
		EntityManager em = getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		Endereco resultado = endereco;
		try {
			resultado = em.merge(endereco);
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
	
	public Endereco getByID(long userId) throws PersistenciaDacException {
		EntityManager em = getEntityManager();
		Endereco resultado = null;
		
		try {
			resultado = em.find(Endereco.class, userId);
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			throw new PersistenciaDacException("Ocorreu algum erro ao tentar recuperar o usuário com base no ID.", pe);
		} finally {
			em.close();
		}

		return resultado;
	}


}
