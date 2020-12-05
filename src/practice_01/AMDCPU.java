package practice_01;

/**
 * AMD CPU具体类
 */
public class AMDCPU extends CPU {
    public AMDCPU(String name, double price, int coreNum) {
        super(name, price, coreNum);
    }

    @Override
    public void work() {
        System.out.println("This is AMD's cpu working.");
    }
}
