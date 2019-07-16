/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.HashMap;
import java.util.Properties;

/**
 *
 * @author jp
 */
public interface IControlerProperties {

    public void crearProperties();

    public boolean recibeDiccPropiedades(HashMap<String, String> diccprop);

    public Properties levantarProperties();

    public Properties leerProperties(String ruta);

    public String getIp();

    public String getPuerto();

    public String getRutaImgMascota();

    public String getRutaImgProducto();

    public String getCorreo();

    public String getContraseña();

    public String getNomWSCliente();

    public String getNomWSReserva();

    public String getNomWSVentas();

    public String getWSContCliente();

    public String getWSContReserva();

    public String getWSContVentas();
}
