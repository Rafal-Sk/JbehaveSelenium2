package pagesPOM.interesCalculator;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class WindChilCalc {


    WebDriver driver;
    By windspeed = By.name("windspeed");
    By selectspeed = By.name("windspeedunit");
    By airtemperature = By.name("airtemperature");
    By selectemperature = By.name("airtemperatureunit");
    By buttoncalculate = By.xpath("//*[@id='content']/table/tbody/tr/td/table/tbody/tr[3]/td[2]/input");
    By textresult = By.className("verybigtext");
    By showText = By.xpath("//*[@id='content']/h2");


    public WindChilCalc(WebDriver d)
    {
        this.driver = d;
    }


    public void setWindSpeed()
    {
        driver.findElement(windspeed).sendKeys("15");
        Select setSpeed = new Select(driver.findElement(selectspeed));
        setSpeed.selectByIndex(1);

    }

    public void settemperature()
    {
        driver.findElement(airtemperature).sendKeys("7");
        Select settemp = new Select(driver.findElement(selectemperature));
        settemp.selectByIndex(1);

    }

    public void clickCalculate()
    {
        driver.findElement(buttoncalculate).click();;

    }

    public String getResult()
    {
        if( isElementPresent(showText)) {


            if (driver.findElement(showText).getText().contains("result")) {
                String result = driver.findElement(textresult).getText();
                return result;
            } else {
                return "nie ma wyniku";
            }

        }
        else
        {
            return "niedostepne pole result" ;
        }

    }

    public boolean isElementPresent(By by)
    {
        try
        {
            driver.findElement(by);
            return true;
        }
        catch(org.openqa.selenium.NoSuchElementException e)
        {

            return false;
        }

    }






}
