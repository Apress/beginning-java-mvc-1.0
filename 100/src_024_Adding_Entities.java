package book.javamvc.jpa.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="MEMBER")
@SequenceGenerator(name="HELLO_SEQ", 
                   initialValue=1, allocationSize = 50)
public class Member {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY, 
        generator = "HELLO_SEQ")
  @Column(name = "id")
  private int id;

  @NotNull
  @Column(name = "name")
  private String name;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
