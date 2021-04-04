package Object_Oriented.异常;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

/**
 *
 * 2.体会: try-catch-finally:真正的将异常给处理掉了。
 * throws的方式只是将异常抛给了方法的调用者。并没有真正将异常处理掉。
 * 3.开发中如何选择使用try-catch-finally还是使用throws?
 *      3.1如果父类中被重写的方法没有throws方式处理异常，则子类重写的方法也不能使用throws,意味着如果
 *          子类重写的方法中有异常，必须使用try-catch-finally方式处理。
 * 方法重写的规则之一：
 *      子类重写的方法抛出的异常不大于父类被重写的方法抛出的异常类型
 */
public class OverrideTest {
    public static void main(String[] args) {
        OverrideTest test = new OverrideTest();
        test.display(new Son());
    }
    public void display(Son son){
        try{
            son.method();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}


class Son{
    public void method() throws FileAlreadyExistsException{

    }
//
}

class Father{
    public void method() throws IOException{

    }
}