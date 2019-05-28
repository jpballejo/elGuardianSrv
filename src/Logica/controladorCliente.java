/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Persistencia.clientePersistencia;
import java.util.ArrayList;
import java.util.HashMap;
import Persistencia.persistencia;
import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.List;
import javax.mail.internet.AddressException;
import ClientesRest.apiCliente;
import Persistencia.animalPersistencia;
import java.util.Iterator;

/**
 * Coontrolador de clientes
 *
 * @author jp
 */
public class controladorCliente implements iControladorCliente {

    /////////////Variables///////////////
    private static controladorCliente instance;
    private utilidades util = utilidades.getInstance();
    private persistencia persistencia = Persistencia.persistencia.getInstance();
    private animalPersistencia aPer = new animalPersistencia();
    private clientePersistencia cPer = new clientePersistencia();
    private apiCliente restCliente = apiCliente.getInstance();
    ////////////Arreglos////////////////
    private HashMap<String, cliente> clientes = new HashMap<>();
    private HashMap<String, mascota> mascotas = new HashMap<>();
    
    public static controladorCliente getInstance() {
        if (instance == null) {
            instance = new controladorCliente();
        }
        return instance;
    }
//////////////////////////////////CLIENTE///////////////////////////////////////

    /**
     * Funcion que retorna un ArrayList con todos los clientes de la DB
     *
     * @return ArrayList
     */
    @Override
    public ArrayList getClientes() {
        
        return (ArrayList<cliente>) cPer.getArregloClientes();
        
    }

    /**
     * Funcion que verifica que sea correcto un email
     *
     * @param email String que contiene el email a verificar
     * @return true or false (dependiendo si la cadena es correcta o no)
     */
    @Override
    public boolean emailValido(String email) {
        return util.emailValido(email);
        
    }

