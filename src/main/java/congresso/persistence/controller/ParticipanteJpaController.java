/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package congresso.persistence.controller;

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
public class ParticipanteJpaController extends JpaController{
    
    public ParticipanteJpaController(){
    }
    public ParticipanteJpaController(boolean lazy){
        super(lazy);
    }
    public List<Participante> findAll(){
        EntityManager em = getEntityManager();
        Participante participante = new Participante();
        try{
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Participante> cq = cb.createQuery(Participante.class);
            Root<Participante> rt = cq.from(Participante.class);            
            TypedQuery<Participante> tq = em.createQuery(cq);
            return tq.getResultList();
        }finally{
            closeNotLazy();
        }        
    }
    public Participante findByCpfEmail(Long cpf, String email){
        EntityManager em = getEntityManager();
        Participante participante = new Participante();
        try{
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Participante> cq = cb.createQuery(Participante.class);
            Root<Participante> rt = cq.from(Participante.class);
            cq.where(cb.equal(rt.get(Participante_.cpf), cpf), 
                    cb.equal(rt.get(Participante_.email), email));
            TypedQuery<Participante> tq = em.createQuery(cq);
            participante = tq.getSingleResult();            
        }catch(NoResultException e){
            return null;
        }finally{
            closeNotLazy();
        }
        return participante;
   }
    
   public Integer MaxId(){
       EntityManager em = getEntityManager();
       try{
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Integer> cq = cb.createQuery(Integer.class);
            Root<Participante> rt = cq.from(Participante.class);
            cq.select(cb.max(rt.get(Participante_.idParticipante)));            
            TypedQuery<Integer> tq = em.createQuery(cq);
            return tq.getSingleResult();
       }catch(NullPointerException e){
            return 0;
       }finally{
           closeNotLazy();
       }
   } 
    
   public void persist(Participante participante){
       EntityManager em = getEntityManager();
       try{
           em.getTransaction().begin();
           em.persist(participante);
           em.getTransaction().commit();
       }finally{
           em.close();
       }   
   }
   
   public void merge(Participante participante){
       EntityManager em = getEntityManager();
       try{
           em.getTransaction().begin();
           em.merge(participante);
           em.getTransaction().commit();
       }finally{
           em.close();
       }   
   }
   public void remove(Participante participante){
       EntityManager em = getEntityManager();
       try{
           em.getTransaction().begin();
           em.remove(em.merge(participante));
           em.getTransaction().commit();
       }finally{
           em.close();
       }   
   }
   public Participante findById(Integer id){
       EntityManager em = getEntityManager();
       try{           
           return em.find(Participante.class, id);           
       }catch(NoResultException e){
           return null;
       }finally{
           em.close();
       }
   }
}
