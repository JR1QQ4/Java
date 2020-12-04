package base;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Date;
import java.util.*;
import java.util.function.Consumer;

/**
 * lambda
 */
public class Core_05 {
    public static void main(String[] args) {
        /*
         * lambda表达式
         * 在lambda表达式中，只能引用值不会改变引用的变量
         * lambda表达式中捕获的变量必须实际上是最终变量（effectively final）
         * 在方法中不能有两个同名的局部变量，因此lambda表达式中同样也不能有同名的局部变量
         *
         * */
//        Comparator<String> comp = (String first, String second) -> {
//            if (first.length() < second.length()) return -1;
//            else if (first.length() > second.length()) return 1;
//            else return 0;
//        };
//        System.out.println(comp.compare("abc", "bcde"));
//
//        Consumer tConsumer = event -> {
//            System.out.println("The time is " + new Date());
//        };
//        tConsumer.accept(comp);

//        String[] planets = new String[] {"Mercury", "Venus", "Earth", " Mars", "Jupiter", "Saturn", "Uranus", "Neptune"};
//        System.out.println(Arrays.toString(planets));
//        System.out.println("Sorted in dictionary order:");
//        Arrays.sort(planets);
//        System.out.println(Arrays.toString(planets));
//        System.out.println("Sorted by length:");
//        Arrays.sort(planets, (first, second) -> first.length() - second.length());
//        System.out.println(Arrays.toString(planets));
//
//        Timer t = new Timer(1000, event ->
//                System.out.println("The time is " + new Date()));
//        t.start();
//        JOptionPane.showMessageDialog(null, "Quit program?");
//        System.exit(0);

        // 两个是等价的
        // ::操作符分割方法名于对象或类名，主要有3种情况：
        // object::instanceMethod
        // Class::staticMethod
        // Class::instanceMethod，String::compareToIgnoreCase等同于(x,y)->x.compareToIgnoreCase(y)
//        Timer t1 = new Timer(1000, System.out::println);
//        Timer t2 = new Timer(1000,
//                x -> System.out.println(x));

        //
    }
}

/*
 * 接口：
 * 接口不是类，而是对类的一组需求描述，这些类要遵从接口描述的统一格式进行定义
 * 接口中的所有方法自动地属于public，在声明方法时不必提供关键字public
 * 在接口中还可以定义常量，接口不能含有实例域，JavaSE8之前也不能在接口中实现方法
 * 提供实例域和方法实现的任务应该由实现接口的那个类来完成，可以将接口看成是没有实例域的抽象类
 *
 * 让类实现一个接口的两个步骤：
 * 1）将类声明为实现给定的接口（class Employee implements Comparable）
 * 2）对接口中的所有方法进行定义
 * */
class EmployeeSortTest {
    public static void main(String[] args) {
        InEmployee[] staff = new InEmployee[3];
        staff[0] = new InEmployee("Harry Hacker", 35000);
        staff[1] = new InEmployee("Carl Cracker", 75000);
        staff[2] = new InEmployee("Tony Tester", 38000);
        Arrays.sort(staff);
        for (InEmployee e :
                staff) {
            System.out.println("name=" + e.getName() + ", salary=" + e.getSalary());
        }
    }
}

class InEmployee implements Comparable<InEmployee> {
    private String name;
    private double salary;

    public InEmployee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    public int compareTo(InEmployee other) {
//        return Double.compare(salary, other.salary);
        return Double.compare(other.salary, salary);
    }
}

/*
 * 接口不是类，尤其不能使用new运算符实例化一个接口
 * 然而，尽管不能构造接口的对象，却能声明接口的变量
 * 接口变量必须引用实现了接口的类对象
 * 一个类实现多个接口时用逗号将实现的格格接口分隔开
 *
 * 抽象类表示通用属性存在这样一个问题：每个类只能扩展于一个类
 * 但每个类可以实现多个接口，即多重继承
 *
 * 解决默认方法冲突规则：1）超类优先；2）接口冲突
 * */
class TimerTest {
    public static void main(String[] args) {
        ActionListener listener = new TimePrinter();
        Timer t = new Timer(10000, listener);
        t.start();
    }
}

class TimePrinter implements ActionListener {
    public void actionPerformed(ActionEvent event) {
        System.out.println("At the tone, the time is " + new Date());
        Toolkit.getDefaultToolkit().beep();
    }
}

/**
 * 对象克隆
 */
class CloneTest {
    public static void main(String[] args) {
        try {
            CloneEmployee original = new CloneEmployee("John Q. Public", 50000);
            original.setHireDay(2000, 1, 1);
            CloneEmployee copy = original.clone();
            copy.raiseSalary(10);
            copy.setHireDay(2002, 12, 31);
            System.out.println("original=" + original);
            System.out.println("copy=" + copy);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}

class CloneEmployee implements Cloneable {
    private String name;
    private double salary;
    private Date hireDay;

    public CloneEmployee(String name, double salary) {
        this.name = name;
        this.salary = salary;
        hireDay = new Date();
    }

    public CloneEmployee clone() throws CloneNotSupportedException {
        CloneEmployee cloned = (CloneEmployee) super.clone();
        cloned.hireDay = (Date) hireDay.clone();
        return cloned;
    }

    public void setHireDay(int year, int month, int day) {
        Date newHireDay = new GregorianCalendar(year, month - 1, day).getTime();
        hireDay.setTime(newHireDay.getTime());
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    public String toString() {
        return "CloneEmployee[name=" + name + ",salary=" + salary + ",hireDay=" + hireDay + "]";
    }
}

/*
 * 内部类
 * */
class InnerClassTest {
    public static void main(String[] args) {
        // OuterClass.InnerClass引用
        TalkingClock clock = new TalkingClock(1000, true);
        clock.start();
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}

class TalkingClock {
    private int interval;
    private boolean beep;

    public TalkingClock(int interval, boolean beep) {
        this.interval = interval;
        this.beep = beep;
    }

    public void start() {
        ActionListener listener = new TimePrinter();
        Timer t = new Timer(interval, listener);
        t.start();
    }

    public class TimePrinter implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            System.out.println("At the tone, the time is " + new Date());
            if (beep) Toolkit.getDefaultToolkit().beep();
        }
    }
}

/*
 * 代理
 * 合适使用代理：假设有一个表示接口的Class对象（有可能只包含一个接口），它的确切类型在编译时无法知道
 * 创建代理，需要使用Proxy类的newProxyInstance方法
 * */
class ProxyTest {
    public static void main(String[] args) {
        Object[] elements = new Object[1000];
        for (int i = 0; i < elements.length; i++) {
            Integer value = i + 1;
            InvocationHandler handler = new TraceHandler(value);
            Object proxy = Proxy.newProxyInstance(null, new Class[]{Comparable.class}, handler);
            elements[i] = proxy;
        }
        Integer key = new Random().nextInt(elements.length) + 1;
        int result = Arrays.binarySearch(elements, key);
        if (result >= 0) System.out.println(elements[result]);
    }
}

class TraceHandler implements InvocationHandler {
    private Object target;

    public TraceHandler(Object t) {
        target = t;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.print(target);
        System.out.print("." + method.getName() + "(");
        if (args != null) {
            for (int i = 0; i < args.length; i++) {
                System.out.print(args[i]);
                if (i < args.length - 1) System.out.print(", ");
            }
        }
        System.out.print(")");
        return method.invoke(target, args);
    }
}