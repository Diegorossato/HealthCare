package healthCare.model;

public abstract class Pessoa {
	
	 //Atributos da classe Pessoa:	
		private String nome;
		private int idade;
		private double peso;
		private Boolean jaTeveDoenca;
		private Boolean estaGravida;
		
		//construtor
		public Pessoa(String nome, int idade, double peso, Boolean jaTeveDoenca, Boolean estaGravida) {
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
		
		public void visualizar() {}
		
		
		
		

}
