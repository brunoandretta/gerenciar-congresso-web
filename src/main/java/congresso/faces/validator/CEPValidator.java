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
 * @author Wilson
 */
public class CEPValidator implements Validator {

    @Override
    public void validate(FacesContext fc, UIComponent uic, Object o) throws ValidatorException {
        String cep = o.toString();
        if (!cep.matches("d{8}-d{3}")) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "CEP \'" + cep + "\' em formato incorreto.", null));
        }
    }
}
