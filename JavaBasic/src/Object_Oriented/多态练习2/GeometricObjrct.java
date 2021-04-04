package Object_Oriented.多态练习2;

public class GeometricObjrct {
    String color;
    double weight;

    public GeometricObjrct(String color,double weight)
    {
        this.color = color;
        this.weight = weight;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public double findArea(){
        return 0;
    }
}
