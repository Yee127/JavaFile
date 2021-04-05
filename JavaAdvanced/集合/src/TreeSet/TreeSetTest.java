package TreeSet;

import org.junit.Test;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetTest {
    /*
    两种排序方式：自然  &  定制
        自然排序：自然排序中，比较两个对象是否相同的标准为: compareTo() 返回e.不再是equals().
     */
    @Test
    public void test1(){
//        TreeSet 只能添加同类型的数据
        TreeSet set = new TreeSet();
        set.add(12);
        set.add(23);
        set.add(34);
        set.add(45);
        set.add(56);
        set.add(67);

        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
