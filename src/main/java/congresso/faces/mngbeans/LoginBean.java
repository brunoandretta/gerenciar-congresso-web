/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package congresso.faces.mngbeans;

import congresso.faces.support.PageBean;
import congresso.persistence.controller.UsuarioJpaController;
import congresso.persistence.entity.Usuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


/**
 *
 * @author Bruno
 */
@ManagedBean
@RequestScoped
public class LoginBean extends PageBean{
    
    private String senha;
    private String usuario;
    private Usuario user = new Usuario();
    private Boolean invalido;

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the user
     */
    public Usuario getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(Usuario user) {
        this.user = user;
    }

    /**
     * @return the invalido
     */
    public Boolean getInvalido() {
        return invalido;
    }

    /**
     * @param invalido the invalido to set
     */
    public void setInvalido(Boolean invalido) {
        this.invalido = invalido;
    }
    public String consultar(){
        UsuarioJpaController ujc = new UsuarioJpaController();
        user = ujc.findByusuarioSenha(usuario, senha);
        if(user == null){
            invalido = true;
            return "";
        }        
        return "administracao";
    }
}
