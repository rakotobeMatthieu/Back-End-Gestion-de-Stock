package connexion;
import java.sql.*;  
public class Connexion{ 
    private Statement stmt;
    private Connection con;
        
    public Statement getStatement(){
        return stmt;
    }
    public Connection getConnection(){
        return con;
    }
    public Connexion(){  
        try{  
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","gestion","gestion");
            stmt=con.createStatement();  
        }
        catch(Exception e){ 
            System.out.println("Erreur connexion");
            e.printStackTrace();
        }  
    }  
}  