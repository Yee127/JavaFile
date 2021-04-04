package Object_Oriented.super关键字;

public class Father {

    int id = 111 ;

    String name ;

    public Father(){

    }

    public Father(String name,int id){
        this.name = name;
        this.id = id;
        System.out.println("调父类了");

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

}
