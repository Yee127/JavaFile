package List遍历;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

public class listIndex {
    @Test
    public void test1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(3);
        arrayList.add(5);
        arrayList.add(7);
        arrayList.add(0);

//        迭代器遍历
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("______________________");
//        for
        for (Object obj : arrayList){
            System.out.println(obj);
        }
        System.out.println("______________________");
//        普通for循环
        for (int i = 0;i<arrayList.size();i++){
            System.out.println(arrayList.get(i));
        }
    }
}
