package practice_01;

/**
 * 西部数据类
 */
public class WestDigital extends Disk {
    public WestDigital(String name, double price, int volume) {
        super(name, price, volume);
    }

    @Override
    public void work() {
        System.out.println("This is WestDigital working.");
    }
}
