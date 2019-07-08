/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import ListServicios.ListMascota;
import Logica.cliente;
import Logica.fabricaElGuardian;
import javax.annotation.Resource;
import javax.annotation.Resources;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;
import javax.xml.ws.WebServiceContext;

/**
 *
 * @author jp
 */
@WebService(serviceName = "ServicioContCliente")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class WSContCliente {

    @Resource
    private WebServiceContext context;
    private Endpoint endpoint = null;
    private String direccion;

    public WSContCliente(String direccionV) {
        this.direccion = direccionV;
    }

    public boolean despublicar() {
        try {
            endpoint.stop();
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }

    }

    public void publicar() {
        try {
            endpoint = Endpoint.publish(direccion, this);
            System.out.println("Publique servicio: WSContCliente: " + direccion);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

////////////////////////////////////WEBMETHOD's/////////////////////////////
///////////////////////////////CLIENTE//////////////////////////////////////    
    @WebMethod
    public cliente obtenerCliente(@WebParam(name = "email") String email) {
        System.out.println(email);
        cliente cli= fabricaElGuardian.getInstance().getInstanceIControladorCliente().getCliente(email);
        System.out.println(cli);
        return cli;
    }

    @WebMethod
    public void AgregarCliente(@WebParam(name = "cedula") String cedula, @WebParam(name = "nombre") String nombre, @WebParam(name = "apellido") String apellido, @WebParam(name = "correo") String correo, @WebParam(name = "telefono") String telefono, @WebParam(name = "direccion") String direccion, @WebParam(name = "hash") String hash) {

        cliente clie = new cliente();
        clie.setCedula(cedula);
        clie.setNombre(nombre);
        clie.setApellido(apellido);
        clie.setCorreo(correo);
        clie.setTel_cel(telefono);
        clie.setDireccion(direccion);
        clie.setPassword(hash);
        System.out.println(clie);
        fabricaElGuardian.getInstance().getInstanceIControladorCliente().altaClienteWeb(clie);
    }

    @WebMethod
    public boolean resetearPassword(@WebParam(name = "email") String email) {
        return fabricaElGuardian.getInstance().getInstanceIControladorCliente().resetearPassword(email);
    }
    ////++++++//////////////+++++++++++++////////////+++++++++++///////////+++++/

    ///////////////////////////////ANIMAL////////////////////////////////////// 
    @WebMethod
    public ListMascota getMascotas() {

        return null;
    }

    ////++++++//////////////+++++++++++++////////////+++++++++++///////////+++++/
    ///////////////////////////////****////////////////////////////////////// 
    ////++++++//////////////+++++++++++++////////////+++++++++++///////////+++++/
    ///////////////////////////////****////////////////////////////////////// 
    ////++++++//////////////+++++++++++++////////////+++++++++++///////////+++++/
    ///////////////////////////////****////////////////////////////////////// 
    ////++++++//////////////+++++++++++++////////////+++++++++++///////////+++++/
    ///////////////////////////////****////////////////////////////////////// 
    ////++++++//////////////+++++++++++++////////////+++++++++++///////////+++++/
}
