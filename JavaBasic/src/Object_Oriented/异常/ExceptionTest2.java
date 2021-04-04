package Object_Oriented.异常;

import java.io.IOException;

/**
 * throws + 异常类型
 *
 * throws + 异常类型  写在方法声明处，指明方法执行时可能回抛出的异常
 *                      一旦出现异常，仍会在异常代码处生成一个异常类的对象，此对象满足throws后异常
 *                      类型是，就会被抛出 异常代码后续的代码不再执行
 */
public class ExceptionTest2 {
    public static void main(String[] args) {
        try {
            method2();
        }catch (Exception e){
            System.out.println("抛出异常");
        }
    }
    public static void method1() throws Exception{

    }

    public static void method2() throws Exception {
        method1();
    }

}
