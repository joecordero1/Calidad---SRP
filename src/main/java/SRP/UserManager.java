package SRP;

public class UserManager {
    private UserValidator userValidator;
    private UserRepository userRepository;
    private NotificationService notificationService;

    // Constructor que inicializa las dependencias
    public UserManager(UserValidator userValidator, UserRepository userRepository, NotificationService notificationService) {
        this.userValidator = userValidator;
        this.userRepository = userRepository;
        this.notificationService = notificationService;
    }

    public void addUser(String email, String password) {
        if (userValidator.isValidEmail(email) && userValidator.isValidPassword(password)) {
            userRepository.saveToDatabase(email, password);
            notificationService.sendWelcomeEmail(email);
        } else {
            System.out.println("Invalid email or password. User not added.");
        }
    }
}
