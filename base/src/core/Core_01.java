package core;

/**
 * @author 东夋壬
 * Java的基本程序设计结构
 */
public class Core_01 {
	// class 类名是以大写字母开头的名词，采用“骆驼命名法”
	// 类名和文件名必须相同
	public static void main(String[] args) {
		// 运行已编译的程序时调用java ClassName，从指定类中的main方法开始执行
		// 在类的源文件中必须包含一个main方法
		// main必须声明为public static
		// static表示静态成员函数，这类成员函数定义在类的内部，并且不对对象进行操作
		// void表示这个方法没有返回值，正常退出时退出代码为0，可调用System.exit方法修改
		// Java与C/C++一样，都采用双引号分隔字符串
		System.out.println("We will not use 'Hello, World!'");
	}
}
