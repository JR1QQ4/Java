package base;
/**
 * Java的基本程序设计
 */

import static java.lang.Math.*;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

enum Color {
    RED, GREEN, BLUE;
}

/**
 * @author 东夋壬 Java的基本程序设计结构
 */
public class Core_01 {
    // class 类名是以大写字母开头的名词，采用“骆驼命名法”
    // 类名和文件名必须相同

    enum Size {
        SMALL, MEDIUM, LARGE, EXRTA_LATGE;
    }

    public static void main(String[] args) {
        // 运行已编译的程序时调用java ClassName，从指定类中的main方法开始执行
        // 在类的源文件中必须包含一个main方法
        // main必须声明为public static
        // static表示静态成员函数，这类成员函数定义在类的内部，并且不对对象进行操作
        // void表示这个方法没有返回值，正常退出时退出代码为0，可调用System.exit方法修改
        // Java与C/C++一样，都采用双引号分隔字符串

        // 快捷键：atl + /，syso， sysout， main
//		System.out.println("We will not use 'Hello, World!'");

        // 数据类型：
        // 整型：
        // int 4字节
        // short 2字节
        // long 8字节，右后缀L或l
        // byte 1字节
        // 0b或0B表示二进制数，0x或0X表示十六进制
        // Java没有任何无符号形式的int、long、short或byte类型
        // 浮点类型：
        // float 4字节，有一个后缀F或f
        // double 8字节
        // 所有浮点数计算都遵循IEEE754规范，正无穷大、负无穷大、NaN表示溢出和出错情况
        // Double.POSITIVE_INFINITY，Double.NEGATIVE_INFINITY，Double.NaN
        // char类型：
        // 原本用于表示单个字符，现在有些Unicode字符可以用一个char值描述，另外一些Unicode需要两个char值
        // ‘A’对应65
        // char类型可以表示为十六进制值，范围 \u0000 ~ Uffff
        // 转义字符的转义序列：\b(0008) \n(000a) \t(0009) \r(000d) \"(0022) \'(0027) \\(005c)
        // JavaSE 5.0开始，码点(code point)指与一个编码表中的某个字符对应的代码值
        // Unicode的码点右17个代码级别(code plane)，U+0000到U+10FFFF
        // UTF-16编码采用不同长度的编码表示所有Unicode码点，每个字符用16位表示，被称为代码单元(code unit)
        // 在Java中，char类型描述了UTF-16编码中的一个代码单元
        // boolean类型：true和false
        // if(x = 0)，C++总是能运行其结果为false，Java中这个测试不能通过编译，因为整数表达式不能转换为布尔值

        // 变量：在Java中。每个变量都是一个类型（type）
        // 变量名必须时一个以字母开头并由字母或数字构成的序列，字母包括A-Za-z_$或unicode字符
        // 想要知道那些Unicode字符属于Java中的字母，可以使用Character类中的isJavaIdentifierStart和isJavaIdentifierPart检查
        // double salary; int vacationDays; long earthPopulation; boolean done;
        // 在Java中不区分变量的声明与定义
        // final，指示常量，变量只能被赋值一次，习惯上常量名使用全大写
        // static final设置一个类常量，如果被声明为public，那么其他类的方法也可以使用这个常量

        // 运算符：
        // +、-、*、/(两个整数相除为整数，否则为浮点数)
        // %（取模）
        // 整数被0除会产生一个异常，浮点数被0除会得到无穷大或NaN
        // public static strictfp void main(String[] args)中的所有指令都将使用严格的浮点计算
        // 数学函数与常量：Math.sqrt()、Math.pow(x,a)、Math.PI、Math.E
        // condition ? expression1 : expression2;
//		System.out.println(sqrt(PI));
//		int n = 123456789;
//		float f = n;
//		System.out.println(f);  // 1.23456792E8
//		double x = 9.997;
//		int nx = (int)x;
//		System.out.println(nx);  // 9
        // 枚举类型：声明可以在类外声明；也可能声明在类中，但需要在main外
//		Size s = Size.MEDIUM;
//		System.out.println(s);
//		Color c1 = Color.RED;
//      System.out.println(c1);

        // 字符串
        // 不可变字符串
        // 以定不要使用 == 运算符检测两个字符串是否相等
//		String greeting = "Hello";
//		System.out.println(greeting);
//		System.out.println(greeting.substring(0, 3));  // Hel
//		System.out.println("Expletive" + " deleted " + 13);  // Expletive deleted 13
//		System.out.println("Hello".equals(greeting));  // true
//		System.out.println("Hello".equalsIgnoreCase("hello"));  // true
//		System.out.println(greeting.codePointCount(0, greeting.length()));  // 5


        // 输入输出
        // 格式化输出
//		Scanner in = new Scanner(System.in);
//		System.out.print("What is your name?");
//		System.out.println(in);
        // 文件输入与输出
//		Scanner in = new Scanner(Paths.get("filename.txt"), "UTF-8");


        // 控制流程
        // 块作用域
        // 条件语句
        // 循环
        // switch语句
        // continue break
        // for each：for (variable: collection) statement

        // 数组
//        int[] anonymous = {17, 19, 23, 29, 32, 37};
//        int[] copiedLuckyNumbers = Arrays.copyOf(anonymous, 2 * anonymous.length);
//        for (int a :
//                copiedLuckyNumbers) {
//            System.out.println(a);
//        }

        // 命令行参数
//        if (args.length == 0 || args[0].equals("-h"))
//            System.out.println("Hello,");
//        else if (args[0].equals("-g"))
//            System.out.println("Goodbye,");
//        for (int i = 0; i < args.length ; i++)
//            System.out.println(" " + args[i]);
//        System.out.println("!");

//        Scanner in = new Scanner(System.in);
//        System.out.println("How many numbers do you need to draw? ");
//        int k = in.nextInt();
//        System.out.println("What is the highest number you can draw? ");
//        int n = in.nextInt();
//        int[] numbers = new int[n];
//        for (int i = 0; i < numbers.length; i++) {
//            numbers[i] = i + 1;
//        }
//        int[] result = new int[k];
//        for (int i = 0; i < result.length; i++) {
//            int r = (int) (Math.random() * n);
//            result[i] = numbers[r];
//            numbers[r] = numbers[n - 1];
//            n--;
//        }
//        Arrays.sort(result);
//        System.out.println("Bet the following combination. I'll amke you rich!");
//        for (int r :
//                result) {
//            System.out.println(r);
//        }

        // 多维数组
//        int[][] magicSquare = {
//                {16, 3, 2, 13},
//                {5, 10, 11, 8},
//                {3, 7, 2, 12},
//                {4, 15, 14, 1}
//        };
//        for (int[] row :
//                magicSquare) {
//            for (int a :
//                    row) {
//                System.out.println(a);
//            }
//        }
//        System.out.println(Arrays.deepToString(magicSquare));
//        System.out.println(Arrays.toString(magicSquare));

//        final double STARTRATE = 10;
//        final int NRATES = 6;
//        final int NYEARS = 10;
//        double[] interestRate = new double[NRATES];
//        for (int i = 0; i < interestRate.length; i++) {
//            interestRate[i] = (STARTRATE + i) / 100.0;
//        }
//        double[][] banlances = new double[NYEARS][NRATES];
//        for (int i = 0; i < banlances[0].length; i++) {
//            banlances[0][i] = 10000;
//        }
//        for (int i = 1; i < banlances.length; i++) {
//            for (int j = 0; j < banlances[i].length; j++) {
//                double oldBanlance = banlances[i - 1][j];
//                double interest = oldBanlance + interestRate[j];
//                banlances[i][j] = oldBanlance + interest;
//            }
//        }
//        for (int i = 0; i < interestRate.length; i++) {
//            System.out.printf("%9.0f%%", 100 * interestRate[i]);
//        }
//        System.out.println("\n" + Arrays.toString(interestRate));
//        for (double[] row :
//                banlances) {
//            for (double b :
//                    row) {
//                System.out.printf("%10.2f", b);
//            }
//            System.out.println();
//        }

//        final int NMAX = 10;
//        int[][] odds = new int[NMAX + 1][];
//        for (int i = 0; i <= NMAX; i++) {
//            odds[i] = new int[i + 1];
//        }
//        for (int i = 0; i < odds.length; i++) {
//            for (int j = 0; j < odds[i].length; j++) {
//                int lotteryOdds = 1;
//                for (int k = 1; k <= j; k++) {
//                    lotteryOdds = lotteryOdds * (i - k + 1) /k;
//                }
//                odds[i][j] = lotteryOdds;
//            }
//        }
//        for (int[] row :
//                odds) {
//            for (int odd :
//                    row) {
//                System.out.printf("%4d", odd);
//            }
//            System.out.println();
//        }
    }
}
