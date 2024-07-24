import java.util.Scanner;

public class Portail {

	private Scanner scanner = new Scanner(System.in);
	private boolean elixir = false;

	public void bienvenue() {
		System.out.println("Bienvenue dans le portail N°1 !");
		System.out.print("Entrez votre pseudonyme svp : ");
	}

	public void portail1() {
		bienvenue();
		String pseudo = scanner.nextLine();

		if (pseudo.equals("XR12CV7")) {
			System.out.println("Décryptage terminé");
			portail2();

		} else {
			System.out.println("Accès à la dimension non autorisé");
		}
	}

	public void portail2() {
		System.out.println("Bienvenue devant le portail N°2 !\nL'obscurité s'intensifie.");
		System.out.print("Choisissez un nombre pair : ");
		int choice_even = scanner.nextInt();
		if (choice_even % 2 == 0) {
			System.out.println("La voix des anciens est avec vous.");
		} else {
			portail1bis();
		}
	}

	public void portail1bis() {
		bienvenue();
		String pseudo = scanner.nextLine();

		if (pseudo.equals("XR12CV7")) {
			System.out.println("L'erreur est la raison du doute.\nSouffre la fureur du dragon !");
			portail1();
		} else {
			System.out.println("Souhaitez-vous un élixir ? (oui/non) : ");
			String choice_elixir = scanner.nextLine();
			if (choice_elixir.equalsIgnoreCase("oui")) {
				elixir = true;
				System.out.println("Bien, vous en aurez besoin plus tard.");
			} else if (choice_elixir.equalsIgnoreCase("non")) {
				System.out.println("Dommage, vous souffrirez plus tard.");
			}
			portail3();
		}
	}

	public void portail3() {
		System.out.println("Bienvenue devant le portail N°3, l'attente");
		System.out.print("Saisissez une phrase svp : ");
		String choice_phrase = scanner.nextLine();
		if (choice_phrase.contains("dragon")) {
			portail2bis();
			;
		} else {
			portail2();
		}
	}

	public void portail2bis() {
		System.out.println("Bienvenue dans le portail N°2, la détresse");
		if (elixir) {
			System.out.println("La solution donne gain de cause");
			portail2();
		} else {
			portail4();
		}
	}

	public void portail4() {
		System.out.println("Bienvenue dans le portail N°2. L'obscurité s'intensifie");
		System.out.println("Entrez un chiffre entre 1 et 9 : ");
		int choice_number = scanner.nextInt();
		if (choice_number % 2 == 0) {
			System.out.println("Gagné ! Vous rejoignez la constellation.");
		} else {
			portail1bis();
		}
	}

	public static void main(String[] args) {
		Portail jeu = new Portail();
		jeu.portail1();
	}
}