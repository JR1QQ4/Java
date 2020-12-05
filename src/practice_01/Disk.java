package practice_01;

/**
 * 硬盘的抽象定义，继承自Component，实现Workable
 */
public abstract class Disk extends Component implements Workable {
    protected int volume;

    public Disk(String name, double price, int volume) {
        super(name, price);
        this.volume = volume;
    }

    @Override
    public String description() {
        StringBuilder diskDescBuilder = new StringBuilder();
        diskDescBuilder.append(super.description())
                .append(" size(MB):{")
                .append(volume)
                .append(" MB}");
        return diskDescBuilder.toString();
    }
}
