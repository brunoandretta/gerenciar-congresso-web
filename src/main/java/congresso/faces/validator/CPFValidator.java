/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package congresso.faces.validator;

import congresso.util.ValidaCPF;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Bruno
 */

public class CPFValidator implements Validator {

    /**
     *
     * @param context
     * @param component
     * @param o
     * @throws ValidatorException
     */
    @Override
    public void validate(FacesContext context, UIComponent component, Object o) throws ValidatorException {
        String cpf = String.format("%011d", (Long) o);
        if (!cpf.matches("\\d{11}")) {        
            throw new ValidatorException(new FacesMessage("CPF em formato incorreto."));
        } else {          
            if (!ValidaCPF.isCPF(cpf)) {
                throw new ValidatorException(new FacesMessage("CPF inválido"));
            }
        }
    }


    
}
