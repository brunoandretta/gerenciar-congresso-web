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
import congresso.persistence.controller.CursoJpaController;
import congresso.persistence.controller.ParticipanteJpaController;
import congresso.persistence.entity.Curso;
import congresso.persistence.entity.Participante;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ValueChangeEvent;


/**
 *
 * @author Bruno
 */
@ManagedBean
@RequestScoped
public class InscricaoBean extends PageBean{
    
    private CPFConverter cpfConverter = new CPFConverter();
    private CPFValidator cpfValidator = new CPFValidator();
    private CEPConverter cepConverter = new CEPConverter();
    private CEPValidator cepValidator = new CEPValidator();
    private Participante participante = new Participante();
    private List<Curso> selecaoCurso = new ArrayList<Curso>();
    private Map<Integer,Boolean> checked = new HashMap<Integer,Boolean>();
    private boolean cadastrar;    
    
    public InscricaoBean(){
        cadastrar = true;
    }
    
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
        /**
     * @return the selecaoCurso
     */
    public List<Curso> getSelecaoCurso() {
        try {
            if (selecaoCurso.isEmpty()) {
                CursoJpaController ctl = new CursoJpaController();
                selecaoCurso = ctl.findAll();
            }
        } catch (Exception e) {
            log("", e);            
        }
        return selecaoCurso;
    }

    /**
     * @param selecaoCurso the selecaoCurso to set
     */
    public void setSelecaoCurso(List<Curso> selecaoCurso) {
        this.selecaoCurso = selecaoCurso;
    }

    /**
     * @return the checked
     */
    public Map<Integer,Boolean> getChecked() {
        return checked;
    }

    /**
     * @param checked the checked to set
     */
    public void setChecked(Map<Integer,Boolean> checked) {
        this.checked = checked;
    }
    /**
     * @return the cadastrar
     */
    public boolean isCadastrar() {
        return cadastrar;
    }

    /**
     * @param cadastrar the cadastrar to set
     */
    public void setCadastrar(boolean cadastrar) {
        this.cadastrar = cadastrar;
    }
    
    public void getFormulario(String nome){
        ParticipanteJpaController pjc = new ParticipanteJpaController();
        participante = pjc.findByName(nome);
        if(participante == null){
            setCadastrar(true); 
        }else{
            setCadastrar(false);
        }
    }
    public void cadastrar(){}
    public void alterar(){}
    
}
