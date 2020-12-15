package base;

import org.json.JSONArray;
import org.json.JSONObject;

import java.awt.print.Book;
import java.io.File;
import java.io.FileReader;
import java.nio.charset.Charset;
import java.util.*;
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

/**
 * 正则
 */
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

/**
 * JSON
 */
class NewPerson {
    private String name;
    private int age;
    private List<Integer> scores;

    public NewPerson() {
    }

    public NewPerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Integer> getScores() {
        return scores;
    }

    public void setScores(List<Integer> scores) {
        this.scores = scores;
    }
}

class JSONHandler {
    public static void main(String[] args) {
        testJsonObject();
        System.out.println("=========================");
    }

    public static void testJsonObject() {
        NewPerson p = new NewPerson();
        p.setName("Tom");
        p.setAge(20);
        p.setScores(Arrays.asList(60, 70, 80));

        // JSONObject来自org.json
        JSONObject obj = new JSONObject();
        obj.put("name", p.getName());
        obj.put("age", p.getAge());
        obj.put("scores", p.getScores());
        System.out.println(obj);
        System.out.println("name: " + obj.getString("name"));
        System.out.println("age: " + obj.getInt("age"));
        System.out.println("scores: " + obj.getJSONArray("scores"));
    }

//    public static void testJsonFile() {
//        File file = new File("src/data/books.json");
//        try(FileReader reader = new FileReader(file)){
//            int fileLen = (int)file.length();
//            char[] chars = new char[fileLen];
//            reader.read(chars);
//            String s = String.valueOf(chars);
//            JSONObject jsonObject = new JSONObject(s);
//
//            JSONArray books = jsonObject.getJSONArray("books");
//            List<Book> bookList = new ArrayList<>();
//            for (Object book :
//                    books) {
//                JSONObject bookObject = (JSONObject) book;
//                Book book1 = new Book();
//                book1.setAuthor(bookObject.getString("author"));
//                book1.setYear(bookObject.getString("year"));
//                book1.setTitle(bookObject.getString("title"));
//                book1.setPrice(bookObject.getString("price"));
//                book1.setCategory(bookObject.getString("category"));
//                bookList.add(book1);
//            }
//            for (Book book :
//                    bookList) {
//                System.out.println(book.getAuthor() + ", " + book.getTitle());
//            }
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
}