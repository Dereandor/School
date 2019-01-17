import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class DatabaseWrapper {
    
    public static void main(String[]args) throws Exception {
        System.out.println("Starter opp...");
        
        Scanner s = new Scanner(System.in);
        String password = s.nextLine();
        
        String url = "jdbc:mysql://mysql.stud.idi.ntnu.no:3306/torstehs?user=torstehs&password=" + password;
        Connection con = DriverManager.getConnection(url);
        
        Statement stmt = con.createStatement();
        ResultSet res = stmt.executeQuery("SELECT * from person ORDER BY fornavn");
        
        while(res.next()) {
            System.out.println("Personnr " + res.getInt("persnr"));
            System.out.println("Fornavn " + res.getString("fornavn"));
            System.out.println("Etternavn " + res.getString("etternavn"));
        }
        
        con.close();
        s.close();
    }
}
