package healthCare;

import java.util.Scanner;

public class Teste {

	public static void main(String[] args) {

		Scanner Leia = new Scanner(System.in);

		System.out.print("\nNome do doador: ");
		String nomeDoador = Leia.nextLine();

		System.out.println("\nIdade do doador: ");
		int idadeDoador = Leia.nextInt();

		System.out.println("\nJá fez outras doações (true/false)? ");
		boolean jaDoou = Leia.nextBoolean();

		if (idadeDoador >= 18 && idadeDoador <= 69) {
			System.out.println("Doador " + nomeDoador + " é apto para doar sangue. ");
		} else if (idadeDoador >= 60 && idadeDoador <= 69 && jaDoou) {
			System.out.println("Doador " + nomeDoador + " é apto para doar sangue. ");
		} else {
			System.out.println("Doador " + nomeDoador + " não é apto para doar sangue. ");
		}

	}

}
