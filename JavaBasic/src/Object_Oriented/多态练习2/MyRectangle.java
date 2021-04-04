package Object_Oriented.多态练习2;

public class MyRectangle extends GeometricObjrct{
    double width;
    double height;

    public MyRectangle(double width,double height,String color,double weight){
        super(color, weight);
        this.height = height;
        this.width = width;

    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getWidth() {
        return width;
    }
    public double findArea(){
        return (height+width)*2;
    }
}
