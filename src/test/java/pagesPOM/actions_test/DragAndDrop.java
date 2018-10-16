package pagesPOM.actions_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

    WebDriver driver;
    By j7disableNode = By.id("j3_7_anchor");
    By j3parentNode = By.id("j3_1_anchor");


    public DragAndDrop(WebDriver d)
    {
        this.driver = d;
    }

    public void moveToPlace()
    {
        WebElement From = driver.findElement(j7disableNode);
        WebElement To = driver.findElement(j3parentNode);

        Actions builder = new Actions(driver);
        Action draganddrop = builder.clickAndHold(From).moveToElement(To).release(To).build();
        draganddrop.perform();

    }


}
