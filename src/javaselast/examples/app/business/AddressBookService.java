package javaselast.examples.app.business;

import javaselast.examples.app.business.exceptions.AuthException;
import javaselast.examples.app.models.Record;
import javaselast.examples.app.models.Roles;
import javaselast.examples.app.persistance.Repository;

public class AddressBookService {

    private Repository<Record,Integer> repository;
    private UserService userService;

    public AddressBookService(Repository<Record,Integer> repository, UserService userService){
        this.repository = repository;
        this.userService = userService;
    }

    private void validation(Record record) {

    }

    public void insert(Record record) {

        validation(record);

        if(userService.checkRole(Roles.MODERATOR)) {
            repository.insert(record);
        } else {
            throw new AuthException();
        }
    }

}
