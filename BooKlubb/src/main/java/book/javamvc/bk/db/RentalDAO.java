package book.javamvc.bk.db;

import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class RentalDAO {
    @PersistenceContext
    private EntityManager em;

	public void rentBook(Book b, Member m, Date day) {
		Rental r = b.getRental();
		if(r == null) {
			r = new Rental();
		}
		r.setBook(b);
		r.setMemberId(m.getId());
		r.setRentalDay(day);
		b.setRental(r);
		em.merge(b);
		
		Set<Rental> rs = m.getRental();
		if(rs.stream().allMatch(r1 -> { return r1.getBook().getId() != b.getId(); })) {
			rs.add(r);
			m.setRental(rs);
			em.merge(m);			
		}
	}

	public void unrentBook(Book b, Member m) {
		Rental r = b.getRental();
		if(r == null) return;
		
		b.setRental(null);
		em.merge(b);
		
		Set<Rental> newRental = 
				m.getRental().stream().filter(rr -> { return rr.getBook().getId() != b.getId(); }).collect(Collectors.toSet());
		m.setRental(newRental);
		em.merge(m);
	}
}
