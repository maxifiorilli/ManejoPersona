/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personas.jdbc;
import java.sql.*;
/**
 *
 * @author Maxi
 */
public class Conexion {
    
    private static final String JDBC_URL="jdbc:sqlserver://localhost:1433;databaseName=SGA";
    private static final String JDBC_USER="Torture";
    private static final String JDBC_PASS="Torture";
    
    
    public static synchronized Connection getConnection()
            throws SQLException{
        return DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASS);
    }
    
    public static void close(ResultSet rs){
        try{
            if(rs !=null){
                rs.close();
            }
        }
        catch(SQLException sqle){
            sqle.printStackTrace();
        }
    }
    
    //Cierre del PrepareStatement
    public static void close(PreparedStatement stmt){
        try{
            if(stmt != null){
                stmt.close();
            }
        }
        catch (SQLException sqle){
            sqle.printStackTrace();
        }
    }
    
    //Cierre de conexion
    public static void close(Connection conn){
        try{
            if (conn !=null){
                conn.close();
            }
        }
        catch(SQLException sqle){
            sqle.printStackTrace();
        }
    }
}



