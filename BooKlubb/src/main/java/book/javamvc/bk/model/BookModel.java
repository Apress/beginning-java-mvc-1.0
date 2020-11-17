package book.javamvc.bk.model;

import java.util.Date;

public class BookModel {
	private int id;
	private String authorFirstName;
	private String authorLastName;
	private String title;
	private String isbn;
	private Date make;
	
	public BookModel(int id, String authorFirstName, String authorLastName, String title, String isbn, Date make) {
		this.id = id;
		this.authorFirstName = authorFirstName;
		this.authorLastName = authorLastName;
		this.title = title;
		this.isbn = isbn;
		this.make = make;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuthorFirstName() {
		return authorFirstName;
	}

	public void setAuthorFirstName(String authorFirstName) {
		this.authorFirstName = authorFirstName;
	}

	public String getAuthorLastName() {
		return authorLastName;
	}

	public void setAuthorLastName(String authorLastName) {
		this.authorLastName = authorLastName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Date getMake() {
		return make;
	}

	public void setMake(Date make) {
		this.make = make;
	}

}
