package base;
/**
 * 继承的技巧：
 * 1.将公共操作和域放在超类
 * 2.不要使用受保护的域
 * 3.使用继承实现“is-a”关系
 * 4.除非所有继承的方法都有意义，否则不要使用继承
 * 5.在覆盖方法时，不要改变预期的行尾
 * 6.使用多态，而非类型信息
 * 7.不要过多地使用反射
 */

import com.sun.xml.internal.bind.v2.runtime.MarshallerImpl;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

import java.lang.reflect.*;
import java.util.*;

public class Core_04 {
    public static void main(String[] args) {
        ArrayList<Integer> squares = new ArrayList<>();
        for (int i = 0; i <= 5; i++) {
            squares.add(i * i);
        }
        System.out.println(new ObjectAnalyzer().toString(squares));
    }
}

/**
 * 反射
 */
class ReflectionTest {
    public static void main(String[] args) {
        String name = "";
        if (args.length > 0) name = args[0];
        else {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter class name (e.g. java.util.Date): ");
            name = in.next();
        }
        try {
            Class cl = Class.forName(name);
            Class supercl = cl.getSuperclass();
            String modifiers = Modifier.toString(cl.getModifiers());
            if (modifiers.length() > 0) System.out.print(modifiers + " ");
            System.out.print("class " + name);
            if (supercl != null && supercl != Object.class) System.out.print(" extends "
                    + supercl.getName());
            System.out.print("\n{\n");
            printConstructors(cl);
            System.out.println();
            printMethods(cl);
            System.out.println();
            printFields(cl);
            System.out.println("}");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }

    public static void printConstructors(Class cl) {
        // getConstructor返回CLass对象描述的类的所有公有构造器
        // getDeclaredConstructors返回所有构造器
        Constructor[] constructors = cl.getDeclaredConstructors();
        for (Constructor c :
                constructors) {
            String name = c.getName();
            System.out.print("  ");
            // getModifiers返回用于描述构造器、方法或域的修饰符的整型数值
            // Modifier.toString返回modifiers中设置的修饰符的字符串表示
            String modifiers = Modifier.toString(c.getModifiers());
            if (modifiers.length() > 0) System.out.print(modifiers + " ");
            System.out.print(name + "(");
            // getParameterTypes返回用于描述参数类型的Class对象数组
            Class[] paramTypes = c.getParameterTypes();
            for (int i = 0; i < paramTypes.length; i++) {
                if (i > 0) System.out.print(", ");
                System.out.print(paramTypes[i].getName());
            }
            System.out.println(");");
        }
    }

    public static void printMethods(Class cl) {
        // getMethods返回包含Method对象的数组
        // getDeclaredMethods单会这个类或接口的全部方法，但不包括由超类继承了的方法
        Method[] methods = cl.getDeclaredMethods();
        for (Method m :
                methods) {
            Class retType = m.getReturnType();
            String name = m.getName();
            System.out.print("  ");
            String modifiers = Modifier.toString(m.getModifiers());
            if (modifiers.length() > 0) System.out.print(modifiers + " ");
            System.out.print(retType.getName() + " " + name + "(");
            Class[] patamTypes = m.getParameterTypes();
            for (int i = 0; i < patamTypes.length; i++) {
                if (i > 0) System.out.print(", ");
                System.out.print(patamTypes[i].getName());
            }
            System.out.println(");");
        }
    }

    public static void printFields(Class cl) {
        // getFields返回一个包含Field对象的数组
        // getDeclaredFields返回包含Field对象的数组
        // 记录了这个类的全部域，如果没有域或者Class对象描述的是基本类型或数组类型，返回一个长度为0的数组
        Field[] fields = cl.getDeclaredFields();
        for (Field f :
                fields) {
            Class type = f.getType();
            String name = f.getName();
            System.out.print("  ");
            String modifiers = Modifier.toString(f.getModifiers());
            if (modifiers.length() > 0) System.out.print(modifiers + " ");
            System.out.println(type.getName() + " " + name + ";");
        }
    }
}

/**
 * 利用反射分析类
 */
class ObjectAnalyzer {
    private ArrayList<Object> visited = new ArrayList<>();

    public String toString(Object obj) {
        if (obj == null) return "null";
        if (visited.contains(obj)) return "...";
        visited.add(obj);
        Class cl = obj.getClass();
        if (cl == String.class) return (String) obj;
        if (cl.isArray()) {
            String r = cl.getComponentType() + "[]{";
            for (int i = 0; i < Array.getLength(obj); i++) {
                if (i > 0) r += ",";
                Object val = Array.get(obj, i);
                if (cl.getComponentType().isPrimitive()) r += val;
                else r += toString(val);
            }
            return r + "}";
        }
        String r = cl.getName();
        do {
            r += "[";
            Field[] fields = cl.getDeclaredFields();
            // setAccessible为反射对象设置可访问标志
            AccessibleObject.setAccessible(fields, true);
            for (Field f :
                    fields) {
                if (!Modifier.isStatic(f.getModifiers())) {
                    if (!r.endsWith("[")) r += ",";
                    r += f.getName() + "=";
                    try {
                        Class t = f.getType();
                        Object val = f.get(obj);
                        if (t.isPrimitive()) r += val;
                        else r += toString(val);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            r += "]";
            cl = cl.getSuperclass();
        } while (cl != null);
        return r;
    }
}

/**
 * 使用反射编写泛型数组
 */
class CopyOfTest {
    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        a = (int[]) goodCopyOf(a, 10);
        System.out.println(Arrays.toString(a));
        String[] b = {"Tom", "Dick", "Harry"};
        b = (String[]) goodCopyOf(b, 10);
        System.out.println(Arrays.toString(b));
        System.out.println("The following call will generate an exception.");
//        b = (String[]) badCopyOf(b, 10);
    }

    public static Object[] badCopyOf(Object[] a, int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(a, 0, newArray, 0, Math.min(a.length, newLength));
        return newArray;
    }

    public static Object goodCopyOf(Object a, int newLength) {
        Class cl = a.getClass();
        if (!cl.isArray()) return null;
        Class componentType = cl.getComponentType();
        int length = Array.getLength(a);
        // newInstance返回一个由给定类型、给定维数的新数组
        Object newArray = Array.newInstance(componentType, newLength);
        System.arraycopy(a, 0, newArray, 0, Math.min(length, newLength));
        return newArray;
    }
}

/**
 * 调用任意方法
 */
class MethodTableTest{
    public static void main(String[] args) throws Exception {
        Method square = MethodTableTest.class.getMethod("square", double.class);
        Method sqrt = Math.class.getMethod("sqrt", double.class);
        printTable(1, 10, 10, square);
        printTable(1, 10, 10,sqrt);
    }

    public static double square(double x){
        return x * x;
    }

    public static void printTable(double from, double to, int n, Method f){
        System.out.println(f);
        double dx = (to -from) / (n -1);
        for (double i = from; i <= 10; i+=dx) {
            try{
                // invoke返回方法的返回值， null作为隐式参数传递
                // 在使用包装器传递基本类型的值时，基本累心过的返回值必须时包装的
                double y = (Double) f.invoke(null, i);
                System.out.printf("%10.4f | %10.4f%n", i, y);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}