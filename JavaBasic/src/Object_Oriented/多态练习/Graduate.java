package Object_Oriented.多态练习;

public class Graduate extends Student{
    public String major = "IT";
    public String getInfo(){
        return  "Name: "+name+"\t"+"Age: "+age+"\t\t"+"Major: "+major;
    }
}
