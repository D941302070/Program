package XueXiJiLu.Polymorphism.demo04;

public class Main {

    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.powerOn();
        USB mouse = new Mouse();
        computer.usbDevice(mouse);
        Keyboard keyboard =new Keyboard();
        computer.usbDevice(keyboard);//传入参数时自动进行转换

        computer.powerOff();
    }
}
