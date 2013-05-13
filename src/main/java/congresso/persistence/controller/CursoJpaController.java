/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package congresso.persistence.controller;

import congresso.persistence.entity.Curso;
import congresso.persistence.entity.Curso_;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Bruno
 */
public class CursoJpaController extends JpaController{
    
    public CursoJpaController() {
    }
    
    public CursoJpaController(boolean lazy) {
        super(lazy);
    }
    
    public List<Curso> findAll() {
        EntityManager em = getEntityManager();
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Curso> cq = cb.createQuery(Curso.class);
            Root<Curso> rt = cq.from(Curso.class);
            cq.orderBy(cb.asc(rt.get(Curso_.idCurso)));
            TypedQuery<Curso> q = em.createQuery(cq);
            return q.getResultList();
        } finally {
            closeNotLazy();
        }
    }
    
    public void merge(Curso c){
        EntityManager em = getEntityManager();
        try{
            em.getTransaction().begin();
            em.merge(c);
            em.getTransaction().commit();
        }finally{
            closeNotLazy();
        }
    }
    
}
