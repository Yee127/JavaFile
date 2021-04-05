package Object_Oriented.多态练习;

public class InstanceTest {
    public static void main(String[] args) {
        Person p = new Person();
        Person s = new Student();
        Person g = new Graduate();

        Student s1 = new Graduate();

        Graduate g1 = new Graduate();
        System.out.println("=============getInfo===============");

        System.out.println(p.getInfo());
        System.out.println(s.getInfo());
        System.out.println(g.getInfo());

        InstanceTest instanceTest = new InstanceTest();
        instanceTest.method(p);
        System.out.println("++++++++++++++++++++++++++");
        instanceTest.method(s);
        System.out.println("++++++++++++++++++++++++++");
        instanceTest.method(g);
        System.out.println("+++++++++++++++++++++++++++");
        instanceTest.method(s1);
        System.out.println("++++++++++++++++++++++++++++");
        instanceTest.method(g1);
    }
   public void method(Person e){
       if(e instanceof Person){
           System.out.println("A Person");
       }
       if(e instanceof Student){
           System.out.println("A Student");
       }
       if(e instanceof Graduate){
           System.out.println("A graduated student");
       }



//       if(e instanceof Graduate){
//           System.out.println("A graduated student");
//           System.out.println("A Student");
//           System.out.println("A Person");
//       }else  if(e instanceof Student){
//           System.out.println("A Student");
//           System.out.println("A Person");
//       }else  if(e instanceof Person){
//           System.out.println("A Person");
//       }
   }
}
