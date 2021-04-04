package Object_Oriented.抽象类练习;

public class MyDate {
    private int year;
    private int month;
    private int day;

   public MyDate(int year,int month,int day){
       this.day = day;
       this.month = month;
       this.year = year;

   }
   public MyDate(){}

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "MyDate:" +
                year +
                "/" + month +
                "/" + day;
    }
}
