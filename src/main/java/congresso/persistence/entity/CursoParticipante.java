/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package congresso.persistence.entity;

import java.io.Serializable;
import javax.persistence.Cacheable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Bruno
 */
@Entity
@Cacheable
@Table(name = "curso_participante")
@NamedQueries({
    @NamedQuery(name = "CursoParticipante.findAll", query = "SELECT c FROM CursoParticipante c")})
public class CursoParticipante implements Serializable {
    @EmbeddedId
    private CursoParticipantePK cursoParticipantePK;
    @JoinColumn(name = "id_curso", referencedColumnName = "id_curso", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Curso curso;
    @JoinColumn(name = "id_participante", referencedColumnName = "id_participante", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Participante participante;
    
    public CursoParticipante(){
    }
    public CursoParticipante(Long idCurso, Integer idParticipante){
        this.cursoParticipantePK = new CursoParticipantePK(idCurso, idParticipante);
    }
    /**
     * @return the cursoParticipantePK
     */
    public CursoParticipantePK getCursoParticipantePK() {
        return cursoParticipantePK;
    }

    /**
     * @param cursoParticipantePK the cursoParticipantePK to set
     */
    public void setCursoParticipantePK(CursoParticipantePK cursoParticipantePK) {
        this.cursoParticipantePK = cursoParticipantePK;
    }

    /**
     * @return the curso
     */
    public Curso getCurso() {
        return curso;
    }

    /**
     * @param curso the curso to set
     */
    public void setCurso(Curso curso) {
        this.curso = curso;
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
    
        @Override
    public int hashCode() {
        int hash = 0;
        hash += (cursoParticipantePK != null ? cursoParticipantePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CursoParticipante)) {
            return false;
        }
        CursoParticipante other = (CursoParticipante) object;
        if ((this.cursoParticipantePK == null && other.cursoParticipantePK != null) || (this.cursoParticipantePK != null && !this.cursoParticipantePK.equals(other.cursoParticipantePK))) {
            return false;
        }
        return true;
    }
    
}
