package com.uv.bbasket.model;

public class Tienda {
    private int id;
    private String nombre;
    private int entidad;
    private String ciudad;
    private String colonia;
    private String calle;
    private String numero;
    private String coPo;
    private int tipo;
    private String passwd;
    private int comprador; 
    public Tienda(int id, String nombre, int entidad, String ciudad, String colonia, String calle, String numero, String coPo, int tipo, String passwd, int comprador){
        this.setId(id);
        this.setEntidad(entidad);
        this.setTipo(tipo);
        this.setComprador(comprador);
        this.setNombre(nombre);
        this.setCiudad(ciudad);
        this.setColonia(colonia);
        this.setCalle(calle);
        this.setNumero(numero);
        this.setCoPo(coPo);
        this.setPassword(passwd);
    }
    //Setters
    public void setId       (int id)          {        this.id=id;                }
    public void setEntidad  (int entidad)     {        this.entidad=entidad;      }
    public void setTipo     (int tipo)        {        this.tipo=tipo;            }
    public void setComprador(int comprador)   {        this.comprador=comprador;  }
    public void setPassword (String passwd)   {        this.passwd=passwd;        }
    public void setCoPo     (String coPo)     {        this.coPo=coPo;            }
    public void setNumero   (String numero)   {        this.numero=numero;        }
    public void setCalle    (String calle)    {        this.calle=calle;          }
    public void setColonia  (String colonia)  {        this.colonia=colonia;      }
    public void setCiudad   (String ciudad)   {        this.ciudad=ciudad;        }
    public void setNombre   (String nombre)   {        this.nombre=nombre;        }
    //Getters
    public int    getId         (){ return this.id;         }
    public int    getEntidad    (){ return this.entidad;    }
    public int    getTipo       (){ return this.tipo;       }
    public int    getComprador  (){ return this.comprador;  }
    public String getPasswd     (){ return this.passwd;     }
    public String getCoPo       (){ return this.coPo;       }
    public String getNumero     (){ return this.numero;     }
    public String getCalle      (){ return this.calle;      }
    public String getColonia    (){ return this.colonia;    }
    public String getCiudad     (){ return this.ciudad;     }
    public String getNombre     (){ return this.nombre;     }
}
