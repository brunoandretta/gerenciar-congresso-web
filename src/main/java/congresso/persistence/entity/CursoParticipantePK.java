/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package congresso.persistence.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Bruno
 */
@Embeddable
public class CursoParticipantePK implements Serializable {
    @Column(name="id_participante")
    private Integer idParticipante;
    @Column(name="id_curso")
    private Integer idCurso;
    
    public CursoParticipantePK(){
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
     * @return the idCurso
     */
    public Integer getIdCurso() {
        return idCurso;
    }

    /**
     * @param idCurso the idCurso to set
     */
    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }
    
        @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + Objects.hashCode(this.idParticipante);
        hash = 31 * hash + Objects.hashCode(this.idCurso);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CursoParticipantePK other = (CursoParticipantePK) obj;
        if (!Objects.equals(this.idParticipante, other.idParticipante)) {
            return false;
        }
        if (!Objects.equals(this.idCurso, other.idCurso)) {
            return false;
        }
        return true;
    }
    
}
