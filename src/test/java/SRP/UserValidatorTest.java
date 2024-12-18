package SRP;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserValidatorTest {

    private final UserValidator validator = new UserValidator();

    @Test
    public void testValidEmail() {
        assertTrue(validator.isValidEmail("test@example.com"));
    }

    @Test
    public void testInvalidEmail() {
        assertFalse(validator.isValidEmail("invalid-email"));
    }

    @Test
    public void testValidPassword() {
        assertTrue(validator.isValidPassword("password123"));
    }

    @Test
    public void testInvalidPassword() {
        assertFalse(validator.isValidPassword("12345"));
    }
}
