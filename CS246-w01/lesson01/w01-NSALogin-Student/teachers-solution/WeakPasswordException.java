/**
* This exception is used when a password violates NSA policy.
*
* @author  Brother Falin
* @version 1.0
* @since   2016-12-08 
* @see NSALoginController
*/
public class WeakPasswordException extends Exception {

    /**
    * Constructor.
    * @param message The reason the password was rejected. 
    */
    public WeakPasswordException(String message) {
        super(message);
    }
}