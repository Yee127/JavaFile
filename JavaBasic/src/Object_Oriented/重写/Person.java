package Object_Oriented.重写;

public class Person {

    private String name;
    private int age;

    public Person(){

    }

    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
     public void eat(){
         System.out.println("Eat");
     }

     public void walk()
     {
         System.out.println("walk....");
     }
}
