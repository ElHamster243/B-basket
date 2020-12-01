package mx.uv.bbasket.DAO;

import java.io.File;
import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import mx.uv.bbasket.DAO.objects.CompradorDAO;
import mx.uv.bbasket.miniTools.BbasketSQL;

public class CompradorCRUD {
    private Conexion connComprador=new Conexion();
    List<CompradorDAO>compradores=new ArrayList<>();
    private static final String TABLA="comprador";
    private BbasketSQL bbasketSQL=new BbasketSQL();
    //Agregar comprador a la base de datos
    public void registrarComprador(CompradorDAO c){
        try {
            String query =  " insert into "+TABLA+" (nombres, apellidos, usuario, correo, foto, contraseña)"
                            + " values (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStmt = connComprador.conectar().prepareStatement(query);
            preparedStmt.setString(1, c.getNombres());
            preparedStmt.setString(2, c.getApellidos());
            preparedStmt.setString(3, c.getUsuario());
            preparedStmt.setString(4, c.getEmail());
            preparedStmt.setBlob(5, c.getFoto());
            preparedStmt.setString(6, c.getPassword());
            preparedStmt.execute();
            //System.out.println(c.toString());
        } catch (SQLException sqlException) {
            System.out.println("Estado SQL: "+sqlException.getSQLState());
            System.out.println("Código de error: "+sqlException.getErrorCode());
            System.out.println(sqlException.getMessage());
        }
    }
    //Eliminar cuenta de la base de datos mediante el nombre de usuario
    public void eliminarComprador(CompradorDAO c){
        String query = "delete from "+TABLA+" where usuario = ?;";
        try {
            PreparedStatement preparedStmt = connComprador.conectar().prepareStatement(query);
            preparedStmt.setString(1, c.getUsuario());
            preparedStmt.execute();
        } catch (SQLException sqlException) {
            System.out.println("Estado SQL: "+sqlException.getSQLState());
            System.out.println("Código de error: "+sqlException.getErrorCode());
            System.out.println(sqlException.getMessage());
        }

    }
    //Cambiar contraseña de usuario
    public void cambiarPasswd(CompradorDAO c, String passwd){
        String query = "update "+TABLA+" set contraseña = ? where usuario = ?;";
        try {
            PreparedStatement preparedStmt = connComprador.conectar().prepareStatement(query);
            preparedStmt.setString(1, passwd);
            preparedStmt.setString(2, c.getUsuario());
            preparedStmt.executeUpdate();
        } catch (SQLException sqlException) {
            System.out.println("Estado SQL: "+sqlException.getSQLState());
            System.out.println("Código de error: "+sqlException.getErrorCode());
            System.out.println(sqlException.getMessage());
        }
    }
    //Cambiar nombres de comprador
    public void cambiarNombres(CompradorDAO c, String nombres){
        String query = "update "+TABLA+" set nombres = ? where usuario = ?;";
        try {
            PreparedStatement preparedStmt = connComprador.conectar().prepareStatement(query);
            preparedStmt.setString(1, nombres);
            preparedStmt.setString(2, c.getUsuario());
            preparedStmt.executeUpdate();
        } catch (SQLException sqlException) {
            System.out.println("Estado SQL: "+sqlException.getSQLState());
            System.out.println("Código de error: "+sqlException.getErrorCode());
            System.out.println(sqlException.getMessage());
        }
    }
    //Cambiar apellidos de comprador
    public void cambiarApellidos(CompradorDAO c, String apellidos){
        String query = "update "+TABLA+" set apellidos = ? where usuario = ?;";
        try {
            PreparedStatement preparedStmt = connComprador.conectar().prepareStatement(query);
            preparedStmt.setString(1, apellidos);
            preparedStmt.setString(2, c.getUsuario());
            preparedStmt.executeUpdate();
        } catch (SQLException sqlException) {
            System.out.println("Estado SQL: "+sqlException.getSQLState());
            System.out.println("Código de error: "+sqlException.getErrorCode());
            System.out.println(sqlException.getMessage());
        }
    }
    //Cambiar foto de comprador
    public void actualizarFoto(String ruta, CompradorDAO c){
        String insert = "UPDATE `bbasket_bd`.`comprador` SET `foto` = ? WHERE `usuario` = ?;";
        FileInputStream fis = null;
        PreparedStatement ps = null;
        try {
            File file = new File(ruta);
            fis = new FileInputStream(file);
            ps = connComprador.conectar().prepareStatement(insert);
            ps.setBinaryStream(1,fis,(int)file.length());
            ps.setString(2, c.getUsuario());
            ps.executeUpdate();
        } catch (Exception sqlException) {
            System.out.println(sqlException.getMessage());
        }
       }
       //Cambiar foto de comprador
        public void eliminarFoto(CompradorDAO c){
            String insert = "UPDATE `bbasket_bd`.`comprador` SET `foto` = null WHERE `usuario` = ?;";
            PreparedStatement ps = null;
            try {
                ps = connComprador.conectar().prepareStatement(insert);
                ps.setString(1, c.getUsuario());
                ps.executeUpdate();
            } catch (Exception sqlException) {
                System.out.println(sqlException.getMessage());
            }
        }
        //Verificar usuario->contraseña 
        public CompradorDAO usuarioPasswd(CompradorDAO c, String passwd){
            CompradorDAO aux=null;

            String select = "select * from comprador where comprador.usuario='"+c.getUsuario()+"' and comprador.contraseña='"+passwd+"';";
            Statement stmt;
            try {
                stmt=connComprador.conectar().createStatement();
                ResultSet rs=stmt.executeQuery(select);
                if(!rs.next()){
                    System.out.println("\nSin coincidencias registradas en la base de datos.");
                    System.out.println("\nVerificar contraseña o usuario.");
                };
                    int id=rs.getInt("id");
                    String nombres=rs.getString("nombres");
                    String apellidos=rs.getString("apellidos");
                    String usuario=rs.getString("usuario");
                    String correo=rs.getString("correo");
                    Blob foto=rs.getBlob("foto");
                    String passsword=rs.getString("contraseña");
                    aux=new CompradorDAO(id, nombres, apellidos, usuario, correo, foto, passsword);
                    System.out.println(aux.toString());
                
            } catch (Exception sqlException) {
                System.out.println(sqlException.getMessage());
            }
            
            return aux;
        }
    //Consulta de todos los compradores
    public List <CompradorDAO> getCompradores(){
        Statement stmt;
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
                CompradorDAO c=new CompradorDAO(id, nombres, apellidos, usuario, correo, foto, passsword);
                this.compradores.add(c);
                //System.out.println(c.toString());
            }
            
        } catch (SQLException sqlException) {
            System.out.println("Estado SQL: "+sqlException.getSQLState());
            System.out.println("Código de error: "+sqlException.getErrorCode());
            System.out.println(sqlException.getMessage());
        }
        return compradores;
    }
}
