package javaselast.examples.app.business.exceptions;

public class AuthException extends RuntimeException {

    public AuthException() {
        super("User access");
    }

}
