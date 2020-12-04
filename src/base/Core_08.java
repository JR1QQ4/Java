package base;

import java.util.*;

/**
 * 集合
 */
public class Core_08 {
    public static void main(String[] args) {

    }
}

/*
 * 集合有两个基本接口：Collection和Map
 * Collection中包括：List、Set、Queue
 * List 是一个有序集合，元素会增加到容器中的特定位置，可以用迭代器或整数索引访问元素
 * Set 接口等同于Collection接口，不过其方法的行尾有更严谨的定义，Set的add方法不允许增加重复的元素
 *
 * 队列（queue），在尾部添加元素，在头部删除元素
 * 链表（linked list），Java中所有链表实际上都是双向链接的，链表算是一个有序集合
 *
 * 散列集
 * 树集
 * 优先级队列
 * 映射
 * 栈
 * */
class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<Integer> a1 = new ArrayList<>();
        a1.add(3);
        a1.add(2);
        a1.add(1);
        a1.add(4);
        a1.add(5);
        a1.add(6);
        a1.add(new Integer(6));

        System.out.print("The third element is ");
        System.out.println(a1.get(2));
        a1.remove(3);  // 删除第四个元素，后面元素往前挪动
        a1.add(3, 9);  // 将9插入到第3个元素，后面元素往后挪动
        System.out.println(a1.toString());  // [3, 2, 1, 9, 5, 6, 6]

        System.out.println("======= 遍历方法 ========");
        ArrayList<Integer> as = new ArrayList<>(100000);
        for (int i = 0; i < 100000; i++) {
            as.add(i);
        }
        traverseByIterator(as);
        traverseByIndex(as);
        traverseByFor(as);
    }

    public static void traverseByIterator(ArrayList<Integer> a1) {
        long startTime = System.nanoTime();
        System.out.println("======= 迭代器遍历 ==========");
        Iterator<Integer> iter1 = a1.iterator();
        while (iter1.hasNext()) {
            iter1.next();
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println(duration + "纳秒");
    }

    public static void traverseByIndex(ArrayList<Integer> a1) {
        long startTime = System.nanoTime();
        System.out.println("======= 随机索引值遍历 ==========");
        for (int i = 0; i < a1.size(); i++) {
            a1.get(i);
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println(duration + "纳秒");
    }

    public static void traverseByFor(ArrayList<Integer> a1) {
        long startTime = System.nanoTime();
        System.out.println("======= Foreach遍历 ==========");
        for (Integer item :
                a1) {
            ;
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println(duration + "纳秒");
    }
}

class LinkedListTest {
    public static void main(String[] args) {
        List<String> a = new LinkedList<>();
        a.add("Amy");
        a.add("Carl");
        a.add("Erica");
        List<String> b = new LinkedList<>();
        b.add("Bob");
        b.add("Doug");
        b.add("Frances");
        b.add("Gloria");
        ListIterator<String> aIter = a.listIterator();
        Iterator<String> bIter = b.iterator();
        while (bIter.hasNext()) {
            if (aIter.hasNext()) aIter.next();
            aIter.add(bIter.next());
        }
        System.out.println(a);
        bIter = b.iterator();
        while (bIter.hasNext()) {
            bIter.next();
            if (bIter.hasNext()) {
                bIter.next();
                bIter.remove();
            }
        }
        System.out.println(b);
        a.removeAll(b);
        System.out.println(a);
    }
}

class VectorTest {
    public static void main(String[] args) {
        Vector<Integer> v = new Vector<>();
        v.add(1);
        v.add(2);
        v.add(3);
        System.out.println(v.toString());
        v.remove(2);
        v.add(1, 5);
        System.out.println(v.toString());

        // 有四种遍历方式：Iterator、索引位置、foreach、Enumeration
    }
}

class HashSetTest {
    public static void main(String[] args) {
        HashSet<Integer> hs = new HashSet<>();
        hs.add(null);
        hs.add(1000);
        hs.add(20);
        hs.add(3);
        hs.add(4000);
        hs.add(5000000);
        hs.add(3);
        hs.add(null);
        System.out.println(hs.toString());
        System.out.println(hs.size());  // 6
        if (!hs.contains(6)) {
            hs.add(6);
        }
        System.out.println(hs.size());
        hs.remove(4);
        System.out.println(hs.size());
//        hs.clear();
//        System.out.println(hs.size());

        System.out.println("======= foreach遍历 =========");
        for (Integer item :
                hs) {
            System.out.println(item);
        }

        System.out.println("========= 测试集合交集 ===========");
        HashSet<String> set1 = new HashSet<>();
        HashSet<String> set2 = new HashSet<>();
        set1.add("a");
        set1.add("b");
        set1.add("c");

        set2.add("c");
        set2.add("d");
        set2.add("e");

        // 交集
        set1.retainAll(set2);
        System.out.println("交集是：" + set1);  // c
        System.out.println(set1.toString());  // c
        System.out.println(set2.toString());  // c d e

        // 两种遍历方法：iterator、foreach
    }
}