package List;
/*
 |----Collection接口: 单列集合，用来存储一一个一个的对象
        |----List接口: 存储有序的、可重复的数据。
            |----ArrayList: 作list接口的主要实现类;线程不安全的,效率高;底层使用0bject
            |----LinkedList: 对于頻繁的插入、刪除操作，使用此类效率比ArrayList高; 底层使用
            |----Vector:作为list接口的古老实现类;线程安全的，效率低;底居使用object[]
 */


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
void add(int index, object ele):在index位置插入eLe元素
boolean addALL(int index, Collection eles): Mindex位置开始将eLes中的所有元素添加进来
object get(int index):获取指定index位置的元素
int index0f(Object obj):返回obj在集合中首次出现的位置
int LastIndexOf(Object obj):返回obj在当前集合中末次出现的位置
0bject remove(int index):移除指定index位置的元素，并返回此元素
object set(int index, object eLe):设置指定index位置的元素为eLe
List sublist(int fromIndex, int toIndex):返回从fromIndex到toIndex位置的子集合
 */
public class ListTest {
    @Test
    public void test1(){
        ArrayList arrayList = new ArrayList();
        arrayList.add(12);
        arrayList.add(123);
        arrayList.add(13);
        arrayList.add(42);
        arrayList.add(15);

        System.out.println(arrayList);

        arrayList.add(1,"vv");
        System.out.println(arrayList);
//      void add(int index, object ele):在index位置插入eLe元素
        List list = Arrays.asList(1, 2, 3);
//        arrayList.add(list);    //  [12, vv, 123, 13, 42, 15, [1, 2, 3]]
//        boolean addALL(int index, Collection eles): Mindex位置开始将eLes中的所有元素添加进来
        arrayList.addAll(list);     //  [12, vv, 123, 13, 42, 15, 1, 2, 3]
//        object get(int index):获取指定index位置的元素
        System.out.println(arrayList.get(1));    // vv
//        int index0f(Object obj):返回obj在集合中首次出现的位置
        System.out.println(arrayList.indexOf("vv"));    // 1
//        int LastIndexOf(Object obj):返回obj在当前集合中末次出现的位置
//        0bject remove(int index):移除指定index位置的元素，并返回此元素
//        object set(int index, object eLe):设置指定index位置的元素为eLe
//        List sublist(int fromIndex, int toIndex):返回从fromIndex到toIndex位置的子集合
    }


}
