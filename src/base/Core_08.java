package base;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * 集合
 */
public class Core_08 {
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
class LinkedListTest{
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
        while (bIter.hasNext()){
            if (aIter.hasNext()) aIter.next();
            aIter.add(bIter.next());
        }
        System.out.println(a);
        bIter = b.iterator();
        while (bIter.hasNext()){
            bIter.next();
            if (bIter.hasNext()){
                bIter.next();
                bIter.remove();
            }
        }
        System.out.println(b);
        a.removeAll(b);
        System.out.println(a);
    }
}