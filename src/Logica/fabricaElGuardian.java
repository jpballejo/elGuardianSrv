/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Persistencia.persistencia;
import Servicios.WSContCliente;
import Servicios.WSContReserva;
import Servicios.WSContVentas;
import java.net.URL;

/**
 *
 * @author jp
 */
public class fabricaElGuardian {

    private static fabricaElGuardian instance;

    iControladorCliente iCC = controladorCliente.getInstance();
    iControladorVentas iCV = ControladorVentas.getInstance();
    IControlerProperties iCP = ControladorProperties.getInstance();
    iControladorServicios iCS = controladorServicios.getInstance();
    iControladorReservas iCR = ControladorReservas.getInstance();
    persistencia perInstance = persistencia.getInstance();
    utilidades util = utilidades.getInstance();
    WSContCliente WSCC = null;
    WSContReserva WSCR = null;
    WSContVentas WSCV = null;

    public static fabricaElGuardian getInstance() {
        if (instance == null) {
            instance = new fabricaElGuardian();
        }
        return instance;
    }

    private fabricaElGuardian() {

    }

    public iControladorCliente getInstanceIControladorCliente() {
        return iCC;
    }

    public persistencia getInstancePersistencia() {
        return perInstance;
    }

    public iControladorVentas getInstanceIControladorVentas() {
        return iCV;
    }

    public IControlerProperties getInstanceIControladorProperties() {
        return iCP;
    }

    public iControladorServicios getInstanceIControladorServicios() {
        return iCS;
    }

    public iControladorReservas getInstanceIControladorReservas() {
        return iCR;
    }

    public boolean cargarInicio() {

        if (iCP.levantarProperties() != null) {
            iCC.setRutaFotoImagenesMascotaLevantar(iCP.getRutaImgMascota());
            iCV.setRutaImgProducto(iCP.getRutaImgProducto());
            utilidades.setUsername(iCP.getCorreo());
            utilidades.setPassword(iCP.getContraseña());
            levantarWebServices();
            iCV.cargarproductos();
            iCC.cargarListaImagenesGaleriaBD();
            return true;
        }

        return false;
    }

    public boolean levantarWebServices() {
        try {
            System.out.println("Levantar WebServices inicio");
            System.err.println("--------------------------------------");
            WSCC = new WSContCliente(iCP.getWSContCliente());
            WSCR = new WSContReserva(iCP.getWSContReserva());
            WSCV = new WSContVentas(iCP.getWSContVentas());
            WSCC.publicar();
            System.out.println("Levante Web Service ContCliente en: " + iCP.getWSContCliente() + "?wsdl");
            WSCR.publicar();
            System.out.println("Levante Web Service ContReserva en: " + iCP.getWSContReserva() + "?wsdl");
            WSCV.publicar();
            System.out.println("Levante Web Service ContVenta en: " + iCP.getWSContVentas() + "?wsdl");
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    public boolean bajarWebServices() {
        try {
            System.out.println("Bajando servicios...");
            if (!WSCC.despublicar()) {
                return false;
            }
            if (!WSCR.despublicar()) {
                return false;
            }
            if (!WSCV.despublicar()) {
                return false;
            }
            System.out.println("Servicios offline...");
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    public void reload() {
        if (iCP.levantarProperties() != null) {
            iCC.setRutaFotoImagenesMascotaLevantar(iCP.getRutaImgMascota());
            iCV.setRutaImgProducto(iCP.getRutaImgProducto());
            util.setUsername(iCP.getCorreo());
            util.setPassword(iCP.getContraseña());
            bajarWebServices();
            levantarWebServices();

        }

    }
}
