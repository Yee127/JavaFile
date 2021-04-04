package Basic;

import java.util.Scanner;
public class Array4_index_line {
    public static void main(String[] args) {
        String [] str = new String[]{"FF","EE","DD","CC","BB","AA"};
        System.out.println("输入一个字符串：");
        Scanner scanner = new Scanner(System.in);

        String dest = scanner.next();
        boolean isFlag = true;

        for (int i = 0; i < str.length; i++)
        {
            if(dest.equals(str[i]))  // equals 比较字符串
            {
                System.out.println("\""+str[i]+"\""+"找到了！");
                isFlag = false;
                break;
            }
        }
        if (isFlag)
        {
            System.out.println("Not Fount!");
        }

        // 二分法查找（折半查找）
        // 前提 要查找的数组必须是有序的
        System.out.println("**********************************");

        int [] arr = new int[]{1,2,3,4,5,6,7,8,9,10};
        boolean isFlag1 = true;
        Scanner num = new Scanner(System.in);
        System.out.println("input a N:");
        int N = num.nextInt();

        int head = 0, end = arr.length-1;
        while (head<=end)
        {
            int middle =(end + head) / 2;

            if(N == arr[middle])
            {
                System.out.println("找到了！");
                isFlag1 = false;
                break;
            }
            else if(arr[middle] > N)
            {
                end = middle-1;
            }
            else {
                head = middle+1;
            }
        }

        if(isFlag1)
        {
            System.out.println("Not Fund!");
        }

    }
}
