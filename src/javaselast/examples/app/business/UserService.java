package javaselast.examples.app.business;


import javaselast.examples.app.models.Roles;
import javaselast.examples.app.models.User;

public class UserService {

    public User current() {
        return new User();
    }

    public boolean checkRole(Roles role) {
        return true;
    }

}
