package NSALogin;

public class WeakPasswordException extends Exception {

    public WeakPasswordException() {
        super("Invalid password. Try again.");
    }

    public WeakPasswordException(String message) {
        super(message);
    }

}
