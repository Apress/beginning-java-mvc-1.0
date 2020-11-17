package book.javamvc.jpa.db;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class MemberDAO {
    @PersistenceContext
    private EntityManager em;

    public int addMember(String name) {
      List<?> l = em.createQuery(
              "SELECT m FROM Member m WHERE m.name=:name").
          setParameter("name",  name).
          getResultList();
      int id = 0;
      if(l.isEmpty()) {
        Member member = new Member();
        member.setName(name);
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

    public void deleteMember(int id) {
      Member member = em.find(Member.class, id);
      em.remove(member);
    }
}
