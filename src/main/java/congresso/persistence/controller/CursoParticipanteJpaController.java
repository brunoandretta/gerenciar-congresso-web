/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package congresso.persistence.controller;

import congresso.persistence.entity.CursoParticipante;
import congresso.persistence.entity.CursoParticipante_;
import congresso.persistence.entity.Participante;
import congresso.persistence.entity.Participante_;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Bruno
 */
public class CursoParticipanteJpaController extends JpaController{
    
    public CursoParticipanteJpaController(){
    }
    public CursoParticipanteJpaController(boolean lazy){
        super(lazy);
    }
        public List<CursoParticipante> findByParticipante(Participante p) {
        EntityManager em = getEntityManager();
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<CursoParticipante> cq = cb.createQuery(CursoParticipante.class);
            Root<CursoParticipante> rt = cq.from(CursoParticipante.class);
            cq.where(cb.equal(rt.get(CursoParticipante_.participante), p));
            TypedQuery<CursoParticipante> q = em.createQuery(cq);
            return q.getResultList();
        } finally {
            closeNotLazy();
        }
    }
    public List<CursoParticipante> findAll() {
        EntityManager em = getEntityManager();
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<CursoParticipante> cq = cb.createQuery(CursoParticipante.class);
            Root<CursoParticipante> rt = cq.from(CursoParticipante.class);            
            TypedQuery<CursoParticipante> q = em.createQuery(cq);
            return q.getResultList();
        } finally {
            closeNotLazy();
        }
    }
    
    public void persist(CursoParticipante cp){
       EntityManager em = getEntityManager();
       try{
           em.getTransaction().begin();
           em.persist(cp);
           em.getTransaction().commit();
       }finally{
           em.close();
       }
   
   } 
}
