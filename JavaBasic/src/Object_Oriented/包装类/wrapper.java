package Object_Oriented.包装类;

/**
 *
 * 使用：
 *      Java提供了8种基本数据类型对应的包装类，使得基本数据类型的变量具有类的特征
 *      基本数据类型，包装类，String三者之间的相互转换
 *
 */
public class wrapper {
    public static void main(String[] args) {
        wrapper w = new wrapper();
        w.test();
        w.test2();
        w.test3();
        System.out.println(">>>>>>>>>> 自动装箱 <<<<<<<<<<<");
        w.test4();
    }

    /**
     * 基本数据类型 ===> 包装类，调用包装类的构造器
     */
    public void test(){
        int num = 10;
        Integer integer = new Integer(num);
        System.out.println(integer.toString());

        Integer integer1 = new Integer("123");
        System.out.println(integer1.toString());
//          异常！
//        Integer integer2 = new Integer("123sab");
//        System.out.println(integer2.toString());
        Float f = new Float(12.3f);
        Float f1 = new Float("123.1");
        System.out.println(f);
        System.out.println(f1);

        Boolean b = new Boolean("True1");
        Boolean b1 = new Boolean("True");  //不区分大小写
        Boolean b2 = new Boolean(true);
        System.out.println(b);
        System.out.println(b1);
        System.out.println(b2);
    }

    /**
     * 包装类 ===> 基本数据类型
     */
    public void test2(){
        Integer integer = new Integer(12);
        int i1 = integer.intValue();
        System.out.println(i1);

        Float f = new Float(12.3);
        float f2 = f.floatValue();
        System.out.println(f2);
    }

    /**
     * 基本数据类型 ==>  包装类对象
     * JDK5.0 新特性：自动装箱,自动拆箱
     */
    public void test3(){
        // 自动装箱:基本数据类型 ==>  包装类对象
        int num = 10;
        Integer integer = num;
        System.out.println(integer);

        //自动拆箱：包装类 --> 基本数据类型
     //   System.out.println(integer.toString());

        int num2 = integer;
        System.out.println(num2);//自动拆箱

    }

    /**
     * 基本数据类型，包装类  ----> String类型
     */
    public void test4(){
        int n = 100;
        // way1  连接运算
        String s = 100 + "";
        System.out.println("s:"+s);
        // way2  调用String的valueOf（）
        float f =12.3f;
        String s1 = String.valueOf(f);
        System.out.println("s1:"+s1);

        Double d = new Double(12.4);
        String s2 = String.valueOf(d);
        System.out.println("S2:"+s2);

        /**
         * 基本数据类型，包装类  ----> String类型
         * 调用包装类的parseXXX（）
         */
        System.out.println("String类型 ----> 基本数据类型，包装类");
        String s3 = "123";
//        wrong way:
//
//        int num1 = (int)s3;
//        Integer integer = (Integer)s3;
       int num2 = Integer.parseInt(s3);
        System.out.println("num2 : "+num2);

        String s4 ="true";
        boolean b = Boolean.parseBoolean(s4);
        System.out.println("b:"+b);
    }


}
