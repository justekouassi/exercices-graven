import java.util.List;
import java.util.ArrayList;

public class Livre {
	private String name_book;
	private List<Page> pages;

	public Livre(String name_book) {
		this.name_book = name_book;
		this.pages = new ArrayList<>();
	}

	public List<String> getPage(int choice_page) {
		return pages.get(choice_page).getLines();
	}

	public int getNbPages() {
		return pages.size();
	}

	public void AddPage(List<String> lines) {
		Page new_page = new Page(lines);
		pages.add(new_page);
	}

	public String getNameBook() {
		return name_book;
	}

}
