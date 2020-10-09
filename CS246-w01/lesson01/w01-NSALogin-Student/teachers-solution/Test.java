import java.util.Scanner;

/**
* The Test class is designed for testing the interactions between
* the {@link User} and {@link NSALoginController} classes.
*
* @author  Brother Falin
* @version 1.0
* @since   2016-12-08 
*/
public class Test {

    static final Scanner _scanner = new Scanner(System.in);

    /**
    * This is the main method we use for testing the encryption code.
    * @param args Unused.
    */
    public static void main(String[] args) {
        
        // Ask the user for their password and use it to create a new User instance
        System.out.print("Enter your password: ");
        String password = _scanner.next();

        User user = new User(password);
        
        // We have to use try/catch blocks here because our hashing functions
        // can throw exceptions. For more information see:
        // https://docs.oracle.com/javase/tutorial/essential/exceptions/handling.html
        try
        {
            // Use NSALoginController to hash the user's password.
            NSALoginController.hashUserPassword(user);
            
            // The user's password should now be empty, but we should have a 
            // hashed version as well as the salt value. Print all three of those
            // to verify our assumptions.
            System.out.format("\tPassword After Hash: %s\n", user.getPassword());
            System.out.format("\tHashed Password: %s\n", user.getHashedPassword());
            System.out.format("\tSalt: %s\n", user.getSalt());
        }
        catch(WeakPasswordException ex) {
            System.out.println("Password rejected: " + ex.getMessage());
            return;
        }
        catch(Exception ex) {
            System.out.println("Something went wrong.");
            return;
        }
        
        // Now, imagine the user tries to login. Set their password to the correct
        // value, and use NSALoginController's verifyPassword() method to verify
        // that the password specified is the same as the one we hashed.
        System.out.print("Enter your password: ");
        password = _scanner.next();
        user.setPassword(password);
        
        try {
            if(NSALoginController.verifyPassword(user))
                System.out.println("Login Successful!");
            else
                System.out.println("Login Failed!");
        } 
        catch (Exception e) {
            System.out.println("Something went wrong.");
        }
        
    }
}