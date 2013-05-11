/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package congresso.persistence.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Bruno
 */
public class JpaController {
    protected static EntityManagerFactory emf = null; 
    private EntityManager entityManager;
    private boolean lazy;

    public JpaController() {
    }
    public JpaController(boolean lazy) {
        this.lazy = lazy;
    }
    public EntityManagerFactory getEMFactory() {
        if (emf == null)
            emf = Persistence.createEntityManagerFactory("CongressoPU");
        return emf;
    }

    public EntityManager getEntityManager() {
        if (entityManager == null || !entityManager.isOpen()) {
            entityManager = getEMFactory().createEntityManager();
        }
        return entityManager;
    }

    public boolean isLazy() {
        return lazy;
    }

    protected void closeNotLazy() {
        if (!lazy) {
            close();
        }
    }

    public void close() {
        if (entityManager != null && entityManager.isOpen()) {
            entityManager.close();
        }
    }
}
