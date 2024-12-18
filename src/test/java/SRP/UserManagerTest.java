package SRP;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class UserManagerTest {

    @Mock
    private UserValidator mockValidator;

    @Mock
    private UserRepository mockRepository;

    @Mock
    private NotificationService mockService;

    @InjectMocks
    private UserManager userManager;

    @BeforeEach
    public void setUp() {
        // Inicializa los mocks manualmente
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddUserValid() {
        // Configura el comportamiento de los mocks
        when(mockValidator.isValidEmail("test@example.com")).thenReturn(true);
        when(mockValidator.isValidPassword("password123")).thenReturn(true);

        // Llama al método
        userManager.addUser("test@example.com", "password123");

        // Verifica las interacciones con los mocks
        verify(mockRepository).saveToDatabase("test@example.com", "password123");
        verify(mockService).sendWelcomeEmail("test@example.com");
    }

    @Test
    public void testAddUserInvalid() {
        // Configura el comportamiento de los mocks
        when(mockValidator.isValidEmail("invalid-email")).thenReturn(false);

        // Llama al método
        userManager.addUser("invalid-email", "password123");

        // Verifica que no se llamaron los métodos de repository y service
        verify(mockRepository, never()).saveToDatabase(anyString(), anyString());
        verify(mockService, never()).sendWelcomeEmail(anyString());
    }
}
