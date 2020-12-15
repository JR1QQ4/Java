package base;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * 图形程序设计 swing
 * <p>
 * 事件处理 ActionEvent ActionListener WindowEvent
 * <p>
 * swing 用户界面组件
 */
public class Core_09 {
}

class ImageTest {
    public static void main(String[] args) throws Exception {
        readAndWrite();
    }

    public static void readAndWrite() throws Exception {
        BufferedImage image = ImageIO.read(new File("c:/temp/ecnu.jpg"));
        System.out.println("Height: " + image.getHeight());
        System.out.println("Width: " + image.getWidth());
        ImageIO.write(image, "png", new File("c:/temp/ecnu.png"));
    }

    public static void readComparison() throws Exception {

    }
}
