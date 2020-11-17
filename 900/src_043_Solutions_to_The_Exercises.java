import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import [...].MyDateTimeLocal;
import [...].MyDateTimeRemote;
import [...].MyDateTime;

@Stateless
@Local(MyDateTimeLocal.class)
@Remote(MyDateTimeRemote.class)
public class MyDateTimeEjb {
  public String date(String format) {
    return new MyDateTime().date(format);
  }
}
