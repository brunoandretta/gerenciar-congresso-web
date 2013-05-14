/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package congresso.test.it.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author Bruno
 */
public class IndexSteps {
    private static final String BASE_URL = "http://localhost:8087";
    private static final String CONTEXT = "/gerenciar-congresso-web/";
    private static final String CONTEXT_URL = BASE_URL + CONTEXT;
    private static final String form1 = "form1:";
    
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
    
    @Given("^Estou na página Inicial$")
    public void openHomePage() throws Throwable {
        driver.get(CONTEXT_URL);
    }
    
    @Then("^Eu poderia ver \"([^\"]*)\"$")
    public void shouldSee(String text) throws Throwable {
        Thread.sleep(1000);
        String source = driver.getPageSource();
        Assert.assertTrue("Source: " + source, source.contains(text));
    }    
}
