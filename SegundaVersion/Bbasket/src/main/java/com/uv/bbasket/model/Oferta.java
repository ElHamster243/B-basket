package com.uv.bbasket.model;

public class Oferta {
    private int id;
    private int cantidad;
    private double precio;

    public int getId(){
        return this.id;
    }
    public int getCantidad(){
        return this.cantidad;
    }
    public double getPrecio(){
        return this.precio;
    }
    public void setId(int id){
        this.id=id;
    }
    public void setCantidad(int cantidad){
        this.cantidad=cantidad;
    }
    public void setPrecio(double precio){
        this.precio=precio;
    }
    public Oferta (int id, int cantidad, double precio){
        this.setId(id);
        this.setCantidad(cantidad);
        this.setPrecio(precio);
    }
    @Override
    public String toString() {
        return "\nID: "+getId()+" \nCantidad: "+getCantidad()+" "+"\nPrecio: "+getPrecio();
    }
}
