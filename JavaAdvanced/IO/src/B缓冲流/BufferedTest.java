package B缓冲流;

import org.junit.Test;

import java.io.*;
/**
 * 处理流之一：缓冲流的使用
 *
 * 1.缓冲流：
 * BufferedInputStream
 * BufferedOutputStream
 * BufferedReader
 * BufferedWriter
 *
 * 2.作用：提供流的读取、写入的速度
 *   提高读写速度的原因：内部提供了一个缓冲区
 *
 * 3. 处理流，就是“套接”在已有的流的基础上。
 *
 * @author shkstart
 * @create 2019 下午 2:44
 */
public class BufferedTest {

    public void BufferedStreamTest(String src,String dest){
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
//        1.造文件
            File srcfile = new File(src);
            File destfile = new File(dest);
//        2.造流
//        2.1 造字节流
            FileInputStream fis = new FileInputStream(srcfile);
            FileOutputStream fos = new FileOutputStream(destfile);

//        2.2 造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

//        3.复制的细节：读写
            byte[] buffer = new byte[10];
            int len;
            while ((len = bis.read(buffer)) != -1){
                bos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //         4.资源关闭 从外到内
//        说明：关闭外层，内层自动关闭

                if (bis != null){
                    try {
                        bis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if(bos != null){
                    try {
                        bos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }


        }
    }

    @Test
    public void TimeTest(){
        String src = new String("/Users/yee/Desktop/Test/IMG_4598.JPG");
        String dest = new String("/Users/yee/Desktop/Test/IMG_4598副本.JPG");
        long start = System.currentTimeMillis();
        BufferedStreamTest(src,dest);
        long end = System.currentTimeMillis();
        System.out.println("Time:"+(end - start));
    }
}
