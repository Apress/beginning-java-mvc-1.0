package book.javamvc.helloworld;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class UserData {
    private String name;
    private int age;
    // Getters and setters...
}
