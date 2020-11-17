package book.javamvc.bk.db;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class MemberDAO {
  @PersistenceContext
  private EntityManager em;

  public int addMember(String firstName, String lastName, 
        Date birthday, String ssn) {

    // First check if there is already a member with the 
    // same SSN. Create a new entry only if none found.
    List<?> l = em.createQuery("SELECT m FROM Member m "+
              "WHERE m.ssn=:ssn").
          setParameter("ssn",  ssn).
          getResultList();
    int id = 0;
    if(l.isEmpty()) {
      Member member = new Member();
      member.setFirstName(firstName);
      member.setLastName(lastName);
      member.setBirthday(birthday);
      member.setSsn(ssn);
      em.persist(member);
      em.flush(); // needed to get the ID
      id = member.getId();
    } else {
      id = ((Member)l.get(0)).getId();
    }
    return id;
  }
	
  public List<Member> allMembers() {	
    TypedQuery<Member> q = em.createQuery(
        "SELECT m FROM Member m", Member.class);
    List<Member> l = q.getResultList();
    return l;
  }
		
  public Member memberById(int id) {	
    return em.find(Member.class, id);
  }
		
  public Optional<Member> memberBySsn(String ssn) {
    List<?> l = em.createQuery("SELECT m FROM Member m "+
            "WHERE m.ssn=:ssn").
        setParameter("ssn",  ssn).
        getResultList();
    if(l.isEmpty()) {
      return Optional.empty();
    } else {
      return Optional.of((Member)l.get(0));
    }
  }

  @SuppressWarnings("unchecked")
  public List<Member> membersByName(String firstName, 
        String lastName) {
    List<?> l = em.createQuery("SELECT m FROM Member m "+
            "WHERE m.firstName LIKE :fn AND "+
            "m.lastName LIKE :ln").
        setParameter("fn",  firstName.isEmpty() ? 
            "%" : "%" + firstName + "%").
        setParameter("ln",  lastName.isEmpty() ? 
            "%" : "%" + lastName + "%").
        getResultList();
    return (List<Member>) l;
  }

  public void deleteMember(int id) {
    Member member = em.find(Member.class, id);
    em.remove(member);
  }
}
