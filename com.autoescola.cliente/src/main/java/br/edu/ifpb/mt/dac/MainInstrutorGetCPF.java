package br.edu.ifpb.mt.dac;

import java.util.List;
import java.util.Scanner;

import com.autoescola.cliente.model.Aluno;
import com.autoescola.cliente.model.Instrutor;

import br.edu.ifpb.mt.dac.dao.AlunoDAO;
import br.edu.ifpb.mt.dac.dao.InstrutorDao;
import br.edu.ifpb.mt.dac.dao.PersistenciaDacException;

public class MainInstrutorGetCPF {
	public static void main(String[] args) throws PersistenciaDacException {
		Scanner leitor = new Scanner(System.in);
		InstrutorDao dao = new InstrutorDao();
		//Deleta todos as dados do Banco
		System.out.println("Digite o CPF apenas Numeros:");
		String cpf = leitor.nextLine();
			try {
				List<Instrutor> usuarios = dao.getCPF(Integer.parseInt(cpf));
				if(usuarios.size() == 0) {
					System.out.println("Pessoa não encontrada");
				}else {
					for (Instrutor user : usuarios) {
						System.out.println("id: " + user.getId() + " | " + "nome: " + user.getNome() 
						+ " | " + "matricula: " + user.getMatricula() + " | " + "sexo: " + user.getSexo()
						+ " | " + "CPF: " + user.getCpf());
					}

				}
							} finally {
				dao.close();
				leitor.close();
			}

		}
	
	
}
