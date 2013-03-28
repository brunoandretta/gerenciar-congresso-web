/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package congresso.faces.mngbeans;

import congresso.faces.convert.CEPConverter;
import congresso.faces.convert.CPFConverter;
import congresso.faces.support.PageBean;
import congresso.faces.validator.CPFValidator;
import congresso.faces.validator.CampoVazioValidator;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Bruno
 */
@ManagedBean
@RequestScoped
public class CadastroBean extends PageBean{

    private Participante participante = new Participante();
    private CPFConverter cpfConverter = new CPFConverter();
    private CPFValidator cpfValidator = new CPFValidator();
    private CEPConverter cepConverter = new CEPConverter();
    private CampoVazioValidator campoVazioValidator = new CampoVazioValidator();
    private Curso cursos = new Curso();
    private List<String> selecaoCursos;
    private static int valorParticipacao = 100;
    private int valor;
    private String mensagem;
    
    public CadastroBean(){
        this.selecaoCursos = new ArrayList<String>();
        this.valor = 0;
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
     * @return the campoVazioValidator
     */
    public CampoVazioValidator getCampoVazioValidator() {
        return campoVazioValidator;
    }

    /**
     * @param campoVazioValidator the campoVazioValidator to set
     */
    public void setCampoVazioValidator(CampoVazioValidator campoVazioValidator) {
        this.campoVazioValidator = campoVazioValidator;
    }


    /**
     * @return the valor
     */
    public int getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(int valor) {
        this.valor = valor;
    }    
    /**
     *
     * @return
     */
    public void somarValor(){
        int quant = !this.selecaoCursos.isEmpty() ? this.selecaoCursos.size() : 0; 
        this.valor = valorParticipacao + (quant*30);       
    }

    /**
     * @return the selecaoCursos
     */
    public List<String> getSelecaoCursos() {
        return selecaoCursos;
    }

    /**
     * @param selecaoCursos the selecaoCursos to set
     */
    public void setSelecaoCursos(List<String> selecaoCursos) {
        this.selecaoCursos = selecaoCursos;
    }

    /**
     * @return the cursos
     */
    public Curso getCurso() {
        return cursos;
    }

    /**
     * @param cursos the cursos to set
     */
    public void setCurso(Curso cursos) {
        this.cursos = cursos;
    }
    
    public void cadastroAction(){
        this.setMensagem("Cadastro feito com Sucesso!");
    }

    /**
     * @return the mensagem
     */
    public String getMensagem() {
        return mensagem;
    }

    /**
     * @param mensagem the mensagem to set
     */
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
