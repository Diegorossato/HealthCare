package healthCare;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import healthCare.util.Cores;
import healthCare.controller.PessoaController;
import healthCare.model.Doadora;
import healthCare.model.Pessoa;

public class Menu {

	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);

		PessoaController pessoas = new PessoaController();

		int opcao;
		String nome, respostaG = null;
		int idade;
		double peso;
		Boolean jaTeveDoenca = null;
		Boolean estaGravida= null;

	Doadora d1 = new Doadora(1,"Jo",25,63,false,false);
    pessoas.cadastrarPessoa(d1);

		while (true) {
			System.out.println(Cores.TEXT_RED + Cores.ANSI_BLACK_BACKGROUND + "" + 
		              "________________________________________________\n"
					+ "|                                              |\n"
					+ "|                 HEALTHCARE                   |\n"
					+ "|______________________________________________|\n"
					+ "|                                              |\n"
					+ "| 1 - Cadastrar Pessoa                         |\n"
					+ "| 2 - Listar Doadores                          |\n"
					+ "| 3 - Excluir Doador                           |\n"
					+ "| 4 - Atualizar Doador                         |\n"
					+ "| 5 - Sair                                     |\n"
					+ "|______________________________________________|\n" + "\n" + "Entre com a opção desejada:\n" + Cores.TEXT_RESET);
	
				try {
					opcao = leia.nextInt();		
				}catch(InputMismatchException e) {
					System.out.println("\n Digite valores inteiros!");
					leia.nextLine();
				    opcao=0;	
				}
			

			if (opcao == 5) {
				System.out.println("\n Healthcare - Honestidade também Salva Vidas");
				leia.close();
				System.exit(0);
			}

			switch (opcao) {

			case 1 -> {
				System.out.println("1 - Cadastrar Pessoa");

				System.out.println("Informe o nome que gostaria de ser chamade: ");
				nome = leia.next();
				System.out.println("Informe sua idade: ");
				idade = leia.nextInt();
				if (pessoas.doacaoIdade(idade) == false) {// validando idade
					
					pessoas.repostaNegativa();
					
				} else {
					
					System.out.println("Informe seu peso: ");
					peso = leia.nextDouble();
					
					if (pessoas.pesoDoacao(peso) == false) {
						// validando peso
						
						pessoas.repostaNegativa();
						
					}else {
						
						System.out.println("Você já teve alguma das seguintes doenças?\n" + " - HIV\n" + " - Malária\n"
								+ " - Doença de Chagas\n" + " - Câncer, incluindo leucemia\n"
								+ " - Problemas de coagulação de sangue\n"
								+ " - Diabetes com complicações vasculares ou em uso de insulina\n"
								+ " - Problemas graves no pulmão, coração, rins ou fígado\n"
								+ "Digite S para Sim ou N para Não: ");
						
						String resposta = leia.next();
						
						jaTeveDoenca = resposta.equalsIgnoreCase("S");
						
						if(resposta.equalsIgnoreCase("S")) {
							
							pessoas.repostaNegativa();
							jaTeveDoenca = true;
							System.out.println("Infelizmente você tem uma doença que lhe impede de doar.");
									
						}else{
							
						System.out.println("Você está grávida? Digite S para Sim ou N para Não: ");
						resposta = leia.next();
					    estaGravida = resposta.equalsIgnoreCase("S");	
						if(resposta.equalsIgnoreCase("S")) {
							pessoas.repostaNegativa();
							estaGravida = true;
							System.out.println("Você está grávida! Pessoas em gestação não podem doar.");
							
						}else {	
							Pessoa p = new Doadora(pessoas.gerarId(), nome, idade, peso, jaTeveDoenca, estaGravida);
						pessoas.cadastrarPessoa(p);
						}
					  }
					}
				}	
				
				keyPress();		
				break;
			}
			
			case 2 -> {
				System.out.println("2 - Listar Doadores");
				pessoas.listarTodas();
				keyPress();
			}

			case 3 -> {
				System.out.println("3 - Excluir Doador");
				String nomePessoa = "";
				while(nomePessoa.isEmpty()) {
					System.out.println("Por favor, Digite o nome da pessoa: ");
					leia.nextLine();
					nomePessoa = leia.nextLine();
				}
				pessoas.deletar(nomePessoa);
				keyPress();
			}

			case 4 -> {
				System.out.println("4 - Atualizar dados do Doador");
				System.out.println("Por favor, informe seu nome:");
				leia.nextLine();
				nome = leia.nextLine();
				
				//System.out.println(pessoas.buscaNome(nome));
				
				if (pessoas.buscaNome(nome)) {
					int id = pessoas.pegarId(nome);

					System.out.println("Digite seu nome atualizado:");
					
					String novoNome = leia.nextLine();
					
					System.out.println("Meu nome é " + novoNome);
					
					System.out.println("Digite sua idade:");
					
					int novaIdade = leia.nextInt();
					
					if (pessoas.doacaoIdade(novaIdade) == false) {
						
						System.out.println("Seus dados foram atualizados, e infelizmente, "
								+ "a partir de agora você estará impossibilitado de doar");
						pessoas.deletar(nome);
						
					}else {
					
					System.out.println("Digite seu peso:");
					
					double novoPeso = leia.nextDouble();
					if(pessoas.pesoDoacao(novoPeso) == false ) {
						
						
						System.out.println("Seus dados foram atualizados, e infelizmente, "
								+ "a partir de agora você estará impossibilitado de doar");
						pessoas.deletar(nome);
						
						
					}else {
						
					System.out.println("Você já teve alguma das seguintes doenças?\n" + " - HIV\n" + " - Malária\n"
							+ " - Doença de Chagas\n" + " - Câncer, incluindo leucemia\n"
							+ " - Problemas de coagulação de sangue\n"
							+ " - Diabetes com complicações vasculares ou em uso de insulina\n"
							+ " - Problemas graves no pulmão, coração, rins ou fígado\n"
							+ "Digite S para Sim ou N para Não: ");
					String respostaAtualizada = leia.next();
					
					if (respostaAtualizada.equalsIgnoreCase("S")) {
						jaTeveDoenca = true;
						System.out.println("Seus dados foram atualizados, e infelizmente, "
								+ "a partir de agora você estará impossibilitado de doar");
						pessoas.deletar(nome);	
						
					}else {
						System.out.println("Você está grávida? Digite S para Sim ou N para Não: ");
						String respostaGravidez = leia.next();
					if (respostaGravidez.equalsIgnoreCase("S")) {
						estaGravida = true;
						System.out.println("Seus dados foram atualizados, e infelizmente, "
								+ "a partir de agora você estará impossibilitado de doar");
						pessoas.deletar(nome);
					}else {
						System.out.println("Seus dados foram atualizados com sucesso! ");
					pessoas.atualizar(new Doadora(id, novoNome, novaIdade, novoPeso, jaTeveDoenca, estaGravida));
					}
					}
					}
					}
				}else {
					System.out.println("Desculpe, mas não foi possível encontrar este doador. Tente novamente!");
				}
				
					keyPress();
				//System.out.println("Não entrou no if");
					break;
			}
			case 5 -> {
				System.out.println("5 - Sair");
				keyPress();
			}
			default -> {
				System.out.println("Número inválido, por favor, insira um número de 1 a 5");
			}
		 }
		}
	}

	public static void keyPress() {

		try {
			System.out.println("\n\nPressione ENTER para Continuar...");
			System.in.read();
		} catch (IOException e) {
			System.out.println("Você pressionou uma tecla diferente de ENTER!");
		}
	}

}
