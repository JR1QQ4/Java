package practice_01;

/**
 * cpu的抽象定义，继承自Component，实现Workable
 */
public abstract class CPU extends Component implements Workable {
    protected int coreNum;

    public CPU(String name, double price, int coreNum) {
        super(name, price);
        this.coreNum = coreNum;
    }

    @Override
    public String description() {
        StringBuilder cpuDescBuilder = new StringBuilder();
        cpuDescBuilder.append(super.description())
                .append("Core Num:{")
                .append(coreNum)
                .append("}");
        return cpuDescBuilder.toString();
    }
}
