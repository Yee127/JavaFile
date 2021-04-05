package B缓冲流;

import org.junit.Test;

import java.io.*;

/*
 * BufferedReader
 * BufferedWriter
 */
public class BufferedTestB {

    public void test(String src,String dest){
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader(new File(src)));
            bw = new BufferedWriter(new FileWriter(new File(dest)));

            char[] cbuf = new char[1024];
            int len;
            while ((len = br.read(cbuf)) != -1){
                bw.write(cbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            if (bw != null){
                bw.close();
            }
            if (br != null){
                br.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TimeTest(){
        String src = new String("/Users/yee/Desktop/Test/test1.md");
        String dest = new String("/Users/yee/Desktop/Test/test1Copy.md");
        long start = System.currentTimeMillis();
        test(src,dest);
        long end = System.currentTimeMillis();
        System.out.println("Time:"+(end - start));
    }
}
