package NSALogin;
import java.util.Scanner;

public class Test {

    private static final Scanner scanner = new Scanner( System.in );

    public static void main(String[] args) {
        boolean flag = false;

        while (!flag) {
            try {
                System.out.println("Please, choose your password:");
                System.out.println("(Password should be at least 8 characters long and contain at least one digit.)");

                String password = scanner.nextLine();

                if (password.length() < 8 || !password.matches(".*[0-9].*"))
                    throw new WeakPasswordException("All passwords must be at least eight characters long and contain at least one digit.\n");

                User user = new User(password);

                System.out.format("%n\tPassword: %s%n", user.getPassword());
                System.out.format("\tSalt: %s%n", user.getSalt());
                System.out.format("\tHashed Password: %s%n%n", user.getHashedPassword());

                NSALoginController.hashUserPassword(user);

                System.out.format("\tPassword: %s%n", user.getPassword());
                System.out.format("\tSalt: %s%n", user.getSalt());
                System.out.format("\tHashed Password: %s%n%n", user.getHashedPassword());

                System.out.println("Please, re-enter the password again to check matching:");
                String passwordCheck = scanner.nextLine();
                user.setPassword(passwordCheck);

                boolean checked = NSALoginController.verifyPassword(user);

                if (checked) {
                    System.out.println("%n\tPassword matches.");
                    flag = true;
                }
                else
                    System.out.println("%n\tPassword does not match. Please, try again.\n");

            } catch (WeakPasswordException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
