/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package congresso.persistence.controller;

import congresso.persistence.entity.Participante;
import congresso.persistence.entity.Participante_;
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
    public Participante findByName(String nome){
        EntityManager em = getEntityManager();
        Participante participante = new Participante();
        try{
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Participante> cq = cb.createQuery(Participante.class);
            Root<Participante> rt = cq.from(Participante.class);
            cq.where(cb.equal(rt.get(Participante_.nome), nome));
            TypedQuery<Participante> tq = em.createQuery(cq);
            participante = tq.getSingleResult();
        }finally{
            closeNotLazy();
        }
        return participante;
    }
    public Participante findByCpfEmail(String cpf, String email){
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
}
