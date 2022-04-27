package br.edu.ifpb.mt.dac;

import java.util.List;
import java.util.Scanner;

import com.autoescola.cliente.model.Aluno;

import br.edu.ifpb.mt.dac.dao.AlunoDAO;
import br.edu.ifpb.mt.dac.dao.PersistenciaDacException;

public class MainDeletAll {
	public static void main(String[] args) throws PersistenciaDacException {
		Scanner leitor = new Scanner(System.in);
		AlunoDAO dao = new AlunoDAO();
		//Deleta todos as dados do Banco
		System.out.println("Para Confirmar a Exclução Dos Dados  Digite 'confirmar'");
		
		//Confirmação Para Exclução de Todos os Dados
		if(!leitor.nextLine().toUpperCase().equals("CONFIRMAR")) {
			System.out.println("Processo Cancelado");
			
		}else {
			//Caso seja confirmado, todos os dados serão excluidos
			try {
				List<Aluno> usuarios = dao.getAll();
				for (Aluno usuario : usuarios) {
					dao.delete(usuario);
					System.out.println("Dados Excluidos....");
				}
			} finally {
				dao.close();
				leitor.close();
			}

		}
	
	}

}
