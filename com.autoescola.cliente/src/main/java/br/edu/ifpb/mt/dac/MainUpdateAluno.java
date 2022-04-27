package br.edu.ifpb.mt.dac;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.autoescola.cliente.model.Aluno;
import com.autoescola.cliente.model.Endereco;
import com.autoescola.cliente.model.Estado;
import com.autoescola.cliente.model.Sexo;

import br.edu.ifpb.mt.dac.dao.AlunoDAO;
import br.edu.ifpb.mt.dac.dao.EnderecoDao;


public class MainUpdateAluno {

	public static void main(String[] args) throws DacException, ParseException {
		Scanner leitor = new Scanner(System.in);
		
		AlunoDAO dao = new AlunoDAO();
		try {	
			//Id do cliente que deseja alterar os dados
			System.out.println("CPF Sem ponto:");
			int cpf = Integer.parseInt(leitor.nextLine());
			List<Aluno>  aluno  = new ArrayList<Aluno>();
			aluno  = dao.getCPF(cpf);
			Aluno user = null;
			if(aluno.size() == 0) {
				System.out.println("Aluno Não Encontrado");
			}else {
				user = aluno.set(0, null);
				String sair = "n";	
				//Dados atuais do Cliente e da Conta
				System.out.println("Dados Do Cliente");
				System.out.println("id: " + user.getId() + " | " + "nome: " + user.getNome() 
				+ " | " + "matricula: " + user.getMatricula() + " | " + "sexo: " + user.getSexo()
				+ " | " + "CPF: " + user.getCpf() + " | " + "Data De Nascimento: " + user.getDataNascimento()
				+ "\n | " + "Endereço: Cidade " + user.getEndereco().getCidade() + " | CEP " + user.getEndereco().getCep()
				+ " | Rua "+ user.getEndereco().getRua() + " | Complemento " + user.getEndereco().getComplemento() + " | Numero "  + user.getEndereco().getNumeroCasa() + " | Estado" + user.getEndereco().getEstado());
				
				//Seleção doque Deseja Alterar
				while(!sair.equals("s")) {
					System.out.println("Qual Dado Deseja Atualizar"
							+ "\n 1- Nome"
							+ "\n 2- Sexo"
							+ "\n 3- CPF"
							+ "\n 4- Endereco"
							+ "\n 5- Data De Nascimento"
							
							+ "\n S- Sair");
					String op = leitor.nextLine();

					switch (op) {
					//Alteração do Nome
					case "1":
						System.out.println("Qual o Novo Nome:");
						user.setNome(leitor.nextLine());
						break;
					//Alteração do Sexo	
					case"2":
						System.out.println("Qual o Novo Sexo:");
						System.out.println("M- Masculino F-Feminino O-Outro");
						String sexo = leitor.nextLine().toUpperCase();
						if(sexo.equals("M")){
							user.setSexo(Sexo.MASCULINO);
						}else if(sexo.equals("F")){
							user.setSexo(Sexo.FEMININO);
						}else if(sexo.equals("O")){
							user.setSexo(Sexo.OUTRO);
						}else {
							System.out.println("Sexo Invalido");
						}
						break;
					

					case"3":	
						System.out.println("Digite o novo CPF:");
						user.setCpf(Integer.parseInt(leitor.nextLine()));
						break;
					case"4":
						EnderecoDao en = new EnderecoDao();
						Endereco e = en.getByID(user.getEndereco().getID());
						System.out.println("CEP:");
						e.setCep(leitor.nextLine());
						System.out.println("Cidade:");
						e.setCidade(leitor.nextLine());
						System.out.println("Rua:");
						e.setRua(leitor.nextLine());
						System.out.println("Complemento:");
						e.setComplemento(leitor.nextLine());
						System.out.println("Selecione o Seu Estado:"
								+ "\n1 - Paraiba"
								+ "\n2 - Para"
								+ "\n3 - Parana"
								+ "\n4 - Pernanbuco"
								+ "\n5 - Piaui");
						String es = leitor.nextLine();
						switch (es) {
						case "1":
							e.setEstado(Estado.PARAIBA);
							break;
						case "2":
							e.setEstado(Estado.PARA);
							break;
						case "3":
							e.setEstado(Estado.PARANA);
							break;
						case "4":
							e.setEstado(Estado.PERNAMBUCO);
							break;
						case "5":
							e.setEstado(Estado.PIAUI);
							break;

						}					
						System.out.println("Numero:");
						e.setNumeroCasa(leitor.nextLine());
						
						user.setEndereco(e);
						en.update(e);
						en.close();
						System.out.println("Novo Endereço Cadastrado");
						break;
						
					case "5":
						DateFormat data = new SimpleDateFormat("dd/MM/yyyy");
						System.out.println("Qual a Data De Nascimento:");
						user.setDataNascimento(data.parse(leitor.nextLine()));
						break;

					case"s":
						System.out.println("Saindo....");
						sair = "s";
						break;
						
					default:
						System.out.println("Opção Invalida");
						break;
					}
					
					
				}
			}
			
			
			
			dao.update(user);
						
			//Novos Dados 
			System.out.println("--Dados Atualizados--");
			System.out.println("Dados Do Aluno");
			System.out.println("id: " + user.getId() + " | " + "nome: " + user.getNome() 
			+ " | " + "matricula: " + user.getMatricula() + " | " + "sexo: " + user.getSexo()
			+ " | " + "CPF: " + user.getCpf()
			+ "\n | " + "Endereço: Cidade " + user.getEndereco().getCidade() + " | CEP " + user.getEndereco().getCep()
			+ " | Rua "+ user.getEndereco().getRua() + " | Complemento " + user.getEndereco().getComplemento() + " | Numero "  + user.getEndereco().getNumeroCasa() + " | Estado" + user.getEndereco().getEstado());
			
	

		} finally {
			dao.close();
		}
		
	}

}