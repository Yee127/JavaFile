package Object_Oriented.封装重载值传递;

import java.util.Scanner;

public class di_Gui {
    public static void main(String[] args) {
        di_Gui d = new di_Gui();
        Scanner scan = new Scanner(System.in);
        System.out.println("Input a num: ");
        int num = scan.nextInt();
        System.out.println("第"+num+"个值为："+d.Fe(num));
    }
    public int Fe(int n) {
        if(n == 1)
        {
            return 1;
        }else if(n == 2){
            return 1;
        }
        else {
            return Fe(n-2)+Fe(n-1);
        }
    }
}




