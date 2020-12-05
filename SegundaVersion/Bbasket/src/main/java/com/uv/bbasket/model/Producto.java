package com.uv.bbasket.model;

public class Producto {
    private int id;
    private String nombre;
    private String tamano;

    public int getId(){
        return this.id;
    }
    public String getNombre(){
        return this.nombre;
    }
    public String getTamano(){
        return this.tamano;
    }
    public void setId(int id){
        this.id=id;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public void setTamano(String tamano){
        this.tamano=tamano;
    }
    public Producto(int id, String nombre, String tamano){
        this.setId(id);
        this.setNombre(nombre);
        this.setTamano(tamano);
    }
    @Override
    public String toString() {
        return "\nID: "+getId()+" \nProducto: "+getNombre()+" "+"\nTamaño: "+getTamano();
    }
}
