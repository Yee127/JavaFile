package set;

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
  |----Collection接口: 单列集合，用来存储一一个一个的对象
        |----List接口: 存储有序的、可重复的数据。-- >“
        |----Set接口: 存储无序的、不可重复的数据
            |----HashSet: 作为Set接口的主要实现类;线程不安全的;可以存储null值
                |----LinkedHashSet:作为HashSet的子类;遍历其内部数据时，可以按照添加的顺序遍历
            |----TreeSet: 可以按照添加对象的指定属性，进行排序。
 */

/*
    Set:存储无序的、不可重复的数据
    以HashSet为例：
    1.无序性:不等于随机性。存储的数据在底层数组中并非按照数组索引的顺序添加，而是根据数据的哈希值
    2.
    不可重复性:
 */


/*
    二、添加元素的过程:以HashSet 为例:
    我们向HashSet中添加元素a,首先调用元素a所在类的hashCode()方法，计算元素a的哈希值,
    此哈希值接着通过某种算法计算出在HashSet底层数组中的存放位置(即为:索引位置)，判断
    数组此位置上是否已经有元素:
        如果此位置上没有其他元素，则元素a添加成功。--->情况1 .
         如果此位置上有其他元素b(或以链表形式存在的多个元素)，则比较元素a与元素b的hash值:
            如果hash值不相同，则元素a添加成功。--->情况2
            如果hash值相同，进而需要调用元素a所在类的equals()方法:
                equals()返回true,元素a添加失败
                equals().返回false,则元素a添加成功。--->情况2
    对于添加成功的情况2和情况3而言:元素a与已经存在指定索引位置上数据以链表的方式存储。
    jdk 7 : 元素a放到数组中，指向原来的元素。
    jdk 8 : 原来的元素在数组中，指向元素a
    总结:七上八下
 */
public class setTest {
    @Test
    public void test1(){
        Set set = new HashSet();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        set.add(6);
        set.add("AA");
        set.add("AA");

        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }
    }
}
