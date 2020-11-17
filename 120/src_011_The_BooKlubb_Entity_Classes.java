package book.javamvc.bk.db;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "MEMBER")
@SequenceGenerator(name = "MEMBER_SEQ", initialValue = 1, 
      allocationSize = 1)
public class Member {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY, 
      generator = "MEMBER_SEQ")
  @Column(name = "id")
  private int id;

  @NotNull
  @Column(name = "first_name")
  private String firstName;

  @NotNull
  @Column(name = "last_name")
  private String lastName;

  @NotNull
  @Column(name = "birthday")
  private Date birthday;

  @NotNull
  @Column(name = "ssn")
  private String ssn;

  @JoinColumn(name = "MEMBER_ID")
  @OneToMany(cascade = CascadeType.ALL, orphanRemoval=true)
  private Set<Rental> rental;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }

  public String getSsn() {
    return ssn;
  }

  public void setSsn(String ssn) {
    this.ssn = ssn;
  }

  public Set<Rental> getRental() {
    return rental;
  }

  public void setRental(Set<Rental> rental) {
    this.rental = rental;
  }
}
