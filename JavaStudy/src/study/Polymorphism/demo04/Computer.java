package XueXiJiLu.Polymorphism.demo04;

public class Computer {

    public void powerOn() {
        System.out.println("笔记本开机");
    }

    public void powerOff() {
        System.out.println("笔记本关机");
    }

    //使用usb设备
    public void usbDevice(USB usb) {
        usb.open();
        if (usb instanceof Mouse) {//先判断，再向下转型
            Mouse mouse = (Mouse) usb;//向下转型
            mouse.click();
        } else if (usb instanceof Keyboard) {
            Keyboard keyboard = (Keyboard) usb;
            keyboard.type();
        }
        usb.close();
    }
}
