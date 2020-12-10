package com.uv.bbasket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.uv.bbasket.dao.AccesosPublicoDAO;
import com.uv.bbasket.dao.CompradorDAO;
import com.uv.bbasket.dao.TablaIndexDAO;
import com.uv.bbasket.model.AccesosPublico;
import com.uv.bbasket.model.TablaIndex;
import com.uv.bbasket.model.Comprador;

import static spark.Spark.*;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

public class Main {
    private static Gson gson=new Gson();
    public static void main(String[] args) {
        staticFiles.location("public/");
        get("/", (req, res) -> {
            List<AccesosPublico> accesos = new ArrayList<>();
            
            AccesosPublicoDAO apDAO=new AccesosPublicoDAO();
            accesos=apDAO.getAccesos();
            List<TablaIndex>tabla=new ArrayList<>();
            TablaIndexDAO tiDAO=new TablaIndexDAO();
            tabla=tiDAO.getTabla();
            Map<String, Object> modelo = new HashMap<>();
            modelo.put("accesos", accesos);
            modelo.put("vista", tabla);
            modelo.put("proyecto", "B-basket");
            return new ModelAndView(modelo, "spark/velocity/index/index.vm");
        }, new VelocityTemplateEngine());

        get("/comprador", (req, res) ->{
            Map<String, Object> modelo = new HashMap<>();
            CompradorDAO cDao=new CompradorDAO();
            Comprador cliente = cDao.usuarioPasswd("lizardi", "123456");
            modelo.put("u", cliente);
            modelo.put("proyecto", "B-basket");
            return new ModelAndView(modelo, "spark/velocity/comprador/index.vm");
        }, new VelocityTemplateEngine());


    }
    
}
