package Object_Oriented.多态练习2;

public class GeometricTest {
    public static void main(String[] args) {
        GeometricTest test = new GeometricTest();
        Circle c = new Circle(12,"red",12);
        MyRectangle mr = new MyRectangle(24,24,"green",24);

        test.equalsArea(c.findArea(),mr.findArea());
        test.displayGeometricObject(c.findArea(),mr.findArea());


    }
    public void equalsArea(double S1,double S2){
        if (S1 == S2)
        {
            System.out.println("面积相等");
        }else {
            System.out.println("面积不等");
        }
    }

    public void displayGeometricObject(double s1,double s2){
        System.out.println("S1 = "+s1);
        System.out.println("S2 = "+s2);
    }
}
