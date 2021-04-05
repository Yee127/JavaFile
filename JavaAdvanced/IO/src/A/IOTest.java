package A;

import org.junit.Test;

import java.io.*;

public class IOTest {
    @Test
    public void test1() throws IOException {
        File file = new File("/Users/yee/IdeaProjects/JavaAdvanced/IO/src/A/TestA.txt");
//        提供具体的实现流
        FileReader fr = new FileReader(file);
//        数据读入
//        read()返回读入的一个字符，如果达到文件末尾  返回-1
        int data = fr.read();
        while (data != -1){
            System.out.print((char) data);
            data = fr.read();
        }
        fr.close();
    }

    @Test
    public void test2(){
        FileReader fr = null;
        try {
            File file = new File("/Users/yee/IdeaProjects/JavaAdvanced/IO/src/A/TestA.txt");
//        提供具体的实现流
            fr = new FileReader(file);

            char[] buf = new char[5];
            int len;
            while ((len = fr.read(buf)) != -1) {
                for (int i = 0; i < len; i++) {
                    System.out.print(buf[i]);
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(fr != null){
                //4.资源的关闭
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

    }

    @Test
    public void test3(){
        /*
    从内存中写出数据到硬盘的文件里。

    说明：
    1. 输出操作，对应的File可以不存在的。并不会报异常
    2.
         File对应的硬盘中的文件如果不存在，在输出的过程中，会自动创建此文件。
         File对应的硬盘中的文件如果存在：
                如果流使用的构造器是：FileWriter(file,false) / FileWriter(file):对原有文件的覆盖
                如果流使用的构造器是：FileWriter(file,true):不会对原有文件覆盖，而是在原有文件基础上追加内容

     */
        File file =new File("TestB.txt");
        FileWriter fw = null;
        try {
            fw = new FileWriter(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            fw.write("I have a dream!\n");
            fw.write("you are stupid!!!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4()  {
        FileReader fr = null;
        FileWriter fw = null;
        try {
            File srcFile = new File("src.txt");
            File destFile = new File("dest.txt");
            //2.创建输入流和输出流的对象
            fr = new FileReader(srcFile);
            fw = new FileWriter(destFile);
            //3.数据的读入和写出操作
            char[] cbuf = new char[5];
            int len;//记录每次读入到cbuf数组中的字符的个数
            while((len = fr.read(cbuf)) != -1){
                //每次写出len个字符
                fw.write(cbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭流资源
            //方式一：
//            try {
//                if(fw != null)
//                    fw.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }finally{
//                try {
//                    if(fr != null)
//                        fr.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
            //方式二：
            try {
                if(fw != null)
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if(fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    @Test
    public void test5(){

    }
}
