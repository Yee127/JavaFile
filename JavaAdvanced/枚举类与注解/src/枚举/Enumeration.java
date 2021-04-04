package 枚举;

public class Enumeration {
    public static void main(String[] args) {
        Season spring = Season.SPRING;
        System.out.println(spring);
    }

}
//自定义枚举类
class Season{
//    声明Season对象属性
    private final String seasonName;
    private final String seasonDesc;
//    私有化类的构造器
    private Season(String seasonName,String seasonDesc){
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

//    提供当前枚举类的多个对象
    public static final Season SPRING = new Season("春天","春暖花开");
    public static final Season SUMMER = new Season("夏天","夏日炎炎");
    public static final Season AUTUMN = new Season("秋天","秋高气爽");
    public static final Season WINTER = new Season("冬天","冬去春来");
//    其他诉求

    public String getSeasonDesc() {
        return seasonDesc;
    }
    public String getSeasonName() {
        return seasonName;
    }
//    其他诉求

    @Override
    public String toString() {
        return "枚举.Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}