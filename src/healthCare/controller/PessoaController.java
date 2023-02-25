package healthCare.controller;

import java.util.ArrayList;
import java.util.Scanner;
import healthCare.model.Pessoa;
import healthCare.repository.PessoaRepository;

public class PessoaController implements PessoaRepository {
     //ctrl + shift + O
	private ArrayList<Pessoa> listaPessoas = new ArrayList<>();
	
	@Override
	public void procurarPorNome(String nome) {
		var pessoa  = buscarNaCollection(nome);
		if(pessoa != null) {
			pessoa.visualizar();
		}else
			System.out.println("\n A doadora  " + nome + " não foi encontrada...");
		
	}

	@Override
	public void listarTodas() {
		for (var pessoa : listaPessoas) {
			pessoa.visualizar();
		}
		
	}

	@Override
	public void atualizar(Pessoa Pessoa) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletar(String nome) {
        var pessoa = buscarNaCollection(nome);
		
		if(pessoa != null) {
			if(listaPessoas.remove(pessoa) == true) {
				System.out.println("\n A pessoa doadora " + nome + " foi excluída com sucesso do sistema!");
			}else
				System.out.println("Não foi possível excluir a conta...");
			
		}else {
			System.out.println("\n A pessoa doadora " + nome + " não foi encontrada...");
		}
		
		
	}

	public Pessoa buscarNaCollection(String nome) {
		for(var pessoa : listaPessoas) {
			if(pessoa.getNome() == nome) {
				return pessoa;
			}
		}
		return null;
	}

	@Override
	public void cadastrar(Pessoa pessoa, String nome, int idade, double peso, Boolean jaTeveDoenca,
			Boolean estaGravida) {	
	}

	@Override
	public void cadastrarPessoa(Pessoa pessoa) {
		// TODO Auto-generated method stub
		
	}

}
