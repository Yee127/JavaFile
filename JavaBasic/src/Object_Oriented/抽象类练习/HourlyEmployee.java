package Object_Oriented.抽象类练习;

public class HourlyEmployee extends SalariedEmploee{

    private double wage;
    private double hour;



    public HourlyEmployee(String name,int num,MyDate birthday,double wage,double hour){
        super(name, num, birthday);
        setHour(hour);
        setWage(wage);

    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public void setHour(double hour) {
        this.hour = hour;
    }

    public double getHour() {
        return hour;
    }

    public double getWage() {
        return wage;
    }

    public double earnings(){
        return wage*hour;
    }


    @Override
    public String toString() {
        return "name='" + getName() + '\'' +
                ", num=" +getNum() +
                ", birthday=" + getBirthday();
    }
}
