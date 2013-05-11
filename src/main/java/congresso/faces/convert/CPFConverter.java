/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package congresso.faces.convert;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author Wilson
 */
public class CPFConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        return string == null || string.trim().isEmpty() ? null : Long.valueOf(string.replace("-", ""));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        String cpf = (String) o;
        return String.format("%09d-%02d", Long.parseLong(cpf) / 100, Long.parseLong(cpf) % 100);
    }
    
}
