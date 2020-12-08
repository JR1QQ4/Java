package base;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.SortedMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 国际化&文本处理
 */
public class Core_17 {
}

/**
 * 字符编码
 */
class CharsetTest {
    public static void main(String[] args) {
        // 默认字符集
        Charset c = Charset.defaultCharset();
        System.out.println(c.name());

        // 输出所有的支持字符集
        SortedMap<String, Charset> sc = Charset.availableCharsets();
        Set<String> keysets = sc.keySet();
        System.out.println("Java支持的所有字符集：");
        for (String s :
                keysets) {
            System.out.println(s);
        }
    }
}

/**
 * 国际化
 */
class NewHelloWorld {
    public static void main(String[] args) {
        // 获取系统默认的国家/语言环境
        Locale myLocale = Locale.getDefault();
        System.out.println(myLocale);

        // 根据指定语言_国家环境加载资源文件
        // 因为ResourceBundle的查找路径方法，会先找message_zh_CN，再找message
        ResourceBundle bundle = ResourceBundle.getBundle("data/message", myLocale);

        // 从资源文件中获取消息
        System.out.println(bundle.getString("hello"));

        // 强制换成其他国家，参数：语言 国家
        myLocale = new Locale("en", "US");
        bundle = ResourceBundle.getBundle("data/message", myLocale);
        System.out.println(bundle.getString("hello"));
    }
}

class MatcherDemo {
    private static final String REGEX = "\\bdog\\b";  // \b表示边界
    private static final String INPUT = "dog dog dog doggie dogg";

    public static void main(String[] args) {
        // 检查字符串里面有多少个dog
        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(INPUT);
        int count = 0;
        while (m.find()) {
            System.out.println("Matcher number: " + count);
            System.out.println("start(): " + m.start());
            System.out.println("end(): " + m.end());
        }
    }
}

class RegexDemo {
    private static final String REGEX = "a*b";
    private static final String INPUT = "aabfoosaabfooabfoobcdd";
    private static final String REPLACE = "-";

    public static void main(String[] args) {
        // 替换匹配的字符串
        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(INPUT);

        // 方法一：
//        StringBuffer sb = new StringBuffer();
//        // 全部替换
//        while (m.find()){
//            m.appendReplacement(sb, REPLACE);
//        }
//        // 将最后的尾巴字符串附加上，如果不添加此方法，后面没有被匹配的字符串将丢失
//        m.appendTail(sb);

        // 方法二：
        String sb = m.replaceAll(REPLACE);

        System.out.println("INPUT: " + INPUT);
        System.out.println("new StringBuffer: " + sb);
    }
}