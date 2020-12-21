package mx.uv.web.bbasket;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.google.gson.Gson;

import mx.uv.web.bbasket.dao.ClienteDAO;
import mx.uv.web.bbasket.dao.TablaDAO;
import mx.uv.web.bbasket.model.Cliente;
import mx.uv.web.bbasket.util.Path;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.*;
import spark.ModelAndView;

public class App 
{
    public static void main( String[] args )
    {
        //Localización de los archivos del sistema web bbasket
        staticFiles.location("/public");
        Gson gson = new Gson();
        //Puerto de HEROKU para desplegar
        port(getHerokuAssignedPort());
        //Modelo del sitio
        Map<String, Object> model = new HashMap<>();
        model.put("proyecto", "Bbasket");
        init();
        //Ruta principal '/'
        path("/", () -> {
            //Redirige al registro si las credenciales son erróneas
            before(Path.Web.BIENVENIDA, (request, response) -> {
                if(!ClienteDAO.authenticate(request.params(":usuario"), request.params(":password"))){
                    response.redirect("/registro");
                    halt(401, "Tú no pasarás, sin registrarte"+request.params(":usuario")+" verifica tus credenciales.");
                }
            });
            after(Path.Web.REGISTRAR, (request, response) -> {
                if(model.get("nombres")==null){
                     
                    halt(401, "/registro");
                }
            });
            //Ruta INDEX
            get(Path.Web.INDEX, (req, res) -> {
                System.out.println(req.host());
                System.out.println(req.url());
                model.put("pagina", "index");
                model.put("host", req.host());
                model.put("url", req.url());
                System.out.println("Cargando pagina 'Index'");
                return new ModelAndView(model, Path.Template.INDEX);
            }, new VelocityTemplateEngine());
            //Ruta ACCESO
            get(Path.Web.ACCESO, (req, res) -> {
                System.out.println(req.host());
                System.out.println(req.url());
                model.put("pagina", "acceso");
                model.put("host", req.host());
                model.put("url", req.url());
                System.out.println("Cargando pagina 'Acceso'");
                return new ModelAndView(model, Path.Template.ACCESO);
            }, new VelocityTemplateEngine());
            //Ruta REGISTRO
            get(Path.Web.REGISTRO, (req, res) -> {
                System.out.println(req.host());
                System.out.println(req.url());
                model.put("pagina", "registro");
                model.put("host", req.host());
                model.put("url", req.url());
                System.out.println("Cargando pagina 'Registro'");
                return new ModelAndView(model, Path.Template.REGISTRO);
            }, new VelocityTemplateEngine());
            //Ruta Pagina de bienvenida y búsqueda
            get(Path.Web.BIENVENIDA, (req, res) -> {
                System.out.println(req.params(":usuario"));
                Cliente c = ClienteDAO.byUser(req.params(":usuario"));
                model.put("c", c);
                System.out.println(req.host());
                System.out.println(req.url());
                model.put("productos", TablaDAO.getTabla());
                model.put("proyecto", "B-basket");
                model.put("content", "bienvenida");
                model.put("pagina", "bienvenida");
                model.put("url", req.url());
                return new ModelAndView(model, Path.Template.BIENVENIDA);
            }, new VelocityTemplateEngine());
            //Ruta Pagina de gestión del perfil
            get(Path.Web.PERFIL, (req, res) -> {

                System.out.println(req.host());
                System.out.println(req.url());
                model.put("proyecto", "B-basket");
                model.put("content", "perfil");
                model.put("pagina", "perfil");

                model.put("url", req.url());
                return new ModelAndView(model, Path.Template.PERFIL);
            }, new VelocityTemplateEngine());
            //Consumiendo la API para saber si el suario y la contraseña existen
            post(Path.Web.ACCEDER, (req, res) -> {
                model.put("content", "acceso");
                Properties properties = gson.fromJson(req.body(), Properties.class);
                String p=properties.getProperty("password");
                String u=properties.getProperty("usuario"); 
                model.put("proyecto", "B-basket");
                if (ClienteDAO.userPasswd(u, p)==null){
                    System.out.println("falló "+u+p);
                    model.put("url", req.url());
                    model.put("pagina", "login");
                }
                System.out.println(u+p);
                model.put("proyecto", "B-basket");
                req.session().attribute("currentUser", u);
                System.out.println(req.host());
                System.out.println(req.url());
                Cliente c=ClienteDAO.userPasswd(u, p);
                model.put("c", c);
                model.put("pagina", "login");
                model.put("url", req.url());
                System.out.println("LISTO");
                return new ModelAndView(model, Path.Template.ACCEDER);
            }, new VelocityTemplateEngine());
        });
        post(Path.Web.REGISTRAR, (req, res) -> {
            model.put("content", "registro");
            Properties properties = gson.fromJson(req.body(), Properties.class);
            String nombres=properties.getProperty("nombres");
            String apellidos=properties.getProperty("apellidos");
            String correo=properties.getProperty("correo");
            String usuario=properties.getProperty("usuario");
            String password=properties.getProperty("password");
            Cliente c=new Cliente(0, nombres, apellidos, usuario, correo, password);
            System.out.println(c.toString());
            if (!ClienteDAO.registrarCliente(c)) {
                model.put("proyecto", "B-basket");
                System.out.println("falló el registro");
                model.put("url", req.url());
                model.put("pagina", "registro");
                model.put("authenticationFailed", true);
                model.put("estado", "CUENTA NO REGISTRADA");
            }else{
                model.put("estado", "CUENTA REGISTRADA");
                System.out.println("Registro exitoso");
                model.put("proyecto", "B-basket");
                model.put("authenticationSucceeded", true);
                System.out.println(req.host());
                System.out.println(req.url());
                model.put("c", c);
                model.put("pagina", "registro");
                model.put("url", req.url());
            }
            return new ModelAndView(model, Path.Template.REGISTRAR);
        }, new VelocityTemplateEngine());
    
        
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
