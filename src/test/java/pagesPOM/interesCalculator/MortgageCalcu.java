package pagesPOM.interesCalculator;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class MortgageCalcu {


    WebDriver driver;

    By checkBoxIncludeOptions = By.name("caddoptional");
    By startDateMonth = By.id("cstartmonth");
    By clickMonthylSchedule = By.xpath("//*[@id='topmenu']/ul/li[2]/a");
    By titleMonthlySchedule = By.xpath("//*[@id='camortizationschdis']/h2");
    By priceHome = By.id("chouseprice");
    By allLinks = By.tagName("a");

    public MortgageCalcu(WebDriver d)
    {
        this.driver = d;

    }

    public void checkBoxIncludeOpt()
    {
        driver.findElement(checkBoxIncludeOptions).click();

        // in test can isDisplayed, isEnabled, isSelected
    }

    public void setStartDateMonth()
    {
        Select dropdown = new Select(driver.findElement(startDateMonth));
        dropdown.selectByIndex(6);

        //or selectByVisibleTest("Jul");
    }

    public String getTitleMonthlySchedule()
    {
        driver.findElement(clickMonthylSchedule).click();
        String getText = driver.findElement(titleMonthlySchedule).getText();

        return getText;
    }

    public String getpriceHome()
    {
        String result = driver.findElement(priceHome).getAttribute("value");
        return  result;

    }

    public void findAllLinks()
    {
        List<WebElement> linki = driver.findElements(allLinks);

        System.out.println("całkowita liczba linkow na stronie wynosi "+linki.size());

        for(int i=0; i < linki.size(); i++)
        {
            System.out.println("Name of link #"+i+" "+linki.get(i).getText());


        }



    }






}
