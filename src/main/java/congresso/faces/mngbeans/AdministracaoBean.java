/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package congresso.faces.mngbeans;

import congresso.persistence.controller.CursoParticipanteJpaController;
import congresso.persistence.controller.ParticipanteJpaController;
import congresso.persistence.entity.CursoParticipante;
import congresso.persistence.entity.Participante;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Bruno
 */
@ManagedBean
@ViewScoped
public class AdministracaoBean {
    private List<CursoParticipante> listaParticipantes = new ArrayList<CursoParticipante>();
    
    public AdministracaoBean(){
    
    }

    /**
     * @return the listaParticipantes
     */
    public List<CursoParticipante> getListaParticipantes() {
        ParticipanteJpaController pjc = new ParticipanteJpaController();
        CursoParticipanteJpaController cpjc = new CursoParticipanteJpaController();
        listaParticipantes = cpjc.findAll();               
        return listaParticipantes;
    }

    /**
     * @param listaParticipantes the listaParticipantes to set
     */
    public void setListaParticipantes(List<CursoParticipante> listaParticipantes) {
        this.listaParticipantes = listaParticipantes;
    }
    
    public void alterar(CursoParticipante p){
        /*ParticipanteJpaController pjc = new ParticipanteJpaController();
        pjc.merge(p);*/
    }
    public void excluir(CursoParticipante p){
        /*ParticipanteJpaController pjc = new ParticipanteJpaController();
        p.setCursoParticipanteList(null);
        pjc.remove(p);*/
    }
    
}
