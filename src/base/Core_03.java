package base;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

enum Size {
    SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRA_LARGE("XL");
    private String abbreviation;

    private Size(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return abbreviation;
    }
}

/**
 * 继承
 */
public class Core_03 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
//        Manager boss = new Manager("Carl Cracker", 80000, 1987, 12, 15);
//        boss.setBonus(5000);
//        Employee[] staff = new Employee[3];
//        // 可以将一个子类地对象赋给超类变量
//        // 警告别用：子类数组地引用可以转换成超类数组地引用，而不需要采用强制类型转换
//        staff[0] = boss;
//        staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
//        staff[2] = new Employee("Tony Tester", 40000, 1990, 3, 15);
//        for (Employee e :
//                staff) {
//            // 当e引用Employee对象时，e.getSalary调用的是Employee类中的getSalary方法
//            // 当e引用Manager对象时，e.getSalary调用的是Manager类中的getSalary方法
//            // 虚拟机知道e实际引用的对象类型，因此能正确地调用相应地方法
//            // 多态：一个对象变量可以指示多种实际类型地现象称为多态；调用时动态绑定
//            System.out.println(e.getName() + " " + e.getSalary());
//        }

//        Person[] people = new Person[2];
//        people[0] = new MyEmployee("Harry Hacker", 50000, 1989, 10, 1);
//        people[1] = new Student("Maria Morris", "computer science");
//        for (Person p :
//                people) {
//            System.out.println(p.getName() + " " + p.getDescription());
//        }

//        EmployeeObject alice1 = new EmployeeObject("Alice Adams", 75000, 1987, 12, 15);
//        EmployeeObject alice2 = alice1;
//        EmployeeObject alice3 = new EmployeeObject("Alice Adams", 75000, 1987, 12, 15);
//        EmployeeObject bob = new EmployeeObject("Bob Brandson", 50000, 1989, 10, 1);
//        System.out.println("alice1 == alice2: " + (alice1 == alice2));
//        System.out.println("alice1 == alice3: " + (alice1 == alice3));
//        System.out.println("alice1.equals(alice3): " + alice1.equals(alice3));
//        System.out.println("alice1.equals(bob): " + alice1.equals(bob));
//        System.out.println("bob.toString(): " + bob);
//        ManagerObject carl = new ManagerObject("Carl Cracker", 80000, 1987, 12, 15);
//        ManagerObject boss = new ManagerObject("Carl Cracker", 80000, 1987, 12, 15);
//        boss.setBonus(5000);
//        System.out.println("boss.toString(): " + boss);
//        System.out.println("carl.equals(boss): " + carl.equals(boss));
//        System.out.println("alice1.hashCode(): " + alice1.hashCode());
//        System.out.println("alice3.hashCode(): " + alice3.hashCode());
//        System.out.println("bob.hashCode(): " + bob.hashCode());
//        System.out.println("carl.hashCode(): " + carl.hashCode());

//        // 泛型数组列表
//        // Java SE7中可以省去右边的类型参数
//        ArrayList<EmployeeObject> staff = new ArrayList<EmployeeObject>();
//        // add方法，将元素添加到数组列表中
//        staff.add(new EmployeeObject("Harry Hacker", 75000, 1987, 12, 15));
//        staff.add(new EmployeeObject("Tony Tester", 66000, 1998, 10, 1));
//        staff.add(new EmployeeObject("Carl Cracker", 50000, 1990, 3, 15));
//        // 如果已经清除或能够估计出数组可能存储的元素数量，就可以再填充数组之前调用ensureCapacity
//        // ensureCapacity(n)将分配一个包含n个对象的内部数组，然后调用100次add，而不用重新分配空间
//        // staff.ensureCapacity(2);
//        // size返回数组列表中包含的实际元素数目，等价于length
//        // staff.size();
//        // 一旦能够确认数组列表的大小不在发生变化，就可以调用trimToSize方法
//        // 将储存区域的大小调整为当前元素数量所需要的存储空间数目，垃圾回收器将回收多余的存储空间
//        // staff.trimToSize();
//        // 访问数组列表元素，等价于 staff[i] = harry
//        // 添加元素使用add，set是用来修改元素的
//        // staff.set(1, harry);
//        // 获取数组列表的元素，等价于 EmployeeObject e = staff[i];
//        // EmployeeObject e = staff.get(1);
//        // 删除一个元素
//        // EmployeeObject r = staff.remove(1);
//        // 遍历数组列表，等价于 for (int i = 0; i < staff.size(); i++) { }
//        for (EmployeeObject eo:
//                staff) {
//            eo.raiseSalary(5);
//        }
//        for (EmployeeObject eo :
//                staff) {
//            System.out.println("name=" + eo.getName() + ", salary=" + eo.getSalary()
//                    + ", hireDay=" + eo.getHireDay());
//        }

        // 对象包装器类：Integer、Long、Float、Double、Short、Byte、Character、Void、Boolean
        // 对象包装器类是不可变的，一旦构造了包装器，就不允许更改包装在其中的值，同时也是final的，不能定义子类
