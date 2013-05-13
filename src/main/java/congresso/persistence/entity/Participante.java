/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package congresso.persistence.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Bruno
 */
@Entity
@Cacheable
@NamedQueries({
    @NamedQuery(name="Participante.findAll",query = "SELECT p FROM Participante p")
})
public class Participante implements Serializable {
    @Id    
    @Column(name = "id_participante")
    private Integer idParticipante;
    @NotNull
    private String nome;
    @NotNull
    @Size(min = 1, max = 15)
    private Long cpf;
    @NotNull
    @Size(min = 1, max = 15)
    private String rg; 
    @NotNull
    @Size(min = 1, max = 15)
    private Integer cep;
    @NotNull
    @Size(min = 1, max = 50)
    private String endereco;
    @NotNull
    @Size(min = 1, max = 10)
    private String numero;
    @NotNull
    @Size(min = 1, max = 10)
    private String complemento;
    @NotNull
    @Size(min = 1, max = 20)
    private String estado;
    @NotNull
    @Size(min = 1, max = 20)
    private String cidade;
    @NotNull
    @Size(min = 1, max = 20)
    private String bairro;
    @NotNull
    @Size(min = 1, max = 20)
    private String email;
    @NotNull
    @Size(min = 1, max = 15)
    private String telefone;
    @Column(name = "valor_total")
    private double valorTotal; 
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "participante")
    private List<CursoParticipante> cursoParticipanteList;
    
    public Participante(){
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
     * @return the cpf
     */
    public Long getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the rg
     */
    public String getRg() {
        return rg;
    }

    /**
     * @param rg the rg to set
     */
    public void setRg(String rg) {
        this.rg = rg;
    }

    /**
     * @return the cep
     */
    public Integer getCep() {
        return cep;
    }

    /**
     * @param cep the cep to set
     */
    public void setCep(Integer cep) {
        this.cep = cep;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return the complemento
     */
    public String getComplemento() {
        return complemento;
    }

    /**
     * @param complemento the complemento to set
     */
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * @return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param bairro the bairro to set
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the valorTotal
     */
    public double getValorTotal() {
        return valorTotal;
    }

    /**
     * @param valorTotal the valorTotal to set
     */
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
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
        hash += (idParticipante != null ? idParticipante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Participante)) {
            return false;
        }
        Participante other = (Participante) object;
        if ((this.idParticipante == null && other.idParticipante != null) || (this.idParticipante != null && !this.idParticipante.equals(other.idParticipante))) {
            return false;
        }
        return true;
    }   
    
}
