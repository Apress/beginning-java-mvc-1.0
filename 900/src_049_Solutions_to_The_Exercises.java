package book.javamvc.jpa.db;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class MemberDAO {
    ...
    public int addMember(String name, 
        String... status) {
      List<?> l = em.createQuery(
        "SELECT m FROM Member m WHERE m.name=:name").
	setParameter("name",  name).
        getResultList();
      int id = 0;
      if(l.isEmpty()) {
        Member member = new Member();
        member.setName(name);
        Set<Status> s = Stream.of(status).map( 
            s1 -> new Status(s1) ).
          collect(Collectors.toSet());
        member.setStatus(s);
        em.persist(member);
        em.flush(); // needed to get the ID
        id = member.getId();
      } else {
        id = ((Member)l.get(0)).getId();
      }
      return id;
    }
    ...
}
