/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package congresso.faces.mngbeans;

import congresso.faces.support.PageBean;
import congresso.persistence.controller.CursoParticipanteJpaController;
import congresso.persistence.controller.ParticipanteJpaController;
import congresso.persistence.entity.Curso;
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
public class ConsultaBean extends PageBean{
    private static boolean primeiro = true;
    private Participante participante = new Participante();
    private Integer idParticipante;
    private List<Curso> listaCursos = new ArrayList<Curso>();
    
    public ConsultaBean(){
        AcessoBean acesso = (AcessoBean) getBean("acessoBean");        
        if(acesso != null && acesso.getParticipante().getIdParticipante() != null){
            participante = acesso.getParticipante();            
        }
        if(idParticipante != null){
            participante = new ParticipanteJpaController().findById(idParticipante);
        }
    }

    /**
     * @return the participante
     */
    public Participante getParticipante() {
        return participante;
    }

    /**
     * @param participante the participante to set
     */
    public void setParticipante(Participante participante) {
        this.participante = participante;
    } 

    /**
     * @return the idParticipante
     */
    public Integer getIdParticipante() {
        return idParticipante;
    }

    /**
     * @param idParticipante the idParticipante to set
     */
    public void setIdParticipante(Integer idParticipante) {
        this.idParticipante = idParticipante;
    }

    /**
     * @return the listaCursos
     */
    public List<Curso> getListaCursos() {
        List<CursoParticipante> listaParticipantes;
        if(primeiro == true){
            CursoParticipanteJpaController cpjc = new CursoParticipanteJpaController();
            listaParticipantes = cpjc.findByParticipante(participante);
            for(int i=0;i<listaParticipantes.size();i++){
                listaCursos.add(listaParticipantes.get(i).getCurso());
            }
            primeiro = false;
        }        
        return listaCursos;
    }

    /**
     * @param listaCursos the listaCursos to set
     */
    public void setListaCursos(List<Curso> listaCursos) {
        this.listaCursos = listaCursos;
    }
}