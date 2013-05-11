/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package congresso.faces.mngbeans;

import congresso.faces.convert.CEPConverter;
import congresso.faces.convert.CPFConverter;
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
public class AcessoBean {
    
    private CPFConverter cpfConverter = new CPFConverter();
    private CPFValidator cpfValidator = new CPFValidator();
    private CEPConverter cepConverter = new CEPConverter();
    private CEPValidator cepValidator = new CEPValidator();
    private Participante participante = new Participante();
    private InscricaoBean inscricao = new InscricaoBean();

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
    
    public String acessar(){
        ParticipanteJpaController pjc = new ParticipanteJpaController();
        Participante part= pjc.findByCpfEmail(participante.getCpf(), participante.getEmail());
        if(part == null){
            return "index";
        }
        inscricao.setParticipante(part);
        return "cadastro";
    }
}
