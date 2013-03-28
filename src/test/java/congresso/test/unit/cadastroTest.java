/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package congresso.test.unit;

import congresso.util.ValidaCPF;
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
public class cadastroTest {
    
    private static String cpfInvalido = "11111111111";
    private static String cpfInvalido1 = "23232323232";
    private static String cpfValido = "08539403986";
    
    public cadastroTest() {
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
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void testeValidarCPF(){        
        Assert.assertEquals(false, ValidaCPF.isCPF(cpfInvalido));
        Assert.assertEquals(false, ValidaCPF.isCPF(cpfInvalido1));
        Assert.assertEquals(true, ValidaCPF.isCPF(cpfValido));        
    }
}