package com.uv.bbasket.model;

public class TablaIndex {
    private int id;
    private String producto;
    private String tamano;
    private Double precio;
    private String colonia;
    private String tiendaNombre;
    public TablaIndex(int id, String producto, String tamano, Double precio, String colonia, String tiendaNombre){
        this.setId(id);
        this.setProducto(producto);
        this.setTamano(tamano);
        this.setPrecio(precio);
        this.setColonia(colonia);
        this.setTiendaNombre(tiendaNombre);
    }
    public void setId(int id){
        this.id=id;
    }
    public void setProducto(String producto){
        this.producto=producto;
    }
    public void setTamano(String tamano){
        this.tamano=tamano;
    }
    public void setPrecio(Double precio){
        this.precio=precio;
    }
    public void setColonia(String colonia){
        this.colonia=colonia;
    }
    public void setTiendaNombre(String tiendaNombre){
        this.tiendaNombre=tiendaNombre;
    }
    public int getId(){
        return this.id;
    }
    public String getProducto (){
        return this.producto;
    }
    public String getTamano(){
        return this.tamano;
    }
    public Double getPrecio(){
        return this.precio;
    }
    public String getColonia(){
        return this.colonia;
    }
    public String getTiendaNombre(){
        return this.tiendaNombre;
    }
}
