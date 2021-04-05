package Object_Oriented.异常练习;

import java.util.Scanner;

public class ECMDefault {

    public static void main(String[] args) {
        ECMDefault ecmDefault = new ECMDefault();
        try {


            int i = Integer.parseInt(args[0]);
            int j = Integer.parseInt(args[1]);
            int res = ecmDefault.ecm(i,j);
        }catch (NumberFormatException e){
            System.out.println("NumberFormatException");
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("ArrayIndexOutOfBoundsException ");
        }catch (EcDef e){
            System.out.println(e.getMessage());
        }


    }
    public static int ecm(int a,int b) throws EcDef {
        if(a < 0 || b < 0){
            throw new EcDef("两个数不能为负数！！！！");
        }
        return a/b;
    }
}


class EcDef extends Exception{
    static final long seriaVersionUID = -333333333333L;
    public EcDef(){};

    public EcDef(String msg){
        super(msg);

    }

}