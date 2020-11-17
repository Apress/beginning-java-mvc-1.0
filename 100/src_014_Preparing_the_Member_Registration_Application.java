package book.javamvc.jpa.model;

import java.util.ArrayList;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import book.javamvc.jpa.data.User;

@Named
@RequestScoped
public class UserList extends ArrayList<User>{
    private static final long serialVersionUID = 
          8570272213112459191L;
}
