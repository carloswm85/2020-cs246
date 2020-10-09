package NSALogin;

public class User {

    private String password;
    private String salt;
    private String hashedPassword;

    public User(String initialPassword) {
        this.password = initialPassword;
        this.salt = null;
        this.hashedPassword = null;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public void setHashedPassword(String hash) {
        this.hashedPassword = hash;
    }

    public String getPassword() {
        return password;
    }

    public String getSalt() {
        return salt;
    }

    public String getHashedPassword() { return hashedPassword; }
}
