/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package congresso.faces.mngbeans;

import congresso.faces.convert.CEPConverter;
import congresso.faces.convert.CPFConverter;
import congresso.faces.support.PageBean;
import congresso.faces.validator.CEPValidator;
import congresso.faces.validator.CPFValidator;
import congresso.persistence.controller.ParticipanteJpaController;
import congresso.persistence.entity.Participante;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Bruno
 */
@ManagedBean
@RequestScoped
public class AcessoConsultarBean  extends PageBean{
    
    private CPFConverter cpfConverter = new CPFConverter();
    private CPFValidator cpfValidator = new CPFValidator();
    private CEPConverter cepConverter = new CEPConverter();
    private CEPValidator cepValidator = new CEPValidator();
    private Long cpf;
    private String email;
    private Participante participante = new Participante();
    
    /**
     * @return the cpfConverter
     */
    public CPFConverter getCpfConverter() {
        return cpfConverter;
    }

    /**
     * @param cpfConverter the cpfConverter to set
     */
    public void setCpfConverter(CPFConverter cpfConverter) {
        this.cpfConverter = cpfConverter;
    }

    /**
     * @return the cpfValidator
     */
    public CPFValidator getCpfValidator() {
        return cpfValidator;
    }

    /**
     * @param cpfValidator the cpfValidator to set
     */
    public void setCpfValidator(CPFValidator cpfValidator) {
        this.cpfValidator = cpfValidator;
    }

    /**
     * @return the cepConverter
     */
    public CEPConverter getCepConverter() {
        return cepConverter;
    }

    /**
     * @param cepConverter the cepConverter to set
     */
    public void setCepConverter(CEPConverter cepConverter) {
        this.cepConverter = cepConverter;
    }

    /**
     * @return the cepValidator
     */
    public CEPValidator getCepValidator() {
        return cepValidator;
    }

    /**
     * @param cepValidator the cepValidator to set
     */
    public void setCepValidator(CEPValidator cepValidator) {
        this.cepValidator = cepValidator;
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
  
    public String consultar(){
        ParticipanteJpaController pjc = new ParticipanteJpaController();
        participante = pjc.findByCpfEmail(cpf, email);
        if(participante == null){
            return "index";
        }        
        return "consulta";
    }
}
