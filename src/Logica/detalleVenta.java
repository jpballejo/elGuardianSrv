/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author jp
 */
@Entity
public class detalleVenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany
    private List<producto> listaProducto;
//estos dos atributos se pueden calcular de la lista
    private float precioTotalProductos;

    private int cantidad;
    
    

    public detalleVenta() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<producto> getListaProducto() {
        return listaProducto;
    }

    public void setListaProducto(List<producto> listaProducto) {
        this.listaProducto = listaProducto;
    }

    public float getPrecioTotalProductos() {
        return precioTotalProductos;
    }

    public void setPrecioTotalProductos(float precioTotalProductos) {
        this.precioTotalProductos = precioTotalProductos;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.listaProducto);
        hash = 97 * hash + Float.floatToIntBits(this.precioTotalProductos);
        hash = 97 * hash + this.cantidad;
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
        final detalleVenta other = (detalleVenta) obj;
        if (Float.floatToIntBits(this.precioTotalProductos) != Float.floatToIntBits(other.precioTotalProductos)) {
            return false;
        }
        if (this.cantidad != other.cantidad) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.listaProducto, other.listaProducto)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "detalleVenta{" + "id=" + id + ", listaProducto=" + listaProducto + ", precioTotalProductos=" + precioTotalProductos + ", cantidad=" + cantidad + '}';
    }

}
