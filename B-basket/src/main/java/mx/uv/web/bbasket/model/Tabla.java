package mx.uv.web.bbasket.model;
//Autor: Omar Alejandro Alonso Lizardi
//Fecha: 17-12-2020
//Sistemas web
//Universidad Veracruzana
//Modelo de la vista creada para mostrar los productos
public class Tabla {
    //Atributos
    private String producto;
    private String tamano;
    private String marca;
    private double precio;
    private String oferta;
    private String tienda;
    private String colonia;
    private String calle;
    private String numero;
    //Getters
    public String getProducto(){
        return this.producto;
    }
    public String getTamano(){
        return this.tamano;
    }
    public String getMarca(){
        return this.marca;
    }
    public double getPrecio(){
        return this.precio;
    }
    public String getOferta(){
        return this.oferta;
    }
    public String getTienda(){
        return this.tienda;
    }
    public String getColonia(){
        return this.colonia;
    }
    public String getCalle(){
        return this.calle;
    }
    public String getNumero(){
        return this.numero;
    }
    //Setters
    public void setProducto(String producto){
        this.producto=producto;
    }
    public void setTamano(String tamano){
        this.tamano=tamano;
    }
    public void setMarca(String marca){
        this.marca=marca;
    }
    public void setPrecio(double precio){
        this.precio=precio;
    }
    public void setOferta(String oferta){
        this.oferta=oferta;
    }
    public void setTienda(String tienda){
        this.tienda=tienda;
    }
    public void setColonia(String colonia){
        this.colonia=colonia;
    }
    public void setCalle(String calle){
        this.calle=calle;
    }
    public void setNumero(String numero){
        this.numero=numero;
    }
    //Constructor
    public Tabla(   
        String producto, String tamano, String marca, 
        double precio, String oferta, String tienda, 
        String colonia, String calle, String numero
    ){
        this.setProducto(producto);
        this.setMarca(marca);
        this.setTamano(tamano);
        this.setPrecio(precio);
        this.setOferta(oferta);
        this.setTienda(tienda);
        this.setColonia(colonia);
        this.setCalle(calle);
        this.setNumero(numero);
    }
    //Metodo toString
    @Override
    public String toString() {
        return 
            "\nProducto: "+getProducto()+
            "\nMarca: "+getMarca()+
            "\nTamaño: "+getTamano()+
            "\nPrecio: "+getPrecio();
    }
}