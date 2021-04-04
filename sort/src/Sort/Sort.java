package Sort;
import jdk.jfr.StackTrace;
import org.junit.Test;

import java.util.Arrays;
//选择排序
class Select{
    public void select(int []arr){
        int temp,minIndex;
        for(int i = 0;i<arr.length;i++){
            minIndex = i;
            for (int j =i+ 1;j<arr.length;j++){
                if(arr[minIndex] > arr[j]){
                    //交换下标
                    minIndex = j;
                }
            }
            //交换值
            if(minIndex != i){
                temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex]=temp;
                System.out.println("第"+(i+1)+"轮交换：");
                System.out.println(Arrays.toString(arr));
            }
        }
    /*  推导：
    for (int i = 1;i<arr.length;i++){
        if(arr[minIndex] > arr[i]){
            minIndex = i;
        }
    }
    temp = arr[0];
    arr[0] = arr[minIndex];
    arr[minIndex]=temp;
//        System.out.println(arr[minIndex]);
    System.out.println("第1轮交换：");
    System.out.println(Arrays.toString(arr));

    for (int i = 2;i<arr.length-1;i++){
        if(arr[minIndex+1] > arr[i]){
            minIndex = i;
        }
    }
    temp = arr[1];
    arr[1] = arr[minIndex+1];
    arr[minIndex+1]=temp;
//        System.out.println(arr[minIndex]);
    System.out.println("第2轮交换：");
    System.out.println(Arrays.toString(arr));
    */

    }
}
//插入排序
class Insert{
    public void insert(int[] arr){
        for (int i = 1; i<arr.length;i++){
            int index = i-1;
            int Insert = arr[i];
            while (index >=0 && Insert < arr[index]){
                arr[index+1] = arr[index];
                index--;
            }
            //小优化
            if(index+1 != i){
                arr[index+1] = Insert;
            }
            System.out.println("第"+i+"轮：");
            System.out.println(Arrays.toString(arr));
        }
        /*
//    推导：
//        第1轮：
        int index = 0;
        int Insert = arr[1];
        while (index >=0 && Insert < arr[index]){
            arr[index+1] = arr[index];
            index--;
        }//[66, 66, 13, 15, 15, 46, 53, 43]
        System.out.println("index:"+index);
        arr[index+1] = Insert;
        System.out.println("第一轮：");
        System.out.println(Arrays.toString(arr));
//        第2轮：
        index = 0+1;
        Insert = arr[1+1];
        while (index >=0 && Insert < arr[index]){
            arr[index+1] = arr[index];
            index--;
        }//[21, 21, 66, 15, 15, 46, 53, 43]
        arr[index+1] = Insert;
        System.out.println("第2轮：");
        System.out.println(Arrays.toString(arr));
        //        第3轮：
        index = 0+1+1;
        Insert = arr[1+1+1];
        while (index >=0 && Insert < arr[index]){
            arr[index+1] = arr[index];
            index--;//依次比较Insert 和 arr[index] 大小 ： 13比较 66 ，21 大小
        }//[13, 21, 21, 66, 15, 46, 53, 43]
        arr[index+1] = Insert;
        System.out.println("第2轮：");
        System.out.println(Arrays.toString(arr));
*/

    }
}

//希尔排序
class Shell{
    //交换法 效率很低
    public void shellExchange(int[] arr){
        int temp = 0;
        int count = 0;
        for (int gap = arr.length/2;gap>0;gap /=2){
            for(int i = gap; i<arr.length;i++){
                for (int j = i-gap;j>=0;j -= gap){
                    if(arr[j] > arr[j+gap]){
                        temp = arr[j];
                        arr[j] = arr[j+gap];
                        arr[j+gap]=temp;
                    }
                }
            }
            System.out.println("希尔（交换法）第"+(++count)+"轮排序："+Arrays.toString(arr));
        }
        /*推导：
        for(int i = 4; i<arr.length;i++){
            for (int j = i-4;j>=0;j -= 4){
                if(arr[j] > arr[j+4]){
                    temp = arr[j];
                    arr[j] = arr[j+4];
                    arr[j+4]=temp;
                }
            }
        }
        System.out.println("希尔（交换法）第一轮排序："+Arrays.toString(arr));

        for(int i = 2; i<arr.length;i++){
            for (int j = i-2;j>=0;j -= 2){
                if(arr[j] > arr[j+2]){
                    temp = arr[j];
                    arr[j] = arr[j+2];
                    arr[j+2]=temp;
                }
            }
        }
        System.out.println("希尔（交换法）第二轮排序："+Arrays.toString(arr));

        for(int i = 1; i<arr.length;i++){
            for (int j = i-1;j>=0;j -= 1){
                if(arr[j] > arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        System.out.println("希尔（交换法）第三轮排序："+Arrays.toString(arr));

         */
    }
    //移位法 效率高
    public void shellMove(int[] arr){
        int count=0;
        for (int gap = arr.length/2;gap>0;gap /=2){
            for (int i = gap; i< arr.length;i++){
                int index = i;
                int Insert = arr[index];
                if (arr[index] <arr[index - gap]){
                    while ((index - gap) >= 0 && Insert < arr[index - gap]){
                        //move
                        arr[index] = arr[index - gap];
                        index -= gap;
                    }
                    arr[index] = Insert;
                }
            }
            System.out.println("希尔（移位法）第"+(++count)+"轮排序："+Arrays.toString(arr));
        }
    }
}

//快速排序
class Quick{
    public void quickSort(int[] arr,int left,int right){
        int r = right,l = left;
        int x = arr[l];
        while (l < r){
            while (arr[r] > x){
                r--;
            }
            if (l < r){
                arr[l] = arr[r];
            }
        }
    }
}
//归并排序
class Merge{
    //分
    public void mergeSort(int[] arr,int left,int right,int[] temp){
        if(left<right){
            int mid = (right+left)/2;
            //左边递归分解
            mergeSort(arr,left,mid,temp);
            //右边递归分解
            mergeSort(arr,mid+1,right,temp);
            //合
            merge(arr,left,right,temp,mid);
        }

    }
    //治
    public void merge(int[] arr,int left,int right,int [] temp,int mid){
        int i = left;
        int j = mid+1;
        int t = 0;//temp数组下标
        while (i<=mid && j<=right){
            if (arr[i] <= arr[j]){//右边的数小于左边的
                temp[t++] = arr[i++];//则填充到临时数组temp中右边数组指针后移
            } else{
                temp[t++] = arr[j++];
            }
        }
        while( i <= mid) { //左边的有序序列还有剩余的元素，就全部填充到 temp
            temp[t++] = arr[i++];
        }
        while (j<=right){
            temp[t++] = arr[j++];
        }
        t = 0;
        while(left <= right) {
            arr[left++] = temp[t++];
        }
    }
}
public class Sort {
    public static void main(String[] args) {
        long startTime=System.currentTimeMillis();   //获取开始时间
        int [] arr = {66,21,13,15,15,46,53,43,10};
        int [] array = {21,13,15,15,46,53,43,10,66};
        int [] temp = new int[arr.length];
//        new Select().select(arr);
//        new Insert().insert(arr);
//        new Shell().shellExchange(arr);
//        new Shell().shellMove(arr);
        new Merge().mergeSort(arr,0,arr.length-1,temp);
        System.out.println(Arrays.toString(arr));


        long endTime=System.currentTimeMillis(); //获取结束时间
        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
    }
}
