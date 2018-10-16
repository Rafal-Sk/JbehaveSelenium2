package pagesPOM.actions_test;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class MultiSelectActions {

    WebDriver driver;
    Actions builder;
    Action multipleSelect;
    WebElement selectElement;



    By selectMode = By.id("ControlOptionsTopHolder_lbSelectionMode_B-1Img"); //przycisk stzałka w dół - combobox
    By selectModeControl = By.id("ControlOptionsTopHolder_lbSelectionMode_I");




    By contentFeaturesD = By.id("ContentHolder_lbFeatures_D");
    By contentModelsD = By.id("ContentHolder_lbModels_D");


    public MultiSelectActions(WebDriver w)
    {
      this.driver = w;
    }


    public void setModeSelect()  {

        /*   WebElement combobox = driver.findElement(By.id("selectModeControl"));

        Select setElem = new Select(combobox);
        System.out.println(setElem.getOptions());
        setElem.selectByValue("Multiple");




        List<WebElement> options1 = combobox.findElements(By.tagName("id"));
        System.out.println(options1.size());
        System.out.println(options1.get(0).getText());
        System.out.println(options1.get(1).getText());
        System.out.println(options1.get(2).getText());
*/
        driver.findElement(selectMode).click();
        driver.findElement(selectModeControl).sendKeys(Keys.UP);
        driver.findElement(selectModeControl).sendKeys(Keys.ENTER);

        //  driver.findElement(selectMode).click();
      //  driver.findElement(selectMode).clear();
      //  driver.findElement(selectMode).sendKeys("tert");




    }



    public void selecMultiElements()
    {
        builder = new Actions(driver);

        selectElement = driver.findElement(contentFeaturesD);

        List<WebElement> options = selectElement.findElements(By.tagName("td"));

        System.out.println(options.size());

        for(int i = 0; i< options.size(); i++)
            System.out.println("Test multiple nr "+i +" to " +options.get(i).getText());



        multipleSelect = builder.keyDown(Keys.CONTROL).
                click(options.get(3)).
                click(options.get(5)).
                click(options.get(7)).build();
        multipleSelect.perform();





    }


}
