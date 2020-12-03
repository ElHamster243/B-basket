package mx.uv.bbasket;

import static spark.Spark.*;
import mx.uv.bbasket.DAO.CompradorCRUD;
import mx.uv.bbasket.DAO.objects.CompradorDAO;
import mx.uv.bbasket.miniTools.BbasketSQL;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
public class App 
{
    public static void main(String[] args){
        System.out.println("B-BASKET");
        BbasketSQL tool=new BbasketSQL();
        CompradorCRUD compradorCRUD=new CompradorCRUD();
        CompradorDAO c=new CompradorDAO(0, "Usuario", "Quesirve Comoejemplo", "lizardi", "usuario@correo.com", null, "c0nTr4s3ni4");
        //compradorDAO.registrarComprador(c);
        //compradorDAO.eliminarComprador(c);
        //compradorDAO.cambiarPasswd(c, "passwdCambiada");
        //compradorDAO.cambiarNombres(c, "Nombre Cambiado");
        //compradorCRUD.cambiarApellidos(c, "Alonso Lizardii");
        //compradorDAO.actualizarFoto("/Users/heand/Desktop/SistemasWeb/Bbasket/Bbasket/src/main/resources/public/assets/img/5.jpg", c);
        //compradorDAO.eliminarFoto(c);
        CompradorDAO comprador=compradorCRUD.usuarioPasswd(c, "123456");
        //List<CompradorDAO>compradoresBD=compradorDAO.getCompradores();
        Date date=new Date();
        staticFiles.location("/public");
        port(4567);
        get("/index", (req, res) ->{
            Map<String, Object> modelo = new HashMap<>();
            System.out.println("Hola ha entrado");
            modelo.put("fecha", date);
            //modelo.put("comprador", comprador);
            return new ModelAndView(modelo, "velocity/index.vm");
        }, new VelocityTemplateEngine());
        get("/perfil", (req, res)->{
            Map<String, Object> modelo = new HashMap<>();
            //modelo.put("foto", tool.abrirImagen(comprador.getFoto()));
            modelo.put("cliente", comprador);
            return new ModelAndView(modelo, "velocity/perfil.vm");
        }, new VelocityTemplateEngine());

    }
}