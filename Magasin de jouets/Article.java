public class Article implements Comparable<Article> {
	private String nom;
	private int prix;
	private String description;
	private int promotion;

	public Article(String nom, int prix, String description, int promotion) {
		this.nom = nom;
		this.prix = prix;
		this.description = description;
		this.promotion = promotion;
	}

	public String getName() {
		return nom;
	}

	public int getPrice() {
		return prix;
	}

	public String getText() {
		return description;
	}

	public int getPromo() {
		return promotion;
	}

	@Override
	public int compareTo(Article y) {
		return this.getName().compareTo(y.getName());
	}
}
