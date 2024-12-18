package ISP;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PhoneTest {

    @Test
    public void testTurnOn() {
        Phone phone = new Phone();
        assertDoesNotThrow(phone::turnOn);
    }

    @Test
    public void testTurnOff() {
        Phone phone = new Phone();
        assertDoesNotThrow(phone::turnOff);
    }

    @Test
    public void testCharge() {
        Phone phone = new Phone();
        assertDoesNotThrow(phone::charge);
    }
}
