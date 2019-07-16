/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.HashMap;
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

    public abstract boolean EliminarProducto(Long codigo);

    public abstract boolean ModificarProducto(producto p);

    public abstract producto ObtenerProducto(Long codigo);

    public abstract boolean AltaVenta(List<detalleVenta> listaventa, cliente c);

    public abstract List<producto> productosaVender();

    public abstract void setaVender(Long codigo);

    public abstract void eliminaraVender(Long codigo);

    public abstract void limpiarVenta();

    public abstract void setRutaGuardarimgProductos(String rutaGuardarimgProductos);

    public abstract String getRutaGuardarimgProductos();

    public abstract boolean finalizarVenta(cliente c);

    public abstract String getRutaGuardarimgProductosSrv();

    public abstract void setRutaGuardarimgProductosSrv(String rutaGuardarimgProductosSrv);

    public abstract String getRutaGuardarimgGaleria();

    public abstract void setRutaGuardarimgGaleria(String rutagaleria);

    public abstract void setRutaImgProducto(String rutaImgProducto);

    public abstract String getRutaImgProducto();

    public abstract boolean altaProveedor(proveedor p);

    public abstract boolean modificarProveedor(proveedor p);

    public abstract boolean eliminarProveedor(Long id);

    public abstract boolean agregarProductoAProveedor(producto p, Long idProveedor);

    public abstract List getProveedores();

    public abstract proveedor getProveedor(Long id);

    public abstract boolean agregarProductosAProveedor(Long idProveedor, List<producto> productosAgregar);

    public abstract boolean altaProducto(producto p);

    public abstract producto getProducto(Long id);

    public abstract List<producto> getProductosDisponibles();

    public abstract List<producto> getProductosAgotados();

    public abstract List<producto> getProductosTotales();

    public abstract List<producto> getProductosXproveedor(Long id);

    public abstract boolean setearEstadoProducto(Long id, int est);

    public abstract void setearEstadoProductos(List<Long> ids, int est);

    public abstract String getEstado(int est);

    public abstract boolean agregarVenta(venta v);

    public abstract boolean eliminarVenta(long id);
    
    public abstract boolean controlarStock(HashMap<Long, Integer> productoCantidad);//esta es la clave papu...
    
    public abstract boolean setearNuevaCantidadAlStockActual(HashMap<Long,Integer> cantidadesN);

}
