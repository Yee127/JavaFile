package TreeSet练习;


public class Employee implements Comparable{
    private String name;
    private int age;
    private MyDate date;

    public Employee(){

    }

    public Employee(String name, int age, MyDate date) {
        this.name = name;
        this.age = age;
        this.date = date;
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDate(MyDate date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public MyDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", date=" + date +
                '}';
    }

    @Override
    public int compareTo(Object o){
        if (o instanceof Employee){
            Employee e = (Employee) o;
            return this.name.compareTo(e.name);
        }
        throw new RuntimeException("传入的类型不匹配！");
    }


}
