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
import congresso.persistence.entity.CursoParticipante;
import congresso.persistence.entity.Participante;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ValueChangeEvent;

/**
 *
 * @author Bruno
 */
@ManagedBean
@ViewScoped
public class InscricaoBean extends PageBean{
    
    private CPFConverter cpfConverter = new CPFConverter();
    private CPFValidator cpfValidator = new CPFValidator();
    private CEPConverter cepConverter = new CEPConverter();
    private CEPValidator cepValidator = new CEPValidator();
    private Participante participante = new Participante();
    private List<Curso> selecaoCurso = new ArrayList<Curso>(); 
    private Map<Long,Boolean> checked;
    private Boolean selected;
    private boolean cadastrar;
    private Double valorTotal;    
    
    public InscricaoBean(){
        valorTotal = 100.0;
        checked = new HashMap<Long, Boolean>();       
        AcessoBean acesso = (AcessoBean) getBean("acessoBean");
        if(acesso != null && acesso.getParticipante().getIdParticipante() != null){
            participante = acesso.getParticipante();
            cadastrar = false;
        }else{
            cadastrar = true;
        }        
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
    public Map<Long,Boolean> getChecked() {
        return checked;
    }

    /**
     * @param checked the checked to set
     */
    public void setChecked(Map<Long,Boolean> checked) {
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

    /**
     * @return the valorTotal
     */
    public Double getValorTotal() {
        valorTotal = 100.0;
        for(int i = 1; i <= checked.size();i++){
            if(checked.get(Long.valueOf(i))){
                valorTotal += 50.0;
            }            
        }
        return valorTotal;
    }
   
    
    @PostConstruct
    public void init(){        
        for(Curso curso : getSelecaoCurso()){
            checked.put(curso.getIdCurso(), false);
        }
    }
    public void selecaoChanged(ValueChangeEvent e, Long idCurso){
        selected = (Boolean) e.getNewValue();
        checked.put(idCurso, selected);
    }
    
    public String cadastrar(){
        ParticipanteJpaController pjc = new ParticipanteJpaController();
        CursoJpaController cjc = new CursoJpaController();
        List<CursoParticipante> listacp = new ArrayList<CursoParticipante>();        
        Integer idParticipante = pjc.MaxId() == null ? 1 : pjc.MaxId() + 1;
        for(Curso curso : selecaoCurso){
            if(checked.get(curso.getIdCurso())){
                int numVagas = curso.getVagas() - 1;
                curso.setVagas(numVagas);                
                cjc.merge(curso);
                listacp.add(new CursoParticipante(curso.getIdCurso(), idParticipante));                                
            }
        }
        participante.setIdParticipante(idParticipante);
        participante.setValorTotal(valorTotal);
        participante.setCursoParticipanteList(listacp);        
        pjc.persist(participante);       
        return "consulta?faces-redirect=true&participante="+participante.getIdParticipante();
    }
    public String alterar(){
        ParticipanteJpaController pjc = new ParticipanteJpaController();
        pjc.merge(participante);        
        return "consulta?faces-redirect=true&participante="+participante.getIdParticipante();
    }
    
}
