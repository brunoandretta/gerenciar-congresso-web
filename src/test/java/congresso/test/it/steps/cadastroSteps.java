/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package congresso.test.it.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author Bruno
 */
public class cadastroSteps {
    
    private static final String BASE_URL = "http://localhost:8087";
    private static final String CONTEXT = "/gerenciar-congresso-web";
    private static final String CONTEXT_URL = BASE_URL + CONTEXT;
    private static final String padraoIdJSF = "j_idt9:";

    private static WebDriver driver;

    @Before
    public static void before() {
        driver = new FirefoxDriver();
    }

    @After
    public static void after() {
        driver.close();
    }
    
    @When("^Eu preencho \"([^\"]*)\" com \"([^\"]*)\"$")
    public void fillIn(String fieldName, String value) throws Throwable {
        WebElement we = driver.findElement(By.id(padraoIdJSF.concat(fieldName)));
        if (value.isEmpty()) {
            we.clear();
        } else {
            we.sendKeys(value);
        }
    }

    @When("^Eu clico no botao \"([^\"]*)\"$")
    public void click(String name) throws Throwable {
        WebElement we = driver.findElement(By.id(padraoIdJSF.concat(name)));
        we.click();
    }

    @Given("^Estou na página de cadastro$")
    public void openHomePage() throws Throwable {
        driver.get(CONTEXT_URL);
    }

    @Then("^Eu poderia ver \"([^\"]*)\"$")
    public void shouldSee(String text) throws Throwable {
        String source = driver.getPageSource();
        Assert.assertTrue("Source: " + source, source.contains(text));
    }
    
}
