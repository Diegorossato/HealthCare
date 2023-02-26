package healthCare.controller;

import java.util.ArrayList;
import java.util.Scanner;
import healthCare.model.Pessoa;
import healthCare.repository.PessoaRepository;

public class PessoaController implements PessoaRepository {
	// ctrl + shift + O
	private ArrayList<Pessoa> listaPessoas = new ArrayList<>();

	@Override
	public void procurarPorNome(String nome) {
		var pessoa = buscarNaCollection(nome);
		if (pessoa != null) {
			pessoa.visualizar();
		} else
			System.out.println("\n A doadora  " + nome + " não foi encontrada...");

	}

	@Override
	public void listarTodas() {
		for (var pessoa : listaPessoas) {
			pessoa.visualizar();
		}

	}

	@Override
	public void atualizar(Pessoa pessoa) {
		var buscaPessoa = buscarNaCollection(pessoa.getId());
		if (buscaPessoa != null) {
			listaPessoas.set(listaPessoas.indexOf(buscaPessoa), pessoa);
			System.out.println("O cadastro de " + pessoa.getNome() + " foi atualizado");

		} else {
			System.out.println("Essa pessoa não foi encontrada! Sintimos muito por isso...");
		}

	}

	@Override
	public void deletar(String nome) {
		var pessoa = buscarNaCollection(nome);

		if (pessoa != null) {
			if (listaPessoas.remove(pessoa) == true) {
				System.out.println("\n A pessoa doadora " + nome + " foi excluída com sucesso do sistema!");
			} else
				System.out.println("Não foi possível excluir a conta...");

		} else {
			System.out.println("\n A pessoa doadora " + nome + " não foi encontrada...");
		}

	}

	public Pessoa buscarNaCollection(int id) {
		for (var pessoa : listaPessoas) {
			if (pessoa.getId() == id) {
				return pessoa;
			}
		}
		return null;
	}
	public Pessoa buscarNaCollection(String nome) {
		for (var pessoa : listaPessoas) {
			if (pessoa.getNome().equals(nome)) {
				return pessoa;
			}
		}
		return null;
	}
	@Override
	public void cadastrar(String nome, int idade, double peso, Boolean jaTeveDoenca, Boolean estaGravida) {
	}

	@Override
	public void cadastrarPessoa(Pessoa pessoa) {
		listaPessoas.add(pessoa);
		System.out.println(pessoa.getNome() + ", você foi cadastrade com sucesso <3!!!");

	}

	public String validarResposta(String s) {
		if (s.trim().equalsIgnoreCase("s") || s.trim().equalsIgnoreCase("n")) {
			return s;
		}
		return "Sua resposta está fora dos parametros fornecidos, digite S para sim ou N para não";
	}

	public boolean doacaoIdade(int idade) {
		if (idade < 16 || idade > 60) {
			System.out.println(
					"Você não poderá ser cadastrado como doador, pois tem menos de 16 ou tem idade superior a 60 anos");
			return false;
		}
		return true;
	}

	public boolean gravidezDoacao(String s) {
		var estaGravida = validarResposta(s);
		if (estaGravida == "s") {
			System.out.println("Você está gravida!Pessoas em gestação não podem doar...");
			return true;
		}
		return false;
	}

	public boolean doacaoAmamentacao(String string) {
		var amamenta = validarResposta(string);
		if (amamenta == "s") {
			System.out.println("Você está amamentando a menos de 12 meses, então não poderá se cadastrar");
			return false;
		}
		return true;
	}

	public boolean pesoDoacao(double peso) {
		if (peso < 50) {
			System.out.println("Você tem menos que 50 quilos. Doar pode ser prejudial a sua saúde");
			return false;
		}

		return true;
	}

	public boolean doencaDoacao(String s) {
		var estaDoente = validarResposta(s);
		if (estaDoente == "s") {
			return true;
		}
		return false;
	}

	public void repostaNegativa() {
		System.out.println("Voce não pode doar sangue nem continuar em nosso sistema!");
	}

	public boolean buscaNome(String nome) {
		for (var pessoa : listaPessoas) {
			if (pessoa.getNome().equals(nome)) {
				return true;
			}

		}
		return false;
	}
	public int gerarId() {	 
		return listaPessoas.size() +1;
	}
	
	public int pegarId(String nome) {
		for (var pessoa : listaPessoas) {
			if (pessoa.getNome().equals(nome)) {
				return pessoa.getId();
			}
		}
		return 0;
	}
}


