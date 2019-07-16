/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Persistencia.ventaPersistencia;
import java.util.Iterator;

/**
 *
 * @author jp
 */
import Persistencia.persistencia;
import Persistencia.productoPersistencia;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;

public class ControladorVentas implements iControladorVentas {
    
    private static ControladorVentas instance = null;
    persistencia per = persistencia.getInstance();
    ventaPersistencia ventapersist = ventaPersistencia.getventaPersisInstace();
    List<producto> productos;
    List<producto> avender = new ArrayList<>();
    private String ruta = Paths.get(System.getProperty("user.dir")).getParent().getParent().toString();
    private String rutaGuardarimgProductos = ruta + "/GuardianWeb/GuardianWeb/web/img/imgprod/";
    private String rutaGuardarimgProductosSrv = System.getProperty("user.dir") + "/ImagenesProducto/";
    private String rutaGuardarimgGaleria = ruta + "/GuardianWeb/GuardianWeb/web/img/galeria/";
    private String rutaImgProducto;
    private HashMap<Integer, String> estadosProductos = null;
    private HashMap<Long, producto> productosStock = new HashMap<>();
    
    public ControladorVentas() {
       this.estadosProductos= new HashMap<>();
        this.estadosProductos.put(1, "Stock");
        this.estadosProductos.put(2, "Sin Stock");
        this.estadosProductos.put(3, "Pedido");
    }
    
    public static ControladorVentas getInstance() {
        if (instance == null) {
            instance = new ControladorVentas();
        }
        return instance;
    }
    
    @Override
    public List<producto> productosaVender() {
        return avender;
    }
    
    @Override
    public String getRutaGuardarimgProductosSrv() {
        return rutaGuardarimgProductosSrv;
    }
    
    @Override
    public void setRutaGuardarimgProductosSrv(String rutaGuardarimgProductosSrv) {
        this.rutaGuardarimgProductosSrv = rutaGuardarimgProductosSrv;
    }
    
    @Override
    public void setaVender(Long codigo) {
        producto p = ObtenerProducto(codigo);
        this.avender.add(p);
    }
    
    @Override
    public void eliminaraVender(Long codigo) {
        producto p = ObtenerProducto(codigo);
        this.avender.remove(p);
    }
    
    @Override
    public void limpiarVenta() {
        this.avender.clear();
    }
    
    @Override
    public List<producto> obtenerProductos() {
        return productos;
    }
    
    @Override
    public void cargarproductos() {
        productos = ventapersist.getListaproductos();
        for (int x = productos.size() - 1; x >= 0; x--) {
            producto produ = (producto) productos.get(x);
            // produ.setCantidad(1);
        }
    }
    
    @Override
    public producto obtenerProductoporCodigo(String codigo) {
        producto p = new producto();
        Iterator it = this.productos.iterator();
        while (it.hasNext()) {
            producto p2 = (producto) it.next();
            if (p2.getCodigo().equals(codigo)) {
                p = p2;
                break;
            }
        }
        return p;
    }
    
    public float calcularpreciototal(List<producto> listaventa) {
        float preciototal = 0;
        Iterator it = listaventa.iterator();
        while (it.hasNext()) {
            producto p = (producto) it.next();
            preciototal = preciototal + (p.getPrecio() * p.getCantidad());
        }
        return preciototal;
    }
    private productoPersistencia prodPer = new productoPersistencia();
    EntityManager em = persistencia.getInstance().getEm();
    
    @Override
    public List<producto> ListarProductos() {
        
        List<producto> lista = null;
        lista = prodPer.ObtenerListaProductos();
        
        return lista;
    }
    
    @Override
    public boolean EliminarProducto(Long codigo) {
        
        boolean ok = false;
        producto p = this.ObtenerProducto(codigo);
        ok = persistencia.getInstance().eliminar(p);
        
        return ok;
    }
    
    @Override
    public boolean ModificarProducto(producto p) {
        
        boolean ok = false;
        ok = persistencia.getInstance().modificar(p);
        
        return ok;
    }
    
    @Override
    public producto ObtenerProducto(Long codigo) {
        
        producto p = prodPer.ObtenerProducto(codigo);
        return p;
        
    }
    
