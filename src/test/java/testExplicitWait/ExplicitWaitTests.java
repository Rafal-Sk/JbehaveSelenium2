package testExplicitWait;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitTests {

WebDriver driver;
WebDriverWait wait;
GoogleMainPOM googleMainPage;

    @Before
    public void setUP() {

        String extpath = "C:\\install\\driverBrowse\\chromedriver_win32\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",extpath);
        driver = new ChromeDriver();
        driver.get("http://google.pl");

        googleMainPage = new GoogleMainPOM(driver);

    }

    @After
    public void cleanUP()  {

        try {
            Thread.sleep(5000);
        }
        catch (InterruptedException e)
        {
            System.out.println("Blad x wyjatkiem Threadd sleep");
        }
        driver.quit();

    }

    @Test
    public void testSerachforPraseID()
    {
        googleMainPage.searchForStringUsingIdLocator("test by ID");

    }

    @Test
    public void testSearchForXptah()
    {
        googleMainPage.searchForStringUsingXpathLocator("test by xpath");
    }




}
