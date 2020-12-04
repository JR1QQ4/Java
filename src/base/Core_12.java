package base;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

/**
 * 输入于输出
 * 可以从其中读入一个字节序列的对象称为输入流，而可以向其中写入一个字节序列的对象称为输入流
 * 抽象类 InputStream 和 OutputStream 构成了输入/输出（I/O）类层次结构的基础
 */
public class Core_12 {
}

class FileAttributeTest {
    public static void main(String[] args) {
        // 创建目录
        File d = new File("c:/a_temp");
        if (!d.exists()) {
            d.mkdirs();  // mkdir创建单级目录，mkdirs创建多级目录
        }
        System.out.println("Is d directory? " + d.isDirectory());

        // 创建文件
        File f = new File("c:/a_temp/abc.txt");
        if (!f.exists()) {
            try {
                f.createNewFile();  // 创建abc.txt
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Is f file? " + f.isFile());
        System.out.println("Name: " + f.getName());
        System.out.println("Parent: " + f.getParent());
        System.out.println("Path: " + f.getPath());
        System.out.println("Size: " + f.length() + " bytes");
        System.out.println("Last modified time: " + f.lastModified() + "ms");

        // 遍历d目录下所有的文件信息
        System.out.println("List files in d directory:");
        File[] fs = d.listFiles();
        for (File f1 :
                fs) {  // 只会循环一层
            System.out.println("\t" + f1.getPath());
        }

        f.delete();  // 删除文件
        d.delete();  // 删除目录
    }
}

class PathTest {
    public static void main(String[] args) {
        // Path和java.uo.File基本类树
        // 获得path方法一：getNameCount
        Path path = FileSystems.getDefault().getPath("c:/a_temp", "abc.txt");
        System.out.println(path.getNameCount());
        System.out.println(path.toString());

        // 获得path方法二：
        File file = new File("c:/a_temp/abc.txt");
        Path pathOther = file.toPath();
        System.out.println(path.compareTo(pathOther));
        System.out.println(pathOther.toString());

        // 获得path方法三：
        Path path3 = Paths.get("c:/a_temp", "abc.txt");
        System.out.println(path3.toString());

        // 合并两个path
        Path path4 = Paths.get("c:/a_temp");
        System.out.println("path4: " + path4.resolve("abc.txt"));

        if (Files.isReadable(path)) {
            System.err.println("It is readable.");
        } else {
            System.err.println("It is not readable.");
        }

    }
}

class FilesTest {
    public static void main(String[] args) {
        moveFile();
    }

    public static void moveFile() {
        Path from = Paths.get("c:/a_temp", "abc.txt");
        // 移动c:/a_temp/abc.txt到c:/a_temp/test/def.txt，如果目标文件已存在就替换
        Path to = from.getParent().resolve("test/def.txt");
        try {
            System.out.println(Files.size(from));
            // 调用文件移动方法，如果目标已经存在就替换
            Files.move(from, to, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.out.println("移动文件错误" + e.getMessage());
        }
    }
}

class TestFileWrite {

}
