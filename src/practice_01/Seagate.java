package practice_01;

/**
 * 希捷硬盘类
 */
public class Seagate extends Disk {
    public Seagate(String name, double price, int volume) {
        super(name, price, volume);
    }

    @Override
    public void work() {
        System.out.println("This is Seagate working.");
    }
}
