package 枚举;

public class UseEnumClass {
        public static void main(String[] args) {
            Season1 spring = Season1.SPRING;
            System.out.println(spring);
        }

    }
    //自定义枚举类
enum Season1{
//    提供当前枚举类的对象，多个对象间用"，"隔开，末尾对象"；"结束
       SPRING("春天","春暖花开"),
       SUMMER("夏天","夏日炎炎"),
       AUTUMN("秋天","秋高气爽"),
       WINTER("冬天","冬去春来");
    //    声明Season对象属性
    private final String seasonName;
    private final String seasonDesc;
    //    私有化类的构造器
    private Season1(String seasonName,String seasonDesc){
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

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
        return "Season1{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }

}

