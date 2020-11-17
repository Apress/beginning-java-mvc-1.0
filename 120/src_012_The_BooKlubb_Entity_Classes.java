package book.javamvc.bk.db;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "BOOK")
@SequenceGenerator(name = "BOOK_SEQ", initialValue = 1, 
    allocationSize = 1)
public class Book {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY, 
      generator = "BOOK_SEQ")
  @Column(name = "id")
  private int id;

  @NotNull
  @Column(name = "title")
  private String title;

  @NotNull
  @Column(name = "author_first_name")
  private String authorFirstName;

  @NotNull
  @Column(name = "author_last_name")
  private String authorLastName;

  @NotNull
  @Column(name = "make")
  private Date make;

  @NotNull
  @Column(name = "isbn")
  private String isbn;

  @OneToOne(cascade = CascadeType.ALL, orphanRemoval=true, 
      mappedBy = "book")
  private Rental rental;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
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

  public Date getMake() {
    return make;
  }

  public void setMake(Date make) {
    this.make = make;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public Rental getRental() {
    return rental;
  }

  public void setRental(Rental rental) {
    this.rental = rental;
  }
}
