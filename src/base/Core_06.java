package base;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;
import java.util.logging.*;

/*
 * 异常、断言和日志
 * */
public class Core_06 {
//    private static Logger logger = Logger.getLogger("com.Core_06");

    public static void main(String[] args) {
//        Logger.getGlobal().info("File->Open menu item selected");
//        Logger.getGlobal().setLevel(Level.OFF);

        // 日志说明书的最常用操作：
        // 1）为一个简单的应用程序，选择一个日志记录器，并把日志记录命名为于主应用程序包一样的名字
        // 为了方便起见，可能希望利用一些日志操作将下面的静态域添加到类中
        // Logger logger = Logger.getLogger("com.Core_06");
        // private static Logger logger = Logger.getLogger("com.Core_06");
        // 2）默认的日志配置级别等于或高于INFO级别的所有消息记录到控制台
        // if (System.getProperty("java.util.logging.config.class") == null
        //         && System.getProperty("java.util.logging.config.file") == null) {
        //     try {
        //         // 3）将程序员想要的日志记录，设定为FINE时一个很好的选择
        //         Logger.getLogger("").setLevel(Level.ALL);
        //         final int LOG_ROTATION_COUNT = 10;
        //         Handler handler = new FileHandler("%h/myapp.log", 0, LOG_ROTATION_COUNT);
        //         Logger.getLogger("").addHandler(handler);
        //     } catch (IOException e) {
        //         logger.log(Level.SEVERE, "Can't create log file handler", e);
        //     }
        // }

    }
}

/*
 * 可能的错误和问题：
 * 1.用户输入错误
 * 2.设备错误
 * 3.物理限制
 * 4.代码错误
 *
 * 所有的异常都是由Throwable继承而来，下一层分解为两个分支：Error和Exception
 * Error类层次结构描述了Java运行时系统的内部错误和资源耗尽错误
 * Exception又分解为两个分支：一个分支派生于RuntimeException，另一个分支IOException
 * RuntimeException表示程序错误导致的异常，IOException表示其他异常
 * RuntimeException包含：错误的类型转换、数组访问越界、访问null指针
 * 不是派生于RuntimeException的异常包括：试图在文件尾部后面读取数据、试图打开一个不存在的文件、试图根据给定的字符串查找不存在的Class对象
 * Java语言规范将派生于Error类或RuntimeException类的所有异常称为非受查（unchecked）异常
 *
 * 异常捕获：
 * try...catch...finally...
 * */
class StackTraceTest {
    public static int factorial(int n) {
        System.out.println("factorial(" + n + "):");
        Throwable t = new Throwable();
        // getStackTrace获得构造这个对象时调用堆栈的跟踪
        StackTraceElement[] frames = t.getStackTrace();
        for (StackTraceElement f :
                frames) {
            System.out.println(f);
        }
        int r;
        if (n <= 1) r = 1;
        else r = n * factorial(n - 1);
        System.out.println("return " + r);
        return r;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter n:");
        int n = in.nextInt();
        factorial(n);
    }
}

/*
 * 断言
 * assert 条件;
 * assert 条件 : 表达式;
 *
 * 3种处理系统错误的机制：抛出一个异常、日志、使用断言
 *
 * 记录日志
 * 7个日志记录器级别：SEVERE WARNING INFO CONFIG FINE FINER FINEST
 * logger.warning(message);  记录日志
 * logger.fine(message);
 * logger.log(Level.FINE, message);  使用log方法指定级别
 * */
class LoggingImageViewer {
    public static void main(String[] args) {
        if (System.getProperty("java.util.logging.config.class") == null
        && System.getProperty("java.util.logging.config.file") == null){
            try {
                Logger.getLogger("com.base.corejava").setLevel(Level.ALL);
                final int LOG_ROTATION_COUNT = 10;
                Handler handler = new FileHandler("%h/loggingImageViewer.log", 0, LOG_ROTATION_COUNT);
                Logger.getLogger("com.base.corejava").addHandler(handler);
            }catch (IOException e){
                Logger.getLogger("com.base.corejava").log(Level.SEVERE, "Can't create log file handler", e);
            }
        }
        EventQueue.invokeLater(() -> {
            Handler windowHandler = new WindowHandler();
            windowHandler.setLevel(Level.ALL);
            Logger.getLogger("com.base.corejava").addHandler(windowHandler);
            JFrame frame = new ImageViewerFrame();
            frame.setTitle("LoggingImageViewer");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Logger.getLogger("com.base.corejava").fine("showing frame");
            frame.setVisible(true);
        });
    }
}

class ImageViewerFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 400;
    private JLabel label;
    private static Logger logger = Logger.getLogger("com.base.corejava");

    public ImageViewerFrame() {
        logger.entering("ImageViewerFrame", "<init>");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu menu = new JMenu("File");
        menuBar.add(menu);
        JMenuItem openItem = new JMenuItem("Open");
        menu.add(openItem);
        openItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logger.fine("Exiting.");
                System.exit(0);
            }
        });
        label = new JLabel();
        add(label);
        logger.exiting("ImageViewerFrame", "<init>");
    }

    private class FileOpenListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            logger.entering("ImageViewerFrame.FileOpenListener", "actionPerformed", e);
            JFileChooser chooser = new JFileChooser();
            chooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
                @Override
                public boolean accept(File f) {
                    return f.getName().toLowerCase().endsWith(".gif") || f.isDirectory();
                }

                @Override
                public String getDescription() {
                    return "GIF Images";
                }
            });
            int r = chooser.showOpenDialog(ImageViewerFrame.this);
            if (r == JFileChooser.APPROVE_OPTION) {
                String name = chooser.getSelectedFile().getPath();
                logger.log(Level.FINE, "Reading file {0}", name);
                label.setIcon(new ImageIcon(name));
            } else logger.fine("File open dialog canceled.");
            logger.exiting("ImageViewerFrame.FileOpenListener", "actionPerformed");
        }
    }
}

class WindowHandler extends StreamHandler {
    private JFrame frame;

    public WindowHandler() {
        frame = new JFrame();
        final JTextArea output = new JTextArea();
        output.setEditable(false);
        frame.setSize(200, 200);
        frame.add(new JScrollPane(output));
        frame.setFocusableWindowState(false);
        frame.setVisible(true);
        setOutputStream(new OutputStream() {
            @Override
            public void write(int b) throws IOException {

            }

            public void write(byte[] b, int off, int len) {
                output.append(new String(b, off, len));
            }
        });
    }
    public void publish(LogRecord record){
        if (!frame.isVisible()) return;
        super.publish(record);
        flush();
    }
}