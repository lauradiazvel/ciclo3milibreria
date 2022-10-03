
package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    Connection connection ;
    
    static String db = "mi_libreria";
    static String port = "3306";
    static String login = "root";
    static String password = "admin";

    public Conexion() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:" + this.port + "/" + this.db;
            connection = DriverManager.getConnection(url, this.login , this.password);
            System.out.println("Conexion Establecida");
        } catch (Exception e){
            System.out.println("Error en la conexion");
        }
    }
    
    public Connection getConnection(){
        return connection;
    }
    
    public void Desconectar(){
        connection = null;
    }
    

}
