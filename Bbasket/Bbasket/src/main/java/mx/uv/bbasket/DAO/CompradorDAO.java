package mx.uv.bbasket.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import mx.uv.bbasket.DAO.objects.Comprador;
import mx.uv.bbasket.tools.BbasketSQL;

public class CompradorDAO {
    private Conexion connComprador=new Conexion();
    List<Comprador>compradores=new ArrayList<>();
    private static final String TABLA="comprador";
    //Consulta de todos los usuarios
    public List <Comprador> getCompradores(){
        Statement stmt;
        BbasketSQL bbasketSQL=new BbasketSQL();
        try {
            stmt=connComprador.conectar().createStatement();
            ResultSet rs=stmt.executeQuery(bbasketSQL.selectAll(TABLA));
            if(!rs.next()){
                System.out.println("\nSin compradores registrados en la base de datos.");
            };
            while(rs.next()){
                int id=rs.getInt("id");
                String nombres=rs.getString("nombres");
                String apellidos=rs.getString("apellidos");
                String usuario=rs.getString("usuario");
                String correo=rs.getString("correo");
                Blob foto=rs.getBlob("foto");
                String passsword=rs.getString("contraseña");
                Comprador c=new Comprador(id, nombres, apellidos, usuario, correo, foto, passsword);
                this.compradores.add(c);
                System.out.println(c.toString());
            }
            
        } catch (SQLException sqlException) {
            System.out.println("Estado SQL: "+sqlException.getSQLState());
            System.out.println("Código de error: "+sqlException.getErrorCode());
        }
        return compradores;
    }
}
