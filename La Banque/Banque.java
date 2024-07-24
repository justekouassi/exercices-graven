import java.util.Scanner;

public class Banque {
	public static void main(String[] args) {

		int compte_courant = 9600;
		int plafond = 200000;
		Compte compte = new Compte("KOUASSI", compte_courant);

		System.out.println("Bienvenue dans la JBanKing");
		System.out.println("Tapez 1 : pour afficher le solde du compte");
		System.out.println("      2 : pour déposer de l'argent vers votre compte");
		System.out.println("      3 : pour retirer de l'argent depuis votre compte");
		System.out.println("      4 : pour quitter la banque");

		Boolean running = true;

		while (running) {
			System.out.print("\nQue souhaitez-vous faire ? ");
			Scanner scanner = new Scanner(System.in);
			int choix = scanner.nextInt();

			if (choix == 1) {
				compte.getMoney();
			} else if (choix == 2) {
				System.out.print("Le montant à déposer : ");
				int argent = scanner.nextInt();
				if (argent > 0 && compte_courant + argent < plafond) {
					compte.putMoney(argent);
				} else {
					System.out.println("Opération invalide. Vous dépassez votre plafond");
				}

			} else if (choix == 3) {
				System.out.print("Le montant à retirer : ");
				int argent = scanner.nextInt();
				if (argent > 0 && argent < compte.getMoney()) {
					compte.takeMoney(argent);
				} else {
					System.out.println("Vous n'avez pas assez de fonds pour effectuer cette opération.");
				}
			} else if (choix == 4) {
				running = false;
				break;
			}
			System.out.println("Votre solde est de " + compte.getMoney() + " FCFA.");
		}
		System.out.println("\nMerci M./Mme " + compte.getName() + " pour votre fidélité à la JBanKing !\n");
	}
}