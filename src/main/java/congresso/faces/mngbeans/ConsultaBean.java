/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package congresso.faces.mngbeans;

import congresso.faces.support.PageBean;
import congresso.persistence.controller.CursoParticipanteJpaController;
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
    private Participante participante = new Participante();
    private List<Curso> listaCursos = new ArrayList<Curso>();
    
    public ConsultaBean(){
        AcessoConsultarBean acesso = (AcessoConsultarBean) getBean("acessoConsultarBean");
        if(acesso != null && acesso.getParticipante() != null){
            participante = acesso.getParticipante();            
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
     * @return the listaCursos
     */
    public List<Curso> getListaCursos() {
        return listaCursos;
    }

    /**
     * @param listaCursos the listaCursos to set
     */
    public void setListaCursos(List<Curso> listaCursos) {
        this.listaCursos = listaCursos;
    }
    
    private void inicializaConsulta(){
        List<CursoParticipante> listacp = new ArrayList<CursoParticipante>();
        CursoParticipanteJpaController cpjc = new CursoParticipanteJpaController();
        listacp = cpjc.findByParticipante(participante);
        for(int i=0;i < listacp.size();i++){
            listaCursos.add(listacp.get(i).getCurso());
        }
    }
}
