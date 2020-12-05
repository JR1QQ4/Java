package practice_01;

/**
 * 矿机类
 */
public class Computer extends Component implements Workable {
    private CPU cpu;
    private Disk disk;

    public Computer(String name, CPU cpu, Disk disk) {
        super(name, -1);
        this.cpu = cpu;
        this.disk = disk;
        super.setPrice(cpu.getPrice() + disk.getPrice());
    }

    @Override
    public void work() {
        cpu.work();
        disk.work();
    }

    @Override
    public String description() {
        StringBuilder computerDescBuilder = new StringBuilder();
        computerDescBuilder.append(super.description())
                .append(" CPU description:{")
                .append(cpu.description())
                .append("}")
                .append("; Disk description:{")
                .append(disk.description())
                .append("}");
        return computerDescBuilder.toString();
    }
}
