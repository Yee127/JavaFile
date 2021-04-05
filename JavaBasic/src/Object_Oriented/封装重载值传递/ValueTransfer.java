package Object_Oriented.封装重载值传递;
//值传递
public class ValueTransfer {
    public static void main(String[] args) {
        int m=1,n=2;
        ValueTransfer vt = new ValueTransfer();
//        vt.swap(m,n);
        Data d = new Data();
        vt.swap(d);
        System.out.println("m:"+d.m+" n:"+d.n);
    }
    public void swap(Data data){
        int temp;
        temp = data.m;data.m=data.n;data.n=temp;
    }
    public void swap(int m,int n){
        int temp;
        temp = m;m=n;n=temp;
    }




}

class Data{
    int m=1,n=2;
}

//---->  P212

