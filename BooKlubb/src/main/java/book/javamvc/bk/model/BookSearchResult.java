package book.javamvc.bk.model;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import book.javamvc.bk.db.Book;

@Named
@RequestScoped
public class BookSearchResult extends ArrayList<BookModel>{
	private static final long serialVersionUID = -5926389915908884067L;
	public void addAll(List<Book> l) {
		l.forEach(b -> {
			add(new BookModel(
					b.getId(),
					b.getAuthorFirstName(),
					b.getAuthorLastName(),
					b.getTitle(),
					b.getIsbn(),
					b.getMake()
					));
		});
	}
}
