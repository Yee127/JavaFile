package Object_Oriented.多态练习;

public class Student extends Person {
    protected String School = "PKU";
    public String getInfo(){
        return  "Name: "+name+"\t"+"Age: "+age+"\t\t"+"School: "+School;
    }
}
