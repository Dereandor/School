import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        final int PORT = 1991;
        Socket socket = null;
        
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Starter server");
            
            while (true) {
                socket = server.accept();
                Thread client = new ThreadClientHandler(socket);
                client.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException o) {
                o.printStackTrace();
            }
        }
    }
}
