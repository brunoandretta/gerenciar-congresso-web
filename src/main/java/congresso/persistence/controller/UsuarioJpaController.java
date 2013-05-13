/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package congresso.persistence.controller;

import congresso.persistence.entity.Usuario;
import congresso.persistence.entity.Usuario_;
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
public class UsuarioJpaController extends JpaController{
    public UsuarioJpaController(){
    }
    public UsuarioJpaController(boolean lazy){
        super(lazy);
    }
    
        public Usuario findByusuarioSenha(String user, String senha){
        EntityManager em = getEntityManager();
        Usuario usuario = new Usuario();
        try{
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Usuario> cq = cb.createQuery(Usuario.class);
            Root<Usuario> rt = cq.from(Usuario.class);
            cq.where(cb.equal(rt.get(Usuario_.usuario), user), 
                    cb.equal(rt.get(Usuario_.senha), senha));
            TypedQuery<Usuario> tq = em.createQuery(cq);
            usuario = tq.getSingleResult();            
        }catch(NoResultException e){
            return null;
        }finally{
            closeNotLazy();
        }
        return usuario;
   }
}
