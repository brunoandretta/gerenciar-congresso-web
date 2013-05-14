/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package congresso.util;

import congresso.persistence.entity.Curso;
import congresso.persistence.entity.Participante;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bruno
 */
public class Participantes {
    private Participante participante;
    private List<Curso> listaCursos = new ArrayList<Curso>();
    
    public Participantes(){
    
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
    
}
