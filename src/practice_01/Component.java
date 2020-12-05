package practice_01;

/**
 * 逻辑部件的定义
 */
public abstract class Component {
    private double price;  //单位元
    private String name;

    public Component(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String description() {
        StringBuilder descriptionBuilder = new StringBuilder();
        descriptionBuilder.append("name:{")
                .append(name)
                .append("}; price:{")
                .append(price)
                .append("}; ");
        return descriptionBuilder.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
