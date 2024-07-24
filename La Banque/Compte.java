public class Compte {
	private String nom_compte;
	private int compte_courant;

	public Compte(String nom_compte, int compte_courant) {
		this.nom_compte = nom_compte;
		this.compte_courant = compte_courant;
	}

	public String getName() {
		return nom_compte;
	}

	public int getMoney() {
		return compte_courant;
	}

	public void putMoney(int argent) {
		compte_courant += argent;
	}

	public void takeMoney(int argent) {
		compte_courant -= argent;
	}
}
