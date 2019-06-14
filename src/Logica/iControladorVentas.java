/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.List;

/**
 *
 * @author jp
 */
public interface iControladorVentas {

    public abstract List<producto> obtenerProductos();

    public abstract void cargarproductos();

    public abstract producto obtenerProductoporCodigo(String codigo);

    public abstract float calcularpreciototal(List<producto> listaventa);

    public abstract List<producto> ListarProductos();

    public abstract boolean EliminarProducto(String codigo);

    public abstract boolean ModificarProducto(producto p);

    public abstract producto ObtenerProducto(String codigo);

    public abstract boolean AltaVenta(List<producto> listaventa);

    public abstract List<producto> productosaVender();

    public abstract void setaVender(String codigo);

    public abstract void eliminaraVender(String codigo);

    public abstract void limpiarVenta();

    public void setRutaGuardarimgProductos(String rutaGuardarimgProductos);

    public String getRutaGuardarimgProductos();
}
