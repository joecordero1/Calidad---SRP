package ISP;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DisposableCameraTest {

    @Test
    public void testTurnOn() {
        DisposableCamera camera = new DisposableCamera();
        assertDoesNotThrow(camera::turnOn);
    }

    @Test
    public void testTurnOff() {
        DisposableCamera camera = new DisposableCamera();
        assertDoesNotThrow(camera::turnOff);
    }
}
