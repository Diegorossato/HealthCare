package healthCare;

public class Pessoa {
	
    //Atributos da classe Pessoa:	
	private String nome;
	private Boolean jaDoou;
	private int idade;
	private double peso;
	private Boolean jaTeveDoenca;
	private String sexo;
	private Boolean estaGravida;
	private Boolean estaAmamentando;
	
	//Método Construtor:
	public Pessoa(String nome, Boolean jaDoou, int idade, double peso, Boolean jaTeveDoenca, String sexo,
			Boolean estaGravida, Boolean estaAmamentando) {
		this.nome = nome;
		this.jaDoou = jaDoou;
		this.idade = idade;
		this.peso = peso;
		this.jaTeveDoenca = jaTeveDoenca;
		this.sexo = sexo;
		this.estaGravida = estaGravida;
		this.estaAmamentando = estaAmamentando;
	}
	
	//Gets e Sets

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Boolean getJaDoou() {
		return jaDoou;
	}

	public void setJaDoou(Boolean jaDoou) {
		this.jaDoou = jaDoou;
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

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Boolean getEstaGravida() {
		return estaGravida;
	}

	public void setEstaGravida(Boolean estaGravida) {
		this.estaGravida = estaGravida;
	}

	public Boolean getEstaAmamentando() {
		return estaAmamentando;
	}

	public void setEstaAmamentando(Boolean estaAmamentando) {
		this.estaAmamentando = estaAmamentando;
	}
	
	// Métodos
	
	public static void verificarIdade(int idade, Boolean jaDoou) {
		//escrever método aqui
	}
	
	public static void verificarPeso(double peso) {
		//escrever método aqui
	}
	
	public static void verificarDoenca(Boolean jaTeveDoenca) {
		//escrever método aqui
	}
	
	public static void verificarSexoMulher(String sexo, Boolean estaGravida, Boolean estaAmamentando) {
		//escrever método aqui
	}
	
	
	
	

}
