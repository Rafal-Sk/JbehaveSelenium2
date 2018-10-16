package pagesPOM.perc_calc;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class investment_calculator {

    private static WebDriver driver = null;


    public static void main(String[] args) {


        String extpath = "C:\\install\\driverBrowse\\chromedriver_win32\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",extpath);

        driver = new ChromeDriver();

        driver.get("https://www.calculator.net/investment-calculator.html");

     // Use page Object library now

        page_objects_perc_calc.lnk_cont_additional(driver).click();
        page_objects_perc_calc.lnk_return_rate(driver).click();

        page_objects_perc_calc.lnk_after_years(driver).clear();
        page_objects_perc_calc.lnk_after_years(driver).sendKeys("3");


        String pobierzLiczbe =
                page_objects_perc_calc.lnk_start_amount(driver).getAttribute("value");

        int pobierzLiczbe2 = Integer.parseInt(pobierzLiczbe);


        if(pobierzLiczbe.equals("20000") )
        {
            System.out.println("Test amount is passed for string " +pobierzLiczbe);

            if(pobierzLiczbe2==20000)
            System.out.println("Test amount is passed for integer " +pobierzLiczbe2);

            else
                System.out.println("Test amount is failed for integer " +pobierzLiczbe2);

        }
        else
        {
            System.out.println("Test amount is failed, bacause amount is" +pobierzLiczbe);

        }

        // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); -- niestety  nie działa  bo zamyka w ciagu 2 sekund

        //driver.close();


    }



}



