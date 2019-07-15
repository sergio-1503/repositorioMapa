/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package databse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author Usuario
 */
public class bd {

 
    
        public static Connection getConnection() throws Exception {
            
             //conexion 
            Connection cn;
            //se va a cargar el driver en la memoria
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            //obtener el objeto de conexion
            String url = "jdbc:sqlserver://mapagps.database.windows.net:1433;database=mapaGps";
            cn = DriverManager.getConnection(url, "proyecto", "GuerraGuerra19");
            return cn;
        
        }
        
    
    
    
    
    
    
}
