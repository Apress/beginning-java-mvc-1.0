package book.javamvc.bk.db;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "RENTAL")
@SequenceGenerator(name = "RENTAL_SEQ", initialValue = 1, allocationSize = 1)
public class Rental {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "RENTAL_SEQ")
	@Column(name = "id")
	private int id;

	@NotNull
	@Column(name = "member_id")
	private int memberId;

	@NotNull
	@JoinColumn(name = "book_id")
	@OneToOne
	private Book book;

	@NotNull
	@Column(name = "rental_day")
	private Date rentalDay;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Date getRentalDay() {
		return rentalDay;
	}

	public void setRentalDay(Date rentalDay) {
		this.rentalDay = rentalDay;
	}
}
