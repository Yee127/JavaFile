package UDP;

import org.junit.Test;

import java.io.IOException;
import java.net.*;

public class UDPTest {
    @Test       //发送端
    public void sender()  {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket();

            String str = new String("UDP方式.....");
            byte[] d = str.getBytes();

            InetAddress inet = InetAddress.getLocalHost();

            DatagramPacket packet = new DatagramPacket(d,0,d.length,inet,9090);
            socket.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null){
                try {
                    socket.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Test
    public void receiver(){
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(9090);

            byte[] buffer = new byte[100];
            DatagramPacket packet = new DatagramPacket(buffer,0,buffer.length);

            socket.receive(packet);
            System.out.println(new String(packet.getData(),0,packet.getLength()));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null){
                try {
                    socket.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
