package ISP;

public class Main {
    public static void main(String[] args) {
        Switchable phone = new Phone();
        Switchable camera = new DisposableCamera();
        Rechargeable rechargeablePhone = (Rechargeable) phone;

        phone.turnOn();
        rechargeablePhone.charge(); // Solo los dispositivos recargables pueden cargarse
        phone.turnOff();

        camera.turnOn();
        camera.turnOff();
    }
}
