package book.javamvc.bk.db;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class BookDAO {
    @PersistenceContext
    private EntityManager em;

	public int addBook(String authorFirstName, String authorLastName, String title, Date make, String isbn) {
		List<?> l = em.createQuery("SELECT b FROM Book b WHERE b.isbn=:isbn").
		       setParameter("isbn",  isbn).
		       getResultList();
		int id = 0;
		if(l.isEmpty()) {
			Book book = new Book();
			book.setAuthorFirstName(authorFirstName);
			book.setAuthorLastName(authorLastName);
			book.setTitle(title);
			book.setMake(make);
			book.setIsbn(isbn);
		    em.persist(book);
		    em.flush(); // needed to get the ID
		    id = book.getId();
		} else {
			id = ((Book)l.get(0)).getId();
		}
		return id;
	}
	
	public List<Book> allBooks() {	
	      TypedQuery<Book> q = em.createQuery(
	          "SELECT b FROM Book b", Book.class);
	      List<Book> l = q.getResultList();
	      return l;
	    }
		
	public Book bookById(int id) {	
		return em.find(Book.class, id);
    }
		
	public Optional<Book> bookByIsbn(String isbn) {
		List<?> l = em.createQuery("SELECT b FROM Book b WHERE b.isbn=:isbn").
			       setParameter("isbn",  isbn).
			       getResultList();
		if(l.isEmpty()) {
			return Optional.empty();
		} else {
			return Optional.of((Book)l.get(0));
		}
	}

	@SuppressWarnings("unchecked")
	public List<Book> booksByName(String authorFirstName, String authorLastName, String bookTitle) {
		String afn = (authorFirstName == null || authorFirstName.isEmpty() ) ? "%" : ("%"+authorFirstName+"%");
		String aln = (authorLastName == null || authorLastName.isEmpty() ) ? "%" : ("%"+authorLastName+"%");
		String t = (bookTitle == null || bookTitle.isEmpty() ) ? "%" : ("%"+bookTitle+"%");

		List<?> l = em.createQuery("SELECT b FROM Book b WHERE b.title LIKE :title AND b.authorLastName LIKE :aln AND b.authorFirstName LIKE :afn").
			       setParameter("title",  t).
			       setParameter("aln",  aln).
			       setParameter("afn",  afn).
			       getResultList();
		return (List<Book>) l;
	}

	public void deleteBook(int id) {
		Book book = em.find(Book.class, id);
		em.remove(book);
	}
}
