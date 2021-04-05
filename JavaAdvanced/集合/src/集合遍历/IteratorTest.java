package 集合遍历;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
/*
    Iterator迭代器
 */
public class IteratorTest {
    @Test
    public void test1() {
        Collection collection = new ArrayList();
        collection.add(123);
        collection.add(345);
        collection.add(new String("new String"));

        Iterator iterator = collection.iterator();

//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());

//        推荐方式；
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
    @Test
    public void test2() {
        Collection collection = new ArrayList();
        collection.add("123");
        collection.add(345);
        collection.add(300);
        collection.add(377);
        collection.add(new String("new String"));
//          删除123
        Iterator iterator = collection.iterator();
        while(iterator.hasNext()){
            Object o = iterator.next();
            if("123".equals(o)){
                iterator.remove();
            }
        }

        Iterator iterator1 = collection.iterator();
        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
        }

    }
}