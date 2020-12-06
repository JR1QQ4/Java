package mytest;

//import static org.junit.Assert.*;  // 导入Assert类的所有静态方法

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TriangleTest {
    @Test
    public void test() {
        assertEquals(false, new Triangle().judgeEdges(1, 2, 3));
//        Assert.assertEquals(false, new Triangle().judgeEdges(2, 2, 3));
    }
}
