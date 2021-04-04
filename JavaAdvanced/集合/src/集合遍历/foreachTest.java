package 集合遍历;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/*
   用于遍历集合 数组
 */
public class foreachTest {
    @Test
    public void test1() {
        Collection collection = new ArrayList();
        collection.add(123);
        collection.add(345);
        collection.add(3);
        collection.add(5);
        collection.add(35);
        collection.add(new String("new String"));
//        for （集合元素的类型  局部变量 ： 集合对象）
        for(Object obj: collection){
            System.out.println(obj);
        }
    }

    @Test
    public void test2(){
        int [] arr = new int[]{1,2,3,4,5,6,7,8,0};
//        for （数组元素的类型  局部变量 ： 数组对象）
        for (int i : arr){
            System.out.print(i+" ");
        }
    }
}
