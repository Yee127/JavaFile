package Basic;
import java.sql.SQLOutput;
import java.util.Arrays;
public class Array6_ClassTools {
    public static void main(String[] args) {
        //1.boolean equals(int [] a,int [] b):判断两个数组是否相等
        int [] a1,a2 = new int[10];
        a1 = new int[]{1,2,3};
        a2 =new  int[]{1,2,3,7,5,4,8};
        boolean isEquals = Arrays.equals(a1,a2);
        System.out.println(isEquals);
        //2.String toStrong(int[] a) 输出数组的信息
        System.out.println(Arrays.toString(a1)); //[1, 2, 3]

        //3.void fill (int[] a, int val) 将指定的填充到数组之中
        Arrays.fill(a1,10);
        System.out.println(Arrays.toString(a1));

        //4.void sort(int[] a) 对数组进行排序
        Arrays.sort(a2);
        System.out.println(Arrays.toString(a2));
        //5.int binarySearch(int[] a, int key)
        int [] arr = new int[]{1,2,3,4,5,6,7,8,9,98,777};
        int index = Arrays.binarySearch(arr,211);
        if(index>=0)
        {
            System.out.println("找到了");
        }else {
            System.out.println("Not Found!!!");
        }
    }
}
