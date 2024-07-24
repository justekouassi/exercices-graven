public class ADN {
	public static void main(String[] args) {

		String adn = "7777x77x777777x77777";
		String sexe = "féminin";

		if (adn.contains("7")) {
			sexe = "masculin";
		}
		System.out.println("Le sexe de l'individu est : " + sexe);

		// long n = adn.chars().filter(c -> c == '7').count();

		if (adn.length() >= 18) {
			System.out.println("L'individu a plus de 21 ans.");
		} else if (adn.length() < 18 && adn.length() >= 6) {
			System.out.println("L'individu a moins de 21 ans.");
		} else if (adn.length() < 6) {
			System.out.println("L'individu a plus de 65 ans.");
		}
	}
}