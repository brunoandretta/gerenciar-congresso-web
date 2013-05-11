/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package congresso.persistence.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Bruno
 */
@Entity
@Table(name="curso")
@Cacheable
@NamedQueries({
    @NamedQuery(name = "Curso.findAll", query = "SELECT c FROM Curso c")})
public class Curso implements Serializable{    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name="id_curso")
    private Integer idCurso;
    @NotNull
    private String nome;
    @NotNull
    private String descricao;
    @NotNull
    private Integer vagas;
    @NotNull
    private double valor;
    @Temporal(TemporalType.DATE)
    @Column(name="data_curso")
    private Date dataCurso;
    @Column(name="hora_inicio")
    private String horaInicio;
    @Column(name="hora_fim")
    private String horaFim;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "curso")
    private List<CursoParticipante> cursoParticipanteList;
    
    public Curso(){
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

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the vagas
     */
    public Integer getVagas() {
        return vagas;
    }

    /**
     * @param vagas the vagas to set
     */
    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }

    /**
     * @return the valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * @return the dataCurso
     */
    public Date getDataCurso() {
        return dataCurso;
    }

    /**
     * @param dataCurso the dataCurso to set
     */
    public void setDataCurso(Date dataCurso) {
        this.dataCurso = dataCurso;
    }

    /**
     * @return the horaInicio
     */
    public String getHoraInicio() {
        return horaInicio;
    }

    /**
     * @param horaInicio the horaInicio to set
     */
    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    /**
     * @return the horaFim
     */
    public String getHoraFim() {
        return horaFim;
    }

    /**
     * @param horaFim the horaFim to set
     */
    public void setHoraFim(String horaFim) {
        this.horaFim = horaFim;
    }

    /**
     * @return the cursoParticipanteList
     */
    public List<CursoParticipante> getCursoParticipanteList() {
        return cursoParticipanteList;
    }

    /**
     * @param cursoParticipanteList the cursoParticipanteList to set
     */
    public void setCursoParticipanteList(List<CursoParticipante> cursoParticipanteList) {
        this.cursoParticipanteList = cursoParticipanteList;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCurso != null ? idCurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Curso)) {
            return false;
        }
        Curso other = (Curso) object;
        if ((this.idCurso == null && other.idCurso != null) || (this.idCurso != null && !this.idCurso.equals(other.idCurso))) {
            return false;
        }
        return true;
    }   
    
}
