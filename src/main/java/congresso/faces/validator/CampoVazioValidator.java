/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package congresso.faces.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Bruno
 */
public class CampoVazioValidator implements Validator{

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String campo = value.toString();
        if(campo.isEmpty()){
            throw new ValidatorException( new FacesMessage("Favor preencher o campo!"));
        }
    }    
}
