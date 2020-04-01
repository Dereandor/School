import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class WebClient extends Thread {
    Socket connection;
    
    public WebClient(Socket connection) {
        this.connection = connection;
    }
    
    public void run() {
        InputStreamReader readerConnection = null;
        PrintWriter printer = null;
        
        try {
            readerConnection = new InputStreamReader(connection.getInputStream());
            printer = new PrintWriter(connection.getOutputStream(), true);
        } catch (IOException e) {
            System.out.println("IOException: ");
            e.printStackTrace();
        }
        BufferedReader reader = new BufferedReader(readerConnection);
        
        String data = null;
        try {
            data = reader.readLine();
        } catch (IOException e) {
            System.out.println("IOException: ");
            e.printStackTrace();
        }
        
        if(data != null) {
            printer.println("HTTP/1.1 200 OK\n" + "Content-Type: text/html; charset = utf-8\n" + "\n" + "<HTML><BODY>");
            printer.println("<H1>Welcome</H1>\n" + "<ul>");
        }
        while (data != null) {
            printer.println("<li>" + data + "</li>");
            try {
                data = reader.readLine();
                if (data.equals("")) {
                    break;
                }
            } catch (IOException e) {
                System.out.println("IOException: ");
                e.printStackTrace();
            }
        }
        printer.println("</ul>");
        
        try {
            reader.close();
            printer.close();
            connection.close();
        }catch (IOException e) {
            System.out.println("IOException: ");
            e.printStackTrace();
        }
    }
}
