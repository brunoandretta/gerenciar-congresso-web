/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package congresso.test.unit;

import congresso.faces.mngbeans.InscricaoBean;
import congresso.persistence.controller.CursoJpaController;
import congresso.persistence.controller.CursoParticipanteJpaController;
import congresso.persistence.controller.ParticipanteJpaController;
import congresso.persistence.controller.UsuarioJpaController;
import congresso.persistence.entity.Curso;
import congresso.persistence.entity.CursoParticipante;
import congresso.persistence.entity.Participante;
import congresso.persistence.entity.Usuario;
import congresso.util.ValidaCPF;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Bruno
 */
public class UnitarioTest {
    
    private static String cpfInvalido = "11111111111";
    private static String cpfInvalido1 = "23232323232";
    private static String cpfValido = "08539403986";    
    
    public UnitarioTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    
    @Test
    public void testeValidarCPF(){        
        Assert.assertEquals(false, ValidaCPF.isCPF(cpfInvalido));
        Assert.assertEquals(false, ValidaCPF.isCPF(cpfInvalido1));
        Assert.assertEquals(true, ValidaCPF.isCPF(cpfValido));        
    }
    
   /* @Test
    public void testeFindAll(){
        CursoJpaController cjc = new CursoJpaController();
        ParticipanteJpaController pjc = new ParticipanteJpaController();
        CursoParticipanteJpaController cpjc = new CursoParticipanteJpaController();
        List<Curso> cursos = cjc.findAll();
        List<Participante> participantes = pjc.findAll();
        List<CursoParticipante> cps = cpjc.findAll();
        Assert.assertNotNull(cursos);
        Assert.assertNotNull(participantes);
        Assert.assertNotNull(cps);
    }
    
    @Test
    public void testeFindCpfEmail(){        
        ParticipanteJpaController pjc = new ParticipanteJpaController();
        Participante p = pjc.findByCpfEmail(Long.parseLong("8539403986"), "brunogandrettam@gmail.com");      
        Assert.assertNotNull(p);       
    }
    
    @Test
    public void testeFindUsuario(){        
        UsuarioJpaController ujc = new UsuarioJpaController();
        Usuario u = ujc.findByusuarioSenha("admin", "admin");
        Assert.assertNotNull(u);       
    }*/
}