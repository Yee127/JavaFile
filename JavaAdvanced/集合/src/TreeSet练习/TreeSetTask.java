package TreeSet练习;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetTask {
    @Test
    public void tset1(){
        TreeSet set = new TreeSet();

        Employee employee1 = new Employee("张三",34,new MyDate(1976,12,12));
        Employee employee2 = new Employee("李四",35,new MyDate(1979,2,12));
        Employee employee3 = new Employee("王五",54,new MyDate(1966,1,12));
        Employee employee4 = new Employee("赵六",64,new MyDate(1976,12,2));
        Employee employee5 = new Employee("吴七",24,new MyDate(1976,10,12));
        Employee employee6 = new Employee("刘八",55,new MyDate(1976,9,13));

        set.add(employee1);
        set.add(employee2);
        set.add(employee3);
        set.add(employee4);
        set.add(employee5);
        set.add(employee6);

        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
    @Test
    public void Test2(){
        TreeSet set = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Employee && o2 instanceof Employee){
                    Employee e1 = (Employee) o1;
                    Employee e2 = (Employee) o2;
                    MyDate date1 = e1.getDate();
                    MyDate date2 = e2.getDate();

                    return date1.compareTo(date2);
                }
                throw new RuntimeException("传入的数据类型不一致！");
            }
        });

        Employee employee1 = new Employee("张三",34,new MyDate(1972,12,12));
        Employee employee2 = new Employee("李四",35,new MyDate(1979,2,12));
        Employee employee3 = new Employee("王五",54,new MyDate(1963,1,12));
        Employee employee4 = new Employee("赵六",64,new MyDate(1976,12,2));
        Employee employee5 = new Employee("吴七",24,new MyDate(1986,10,12));
        Employee employee6 = new Employee("刘八",55,new MyDate(1966,9,13));

        set.add(employee1);
        set.add(employee2);
        set.add(employee3);
        set.add(employee4);
        set.add(employee5);
        set.add(employee6);

        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
