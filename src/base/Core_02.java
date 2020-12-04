package base;
/**
 * 对象与类
 */

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Date;
import java.util.Random;
import java.awt.*;

// 静态导入，可以导入类的静态方法和静态域
import static java.lang.System.*;

// 编译器对文件进行操作，Java解释器加载类
// > javac com/mycompany/PayrollApp.java
// > java com.mycompany.PayrollApp

// jar文件使用zip格式组织文件和子目录。可以使用所有zip实用程序查看内部的rt.jar以及其他的jar文件

// 类路径
// 当源代码引用了Employee类，编译器将试图查找:
// java.lang.Employee(java.lang被默认导入的) ->
// java.util.Employee
// com.horstmann.corejava.Employee和当前包中的Employee

// 设置类路径
// java -classpath /home/user/classdir:.:/home/user/archives/archive.jar MyProg
// java -classpath c:\classdir;.;c:\archives\archive.jar MyProg
// 或者
// export CLASSPATH=/home/user/classdir:.:/home/user/archives/archive.jar
// set CLASSPATH=c:\classdir;.;c:\archives\archive.jar

/**
 * 通用注释
 * @author 姓名
 * @version 文本
 * @since version 1.7.1
 * @deprecated 文本
 * @see <a href="www.baidu.com">引用</a>
 */

// javadoc生成文档

// 类设计技巧：
    // 一定要保证数据私有
    // 一定要对数据初始化
    // 不要再类中使用过多的基本类型
    // 不是所有的域都需要独立的域访问器和域更改器
    // 将职责过多的类进行分解
    // 类名和方法名要能够体现它们的职责
    // 有限使用不可变的类，如LocalDate类

public class Core_02 {
    public static void tripValue(double x) {
        x = 3 * x;
        System.out.println("End od method: x=" + x);
    }

    public static void tripSalary(Employee x) {
        x.raiseSalary(200);
        System.out.println("End od method: salary=" + x.getSalary());
    }

    public static void swap(Employee x, Employee y) {
        Employee temp = x;
        x = y;
        y = temp;
        System.out.println("End of method: x=" + x.getName());
        System.out.println("End of method: y=" + y.getName());
    }

