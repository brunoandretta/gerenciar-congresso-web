/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package congresso.test.it.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.annotation.XmlElement;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author Bruno
 */
public class CongressoSteps {    
    private static final String CONTEXT_URL = "http://localhost:8087/gerenciar-congresso-web";   
    private static WebDriver driver;   
    
   @Before
    public static void before() {
        driver = new FirefoxDriver();
    }

    @After 
    public static void after() {
        driver.close();
        driver.quit();       
    }
    @When("^Eu navego para a página \"([^\"]*)\"$")
    public void navigateTo(String text) throws Throwable {        
        driver.get(CONTEXT_URL + text);
    }
    
    @Given("^Estou na página Inicial$")
    public void openHomePage() throws Throwable {
        navigateTo("");
    }
    
    @Then("^Eu poderia ver \"([^\"]*)\"$")
    public void shouldSee(String text) throws Throwable {
        Thread.sleep(1000);
        String source = driver.getPageSource();
        Assert.assertTrue("Source: " + source, source.contains(text));
    }
    
    @Then("^Eu poderia nao poderia ver \"([^\"]*)\"$")
    public void shouldNotSee(String text) throws Throwable {
        Thread.sleep(1000);
        String source = driver.getPageSource();
        Assert.assertFalse("Source: " + source, source.contains(text));
    }
    
    @And("^Eu preencho \"([^\"]*)\" com \"([^\"]*)\"$")
    public void fillIn(String fieldName, String value) throws Throwable {
        String field = fieldName;
        if(fieldName.equals("cpf") || fieldName.equals("cep")){
           field = field.concat("_field");
        }
        WebElement we = driver.findElement(By.id(field));
        if (value.isEmpty()) {
            we.clear();
        } else {
            we.clear();
            we.click();
            we.sendKeys(value);            
        }
    }
    
    @And("^Eu clico no botao \"([^\"]*)\"$")
    public void click(String name) throws Throwable {
        WebElement we = driver.findElement(By.id(name));
        WebElement submit = driver.findElement(By.id("form1"));
        we.click();        
        submit.submit();        
        Thread.sleep(2000);
    }
    
    @And("^Eu seleciono a \"([^\"]*)\"ª opção do checkbox \"([^\"]*)\"$")
    public void fillCheckBox(String value, String fieldName){
        int posicao = Integer.valueOf(value) - 1;
        String field = "data".concat(":")
                .concat(String.valueOf(posicao)).concat(":").concat(fieldName);
        WebElement we = driver.findElement(By.id(field));
        if(value.isEmpty()){
            we.clear();
        }else{
            we.click();
        }
    }
}
