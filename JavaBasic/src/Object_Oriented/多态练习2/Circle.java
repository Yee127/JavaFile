package Object_Oriented.多态练习2;

public class Circle extends GeometricObjrct{
    double radius;



    public Circle(double radius,String color, double weight){
        super(color, weight);
        this.radius = radius;

    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double findArea(){
        return Math.PI*radius*radius;
    }
}
