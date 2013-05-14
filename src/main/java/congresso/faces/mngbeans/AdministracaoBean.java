/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package congresso.faces.mngbeans;

import congresso.persistence.controller.CursoJpaController;
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
    private List<Participante> listaParticipantes = new ArrayList<Participante>(); 
    private Participante participanteEdit = new Participante();
    
    public AdministracaoBean(){
    
    }
    /**
     * @return the listaParticipantes
     */
    public List<Participante> getListaParticipantes() {
        ParticipanteJpaController pjc = new ParticipanteJpaController();
        listaParticipantes = pjc.findAll();
        for(int i=0;i<listaParticipantes.size();i++){
            listaParticipantes.get(i)
            .setCursoParticipanteList(new CursoParticipanteJpaController()
            .findByParticipante(listaParticipantes.get(i)));
        }
        return listaParticipantes;
    }

    /**
     * @param listaParticipantes the listaParticipantes to set
     */
    public void setListaParticipantes(List<Participante> listaParticipantes) {
        this.listaParticipantes = listaParticipantes;
    }

    /**
     * @return the participanteEdit
     */
    public Participante getParticipanteEdit() {
        return participanteEdit;
    }

    /**
     * @param participanteEdit the participanteEdit to set
     */
    public void setParticipanteEdit(Participante participanteEdit) {
        this.participanteEdit = participanteEdit;
    }
    
    public void alterar(){
        ParticipanteJpaController pjc = new ParticipanteJpaController();
        pjc.merge(participanteEdit);
    }
    public void excluir(Participante p){
        ParticipanteJpaController pjc = new ParticipanteJpaController();
        CursoParticipanteJpaController cpjc = new CursoParticipanteJpaController();
        CursoJpaController cjc = new CursoJpaController();
        for(CursoParticipante cp : p.getCursoParticipanteList()){
            int numVagas = cp.getCurso().getVagas() + 1;
            cp.getCurso().setVagas(numVagas);
            cjc.merge(cp.getCurso());            
        }
        pjc.remove(p);
    }
    public void editar(Participante p){
        participanteEdit = p;
    }    
}
