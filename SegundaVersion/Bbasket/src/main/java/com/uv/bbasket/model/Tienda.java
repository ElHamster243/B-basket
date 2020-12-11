package com.uv.bbasket.model;

public class Tienda {
    private int id;
    private String nombre;
    private int tipo;
    private String passwd;
    private int comprador; 
    public Tienda(int id, String nombre, int tipo, String passwd, int comprador){
        this.setId(id);
        this.setTipo(tipo);
        this.setComprador(comprador);
        this.setNombre(nombre);
        this.setPassword(passwd);
    }
    //Setters
    public void setId       (int id)          {        this.id=id;                }
    public void setTipo     (int tipo)        {        this.tipo=tipo;            }
    public void setComprador(int comprador)   {        this.comprador=comprador;  }
    public void setPassword (String passwd)   {        this.passwd=passwd;        }
    public void setNombre   (String nombre)   {        this.nombre=nombre;        }
    //Getters
    public int    getId         (){ return this.id;         }
    public int    getTipo       (){ return this.tipo;       }
    public int    getComprador  (){ return this.comprador;  }
    public String getPasswd     (){ return this.passwd;     }
    public String getNombre     (){ return this.nombre;     }
}
