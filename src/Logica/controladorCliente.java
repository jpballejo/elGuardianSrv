/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author jp
 */
public class controladorCliente {
   /*
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("elGuardianServidorPU");
    
    */
    private static controladorCliente instance;

    public static controladorCliente getInstance() {
        if (instance == null) {
            instance = new controladorCliente();
        }
        return instance;
    }

    private static final EntityManager em = Persistencia.persistencia.getInstance().getEm();

    public static EntityManager getEm() {
        return em;
    }

}
