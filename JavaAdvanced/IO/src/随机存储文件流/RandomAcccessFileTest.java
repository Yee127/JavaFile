package 随机存储文件流;

import org.junit.Test;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAcccessFileTest {
   @Test
    public void test(){
       RandomAccessFile raf1 = null;
       try {
           raf1 = new RandomAccessFile("/Users/yee/IdeaProjects/JavaAdvanced/IO/dest.txt","rw");

           raf1.seek(3);//将指针调到角标为3的位置
           raf1.write("xyz".getBytes());//覆盖
       } catch (IOException e) {
           e.printStackTrace();
       } finally {
           if (raf1 != null){
               try {
                   raf1.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
       }


   }
}
