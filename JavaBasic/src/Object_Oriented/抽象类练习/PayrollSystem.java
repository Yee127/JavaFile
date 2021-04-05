package Object_Oriented.抽象类练习;

import java.util.Scanner;

public class PayrollSystem {
    public static void main(String[] args) {
        int month;
        double money;
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入本月月份：");
        month = scanner.nextInt();
        Employee [] array = new Employee[3];
        array[0] = new HourlyEmployee("Jom",1001,new MyDate(1998,2,1),50,60);
        array[1] = new HourlyEmployee("Mike",1002,new MyDate(1999,3,19),60,70);
        array[2] = new SalariedEmploee("Lily",1003,new MyDate(1998,4,21),5500);


        for (int i = 0; i<array.length;i++){
            System.out.println(array[i].toString());
            double salary = array[i].earnings();
            System.out.println("工资："+ salary);
            if(month == array[i].getBirthday().getMonth()){
                System.out.println("Happy Birthday! "+array[i].getName()+ " ,Reward ：￥ 100 To You!");
                System.out.println("奖励后的工资："+ (salary+100));
            }
        }










    }
}
