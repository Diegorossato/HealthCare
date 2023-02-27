package healthCare.model;

import java.util.Scanner;

public abstract class Pessoa {
	
	 //Atributos da classe Pessoa:
	    private int id;
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		private String nome;
		private int idade;
		private double peso;
		private Boolean jaTeveDoenca;
		private Boolean estaGravida;
	
		
		//construtor
		public Pessoa(int id, String nome, int idade, double peso, Boolean jaTeveDoenca, Boolean estaGravida) {
			this.id = id;
			this.nome = nome;
			this.idade = idade;
			this.peso = peso;
			this.jaTeveDoenca = jaTeveDoenca;
			this.estaGravida = estaGravida;
		}

		//get e set
		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public int getIdade() {
			return idade;
		}

		public void setIdade(int idade) {
			this.idade = idade;
		}

		public double getPeso() {
			return peso;
		}

		public void setPeso(double peso) {
			this.peso = peso;
		}

		public Boolean getJaTeveDoenca() {
			return jaTeveDoenca;
		}

		public void setJaTeveDoenca(Boolean jaTeveDoenca) {
			this.jaTeveDoenca = jaTeveDoenca;
		}

		public Boolean getEstaGravida() {
			return estaGravida;
		}

		public void setEstaGravida(Boolean estaGravida) {
			this.estaGravida = estaGravida;
		}
		
		public boolean validarGravidez(String resposta) {
		    switch(resposta.toLowerCase()) {
		        case "sim":
		            return true;
		        case "não":
		            return false;
		        default:
		            System.out.println("Opção inválida. Por favor, responda 'sim' ou 'não'.");
		            return false;
		    }
		}
		
            public void verificarPessoa(Pessoa pessoa) {
			
			Scanner scanner = new Scanner(System.in);
			if(pessoa.getIdade() >= 16 && pessoa.getIdade() <= 60) {
				if(getJaTeveDoenca() == false) {
					if(getPeso() >= 50) {
						if(getEstaGravida() == false) {
							System.out.println("Parabéns!! Você está apto(a) a doar sangue!");
						}else {
							System.out.println("Infelizmente você não pode doar sangue pois está grávida.");
						}
					}else {
						System.out.println("Infelizmente você não pode doar sangue pois possui um peso menor que 50 kilos.");
					}
				}else {
					System.out.println("Infelizmente você não pode doar sangue pois possui uma doença que lhe impede de doar.");
				}
			}else {
				System.out.println("Infelizmente você não pode doar sangue pois é menor de 16 anos ou maior de 60 anos.");
			}	
		}

		public void visualizar() {
			
			System.out.println("" +
					"_________________________________________________ \n" +
					"|                 Dados do Doador(a)            | \n" +
					"|_______________________________________________| \n" +
					"  Nome: " + this.nome         +     "\n" +
					"  Idade: " + this.idade                +     "\n" +
					"  Peso: " + this.peso                  +     "\n" 
					);
			
		}
		
		
}
