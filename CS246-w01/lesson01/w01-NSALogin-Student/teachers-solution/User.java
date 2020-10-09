/**
* The User class is a simple class that holds the password,
* salt, and hashed password for a given user.
* @author  Brother Falin
* @version 1.0
* @since   2016-12-08 
*/
public class User {
        
    String _password;
    String _salt;
    String _hashedPassword;

    /**
    * @param initialPassword (required) The initial password for the user. 
    */
    public User(String initialPassword) {
        _password = initialPassword;
    }
    
    /**
    * @return The plain text version of the password. 
    * Once the password has been hashed, this value will be null.
    */
    public String getPassword() {
        return _password;
    }
    
    /**
    * @param newValue The plain text version of the password. 
    * This value should be cleared by the hashing function.
    */
    public void setPassword(String newValue) {
        _password = newValue;
    }
    
    /**
    * @return The Base64-encoded version of the password hash.
    */
    public String getHashedPassword() {
        return _hashedPassword;
    }
    
    /**
    * @param newValue The Base64-encoded version of the password hash.
    */
    public void setHashedPassword(String newValue) {
        _hashedPassword = newValue;
    } 
    
    /**
    * @return The Base64-encoded version of the random password salt.
    */
    public String getSalt() {
        return _salt;
    }
    
    /**
    * @param newValue The Base64-encoded version random password salt.
    */
    public void setSalt(String newValue) {
        _salt = newValue;
    } 
}
