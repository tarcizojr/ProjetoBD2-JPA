package br.edu.ifpb.mt.dac;

import java.util.List;
import java.util.Scanner;

import com.autoescola.cliente.model.Aluno;

import br.edu.ifpb.mt.dac.dao.AlunoDAO;
import br.edu.ifpb.mt.dac.dao.PersistenciaDacException;

public class MainAlunoGetCPF {
	public static void main(String[] args) throws PersistenciaDacException {
		Scanner leitor = new Scanner(System.in);
		AlunoDAO dao = new AlunoDAO();
		//Deleta todos as dados do Banco
		System.out.println("Digite o CPF apenas Numeros:");
		String cpf = leitor.nextLine();
			try {
				List<Aluno> usuarios = dao.getCPF(Integer.parseInt(cpf));
				if(usuarios.size() == 0) {
					System.out.println("Pessoa não encontrada");
				}else {
					for (Aluno user : usuarios) {
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
