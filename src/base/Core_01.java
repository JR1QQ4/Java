package base;

import static java.lang.Math.*;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

enum Color {
	RED, GREEN, BLUE;
}

/**
 * @author ������ Java�Ļ���������ƽṹ
 */
public class Core_01 {
	// class �������Դ�д��ĸ��ͷ�����ʣ����á�������������
	// �������ļ���������ͬ

	enum Size {
		SMALL, MEDIUM, LARGE, EXRTA_LATGE;
	}

	public static void main(String[] args) {
		// �����ѱ���ĳ���ʱ����java ClassName����ָ�����е�main������ʼִ��
		// �����Դ�ļ��б������һ��main����
		// main��������Ϊpublic static
		// static��ʾ��̬��Ա�����������Ա��������������ڲ������Ҳ��Զ�����в���
		// void��ʾ�������û�з���ֵ�������˳�ʱ�˳�����Ϊ0���ɵ���System.exit�����޸�
		// Java��C/C++һ����������˫���ŷָ��ַ���
		
		// ��ݼ���atl + /��syso�� sysout�� main
//		System.out.println("We will not use 'Hello, World!'");

		// �������ͣ�
		// ���ͣ�
		// int 4�ֽ�
		// short 2�ֽ�
		// long 8�ֽڣ��Һ�׺L��l
		// byte 1�ֽ�
		// 0b��0B��ʾ����������0x��0X��ʾʮ������
		// Javaû���κ��޷�����ʽ��int��long��short��byte����
		// �������ͣ�
		// float 4�ֽڣ���һ����׺F��f
		// double 8�ֽ�
		// ���и��������㶼��ѭIEEE754�淶��������󡢸������NaN��ʾ����ͳ������
		// Double.POSITIVE_INFINITY��Double.NEGATIVE_INFINITY��Double.NaN
		// char���ͣ�
		// ԭ�����ڱ�ʾ�����ַ���������ЩUnicode�ַ�������һ��charֵ����������һЩUnicode��Ҫ����charֵ
		// ��A����Ӧ65
		// char���Ϳ��Ա�ʾΪʮ������ֵ����Χ \u0000 ~ Uffff
		// ת���ַ���ת�����У�\b(0008) \n(000a) \t(0009) \r(000d) \"(0022) \'(0027) \\(005c)
		// JavaSE 5.0��ʼ�����(code point)ָ��һ��������е�ĳ���ַ���Ӧ�Ĵ���ֵ
		// Unicode�������17�����뼶��(code plane)��U+0000��U+10FFFF
		// UTF-16������ò�ͬ���ȵı����ʾ����Unicode��㣬ÿ���ַ���16λ��ʾ������Ϊ���뵥Ԫ(code unit)
		// ��Java�У�char����������UTF-16�����е�һ�����뵥Ԫ
		// boolean���ͣ�true��false
		// if(x = 0)��C++��������������Ϊfalse��Java��������Բ���ͨ�����룬��Ϊ�������ʽ����ת��Ϊ����ֵ

		// ��������Java�С�ÿ����������һ�����ͣ�type��
		// ����������ʱһ������ĸ��ͷ������ĸ�����ֹ��ɵ����У���ĸ����A-Za-z_$��unicode�ַ�
		// ��Ҫ֪����ЩUnicode�ַ�����Java�е���ĸ������ʹ��Character���е�isJavaIdentifierStart��isJavaIdentifierPart���
		// double salary; int vacationDays; long earthPopulation; boolean done;
		// ��Java�в����ֱ����������붨��
		// final��ָʾ����������ֻ�ܱ���ֵһ�Σ�ϰ���ϳ�����ʹ��ȫ��д
		// static final����һ���ೣ�������������Ϊpublic����ô������ķ���Ҳ����ʹ���������

		// �������
		// +��-��*��/(�����������Ϊ����������Ϊ������)
		// %��ȡģ��
		// ������0�������һ���쳣����������0����õ�������NaN
		// public static strictfp void main(String[] args)�е�����ָ���ʹ���ϸ�ĸ������
		// ��ѧ�����볣����Math.sqrt()��Math.pow(x,a)��Math.PI��Math.E
		// condition ? expression1 : expression2;
//		System.out.println(sqrt(PI));
//		int n = 123456789;
//		float f = n;
//		System.out.println(f);  // 1.23456792E8
//		double x = 9.997;
//		int nx = (int)x;
//		System.out.println(nx);  // 9
		// ö�����ͣ���������������������Ҳ�������������У�����Ҫ��main��
//		Size s = Size.MEDIUM;
//		System.out.println(s);
//		Color c1 = Color.RED;
//      System.out.println(c1);

		// �ַ���
			// ���ɱ��ַ���
			// �Զ���Ҫʹ�� == �������������ַ����Ƿ����
//		String greeting = "Hello";
//		System.out.println(greeting);
//		System.out.println(greeting.substring(0, 3));  // Hel
//		System.out.println("Expletive" + " deleted " + 13);  // Expletive deleted 13
//		System.out.println("Hello".equals(greeting));  // true
//		System.out.println("Hello".equalsIgnoreCase("hello"));  // true
//		System.out.println(greeting.codePointCount(0, greeting.length()));  // 5
		
		
		// �������
			// ��ʽ�����
//		Scanner in = new Scanner(System.in);
//		System.out.print("What is your name?");
//		System.out.println(in);
			// �ļ����������
//		Scanner in = new Scanner(Paths.get("filename.txt"), "UTF-8");
		
		
		// ��������
			// ��������
			// �������
			// ѭ��
			// switch���
			// continue break
			// for each��for (variable: collection) statement
		
		// ����ֵ
		
		// ��������
		int[] a = new int[1000];
		Arrays.sort(a);
		System.out.println(a);  // [I@2503dbd3
			
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
