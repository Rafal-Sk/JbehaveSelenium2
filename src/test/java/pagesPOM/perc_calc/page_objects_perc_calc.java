package pagesPOM.perc_calc;

import org.apache.tools.ant.taskdefs.optional.ejb.WeblogicDeploymentTool;
import org.openqa.selenium.*;

public class page_objects_perc_calc {


    private static WebElement element= null;



    public static WebElement lnk_cont_additional(WebDriver driver) // klik na butoton
    {

        element = driver.findElement(By.xpath("//*[@id='topmenu']/ul/li[2]/a"));
        return element;

    }

    public static WebElement lnk_return_rate(WebDriver driver)  // klik na button
    {

        element = driver.findElement(By.xpath("//*[@id='topmenu']/ul/li[3]/a"));
        return element;
    }


    public static WebElement lnk_after_years(WebDriver driver)  // pole tekst - wyczysc i wstaw liczbę 3
    {
        element = driver.findElement(By.xpath("//*[@id='cyearsv']"));
        return element;

    }

    public static WebElement lnk_start_amount(WebDriver driver)  // sprawdz czy zgadza sie z liczbą
    {
        element = driver.findElement(By.xpath("//*[@id='cstartingprinciplev']"));
        return element;
    }






    }
