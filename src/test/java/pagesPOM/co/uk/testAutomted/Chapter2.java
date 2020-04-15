package pagesPOM.co.uk.testAutomted;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Chapter2 {

    WebDriver selenium;

    public Chapter2(WebDriver selenium){

        this.selenium = selenium;

        if (!"Chapter 2".equalsIgnoreCase( this.selenium.getTitle() ) )
        {
            selenium.get("http://book.theautomatedtester.co.uk/chapter2");
        }
    }
    public boolean isButtonPresent(String button){
        return selenium.findElements(By.xpath("//input[@id='" +
                button + "']")).size()>0;
    }




}
