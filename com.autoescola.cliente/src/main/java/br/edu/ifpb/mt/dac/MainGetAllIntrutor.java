package br.edu.ifpb.mt.dac;

import java.util.List;

import com.autoescola.cliente.model.Instrutor;

import br.edu.ifpb.mt.dac.dao.AlunoDAO;
import br.edu.ifpb.mt.dac.dao.InstrutorDao;
import br.edu.ifpb.mt.dac.dao.PersistenciaDacException;

public class MainGetAllIntrutor {
	public static void main(String[] args) throws PersistenciaDacException {
		InstrutorDao dao = new InstrutorDao();
		try {
			//Salva todos os contas salvas no banco
			List<Instrutor> usuarios = dao.getAll();
			
			//Depois printa ultilizando um for
			for (Instrutor user : usuarios) {
				System.out.println("id: " + user.getId() + " | " + "nome: " + user.getNome() 
				+ " | " + "matricula: " + user.getMatricula() + " | " + "sexo: " + user.getSexo()
				+ " | " + "CPF: " + user.getCpf());
			}

		} finally {
			dao.close();
		}
	}

}