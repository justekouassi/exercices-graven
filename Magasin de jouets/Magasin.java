import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Magasin {
	public static void main(String[] args) {
		List<Article> jouets = new ArrayList<>();
		jouets.add(new Article("Scrabble Deluxe", 25, "Pour les amoureux de lettres", 10));
		jouets.add(new Article("Ludo", 15, "", 25));
		jouets.add(new Article("Monopoly", 60, "Conquis ton royaume", 50));
		jouets.add(new Article("Puissance 4", 20, "4x plus puissant", 5));
		jouets.add(new Article("Donkey Kong", 100, "Sois le roi de la jungle", 0));
		jouets.add(new Article("PlayMobile", 75, "En avant les histoires !", 0));
		jouets.add(new Article("Lego Star Wars", 79, "Que la force sois avec toi !", 0));
		jouets.add(new Article("Backgammon", 15, "Capture tous les pions", 0));
		jouets.add(new Article("Chess", 40, "Tu es le roi", 0));

		Collections.sort(jouets, new PrixComparator());

		int i = 1;
		for (Article jouet : jouets) {
			System.out.println(
					i + " : " + jouet.getName() + " / " + jouet.getPrice() + " / " + jouet.getText() + " / " + jouet.getPromo());
			i += 1;
		}
	}
}
