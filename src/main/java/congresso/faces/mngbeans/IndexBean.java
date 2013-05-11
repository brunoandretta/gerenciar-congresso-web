/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package congresso.faces.mngbeans;

import congresso.faces.support.FacesBean;
import congresso.persistence.controller.CursoJpaController;
import congresso.persistence.entity.Curso;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Bruno
 */
@ManagedBean
@RequestScoped
public class IndexBean extends FacesBean{
    private List<Curso> selecaoCurso = new ArrayList<Curso>();

    public IndexBean() {        
    }

    /**
     * @return the selecaoCurso
     */
    public List<Curso> getSelecaoCurso() {
        try {
            if (selecaoCurso.isEmpty()) {
                CursoJpaController ctl = new CursoJpaController();
                selecaoCurso = ctl.findAll();
            }
        } catch (Exception e) {
            log("", e);            
        }
        return selecaoCurso;
    }

    /**
     * @param selecaoCurso the selecaoCurso to set
     */
    public void setSelecaoCurso(List<Curso> selecaoCurso) {
        this.selecaoCurso = selecaoCurso;
    }
    
    
}
