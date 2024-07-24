import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Redaction {
	public static void main(String[] arg) {
		String title = "Les bases de la programmation";
		String author = "Graven";
		String edition = "Nevarg";
		System.out.println("\nTitre de l'ouvrage : " + title);
		System.out.println("Nom de l'auteur : " + author);
		System.out.println("Société éditrice : " + edition);

		List<String> chapters = new ArrayList<>();
		chapters.add("Qu'est-ce que le Java ?");
		chapters.add("Qu'est-ce qu'une variable ?");
		chapters.add("Les conditions");
		chapters.add("Les tableaux");

		System.out.println("\nSOMMAIRE\n");
		int i = 1;
		for (String chapter : chapters) {
			System.out.println(i + ". " + chapter);
			i += 1;
		}

		// Chapitre 1
		List<String> page1 = new ArrayList<>();
		page1.add("La java est un langage de programmation, Le java est un");
		page1.add("langage de programmation orientée objet");
		page1.add("\n");
		page1.add("Il permet de faire des applications, des sites web ou encore");
		page1.add("des bots discords");

		// Chapitre 2
		List<String> page2 = new ArrayList<>();
		page2.add("Une variable est un élément pour stocker temporairement une valeur");
		page2.add("qui peut changer, varier lors de l’exécution du programme.");

		Livre book_graven = new Livre(title);
		book_graven.AddPage(page1);
		book_graven.AddPage(page2);

		System.out.println("\nTitre : " + book_graven.getNameBook() + " / " + book_graven.getNbPages() + " pages");

		Scanner scanner = new Scanner(System.in);
		int choice_page = scanner.nextInt();
		System.out.println("Page à lire : " + choice_page);

		if (choice_page <= book_graven.getNbPages() && choice_page > 0) {
			System.out.println("\nCHAPITRE " + choice_page + "\n");

			List<String> lines = book_graven.getPage(choice_page - 1);
			lines.forEach(System.out::println);
		}

		System.out.println("Suivant(1) / Précédent(0) ? ");
		int choice_reading = scanner.nextInt();

		if (choice_reading == 1) {
			choice_page += 1;
		} else if (choice_reading == 0) {
			choice_page -= 1;
		}
		List<String> lines = book_graven.getPage(choice_page - 1);
		lines.forEach(System.out::println);

		scanner.close();
	}

}