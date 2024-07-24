import java.util.Comparator;

public class PrixComparator implements Comparator<Article> {
	@Override
	public int compare(Article x, Article y) {
		if (x.getPrice() == y.getPrice()) {
			return x.compareTo(y);
		}
		return x.getPrice() - y.getPrice();
	}
}
