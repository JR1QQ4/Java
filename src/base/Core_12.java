package base;

import java.io.*;
import java.nio.file.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

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

/**
 * 文本文件读写
 */
class TestFileWrite {
    public static void main(String[] args) {
//        writeFile1();
//        System.out.println("==========================");
//        writeFile2();

        readFile1();
        System.out.println("****************************");
        readFile2();
    }

    public static void writeFile1() {
        FileOutputStream fos = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;
        try {
            fos = new FileOutputStream("c:/a_temp/abc.txt");  // 节点类，负责写字节
            osw = new OutputStreamWriter(fos, "UTF-8");  // 转化类，负责字符到字节转化
            bw = new BufferedWriter(osw);  // 装饰类，负责字符到缓存区
//            bw = new BufferedWriter(new OutputStreamWriter(
//                    new FileOutputStream("c:/a_temp/abc.txt")));
            bw.write("我们是");
            bw.newLine();
            bw.write("Ecnuers.^0^");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();  // 关闭最后一个类，会将所有的底层流都关闭
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void writeFile2() {
        // try resource
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("c:/a_temp/abc.txt")))) {
            bw.write("Hello, world!");
            bw.newLine();
            bw.write("Java.");
            bw.newLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void readFile1() {
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
            fis = new FileInputStream("c:/a_temp/abc.txt");  // 节点类
            isr = new InputStreamReader(fis, "UTF-8");  // 转化类
            br = new BufferedReader(isr);  // 装饰类
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void readFile2() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream("c:/a_temp/abc.txt")))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/**
 * 二进制文件读写
 */
class BinFileWrite {
    public static void main(String[] args) {
        writeFile();
        System.out.println("======================");
        readFile();
    }

    public static void writeFile() {
        FileOutputStream fos = null;
        DataOutputStream dos = null;
        BufferedOutputStream bos = null;
        try {
            fos = new FileOutputStream("c:/a_temp/def.dat");  // 节点类
            bos = new BufferedOutputStream(fos);  // 装饰类
            dos = new DataOutputStream(bos);  // 装饰类
            dos.writeUTF("窗外下着雨");
            dos.writeInt(20);
            dos.writeInt(100);
            dos.writeUTF("\r\n");
            dos.writeUTF("b");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                dos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void readFile() {
        try (DataInputStream dis = new DataInputStream(new BufferedInputStream(
                new FileInputStream("c:/a_temp/def.dat")))) {
            String a, b, c;
            int d, e;
            a = dis.readUTF();
            d = dis.readInt();
            e = dis.readInt();
            b = dis.readUTF();
            c = dis.readUTF();
            System.out.println("a: " + a);
            System.out.println("b: " + b);
            System.out.println("c: " + c);
            System.out.println("d: " + d);
            System.out.println("e: " + e);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/**
 * 单个文件压缩
 */
class SingleFileZip {
    public static void main(String[] args) throws Exception {
        File file = new File("c:/a_temp/abc.txt");  // 要压缩的文件
        File zipFile = new File("c:/a_temp/single2.zip");  // 压缩文件

        InputStream is = new FileInputStream(file);  // 文件输入流
        ZipOutputStream zos = null;  // 压缩流
        zos = new ZipOutputStream(new FileOutputStream(zipFile));
        zos.putNextEntry(new ZipEntry(file.getName()));  // 设置ZipEntry对象
        zos.setComment("single file zip");  // 设置注释

        // 压缩过程
        int temp = 0;
        while ((temp = is.read()) != -1) {  // 读取内容
            zos.write(temp);  // 压缩输出
        }
        is.close();
        zos.close();

        System.out.println("single file zip done.");
    }
}

/**
 * 多个文件压缩，文件夹压缩
 */
class MultipleFileZip {
    public static void main(String[] args) throws Exception {
        File file = new File("c:/a_temp/test");  // 要压缩的文件夹
        File zipFile = new File("c:/a_temp/multiple.zip");  // 压缩文件

        InputStream is = null;  // 文件输入流
        ZipOutputStream zos = null;  // 压缩流对象
        zos = new ZipOutputStream(new FileOutputStream(zipFile));
        zos.setComment("multiple file zip");  // 设置注释

        // 开始压缩
        int temp = 0;
        if (file.isDirectory()) {  // 判断是否是文件夹
            File[] lists = file.listFiles();  // 列出全部子文件
            for (int i = 0; i < lists.length; i++) {
                is = new FileInputStream(lists[i]);  // 文件输入流
                zos.putNextEntry(new ZipEntry(file.getName()
                        + File.separator + lists[i].getName()));  // 设置ZipEntry对象
                System.out.println("正在压缩 " + lists[i].getName());
                while ((temp = is.read()) != -1) {  // 读取内容
                    zos.write(temp);  // 压缩输出
                }
                is.close();  // 关闭输入流
            }
        }
        zos.close();  // 关闭输出流

        System.out.println("multiple file zip done.");
    }
}

/**
 * 单个文件解压
 */
class SingleFileUnzip {
    public static void main(String[] args) throws Exception {
        File zipFile = new File("c:/a_temp/single2.zip");  // 压缩文件
        ZipInputStream input = null;  // 压缩输入流
        input = new ZipInputStream(new FileInputStream(zipFile));  //实例化
        ZipEntry entry = input.getNextEntry();  // 得到一个压缩实体
        System.out.println("压缩实体名称：" + entry.getName());

        // 新建目标文件，需要从目标文件打开输入流，数据从java流入
        File outFile = new File("c:/a_temp/" + "new_" + entry.getName());
        OutputStream out = new FileOutputStream(outFile);
        int temp = 0;
        while ((temp = input.read()) != -1) {
            out.write(temp);
        }
        input.close();
        out.close();
        System.out.println("unzip done.");
    }
}

/**
 * 多个文件解压
 */
class MultipleFileUnzip {
    public static void main(String[] args) throws Exception {
        File file = new File("c:/a_temp/multiple.zip");  // 压缩文件
        File outFile = null;  // 输出文件的时候要有的文件夹的操作
        ZipFile zipFile = new ZipFile(file);  // 实例化
        ZipInputStream zipInput = null;  // 压缩输入流

        // 定义解压的文件名
        OutputStream out = null;  // 输出流，用于输出每个实体内容
        InputStream input = null;  // 定义输入流，读取一个ZipEntry
        ZipEntry entry = null;  // 每个压缩实体
        zipInput = new ZipInputStream(new FileInputStream(file));  // 实例化

        // 遍历压缩包中的文件
        while ((entry = zipInput.getNextEntry()) != null) {  // 得到一个压缩实体
            System.out.println("解压 " + entry.getName() + " 文件");
            outFile = new File("c:/a_temp/" + "new" + entry.getName());  // 输出的文件路径
            if (!outFile.getParentFile().exists()) {  // 如果输出文件夹不存在
                outFile.getParentFile().mkdirs();  // 创建文件夹，如果这里的有多级文件夹不存在，使用mkdirs
            }
            if (!outFile.exists()) {  // 输出文件是否存在
                if (entry.isDirectory()){
                    outFile.mkdirs();
                    System.out.println("create directory...");
                }else {
                    outFile.createNewFile();  // 创建文件
                    System.out.println("create file...");
                }
            }
            if (!entry.isDirectory()) {
                input = zipFile.getInputStream(entry);  // 得到每一个实体的输入流
                out = new FileOutputStream(outFile);  // 实例化文件输出流
                int temp = 0;
                while ((temp=input.read())!=-1){
                    out.write(temp);
                }
                input.close();  // 关闭输入流
                out.close();  // 关闭输出流
            }
        }
        input.close();
    }
}