    public static void main(String[] args) {
        // 对象
        // 对象的三个特性：对象的行尾、对象的状态、对象标识
        // 类之间的关系：以来、聚合、集成
//        System.out.println(new Date()); // Thu Nov 26 01:00:18 CST 2020

//        LocalDate date = LocalDate.now();
//        System.out.println(date);
////        date = LocalDate.of(2020, 10, 2);
//        int month = date.getMonthValue();
//        int today = date.getDayOfMonth();
//        date = date.minusDays(today - 1);
//        DayOfWeek weekday = date.getDayOfWeek();
//        int value = weekday.getValue();
//        System.out.println("month is: " + month);
//        System.out.println("today is: " + today);
//        System.out.println("date is: " + date);
//        System.out.println("weekday is: " + weekday);
//        System.out.println("weekday value is: " + value);  // 1=Monday...7=Sunday
//        System.out.println("Mon Tue Wed Thu Fri Sat Sun");
//        for (int i = 0; i < value - 1; i++) {
//            System.out.print("    ");
//        }
//        while (date.getMonthValue() == month){
//            System.out.printf("%3d", date.getDayOfMonth());
//            if (date.getDayOfMonth() == today){
//                System.out.print("*");
//            }else{
//                System.out.print(" ");
//            }
//            date = date.plusDays(1);
//            if (date.getDayOfWeek().getValue() == 1) {
//                System.out.println();
//            }
//        }
//        if (date.getDayOfWeek().getValue() != 1){
//            System.out.println();
//        }

        // Employee Test
//        Employee[] staff = new Employee[3];
//        staff[0] = new Employee("Carl Cracker", 75000, 1987, 12, 15);
//        staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
//        staff[2] = new Employee("Tony Tester", 40000, 1990, 3, 15);
//        for (Employee e :
//                staff) {
//            e.raiseSalary(5);
//        }
//        for (Employee e :
//                staff) {
//            System.out.println("name=" + e.getName() + ", Salary=" + e.getSalary() + ", hireDay=" + e.getHireDay());
//        }

        // 类的调用
        // 显示调用：可以使用通配符调用多各类，Employee*.java会调用Employee.java和EmployeeTest.java
        // 隐式调用：EmployeeTest.java中使用了Employee.java，Java编译器会自动寻找

        // private，如果需要返回一个可变数据域的拷贝，就应该使用clone；数据域即私有变量
        // static，静态变量计师没有一个实例对象，静态变量也存在，它属于类，而不属于任何独立的对象
        // 静态变量，如果关键字static被省略，变量就变成一个实例域，每个对象都有它的一份拷贝
        // 设置类变量时，最好设置成private的，或者设置成final的，防止每个类对象都可以进行修改
        // 静态方法是没有this参数的方法，使用类名调用；非静态的方法中，this标识这个方法的隐式参数

//        Employee[] staff = new Employee[3];
//        staff[0] = new Employee("Tom", 40000);
//        staff[1] = new Employee("Dick", 50000);
//        staff[2] = new Employee("Harry", 65000);
//        for (Employee e :
//                staff) {
//            e.setId();
//            System.out.println("name=" + e.getName() + ", id=" + e.getId() + ", salary=" + e.getSalary());
//        }
//        int n = Employee.getNextId();
//        System.out.println("Next available id=" + n);

        // 对象引用是按值传递的
        // 一个方法不能直接修改一个基本数据类型的参数
        // 一个方法可以改变一个对象参数的状态
        // 一个方法不能让对象参数引用一个新的对象
//        System.out.println("Testing tripValue:");
//        double percent = 10;
//        System.out.println("Before: percent=" + percent);
//        tripValue(percent);
//        System.out.println("After: percent=" + percent);
//
//        System.out.println("\nTesting tripleSalary:");
//        Employee harry = new Employee("Harry", 500000);
//        System.out.println("Before: salary=" + harry.getSalary());
//        tripSalary(harry);
//        System.out.println("After: salary=" + harry.getSalary());
//
        System.out.println("\nTesting swap:");
        Employee a = new Employee("Alice", 620000);
        Employee b = new Employee("Bob", 530000);
        System.out.println("Before: a=" + a.getName());
        System.out.println("Before: b=" + b.getName());
        swap(a, b);
        System.out.println("After: a=" + a.getName());
        System.out.println("After: b=" + b.getName());

        // 重载：多个方法有相同的名字、不同的参数

//        Employee a = new Employee("Harry", 40000);
//        System.out.println("name=" + a.getName() + ",id=" + a.getId() + ",salary=" + a.getSalary());
    }
}

class Employee {
    // public允许程序中的任何方法对其进行读取和修改
    // private确保只有通过类自身的方法访问到这些变量

    private String name;
    private double salary;
    private LocalDate hireDay;
    private int id;

    // 类第一次加载的时候将会进行静态域的初始化
    // 与实例域一样，除非显示地设置成其他值，否则默认的初始值是0、false、null
    private static int nextId;

    static {
        System.out.println("Hello, world!");
    }

    static {
        Random generator = new Random();
        nextId = generator.nextInt(10000);  // [0, 10000 - 1]
    }

    {
        id = nextId;
        nextId++;
    }

    public Employee(String n, double s, int year, int month, int day) {
        // 构造器与类同名，一个类可以有一个以上的构造器，构造器没有返回值
        // 构造器总是伴随着new操作一起调用
        // 不要再构造器中定义与类变量重名的局部变量
        name = n;
        salary = s;
        hireDay = LocalDate.of(year, month, day);
    }

    public Employee(String n, double s) {
        hireDay = LocalDate.now();
        name = n;
        salary = s;
    }

    public Employee() {
        name = "";
        salary = 0;
        hireDay = LocalDate.now();
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Employee.nextId = nextId;
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

    public int getId() {
        return id;
    }

//    public void setId() {
//        id = nextId;
//        nextId++;
//    }

//    public static void main(String[] args) {
//        Employee e = new Employee("Harry", 50000);
//        System.out.println(e.getName() + " " + e.getSalary());
//    }
}