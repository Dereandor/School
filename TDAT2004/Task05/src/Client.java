import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        final int PORT = 1991;
    
        System.out.println("Connecting to server");
        System.out.println("Skriv inn et regnestykke eller \"close\"");
    
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        
        try {
            DatagramSocket ds = new DatagramSocket();
            InetAddress ia = InetAddress.getByName("127.0.0.1");
            
            byte[] send;
            byte[] receive = new byte[256];
            
            while (true) {
                String message = br.readLine();
                if(message.equals("close")) {
                    ds.close();
                    return;
                }
                send = message.getBytes();
    
                DatagramPacket dp = new DatagramPacket(send, 0, send.length, ia, PORT);
                ds.send(dp);
                DatagramPacket rp = new DatagramPacket(receive, receive.length);
                ds.receive(rp);
                String response = new String(rp.getData(), 0, rp.getLength());
                System.out.println("Svar: " + response);
            }
        } catch (SocketException s) {
            System.out.println("SocketException: ");
            s.printStackTrace();
        } catch (IOException i) {
            System.out.println("IOException: ");
            i.printStackTrace();
        }
    }
}
