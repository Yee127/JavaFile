package Object_Oriented.抽象类练习;

public abstract class Employee {
    private String name;
    private int num;
    private MyDate birthday;
    public abstract double earnings();

    public Employee(String name,int num,MyDate birthday){
        this.name =name;
        this.num = num;
        this.birthday = birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public String getName() {
        return name;
    }

    public int getNum() {
        return num;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", num=" + num +
                ", birthday=" + birthday +
                '}';
    }
}
