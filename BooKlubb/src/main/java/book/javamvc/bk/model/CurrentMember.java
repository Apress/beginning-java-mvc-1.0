package book.javamvc.bk.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class CurrentMember extends MemberModel implements Serializable {	
	private static final long serialVersionUID = 1072669174088693545L;
	private boolean defined = false;
	private Set<BookModel> rentals;
	
	public boolean isDefined() {
		return defined;
	}

	public void setDefined(boolean defined) {
		this.defined = defined;
	}

	public void setRentals(Set<BookModel> rentals) {
		this.rentals = rentals;
	}

	public Set<BookModel> getRentals() {
		return rentals;
	}
}
