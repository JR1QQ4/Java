package base;

/**
 * 设计模式
 */
public class Core_23 {
}

/**
 * 单例模式
 */
class Singleton {
    // private保证不能被new，static保证所有对象存储在同一个内存中
    private static Singleton obj = new Singleton();
    private String content;

    private Singleton() {
        this.content = "abc";
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public static Singleton getInstance() {
        return obj;
    }

    public static void main(String[] args) {
        Singleton obj1 = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance();
        System.out.println(obj1.getContent());
        System.out.println(obj2.getContent());
        System.out.println("------------------");
        obj1.setContent("jkl");
        System.out.println(obj1.getContent());
        System.out.println(obj2.getContent());
        System.out.println("obj1==obj2: " + (obj1 == obj2));
    }
}