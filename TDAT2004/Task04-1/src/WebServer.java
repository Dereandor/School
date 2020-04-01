import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class WebServer {
    public static void main(String[] args) throws IOException {
        final int PORT = 80;
        
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("kjører på port: " + PORT);
        Socket connection = server.accept();
        System.out.println("Connected");
        
        InputStreamReader readerConnection = new InputStreamReader(connection.getInputStream());
        BufferedReader reader = new BufferedReader(readerConnection);
        PrintWriter printer = new PrintWriter(connection.getOutputStream(), true);
        
        String data = reader.readLine();
        ArrayList<String> info = new ArrayList<>();
        while (!data.equals("")) {
            info.add(data);
            System.out.println(data);
            data = reader.readLine();
        }
        
        printer.println("HTTP/1.1 200 OK\r\n" + "Content-Type: text/html; charset = utf-8\r\n" + "Server: SimpleWebServer\r\n" + "<HTML>\r\n<BODY>\r\n");
        printer.println("<H1>Welcome</H1>\r\n" + "<ul>\r");
        for (String str : info) {
            printer.println("<li>" + str + "</li>\r");
        }
        printer.println("</ul>\r\n" + "</BODY>\r\n" + "</HTML>\r");
    
        reader.close();
        printer.close();
        connection.close();
        
    }
}
