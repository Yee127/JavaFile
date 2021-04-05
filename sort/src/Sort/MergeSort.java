package Sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int []arr = {9,8,7,6,5,4,3,2,1};
        int [] temp = new int[arr.length];
        mergeSort(arr,0,arr.length-1,temp);
        System.out.println(Arrays.toString(arr));
    }
    public static void mergeSort(int[] arr,int left,int right,int[] temp){
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
    public static void merge(int[] arr,int left,int right,int [] temp,int mid){
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

