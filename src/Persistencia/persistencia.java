/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import static Logica.mascota_.id;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author jp
 */
public class persistencia {

    private static persistencia instance;
    private static String unidadPersistencia = "elGuardianServidorPU";
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory(unidadPersistencia);
    private static final EntityManager em = emf.createEntityManager();

    /**
     * @return retorna un manejador de entidades
     */
    public EntityManager getEm() {
        return em;
    }

    public static persistencia getInstance() {
        if (instance == null) {
            instance = new persistencia();
        }
        return instance;
    }

    public String getUnidadPersistencia() {
        return unidadPersistencia;
    }

    public void setUnidadPersistencia(String unidadPersistencia) {
        persistencia.unidadPersistencia = unidadPersistencia;
    }

    public boolean persis(Object obj) {
        try {
            System.out.println("Metodo persis inicio");
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
            System.out.println("Agrege: " + obj.getClass().getName());
            System.out.println("Metodo persis fin");
            return true;
        } catch (Exception e) {
            System.err.println("Error al agregar: " + e.getMessage() + " Causa: " + e.getCause());
            em.getTransaction().rollback();
            return false;
        }
    }

    public boolean modificar(Object obj) {
        try {
            em.getTransaction().begin();
            em.merge(obj);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
              System.err.println("Error al modificar: "+e.getMessage() + " Causa: " + e.getCause());
            return false;
        }

    }

    public boolean eliminar(Object obj) {
        try {
            em.getTransaction().begin();
            em.remove(obj);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
           System.err.println("Error al eliminar: "+e.getMessage() + " Causa: " + e.getCause());
            return false;
        }
    }

    public List<Object> getListaObjetos(String sql, Class clase) {
        try {
            em.getTransaction().begin();
            List resultList = em.createNativeQuery(sql, clase).getResultList();
            em.getTransaction().commit();
            return resultList;

        } catch (Exception e) {
            System.err.println(e.getMessage() + " CAUSA " + e.getCause());
        }

        return null;

    }

    public boolean existe(Object obj) {

        try {
            em.getTransaction().begin();
            boolean ret = em.contains(obj);
            em.getTransaction().commit();
            return ret;
        } catch (Exception e) {
            System.err.println(e.getMessage() + " CAUSA " + e.getCause());
            return false;
        }
    }

    public boolean ejecutarSql(String sql) {
        try {
            em.getTransaction().begin();
            Query resultQuery = em.createNativeQuery(sql);
            resultQuery.executeUpdate();
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e.getMessage() + " CAUSA " + e.getCause());
            return false;
        }
        return true;
    }

    public Object getObjeto(String id, Class clase) {
        Object obj = null;
        try {
            em.getTransaction().begin();
            obj = (Object)em.find(clase, id);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e.getMessage() + " CAUSA " + e.getCause());
        }
        return obj;
    }
}
