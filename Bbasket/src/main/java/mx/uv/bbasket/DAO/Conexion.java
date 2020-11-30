package mx.uv.bbasket.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public Connection conectar(){
        Connection connection=null;
        try {
            connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/bbasket_bd?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", ""
                );
        }catch(SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        if(connection==null){
            System.out.println("Conexión fallida.");
        }else{
            System.out.print("Conexión establecida.");
        }
        return connection;

    }
}