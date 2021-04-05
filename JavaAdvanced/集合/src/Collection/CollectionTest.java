package Collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class CollectionTest {
    @Test
    public void test1(){
        Collection collection = new ArrayList();
        collection.add(123);
        collection.add(345);
        collection.add(new String("new String"));
        collection.add(new Person("Tom",18));

//        1.contains(Object obj)  判断当前集合中是否包含obj
        System.out.println(collection.contains(new String("new String")));      //true
        System.out.println(collection.contains(new Person("Tom",18)));      //false
//        2.containsALL(Collection coll1) 判断形参coll1中所有元素是否都在当前集合中
        Collection coll1 = Arrays.asList(123);
        System.out.println(collection.containsAll(coll1));
    }

    @Test
    public void test2(){
//        3.remove(Object obj)
        Collection collection = new ArrayList();
        collection.add(123);
        collection.add(456);
        collection.add(789);
        collection.add(new String("new String"));
//        collection.add(new Person("Tom",18));
        boolean a = collection.remove(123);
        System.out.println(a);
        System.out.println(collection);
//        3.removeALL(Collection ccollection1)
        Collection collection1 = Arrays.asList(1,2,3,4,5);
        collection.removeAll(collection);
        System.out.println(collection);

    }
    @Test
    public void test3(){
        Collection collection = new ArrayList();
        collection.add(123);
        collection.add(456);
        collection.add(789);
        collection.add(new String("new String"));

//        retainALL(Collection ccollection1)  交集
//        Collection collection1 = Arrays.asList(123);
//        collection.retainAll(collection1);
//        System.out.println(collection);

//        equals(Object obj)
        Collection collection2 = new ArrayList();
        collection2.add(123);
        collection2.add(456);
        collection2.add(789);
        collection2.add(new String("new String"));
        System.out.println(collection.equals(collection2));
    }
    @Test
    public void test4(){
        Collection collection = new ArrayList();
        collection.add(123);
        collection.add(456);
        collection.add(789);
        collection.add(new String("new String"));
//        hashCode()返回当前对象哈希值
        System.out.println(collection.hashCode());
//        集合  -->   数组  ：toArray
        Object[] arr = collection.toArray();
        for(int i = 0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
//         数组  -->  集合 : 调用Arrays类的静态方法asList（）
        List<String> list = Arrays.asList(new String[]{"11","22"});
        System.out.println(list);

    }
}
