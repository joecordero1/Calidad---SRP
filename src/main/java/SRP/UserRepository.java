package SRP;

public class UserRepository {
    public void saveToDatabase(String email, String password) {
        System.out.println("Saving user to the database...");
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);
    }
}
