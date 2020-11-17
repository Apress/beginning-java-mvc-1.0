package book.javamvc.bk.model;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import book.javamvc.bk.db.Member;

@Named
@RequestScoped
public class MemberSearchResult extends 
      ArrayList<MemberModel>{
  private static final long serialVersionUID = 
        -5926389915908884067L;
  public void addAll(List<Member> l) {
    l.forEach(m -> {
      add(new MemberModel(
        m.getId(),
        m.getFirstName(),
        m.getLastName(),
        m.getBirthday(),
        m.getSsn()
      ));
    });
  }
}
