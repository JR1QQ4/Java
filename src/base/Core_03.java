package base;

import java.time.LocalDate;

/**
 * 继承
 */

public class Core_03 {
    public static void main(String[] args) {
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

        Person[] people = new Person[2];
        people[0] = new MyEmployee("Harry Hacker", 50000, 1989, 10, 1);
        people[1] = new Student("Maria Morris", "computer science");
        for (Person p :
                people) {
            System.out.println(p.getName() + " " + p.getDescription());
        }
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