package com.uv.bbasket.model;

public class Direccion {
    private int id, entidad, tienda;
    private String ciudad, colonia, calle, numero, codigoPostal;
    public void setId(int id){
        this.id=id;
    }
    public void setEntidad(int entidad){
        this.entidad=entidad;
    }
    public void setTienda(int tienda){
        this.tienda=tienda;
    }
    public void setCiudad(String ciudad){
        this.ciudad=ciudad;
    }
    public void setColonia(String colonia){
        this.colonia=colonia;
    }
    public void setCalle(String calle){
        this.calle=calle;
    }
    public void setNumero(String  numero){
        this.numero=numero;
    }
    public void setCP(String codigoPostal){
        this.codigoPostal=codigoPostal;
    }
    public int getId(){
        return this.id;
    }
    public int getEntidad(){
        return this.entidad;
    }
    public int getTienda(){
        return this.tienda;
    }
    public String getCiudad(){
        return this.ciudad;
    }
    public String getCalle(){
        return this.calle;
    }
    public String getColonia(){
        return this.colonia;
    }
    public String getNumero(){
        return this.numero;
    }
    public String getCP(){
        return this.codigoPostal;
    }
    public Direccion (int id, int entidad, int tienda, String ciudad,String colonia, String calle, String numero, String cp){
        this.setId(id);
        this.setEntidad(entidad);
        this.setTienda(tienda);
        this.setCiudad(ciudad);
        this.setColonia(colonia);
        this.setCalle(calle);
        this.setNumero(numero);
        this.setCP(cp);
    }
}
