package Object_Oriented.super关键字;

public class Son extends Father{
    int id = 222;
    String name ;

    public Son(){

    }

    public Son(String name,int id){
        super(name,id);//super(XXX)的使用。必须声明在子类构造器首行
        this.name = name;
        this.id = id;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public void show(){

        System.out.println("id : "+id);
        System.out.println("name: "+name);

        System.out.println("id of super: "+super.id);
        System.out.println("name of super: "+super.name);

    }
}
