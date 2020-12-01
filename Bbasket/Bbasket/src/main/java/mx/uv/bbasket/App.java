package mx.uv.bbasket;

import java.util.List;

import mx.uv.bbasket.DAO.CompradorCRUD;
import mx.uv.bbasket.DAO.objects.CompradorDAO;
 
public class App 
{
    public static void main(String[] args){
        System.out.println("B-BASKET");
        
        CompradorCRUD compradorDAO=new CompradorCRUD();
        CompradorDAO c=new CompradorDAO(0, "Usuario", "Quesirve Comoejemplo", "lizardi", "usuario@correo.com", null, "c0nTr4s3ni4");
        //compradorDAO.registrarComprador(c);
        //compradorDAO.eliminarComprador(c);
        //compradorDAO.cambiarPasswd(c, "passwdCambiada");
        //compradorDAO.cambiarNombres(c, "Nombre Cambiado");
        //compradorDAO.cambiarApellidos(c, "Apellidos Cambiados");
        //compradorDAO.actualizarFoto("/Users/heand/Desktop/SistemasWeb/Bbasket/Bbasket/src/main/resources/public/assets/img/5.jpg", c);
        //compradorDAO.eliminarFoto(c);
        //compradorDAO.usuarioPasswd(c, "123456");
        List<CompradorDAO>compradoresBD=compradorDAO.getCompradores();
        
    }
}