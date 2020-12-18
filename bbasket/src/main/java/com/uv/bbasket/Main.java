package com.uv.bbasket;

import static spark.Spark.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.uv.bbasket.dao.TablaDAO;
import com.uv.bbasket.dao.AccesoDAO;
import com.uv.bbasket.dao.ClienteDAO;
import com.uv.bbasket.model.Cliente;
import com.uv.bbasket.model.Acceso;
import com.uv.bbasket.model.Tabla;



import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
public class Main {
    public static void main(String[] args) {
        //Puerto de HEROKU para desplegar
        port(getHerokuAssignedPort());
        //Localización de los archivos del sistema web bbasket
        staticFiles.location("/public");
        //Ruta base
        path("/bbasket", () -> {
            //Modelo del sitio
            Map<String, Object> modelo = new HashMap<>();
            //Nombre del sitio
            modelo.put("proyecto", "B-basket");
            options("/*", (request, response) -> {
                String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
                if (accessControlRequestHeaders != null) {
                    response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
                }
                String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
                if (accessControlRequestMethod != null) {
                    response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
                }
                return "OK";
            });
            before((request, response) -> response.header("Access-Control-Allow-Origin", "*"));
            before((req, res)->res.type("application/json"));
            //Cargar página principal
            get("", (req, res) -> {
                List<Acceso>lista=new ArrayList<>();
                lista=AccesoDAO.getLista();
                System.out.println(req.host());
                System.out.println(req.url());
                modelo.put("lista", lista);
                modelo.put("host", req.host());
                modelo.put("url", req.url());
                modelo.put("nav", "spark/velocity/principal/nav.vm");
                modelo.put("mision", "spark/velocity/principal/mision.vm");
                modelo.put("registro", "spark/velocity/principal/registro.vm");
                modelo.put("login", "spark/velocity/principal/login.vm");
                return new ModelAndView(modelo, "spark/velocity/principal/index.vm");
            }, new VelocityTemplateEngine());
            //Cargar página comprador
            get("/:usuario/:passwd", (req,res)->{
                Cliente c=ClienteDAO.userPasswd(req.params(":usuario"), req.params(":passwd"));
                
                System.out.println(req.params(":usuario")+ req.params(":passwd"));
                if(c!=null){
                    System.out.println("Comprador:"+c.getNombres());
                    modelo.put("comprador", c);
                    List<Tabla>tabla=new ArrayList<>();
                    tabla=TablaDAO.getTabla();
                    modelo.put("tabla", tabla);
                    return new ModelAndView(modelo, "spark/velocity/comprador/index.vm");
                }else{
                    res.redirect("/bbasket");
                    return null;
                }
            }, new VelocityTemplateEngine());
            
        });
        
    }
    //HEROKU
    static int getHerokuAssignedPort() {
    ProcessBuilder processBuilder = new ProcessBuilder();
    if (processBuilder.environment().get("PORT") != null) {
        return Integer.parseInt(processBuilder.environment().get("PORT"));
    }
        return 4567;
    }
}
