/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

/**
 *
 * @author jp
 */
public class ControladorProperties implements IControlerProperties {

    private static ControladorProperties instance = null;

    public static ControladorProperties getInstance() {
        if (instance == null) {
            instance = new ControladorProperties();
        }
        return instance;
    }
//////////VARIABLES WS////////////////

    String WSContCliente = null;
    String WSContReserva = null;
    String WSContVentas = null;

    public String getWSContCliente() {
        return WSContCliente;
    }

    public String getWSContReserva() {
        return WSContReserva;
    }

    public String getWSContVentas() {
        return WSContVentas;
    }

/////////////////////////////////////
    ///Variables properties///
    private String ip;

    private String puerto;

    private String nomWSCliente;

    private String nomWSReserva;

    private String nomWSVentas;

    private String correo;

    private String rutaImgMascota;

    private String rutaImgProducto;

    private String contraseña;

    /////////////////////////
    private static Properties propiedades = null;
    ArrayList<String> clavesPropiedades = new ArrayList<>();
    HashMap<String, String> configProp = new HashMap<>();

    public ArrayList<String> getClavesPropiedades() {
        return clavesPropiedades;
    }

    public void setClavesPropiedades(ArrayList<String> clavesPropiedades) {
        this.clavesPropiedades = clavesPropiedades;
    }

    public HashMap<String, String> getConfigProp() {
        return configProp;
    }

    public void setConfigProp(HashMap<String, String> configProp) {
        this.configProp = configProp;
    }

    private void armarDirWservices() {

        /*URL = "http://" + prop.getProperty("Ip") + ":" + prop.getProperty("Porth") + "/servicio" + prop.getProperty(caso);*/
        this.WSContCliente = "http://" + getIp() + ":" + getPuerto() + "/servicio" + getNomWSCliente();
        this.WSContReserva = "http://" + getIp() + ":" + getPuerto() + "/servicio" + getNomWSReserva();
        this.WSContVentas = "http://" + getIp() + ":" + getPuerto() + "/servicio" + getNomWSVentas();
    }

