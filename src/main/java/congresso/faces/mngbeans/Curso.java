/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package congresso.faces.mngbeans;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bruno
 */
public class Curso {
    
    private List<String> cursos;
    
    public Curso(){
        this.cursos = new ArrayList<String>();
        this.cursos.add("Programação Java para Web");
        this.cursos.add("Linguagem Python");
        this.cursos.add("Ruby on Rails");
        this.cursos.add("HTML 5");
        this.cursos.add("WebServices");
    }

    /**
     * @return the cursos
     */
    public List<String> getCursos() {
        return cursos;
    }

    /**
     * @param cursos the cursos to set
     */
    public void setCursos(List<String> cursos) {
        this.cursos = cursos;
    }
}
