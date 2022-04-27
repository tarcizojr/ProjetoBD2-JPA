package br.edu.ifpb.mt.dac;

import java.util.List;

import com.autoescola.cliente.model.Aluno;

import br.edu.ifpb.mt.dac.dao.AlunoDAO;
import br.edu.ifpb.mt.dac.dao.PersistenciaDacException;


public class MainGetAllAluno {
	
	public static void main(String[] args) throws PersistenciaDacException {
		AlunoDAO dao = new AlunoDAO();
		try {
			//Salva todos os contas salvas no banco
			List<Aluno> usuarios = dao.getAll();
			
			//Depois printa ultilizando um for
			for (Aluno user : usuarios) {
				System.out.println("id: " + user.getId() + " | " + "nome: " + user.getNome() 
				+ " | " + "matricula: " + user.getMatricula() + " | " + "sexo: " + user.getSexo()
				+ " | " + "CPF: " + user.getCpf());
			}

		} finally {
			dao.close();
		}
	}
}