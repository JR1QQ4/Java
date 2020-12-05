package practice_01;

/**
 * IntelCPU具体类
 */
public class IntelCPU extends CPU {
    public IntelCPU(String name, double price, int coreNum) {
        super(name, price, coreNum);
    }

    @Override
    public void work() {
        System.out.println("This is Intel's cpu working.");
    }
}
