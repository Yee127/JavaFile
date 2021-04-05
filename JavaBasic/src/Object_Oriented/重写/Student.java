package Object_Oriented.重写;

public class Student extends Person{

    String major;

    public Student(){

    }

    public Student(String major){

    }


    public void study(){
        System.out.println("Study: "+ major);
    }


//     重写
    public void eat(){
        System.out.println(" 吃  ..........");
    }

}
