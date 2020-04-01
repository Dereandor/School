import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Server {
    public static void main(String[] args) {
        final int PORT = 1991;
    
        System.out.println("Starting server");
        
        try {
            DatagramSocket ds = new DatagramSocket(PORT);
            byte[] send;
            byte[] receive = new byte[256];
            
            while(true) {
                DatagramPacket dp = new DatagramPacket(receive, receive.length);
                ds.receive(dp);
                String receivedData = new String(dp.getData(), 0, dp.getLength());
                System.out.println("From client: " + receivedData);
                
                int sum = 0;
                if (receivedData.contains("+")) {
                    int num1 = Integer.parseInt(receivedData.split("\\+")[0]);
                    int num2 = Integer.parseInt(receivedData.split("\\+")[2]);
                    sum = num1 + num2;
                } else if(receivedData.contains("-")) {
                    int num1 = Integer.parseInt(receivedData.split("-")[0]);
                    int num2 = Integer.parseInt(receivedData.split("-")[2]);
                    sum = num1 + num2;
                }
                
                String output = "= " + sum;
    
                InetAddress ia = dp.getAddress();
                int port = dp.getPort();
                send = output.getBytes();
                
                DatagramPacket sp = new DatagramPacket(send, send.length, ia, port);
                ds.send(sp);
            }
            
        } catch(SocketException s) {
            System.out.println("SocketException: ");
            s.printStackTrace();
        } catch (IOException i) {
            System.out.println("IOException: ");
            i.printStackTrace();
        }
    }
}
