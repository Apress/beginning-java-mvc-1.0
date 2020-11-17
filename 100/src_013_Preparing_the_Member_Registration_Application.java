package book.javamvc.jpa.model;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import book.javamvc.jpa.data.User;

@Named
@RequestScoped
public class UserEntering extends User {
}
