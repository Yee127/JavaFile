package 泛型;

import org.junit.Test;

import java.util.*;

//      集合中使用泛型
//      泛型(必须是类，不能是基本类型)：指明类型
public class GenericTest {
    @Test
    public void test1(){
        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(12);
        list.add(23);
        list.add(34);
//        list.add("djdj");

//        遍历操作1:
        for (Integer integer: list){
//            避免强转操作
            int stuScore = integer;
            System.out.println(stuScore);
        }
        System.out.println("——————————————————————");
//        遍历操作1:
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
//      Map使用泛型：以HashMap为例
    @Test
    public void test2(){
        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("AAA",111);
        map.put("BBB",222);
        map.put("CCC",333);

//        泛型嵌套
        Set<Map.Entry<String,Integer>> entrySet = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entrySet.iterator();
        while (iterator.hasNext()){
//            System.out.println(iterator.next());
            Map.Entry<String, Integer> entry = iterator.next();
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key+"-->"+value);
        }

    }
}