//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(3); // add(3) 自动变换成 add(Integer.valueOf(3))，称为自动装箱
//        list.add(Integer.valueOf(5));
//        int n = list.get(0);  // get(0) 自动变换为  get(0).intValue()，称为自动拆箱
//        int m = list.get(1).intValue();
//        System.out.println(list.toString());
//        System.out.println(n);
//        System.out.println(m);

        // 编译器需要对printf的每次调用进行转换，以便将参数绑定到数组上，并在必要的时候进行自动装箱
//        System.out.printf("%d %s", new Object[]{ new Integer(3), "widgets"});

//        double m = max(3.1, 40.4, -5);
//        System.out.println(m);  // 40.4

        // enum枚举类
//        Scanner in = new Scanner((System.in));
//        System.out.print("Enter a size: (SMALL, MEDIUM, LARGE, EXTRA_LARGE)");
//        String input = in.next().toUpperCase();
//        System.out.println(Size.class);  // .class base.Size
//        // valueOf返回指定名字、给定类的枚举常量
//        Size size = Enum.valueOf(Size.class, input);
//        System.out.println("size=" + size);
//        System.out.println("abbreviation=" + size.getAbbreviation());
//        if (size == Size.EXTRA_LARGE){
//            System.out.println("Good job--you paid attention to the _.");
//        }

        // Class类实际上是一个泛型类，例如Employee.class的类型是Class<Employee>
//        EmployeeObject eo = new EmployeeObject("Carl Cracker", 80000, 1987, 12, 15);
//        Class c1 = eo.getClass();
//        System.out.println(eo.getClass().getName() + " " + eo.getName());
//        System.out.println(Double[].class.getName()); // [Ljava.lang.Double;
//        System.out.println(int[].class.getName());  // [I

        // 根据存储在字符串中的类名创建一个对象
//        String s = "java.util.Random";
//        Object m = Class.forName(s).newInstance();
//        System.out.println(m);  // java.util.Random

        // 异常捕获
//        try {
//            String name = "java.util";
//            Class c1 = Class.forName(name);
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
    }

    /**
     * 用户自定义可变参数的方法，并将参数指定为任意类型，甚至是基本类型
     *
     * @param values 传入的参数列表
     * @return 最大的值
     */
    public static double max(double... values) {
        double largest = Double.NEGATIVE_INFINITY;
        for (double v :
                values) {
            if (v > largest) {
                largest = v;
            }
        }
        return largest;
    }
}

class Manager extends Employee {
    private double bonus;

    public void setBonus(double b) {
        this.bonus = b;
    }

    public double getBonus() {
        return bonus;
    }

    @Override
    public double getSalary() {
        // super不是一个对象的引用，不能将super赋给另一个对象变量
        // 它只是一个指示编译器调用超类方法的特殊关键字
        double baseSalary = super.getSalary();
        return baseSalary + bonus;
    }

    public Manager(String n, double s, int y, int m, int d) {
        // super调用构造器的语句必须是字类构造器的第一条语句
        // super的两个用途：
        // 1.调用超类的方法
        // 2.调用超类的构造器
        super(n, s, y, m, d);
        // this的两个用途：
        // 1.引用隐式参数
        // 2.调用该类其他的构造器
        this.bonus = 0;
    }
}

// 抽象类：
// 为了提高程序地清晰度，包含一个或多个抽象方法地类本身必须被声明为抽象地
// 除了抽象方法之外，抽象类还可以包含具体数据和具体方法
// 抽象方法充当着占位地角色，它们地具体实现再子类中

// 扩展抽象类可以有两种选择：
// 一种是再抽象类中定义部分抽象类方法或不定义抽象方法，这样就必须将子类也标记为抽象类
// 另一种是定义全部地抽象方法，这样子类就不是抽象的了

