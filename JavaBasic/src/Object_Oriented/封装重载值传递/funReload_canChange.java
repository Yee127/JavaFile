package Object_Oriented.封装重载值传递;

/**
 * 可变形参
 *
 * 格式：
 *      数据类型 ... 变量名   //  是个数组
 */
public class funReload_canChange {

    public static void main(String[] args) {
        funReload_canChange fC = new funReload_canChange();
        fC.show("AAb");
        System.out.println("*****************");
        fC.show("fdhjfhdjfhdj","hfdjhfdjfhjd","hahahahahaha");
    }
    public void show(int i){
        System.out.println(i);

    }


    public void show(String str){
        System.out.println(str);
        System.out.println("show_String");
    }

    public void show(String ... strs)
    {
        System.out.println("show_String ... ");
        for (int i = 0; i<strs.length;i++)
        {
            System.out.println(strs[i]);
        }

    }


}