    @Override
    public boolean AltaVenta(List<detalleVenta> listaventa, cliente c) {
        venta v = new venta();
        Date fecha = new Date();
        v.setFecha(fecha);
        
        for (int x = listaventa.size() - 1; x >= 0; x--) {
            
            detalleVenta dv = (detalleVenta) listaventa.get(x);
            //dv.setCantidad(produ.getCantidad());
            dv.setPrecioTotalProductos(dv.getProducto().getPrecio() * dv.getCantidad());
            v.getDetalles().add(dv);
            producto produ = dv.getProducto();
            
            int stock = produ.getCantidad() - dv.getCantidad();
            produ.setCantidad(stock);
            
            if (stock == 0) {
                produ.setDisponible(false);
            }
            
            Persistencia.persistencia.getInstance().persis(dv);
            Persistencia.productoPersistencia.getInstance().modificar(produ);
        }
        
        boolean ok = Persistencia.persistencia.getInstance().persis(v);
        c.setVenta(v);
        
        try {
            GenerarPDF gpdf = new GenerarPDF(c);
            gpdf.createPdf();
            c.setVenta(null);
            return true;
        } catch (IOException ex) {
            Logger.getLogger(ControladorVentas.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    
    @Override
    public String getRutaGuardarimgProductos() {
        return rutaGuardarimgProductos;
    }
    
    @Override
    public void setRutaGuardarimgProductos(String rutaGuardarimgProductos) {
        this.rutaGuardarimgProductos = rutaGuardarimgProductos;
    }
    
    @Override
    public boolean finalizarVenta(cliente c) {
        
        try {
//            List<producto> prodsventa = new ArrayList<>();
            List<detalleVenta> Productosavender = (List<detalleVenta>) c.getCompra().getDetalles();
            
            GenerarPDF gpdf = new GenerarPDF(c);
            gpdf.createPdf();
            return true;
        } catch (IOException ex) {
            Logger.getLogger(ControladorVentas.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    
    @Override
    public String getRutaImgProducto() {
        return rutaImgProducto;
    }
    
    @Override
    public void setRutaImgProducto(String rutaImgProducto) {
        this.rutaImgProducto = rutaImgProducto;
    }
    
    @Override
    public String getRutaGuardarimgGaleria() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void setRutaGuardarimgGaleria(String rutagaleria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean altaProveedor(proveedor p) {
        try {
            if (!per.existe(p)) {
                return per.persis(p);
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage() + " Causa: " + e.getCause());
        }
        return false;
    }
    
    @Override
    public boolean modificarProveedor(proveedor p) {
        try {
            if (per.existe(p)) {
                return per.modificar(p);
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage() + " Causa: " + e.getCause());
        }
        return false;
    }
    
    @Override
    public boolean eliminarProveedor(Long id) {
        try {
            return per.eliminar(per.getObjeto(id, proveedor.class));
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage() + " Causa: " + e.getCause());
        }
        
        return false;
    }
    
    @Override
    public boolean agregarProductoAProveedor(producto p, Long idProveedor) {
        if (per.existe(p)) {
            if (per.getObjeto(idProveedor, proveedor.class) != null) {
                proveedor prov = (proveedor) per.getObjeto(idProveedor, proveedor.class);
                return prov.addProducto(p);
            }
        }
        return false;
    }
    
    @Override
    public List getProveedores() {
        List<Object> listaObjetos = per.getListaObjetos("select * from proveedor", proveedor.class);
        List<proveedor> proveedores = new ArrayList<>();
        for (Object obj : listaObjetos) {
            proveedores.add((proveedor) obj);
        }
        return proveedores;
    }
    
    @Override
    public proveedor getProveedor(Long id) {
        return (proveedor) per.getObjeto(id, proveedor.class);
    }
    
    @Override
    public boolean agregarProductosAProveedor(Long idProveedor, List<producto> productosAgregar) {
        if (per.getObjeto(idProveedor, proveedor.class) != null) {
            proveedor p = (proveedor) per.getObjeto(idProveedor, proveedor.class);
            return p.addAllProductos(productos);
            
        }
        return false;
    }
    
    @Override
    public boolean altaProducto(producto p) {
        try {
            if (!per.existe(p)) {
                return per.persis(p);
            }
            
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage() + " Causa: " + e.getCause());
        }
        return false;
    }
    
    @Override
    public producto getProducto(Long id) {
        return (producto) per.getObjeto(id, producto.class);
    }
    
    @Override
    public List<producto> getProductosDisponibles() {
        List<Object> listaObjetos = per.getListaObjetos("select * from producto where cantidad>= 1", producto.class);
        List<producto> productos = new ArrayList<>();
        for (Object obj : listaObjetos) {
            productos.add((producto) obj);
        }
        return productos;
    }
    
    @Override
    public List<producto> getProductosAgotados() {
        List<Object> listaObjetos = per.getListaObjetos("select * from producto where cantidad= 0", producto.class);
        List<producto> productos = new ArrayList<>();
        for (Object obj : listaObjetos) {
            productos.add((producto) obj);
        }
        return productos;
    }
    
    @Override
    public List<producto> getProductosTotales() {
        List<Object> listaObjetos = per.getListaObjetos("select * from producto", producto.class);
        List<producto> productos = new ArrayList<>();
        for (Object obj : listaObjetos) {
            productos.add((producto) obj);
        }
        return productos;
    }
    
    @Override
    public List<producto> getProductosXproveedor(Long id) {
        //revisar campor id_proveedor
        List<Object> listaObjetos = per.getListaObjetos("select * from producto where proveedor_id= " + id + " ", producto.class);
        List<producto> prods = new ArrayList<>();
        for (Object obj : listaObjetos) {
            prods.add((producto) obj);
        }
        return prods;
    }
    
    @Override
    public boolean setearEstadoProducto(Long id, int est) {
        producto p = (producto) per.getObjeto(id, producto.class);
        if (p != null) {
            p.setEstado(this.estadosProductos.get(est));
            if (est == 1) {
                p.setDisponible(true);
            } else {
                p.setDisponible(false);
            }
            return true;
        }
        return false;
    }
    
    @Override
    public void setearEstadoProductos(List<Long> ids, int est) {
        for (Long id : ids) {
            this.setearEstadoProducto(id, est);
        }
        
    }
    
    @Override
    public String getEstado(int est) {
        return this.estadosProductos.get(est);
    }
    
    @Override
    public boolean agregarVenta(venta v) {
        if (!per.existe(v)) {
            return per.persis(v);
        }
        return false;
    }
    
    @Override
    public boolean eliminarVenta(long id) {
        if (per.getObjeto(id, venta.class) != null) {
            return per.eliminar(per.getObjeto(id, venta.class));
        }
        return false;
    }
    
    @Override
    public boolean controlarStock(HashMap<Long, Integer> productoCantidad) {
        producto p = null;
        for (Long key : productoCantidad.keySet()) {
            p = (producto) per.getObjeto(key, producto.class);
            int cant = p.getCantidad();
            cant -= productoCantidad.get(key);
            if (cant > 0) {
                p.setCantidad(cant);
                
            } else {
                if (cant == 0) {
                    p.setCantidad(cant);
                    p.setDisponible(false);
                    p.setEstado(estadosProductos.get(2));
                }
            }
        }
        return per.modificar(p);
    }
    
    @Override
    public boolean setearNuevaCantidadAlStockActual(HashMap<Long, Integer> cantidadesN) {
        cargarDiccionarioProductosStock();
        for (Long key : cantidadesN.keySet()) {
            setearCantidadYcontrolar(this.productosStock.get(key), cantidadesN.get(key));
        }
        return true;
    }
    
    private void cargarDiccionarioProductosStock() {
        List<producto> productosTotales = getProductosTotales();
        productosStock.clear();
        for (producto p : productosTotales) {
            productosStock.put(p.getCodigo(), p);
            
        }
        
    }
    
    private void setearCantidadYcontrolar(producto p, Integer cant) {
        int cantidadAc = p.getCantidad();
        cantidadAc += cant;
        p.setCantidad(cantidadAc);
        if (p.getCantidad() > 0) {
            p.setEstado(getEstado(1));
            p.setDisponible(true);
        }
        per.modificar(p);
        
    }
}
