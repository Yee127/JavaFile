package Object_Oriented.封装重载值传递;

public class value_transfer_Practice {
    public static void main(String[] args) {
        Circle c = new Circle();
        PassObject p = new PassObject();

        p.printAreas(c,5);
    }
}

class Circle{
    double radius;
    public double findArea(){
        return Math.PI*radius*radius;
    }
}

class PassObject{
    public void printAreas(Circle c,int time){
        System.out.println("Radius:\t\tArea:");
        for (c.radius = 1; c.radius<=time;c.radius++)
        {
            System.out.println("\t"+c.radius+"\t\t"+c.findArea());
        }
    }
}