// 类即使不含抽象方法，也可以将类声明为抽象类
// 抽象类不能被实例化
// 可以定义一个抽象类的对象变量，但是它只能引用非抽象子类的对象

abstract class Person {
    public abstract String getDescription();

    private String name;

    public Person(String n) {
        this.name = n;
    }

    public String getName() {
        return name;
    }
}

class MyEmployee extends Person {
    private double salary;
    private LocalDate hireDay;

    public MyEmployee(String n, double s, int y, int m, int d) {
        super(n);
        this.salary = s;
        hireDay = LocalDate.of(y, m, d);
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    public String getDescription() {
        return String.format("an employee with a salary of $%.2f", salary);
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }
}

class Student extends Person {
    private String major;

    public Student(String n, String m) {
        super(n);
        this.major = m;
    }

    @Override
    public String getDescription() {
        return "a student majoring in " + major;
    }
}

// 如果需要限制某个方法的使用，就可以将它声明为protected
// 用于控制可见性的4个修饰符：
// 1）private -- 仅对本类可见
// 2）public -- 对所有类可见
// 3）protected -- 对本包和所有子类可见
// 4）默认，不需要修饰符 -- 对本包可见

// Object所有类的超类，所有的数组类型（不管是对象数组还是基本类型的数组）都扩展了Object类
// 只有基本类型（primitive types）不是对象

// equals特性:
// 1）自反性：对于任何非空引用x，x.equals(x)应该返回true
// 2）对称性：对于任何引用x和y，当且仅当y.equals(x)返回true，那么x.equals(y)也应该返回true
// 3）传递性：对于任何引用x、y、z，如果x.equals(y)返回true，y.equals(z)返回true，那么x.equals(z)也返回true
// 4）一致性：如果x和y引用的对象没有发生变化，反复调用x.equals(y)应该返回同样的结果
// 5）对于任意非空引用x，x.equals(null)应该返回false

class EmployeeObject {
    private String name;
    private double salary;
    private LocalDate hireDay;

    public EmployeeObject(String name, double salary, int year, int month, int day) {
        this.name = name;
        this.salary = salary;
        hireDay = LocalDate.of(year, month, day);
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    /**
     * 完美的equals方法的建议
     *
     * @param otherObject 1）显式参数命名为otherObject
     * @return 是不是用一个对象
     */
    public boolean equals(Object otherObject) {
        // 2）检测this与otherObject是否引用同一个对象
        if (this == otherObject) return true;
        // 3）检测是否为null
        if (otherObject == null) return false;
        // 4）比较this与otherObject是否属于同一类
        // 如果equals的语义再每个子类中有所改变，就使用getClass检测
        if (getClass() != otherObject.getClass()) return false;
        // 如果所有的子类都拥有统一的语义，就使用instanceof检测
//        if (!(otherObject instanceof this)) return false;
        // 5）将otherObject转换为相应的类类型变量
        EmployeeObject other = (EmployeeObject) otherObject;
        // 6）现在开始对所有需要比较的域进项比较了，使用==比较基本类型域
        return name.equals(other.name)
                && salary == other.salary
                && hireDay.equals(other.hireDay);
    }

    /**
     * 散列码
     *
     * @return 返回散列码
     */
    public int hashCode() {
//        return 7 * name.hashCode()
//                + 11 * new Double(salary).hashCode()
//                + 13 * hireDay.hashCode();
        // 或者
        return Objects.hash(name, salary, hireDay);
    }

    /**
     * @return String
     */
    public String toString() {
//        return "Employee[name=" + name
//                + ", salary=" + salary
//                + ", hireDay=" + hireDay
//                + "]";
        // 或者
        return getClass().getName()
                + "[name=" + name
                + ", salary=" + salary
                + ", hireDay=" + hireDay
                + "]";

    }
}

class ManagerObject extends EmployeeObject {
    private double bonus;

    public ManagerObject(String name, double salary, int year, int month, int day) {
        super(name, salary, year, month, day);
        bonus = 0;
    }

    public double getSalary() {
        double baseSalary = super.getSalary();
        return baseSalary + bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public boolean equals(Object otherObject) {
        if (!super.equals(otherObject)) return false;
        ManagerObject other = (ManagerObject) otherObject;
        return bonus == other.bonus;
    }

    public int hashCode() {
        return super.hashCode() + 17 * new Double(bonus).hashCode();
    }

    public String toString() {
        return super.toString() + "[bonus=" + bonus + "]";
    }
}