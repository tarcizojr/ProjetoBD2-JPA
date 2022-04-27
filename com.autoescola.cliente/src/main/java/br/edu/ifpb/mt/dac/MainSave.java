package br.edu.ifpb.mt.dac;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.autoescola.cliente.model.Aluno;
import com.autoescola.cliente.model.Disponibilidade;
import com.autoescola.cliente.model.Endereco;
import com.autoescola.cliente.model.Estado;
import com.autoescola.cliente.model.GeradorDeMatricula;
import com.autoescola.cliente.model.Instrutor;
import com.autoescola.cliente.model.Materia;
import com.autoescola.cliente.model.Pratica;
import com.autoescola.cliente.model.Sexo;
import com.autoescola.cliente.model.Status;
import com.autoescola.cliente.model.Telefone;
import com.autoescola.cliente.model.Teorica;
import com.autoescola.cliente.model.TipoVeiculo;
import com.autoescola.cliente.model.Veiculo;

import br.edu.ifpb.mt.dac.dao.AlunoDAO;


public class MainSave {

	public static void main(String[] args) throws DacException, ParseException {
		AlunoDAO dao = new AlunoDAO();
		try {
			DateFormat data = new SimpleDateFormat("dd/MM/yyyy");
			Aluno aluno = new Aluno();
			
			aluno.setNome("Tarcizo");
			aluno.setCpf(3445);
			GeradorDeMatricula matricula = new GeradorDeMatricula();
			aluno.setMatricula(matricula.gerador(aluno.getCpf()));
			aluno.setDataNascimento(data.parse("01/01/2001"));

			
		//--------
			Endereco enderecoAluno = new Endereco();
			enderecoAluno.setCep("2345");
			enderecoAluno.setCidade("Zabele");
			enderecoAluno.setRua("DR");
			enderecoAluno.setComplemento("AP");
			enderecoAluno.setEstado(Estado.PARAIBA);
			enderecoAluno.setNumeroCasa("00");
			aluno.setEndereco(enderecoAluno);
			aluno.setSexo(Sexo.MASCULINO);
			
			Endereco enderecoI = new Endereco();
			enderecoI.setCep("22");
			enderecoI.setCidade("Monteiro");
			enderecoI.setRua("Joao");
			enderecoI.setComplemento("AP");
			enderecoI.setEstado(Estado.PARAIBA);
			enderecoI.setNumeroCasa("11");
		//-----------	
			Instrutor instrutor = new Instrutor();
			instrutor.setCpf(2456);
			instrutor.setDataNascimento(data.parse("01/01/2000"));
			instrutor.setEndereco(enderecoI);
			instrutor.setNome("Guuilherme");
			instrutor.setSexo(Sexo.MASCULINO);
			GeradorDeMatricula m = new GeradorDeMatricula();
			instrutor.setMatricula(m.gerador(instrutor.getCpf()));
			
			List<Instrutor> intrutores = new ArrayList<Instrutor>();
			intrutores.add(instrutor);
			
			Telefone numero = new Telefone();
			List<Telefone> listNumero = new ArrayList<Telefone>();
			numero.setPessoa(aluno);
			numero.setNumero("839");
			listNumero.add(numero);
			aluno.setTelefone(listNumero);
			instrutor.setTelefone(listNumero);
			
			List<Materia> materia= new ArrayList<Materia>();
			materia.add(Materia.DIRECAO_DEFENSIVA);
			materia.add(Materia.MECANICA_BASICA);
			instrutor.setMaterias(materia);
			
			aluno.setMateriasPendentes(Materia.DIRECAO_DEFENSIVA);
			aluno.setMateriasPagas(Materia.CIDADANIA_E_MEIO_ABIENTE);
		//-------
			Teorica aulaTeorica = new Teorica();
			List<Aluno> listaAluno = new ArrayList<Aluno>();
			listaAluno.add(aluno);
			aulaTeorica.setAluno(listaAluno);
			aulaTeorica.setMateria(Materia.MECANICA_BASICA);
			aulaTeorica.setInstrutor(intrutores);
			aulaTeorica.setStatus(Status.CURSANDO);
			aulaTeorica.setDataHoraInicio(data.parse("19/04/2022"));
			aulaTeorica.setDataHoraTermino(data.parse("03/10/2022"));
			List<Teorica> teorica = new ArrayList<Teorica>();
			teorica.add(aulaTeorica);
			
			aluno.setTeorica(teorica);
		
			
		//-------
			Pratica pratica = new Pratica();
			List<Pratica> listPraticas = new ArrayList<Pratica>();
			pratica.setAluno(aluno);
			pratica.setDataHoraInicio(data.parse("19/10/2022"));
			pratica.setDataHoraTermino(data.parse("03/12/2022"));
			pratica.setInstrutor(intrutores);
			pratica.setAluno(aluno);
			instrutor.setPratica(pratica);
			instrutor.setTeorica(aulaTeorica);
			
			Veiculo veiculo = new Veiculo();
			List<Veiculo> listaVeiculos = new ArrayList<Veiculo>();
			listaVeiculos.add(veiculo);
			
			veiculo.setDisponiblidade(Disponibilidade.INDISPONIVEL);
			veiculo.setModelo("SUV");
			veiculo.setPlaca("A123");
			veiculo.setTipo(TipoVeiculo.CARRO);
			veiculo.setInstrutor(instrutor);
			pratica.setVeiculo(listaVeiculos);
			veiculo.setPratica(listPraticas);			
			
			instrutor.setVeiculos(listaVeiculos);
			
			aluno.setPratica(pratica);
			
			System.out.println(aluno);
			
			dao.save(aluno);
		} finally {
			dao.close();
		}
	}

}
