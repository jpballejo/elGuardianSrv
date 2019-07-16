/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author jp
 */
@Entity
public class proveedor implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombreProveedor;
    private String RUT;
    private String direccion;
    private String correo;
    private String numeroTelCel;

    @OneToMany(cascade = CascadeType.ALL)
    private List<producto> productos = new ArrayList<>();
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    @Override
    public String toString() {
        return "id/=" + id + "/RUT/" + RUT + "/direccion/" + direccion + "/correo/" + correo + "/numeroTelCel/" + numeroTelCel;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
        hash = 37 * hash + Objects.hashCode(this.RUT);
        hash = 37 * hash + Objects.hashCode(this.direccion);
        hash = 37 * hash + Objects.hashCode(this.correo);
        hash = 37 * hash + Objects.hashCode(this.numeroTelCel);
        return hash;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final proveedor other = (proveedor) obj;
        if (!Objects.equals(this.RUT, other.RUT)) {
            return false;
        }
        if (!Objects.equals(this.direccion, other.direccion)) {
            return false;
        }
        if (!Objects.equals(this.correo, other.correo)) {
            return false;
        }
        if (!Objects.equals(this.numeroTelCel, other.numeroTelCel)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    public String getNombreProveedor() {
        return nombreProveedor;
    }
    
    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }
    
    public List<producto> getProductos() {
        return productos;
    }
    
    public void setProductos(List<producto> productos) {
        this.productos = productos;
    }
    
    public boolean addProducto(producto p) {
        return this.productos.add(p);
    }
    
    public boolean addAllProductos(List<producto> productos) {
        return this.productos.addAll(productos);
    }
    
    public String getRUT() {
        return RUT;
    }
    
    public void setRUT(String RUT) {
        this.RUT = RUT;
    }
    
    public String getDireccion() {
        return direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public String getCorreo() {
        return correo;
    }
    
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public String getNumeroTelCel() {
        return numeroTelCel;
    }
    
    public void setNumeroTelCel(String numeroTelCel) {
        this.numeroTelCel = numeroTelCel;
    }
    
}
