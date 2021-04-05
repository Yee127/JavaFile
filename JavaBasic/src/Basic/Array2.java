package Basic;

public class Array2 {
    public static void main(String[] args) {
        int [] arr = new int[]{2,6,4,56,32,44,1,46,36,22,};
        int max = arr[0];
        int min = arr[0];

        for (int i = 1;i<arr.length;i++)
        {
            if(max < arr[i])
            {
                max=arr[i];
            }
            else if(min > arr[i])
            {
                min=arr[i];
            }
        }
        int sum = 0;
        for (int i = 0;i<arr.length;i++)
        {
            sum +=arr[i];
        }
        System.out.println("Max: "+ max +"\n"+"Min: "+ min+"\n"+"Sum: "+sum);

    }
}
