package SRP;

public class Main {
    public static void main(String[] args) {
        UserValidator userValidator = new UserValidator();
        UserRepository userRepository = new UserRepository();
        NotificationService notificationService = new NotificationService();

        UserManager userManager = new UserManager(userValidator, userRepository, notificationService);

        userManager.addUser("example@domain.com", "password123"); // Entrada válida
        userManager.addUser("invalid-email", "1234"); // Entrada inválida
    }
}
