package com.uv.bbasket.model;

public class Vista {
    private int id;
    private String nombre;
    private double precio;
    private String tamanio;
    public Vista (int id, String nombre, double precio, String tamanio){
        this.setId(id);
        this.setNombre(nombre);
        this.setPrecio(precio);
        this.setTamanio(tamanio);
    
	}
	public void setId(int id) {
        this.id=id;
	}
    public void setTamanio(String tamanio) { 
        this.tamanio=tamanio;
	}

	public void setPrecio(double precio) { 
        this.precio=precio;
    }

    public void setNombre(String nombre) { 
        this.nombre=nombre;
    }
    public int getId(){
        return id;
    }
    public double getPrecio(){
        return precio;
    }
    public String getNombre(){
        return nombre;
    }
    public String getTamanio(){
        return tamanio;
    }
}
