package testqaselenbehave.de;

import org.eclipse.jetty.util.annotation.Name;
import org.jbehave.core.annotations.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Logowanie {

    ChromeDriver driver = null;
    String extpath = "C:\\install\\driverBrowse\\chromedriver_win32\\chromedriver.exe";

    //@BeforeStory
    public void ScenarioSetup()
    {
      //nie działa opcja driver get story
    }

    @Given("user <username> with password <passcode> is on product page <url>")
    public void givenUserusernameWithPasswordpasscodeIsOnProductPageurl(@Named("username") String user,
                                                                        @Named("passcode") String pass,
                                                                        @Named("url") String url)  {
        System.setProperty("webdriver.chrome.driver",extpath);
        driver = new ChromeDriver();
        driver.get(url);

        WebElement element = driver.findElement(By.xpath("//*[@id=\"username\"]"));
        element.sendKeys(user);

        element = null;
        element = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        element.sendKeys(pass);



    }

    @When("the user clicks button Login")
    public void whenTheUserClicksButtonLogin() {

        WebElement button = driver.findElement(By.xpath("//*[@id=\"login\"]/button/i"));

        button.click();;

    }

    @Then("the page is displayed <getkeyword>")
    public void thenThePageIsDisplayedYourUsernameIsInvalid(String getkeyword) {

        WebElement text = driver.findElement(By.xpath("//*[@id=\"flash\"]"));
        String getText = text.getText().substring(0,25).toString();

        System.out.println("keyword from story: "+getkeyword);
        System.out.println("keyword from webdriver: "+getText);

        // Assert.assertEquals(getkeyword,getText);
Assert.assertEquals(getText,getkeyword);

    }

  //  @AfterStory
    public void afterScenario()
    {
      //  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
     //   driver.quit();
    }

}
