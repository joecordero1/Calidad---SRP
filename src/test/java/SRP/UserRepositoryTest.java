package SRP;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserRepositoryTest {

    private final UserRepository repository = new UserRepository();

    @Test
    public void testSaveToDatabase() {
        // Simula guardar un usuario y verifica que no lanza excepciones
        assertDoesNotThrow(() -> repository.saveToDatabase("test@example.com", "password123"));
    }
}
