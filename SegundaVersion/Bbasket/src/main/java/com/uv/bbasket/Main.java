package com.uv.bbasket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.uv.bbasket.dao.CompradorDAO;
import com.uv.bbasket.model.Comprador;
import com.uv.bbasket.model.Vista;

import static spark.Spark.*;
import spark.ModelAndView; 
import spark.template.velocity.VelocityTemplateEngine;
public class Main 
{
    public static void main(String[] args){

        staticFiles.location("public/");
        List <Vista>v=new ArrayList<>();
        Vista v0=new Vista (0, "Producto 1", 12.40, "300ml");
        Vista v1=new Vista (0, "Producto 2", 200.40, "4lt");
        Vista v2=new Vista (0, "Producto 3", 2.40, "5gr");
        v.add(v0);
        v.add(v1);
        v.add(v2);
        //Tienda t=new Tienda(11, "La Esperanza", 1, "123456789", 2);
        //Direccion d=new Direccion(0, 30, 11,  "Xalapa", "Progreso", "Guanajuato", "120", "91130");
        //TiendaDAO t_dao=new TiendaDAO();
        //t_dao.bajaTiendaById(t);
        //DireccionDAO ddao=new DireccionDAO();
        //ddao.agregarDireccion(d);
       
        //t_dao.cambiarNombre(t, "Fasti");
        //t_dao.cambiarDireccionById(t);
        //t_dao.cambiarTipo(t);
        //t_dao.cambiarPasswd(t);
        get("/", (req, res) ->{
            Map<String, Object> modelo = new HashMap<>();
            modelo.put("vistas", v);
            
            modelo.put("proyecto", "B-basket");
            
            return new ModelAndView(modelo, "spark/velocity/index/index.vm");
        }, new VelocityTemplateEngine());
        get("/comprador", (req, res) ->{
            Map<String, Object> modelo = new HashMap<>();
            modelo.put("vistas", v);
            CompradorDAO cDao=new CompradorDAO();
            Comprador cliente = cDao.usuarioPasswd("lizardi", "123456");
            modelo.put("u", cliente);
            modelo.put("proyecto", "B-basket");
            
            return new ModelAndView(modelo, "spark/velocity/comprador/index.vm");
        }, new VelocityTemplateEngine());


    }
    
}
