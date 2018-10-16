package pagesPOM.interesCalculator;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestMontgageCalcu {


    WebDriver driver;

    MortgageCalcu objPageCalc;
    WindChilCalc  objPageWind;

    @Before
    public void setup()
    {
        String extpath = "C:\\install\\driverBrowse\\chromedriver_win32\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",extpath);

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.calculator.net/mortgage-calculator.html");
    }

    @Test
    public void testpageCalc()
    {
        objPageCalc = new MortgageCalcu(driver);

        objPageCalc.checkBoxIncludeOpt();
        objPageCalc.setStartDateMonth();

        String getTitleText = objPageCalc.getTitleMonthlySchedule();
        System.out.println("Titel monyh Schedulte is "+getTitleText);

        String getPriceHome = objPageCalc.getpriceHome();
        System.out.println("Price amount is "+getPriceHome);

        objPageCalc.findAllLinks();


        // -------------------------------------------------------------------------------
        // przejście do strony Wind chili Calc
        //--------------------------------------------------------------------------------

        driver.navigate().to("https://www.calculator.net/wind-chill-calculator.html");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        objPageWind = new WindChilCalc(driver);
        objPageWind.setWindSpeed();
        objPageWind.settemperature();
       // objPageWind.clickCalculate();
        String resultText = objPageWind.getResult();
        System.out.println(resultText);




    }








}
