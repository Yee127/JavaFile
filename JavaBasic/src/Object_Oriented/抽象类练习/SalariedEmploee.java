package Object_Oriented.抽象类练习;

public class SalariedEmploee extends Employee {
    private double monthSalary;

    public SalariedEmploee(String name,int num,MyDate birthday){
        super(name,num,birthday);
    }
    public SalariedEmploee(String name,int num,MyDate birthday,double monthSalary){
        super(name,num,birthday);
        this.monthSalary = monthSalary;
    }

    public void setMonthSalary(double monthSalary) {
        this.monthSalary = monthSalary;
    }

    public double getMonthSalary() {
        return monthSalary;
    }

    public  double earnings(){
        return monthSalary;
    }

    @Override
    public String toString() {
        return "name='" + getName() + '\'' +
                ", num=" +getNum() +
                ", birthday：" + getBirthday()
                ;
    }
}