    /**
     * Funcion que elimina un cliente usando la cedula
     *
     * @param cedula
     * @return
     */
    @Override
    public boolean eliminarCliente(String cedula) {
        try {
            
            cliente cli = (cliente) persistencia.getObjeto(cedula, cliente.class);
            
            if (cli != null) {
                return persistencia.eliminar((Object) cli);
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
        
    }

    /**
     * FUncion que genera un String aleatorio como contraseña
     *
     * @return String con la cadena autogenerada
     *
     */
    @Override
    public String generarPassword() {
        SecureRandom random = new SecureRandom();
        String text = new BigInteger(50, random).toString(32);
        return text;
    }

    /**
     * Funcion que retorna un cliente a partir de la cedula, en caso de no
     * encontrar ninguno retorna null
     *
     * @param cedula
     * @return cliente
     */
    @Override
    public cliente getCliente(String cedula) {
        try {
            cliente cli = new cliente();
            cli = (cliente) persistencia.getObjeto(cedula, cliente.class);
            return cli;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    /**
     * Funcion que modifica un cliente
     *
     * @param clieMod
     * @return
     */
    @Override
    public boolean modificarCliente(cliente clieMod) {
        return persistencia.modificar((Object) clieMod);
    }

    /**
     * Funion que resetea el password del cliente
     *
     * @param cedula
     * @return
     */
    @Override
    public boolean resetearPassword(String cedula) {
        try {
            cliente cliPassCambio = this.getCliente(cedula);
            cliPassCambio.setPassword(this.generarPassword());
            if (persistencia.modificar((Object) cliPassCambio)) {
                utilidades.enviarConGMail(cliPassCambio.getCorreo(), "Reseteo de contraseña", "SU contraseña a sido reseteada con exito, puede ingresar al sitio con la siguiente contraseña: " + cliPassCambio.getPassword(), null, null);
                
                return true;
            }
        } catch (MessagingException | AddressException e) {
            System.err.println(e.getMessage());
            return false;
        }
        return false;
        
    }

    /**
     * Funcion que da de alta un cliente en el sistema
     *
     * @param clienteNuevo
     * @return
     */
    @Override
    public boolean altaCliente(cliente clienteNuevo) {
        try {
            clienteNuevo.setPassword(this.generarPassword());
            
            if (!persistencia.existe(clienteNuevo)) {
                if (persistencia.persis((Object) clienteNuevo)) {
                    
                    utilidades.enviarConGMail(clienteNuevo.getCorreo(), "Usuario Nuevo", "EL usuario a sido registrado con exito!", null, null);
                    
                    return true;
                    
                }
            }
        } catch (AddressException | MessagingException ex) {
            System.err.println(ex.getMessage());
            return false;
        }
        return false;
    }

    ////////////////////////////////////ANIMAL///////////////////////////////////
    /**
     * Funcion que da de alta una mascota
     *
     * @param mascota
     * @return
     */
    @Override
    public boolean altaAnimal(mascota mascota) {
        try {
            
            if (!persistencia.existe(mascota)) {
                return persistencia.persis(mascota);
            } else {
                return false;
            }
        } catch (Exception e) {
            System.err.println(e.getMessage() + " CAUSA: " + e.getCause());
            return false;
        }
    }

    /**
     * Funcion que elimina una mascota a partir del id
     *
     * @param id
     * @return
     */
    @Override
    public boolean eliminarAnimal(Long id) {
        try {
            mascota mascota = (mascota) aPer.getMascota(id);
            if (aPer.eliminar((Object) mascota)) {
                return true;
            }
        } catch (Exception e) {
            System.err.println(e.getMessage() + " CAUSA: " + e.getCause());
            return false;
        }
        return false;
    }

    /**
     * Funcion que modifica una mascota ya existente
     *
     * @param mascota
     * @return
     */
    @Override
    public boolean modificarAnimal(mascota mascota) {
        try {
            return aPer.modificar(mascota);
        } catch (Exception e) {
            System.err.println(e.getMessage() + " CAUSA: " + e.getCause());
            return false;
        }
        
    }

    /**
     * Funcion que agrega una nueva raza en el sistema
     *
     * @param raza
     * @return
     */
    @Override
    public boolean nuevaRaza(raza raza) {
        try {
            if (!persistencia.existe(raza)) {
                return persistencia.persis(raza);
            } else {
                return false;
            }
        } catch (Exception e) {
            System.err.println(e.getMessage() + " CAUSA: " + e.getCause());
            return false;
        }
    }

    /**
     * Funcion que retorna una List<> con los nombres de las razas. Requiere
     * internet!
     *
     * @return List<>
     */
    @Override
    public List<String> getRazasApiRest() {
        if (restCliente.getRazas() != null) {
            return restCliente.getRazas();
        } else {
            return this.getRazasDB();
        }
        
    }

    /**
     * Funcion que vuelve a cargar las razas en el sistema, requiere internet!
     *
     * @return List<>
     */
    @Override
    public List<String> reloadRazas() {
        List<String> razas = (ArrayList<String>) restCliente.getRazas();
        if (razas != null && razas.size() > 0) {
            persistencia.ejecutarSql("DROP TABLE raza");
            for (String raza : razas) {
                raza r = new raza();
                r.setRaza(raza);
                this.nuevaRaza(r);
            }
        }
        return razas;
    }

    /**
     * Funcion que retorna las razas existentes en el sistema
     *
     * @return List<>
     */
    public List<String> getRazasDB() {
        List<String> razas = new ArrayList<>();
        List<Object> ra = (List<Object>) persistencia.getListaObjetos("select * from raza", raza.class);
        Iterator it = ra.iterator();
        while (it.hasNext()) {
            raza next = (raza) it.next();
            razas.add((String) next.getRaza());
        }
        return razas;
    }

    /**
     * *
     * Funcion que retorna una mascota en funcion de su Id.
     *
     * @param id
     * @return mascota
     */
    @Override
    public mascota getMascota(Long id) {
        return (mascota) aPer.getMascota(id);
    }

    /**
     * Funcion que elimina una raza del sistema!
     *
     * @param raza
     * @return boolean
     */
    @Override
    public boolean eliminarRaza(String raza) {
        try {
            raza r = (raza) persistencia.getObjeto(raza, raza.class);
            return aPer.eliminar(r);
        } catch (Exception e) {
            System.err.println(e.getMessage() + " CAUSA: " + e.getCause());
            return false;
        }
    }

    /**
     * Funcion que actualiza las razas del sistema, requiere internet!
     *
     * @return boolean
     */
    @Override
    public boolean actualizarRazas() {
        List<String> raza1, raza2;
        raza1 = null;
        raza2 = null;
        raza1 = (List<String>) this.getRazasDB();
        raza2 = (List<String>) ClientesRest.apiCliente.getInstance().getRazas();
        int cont = 0;
        for (int i = 0; i < raza2.size(); i++) {
            String razaapi = raza2.get(i);
            boolean esta = false;
            for (int s = 0; i < raza1.size(); s++) {
                String razadb = (String) raza1.get(i);
                if (razaapi.equals(razadb)) {
                    esta = true;
                    break;
                }
            }
            if (esta == false) {
                raza rN = new raza();
                rN.setRaza(razaapi);
                this.nuevaRaza(rN);
                cont++;
            }
        }
        return cont > 0;
    }

    /**
     * Funcion que retorna un HashMap con los clientes del sistema, la CI es
     * clave.
     *
     * @return clientesMascotas
     */
    @Override
    public HashMap getClientesMascota() {
        HashMap<String, String> clientesMascotas = new HashMap<>();
        try {
            ArrayList<cliente> clientesArreglo = (ArrayList<cliente>) this.getClientes();
            for (cliente cli : clientesArreglo) {
                clientesMascotas.put(cli.getCedula(), cli.getNombre() + " " + cli.getApellido());
            }
        } catch (Exception e) {
            System.err.println(e.getMessage() + " CAUSA " + e.getCause());
            
        }
        return clientesMascotas;
    }

    /**
     * Funcion que retorna una raza en funcion de su nombre.
     *
     * @param raza
     * @return raza
     */
    @Override
    public raza getRaza(String raza) {
        return (raza) persistencia.getObjeto(raza, raza.class);
    }
    
    @Override
    public ArrayList getMascotas() {
        ArrayList<mascota> mascotasSistema = new ArrayList<>();
        try {
            mascotasSistema = (ArrayList<mascota>) aPer.getMascotas();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return mascotasSistema;
    }
    
}