    public void crearProperties() {
        System.out.println("crearProperties-inicio");
        Properties prop = new Properties();
        OutputStream output = null;
        try {
            output = new FileOutputStream("ElGuardianConf.properties");
            prop.setProperty("ip", ip);
            prop.setProperty("puerto", puerto);
            prop.setProperty("rutaImgMascota", rutaImgMascota);
            prop.setProperty("rutaImgProducto", rutaImgProducto);
            prop.setProperty("correo", correo);
            prop.setProperty("contrasenia", contraseña);
            prop.setProperty("servicioC", nomWSCliente);
            prop.setProperty("servicioR", nomWSReserva);
            prop.setProperty("servicioV", nomWSVentas);
            System.out.println("crearProperties-salvando:.properties");
            prop.store(output, null);
            System.out.println("crearProperties-final");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }

    public Properties levantarProperties() {
        InputStream in = null;
        Properties prop = new Properties();
        System.out.println("levantarProperties inicio...");
        try {

            String ruta = ControladorProperties.class.getResource("").getPath();

            in = new FileInputStream(dameArchivo(ruta));
            prop.load(in);

            if (propertiesValido(prop)) {
                propiedades = prop;
                //setearPropiesdades();
                Iterator it = prop.keySet().iterator();
                System.out.println("Properties claves cargadas: ");
                while (it.hasNext()) {
                    String key = (String) it.next();
                    clavesPropiedades.add(key);
                    addDiccionarioProp(key, prop.getProperty(key));
                    System.out.println(key);

                }
                       setearPropiesdades();
                System.out.println("carga finalizada");
            } else {
                System.err.println("Properties invalido");
            }

        } catch (Exception e) {
            System.err.println("levantarProperties: " + e.getMessage());
        }

        return prop;
    }

    private boolean setearPropiesdades() {
        try {
            System.out.println("setearPropiedades inicio...");
            setIp(configProp.get("ip"));
            setPuerto(configProp.get("puerto"));
            setRutaImgMascota(configProp.get("rutaImgMascota"));
            setRutaImgProducto(configProp.get("rutaImgProducto"));
            setCorreo(configProp.get("correo"));
            setContraseña(configProp.get("contrasenia"));
            setNomWSCliente(configProp.get("servicioC"));
            setNomWSReserva(configProp.get("servicioR"));
            setNomWSVentas(configProp.get("servicioV"));
            armarDirWservices();
            System.out.println("setearPropiedades finalizo...");
        } catch (Exception e) {
            System.err.println("setearPropiedades: " + e.getMessage() + " " + e.getCause());
        }
        return false;
    }

    public Properties leerProperties(String ruta) {
        Properties prop = new Properties();
        InputStream in = null;
        try {
            if (cadenaOk(ruta)) {
                in = new FileInputStream(ruta);
                if (in.available() >= 0) {
                    prop.load(in);
                    Iterator it = prop.keySet().iterator();
                    while (it.hasNext()) {
                        String key = (String) it.next();
                        System.out.println(key);
                    }
                }
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return prop;
    }

    private boolean cadenaOk(String cadena) {
        if (cadena.isEmpty()) {
            return false;
        }
        if (cadena == null) {
            return false;
        }
        if (cadena.equals("")) {
            return false;
        }
        if (cadena.equals("null")) {
            return false;
        }
        if (cadena.length() <= 1) {
            return false;
        }
        if (cadena.equals(" ")) {
            return false;
        }
        return true;
    }

    /**
     * @return the propiedades
     */
    public static Properties getPropiedades() {

        return propiedades;
    }

    public boolean setPropiedades(Properties propieda) {
        if (propertiesValido(propieda)) {
            propiedades = propieda;
            setearPropiesdades();

            return true;
        }
        return false;
    }

    public boolean propertiesValido(Properties prope) {
        for (int i = 0; i < clavesPropiedades.size(); i++) {
            String key = clavesPropiedades.get(i);
            if (prope.containsKey(key) != true) {
                return false;
            }
        }
        return true;
    }

    public HashMap getPropiedadesString() {
        return this.configProp;
    }

    private void addDiccionarioProp(String clave, String valor) {
        configProp.put(clave, valor);
    }

    private void cambiarDiccionarioProp(String key, String nuevoValor) {
        configProp.replace(key, nuevoValor);
    }

    public boolean recibeDiccPropiedades(HashMap<String, String> diccprop) {
        System.out.println("Recibi el diccionario");
        try {
            Properties nuevo = new Properties();
            Iterator it = diccprop.keySet().iterator();
            while (it.hasNext()) {
                String key = (String) it.next();
                nuevo.setProperty(key, (String) diccprop.get(key));
            }
            propiedades = nuevo;
            setearPropiesdades();
            crearProperties();
            System.out.println("Lo setee y lo guarde");
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }

    }

    public HashMap levantarYCargar(String ruta) {
        System.out.println("levantarYCargar inicio...");
        HashMap<String, String> dicTemp = new HashMap<>();
        Properties p = null;
        try {
            p = (Properties) leerProperties(ruta);
            if (propertiesValido(p)) {
                System.out.println("Properties valido");
                Iterator it = p.keySet().iterator();
                while (it.hasNext()) {
                    String key = (String) it.next();
                    dicTemp.put(key, (String) p.getProperty(key));
                    System.out.println(key + ":" + (String) p.getProperty(key));
                }
            } else {
                System.err.println("Properties invalido");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        System.out.println("Finalizo levantarYCargar...");
        return dicTemp;
    }

    private String generaPathProperties(String cadena) {
        System.out.println("Ruta recibida: " + cadena);
        String path = "/";
        try {
            String[] subCadena = cadena.split("/");
            // int largo = subCadena.length;
            for (int i = 1; i < subCadena.length - 3; i++) {
                path += subCadena[i] + "/";
                System.out.println(subCadena[i]);

            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        System.out.println("ruta: " + path);
        return path;
    }

    private File dameArchivo(String path) {
        String ruta = generaPathProperties(path);
        File retorno = walking(new File(path));
        if (retorno != null) {
            return retorno;
        }
        return dameArchivo(ruta);

    }

    private File walking(File dir) {
        File listFile[] = dir.listFiles();
        if (listFile != null && listFile.length > 0) {
            for (int i = 0; i < listFile.length; i++) {
                if (listFile[i].isFile()) {
                    if (listFile[i].getName().equals("ElGuardianConf.properties")) {
                        return (File) listFile[i];
                    }
                }

            }
            for (int i = 0; i < listFile.length; i++) {
                if (listFile[i].isDirectory()) {
                    walking(listFile[i]);
                }
            }
        }
        return null;
    }

/////////////////////////////////////////SETTER Y GETTER VARIABLES////////////////////////////////////
    public String getIp() {
        if (ip.equals("AUTO")) {
            return utilidades.getInstance().getIpLocalHost();
        } else {
            return ip;
        }
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPuerto() {
        return puerto;
    }

    public void setPuerto(String puerto) {
        this.puerto = puerto;
    }

    public String getRutaImgMascota() {
        return rutaImgMascota;
    }

    public void setRutaImgMascota(String rutaImgMascota) {
        this.rutaImgMascota = rutaImgMascota;
    }

    public String getRutaImgProducto() {
        return rutaImgProducto;
    }

    public void setRutaImgProducto(String rutaImgProducto) {
        this.rutaImgProducto = rutaImgProducto;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public String getNomWSCliente() {
        return nomWSCliente;
    }

    public void setNomWSCliente(String nomWSCliente) {
        this.nomWSCliente = nomWSCliente;
    }

    public String getNomWSReserva() {
        return nomWSReserva;
    }

    public void setNomWSReserva(String nomWSReserva) {
        this.nomWSReserva = nomWSReserva;
    }

    public String getNomWSVentas() {
        return nomWSVentas;
    }

    public void setNomWSVentas(String nomWSVentas) {
        this.nomWSVentas = nomWSVentas;
    }
}
