package Basic;

public class Array3 {
    public static void main(String[] args) {
        int [] array1,array2;
        array1 = new int[]{2,3,5,7,11,13,17,19};
        for (int i = 0; i< array1.length;i++)
        {
            System.out.print(array1[i]+"  ");
        }
        array2 = array1;
        System.out.println();
        for (int i = 0; i< array1.length;i++)
        {
            System.out.print(array2[i]+"  ");
        }
        System.out.println();
        for (int i = 0; i< array1.length;i++)
        {
            if(i%2==0)
            {
                array1[i] = i;
            }
            System.out.print(array1[i]+"  ");
        }
        System.out.println();
//        反转

        String [] str = new String[]{"FF","EE","DD","CC","BB","AA"};

        for (int i=0;i<str.length/2;i++)
        {
            String t = str[i];
            str[i] = str[str.length-i-1];
            str[str.length-i-1] = t;
        }

        for (int i = 0;i < str.length;i++)
        {
            System.out.print("  "+str[i]);
        }

    }
}
