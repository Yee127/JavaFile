package Object_Oriented.继承练习;

public class ManKind {
    private int sex;
    private int salary;

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getSex() {
        return sex;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void manOrWoman(){
        if(sex == 1)
        {
            System.out.println("It's A Man");
        }
        else if(sex == 0)
        {
            System.out.println("It's A Woman");
        }
    }
    public void employeed(){
        if (salary == 0)
        {
            System.out.println("No Job!");
        }
        else if (salary != 0 && salary > 0)
        {
            System.out.println("Job! And Salay is "+salary+" yuan");
        }
    }
}
