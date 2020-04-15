package pagesPOM.co.uk.testAutomted;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class BestPractices3 {


WebDriver selenium;


  @Before
  public void setup()
  {

      String extpath = "C:\\install\\driverBrowse\\chromedriver_win32\\chromedriver.exe";
      System.setProperty("webdriver.chrome.driver",extpath);

      selenium = new ChromeDriver();


  }

      @After
      public void endtest()
      {
          selenium.quit();


      }

    @Test
    public void ShouldLoadTheHomePageAndThenCheckButtonOnChapter2()
    {
        selenium.get("http://book.theautomatedtester.co.uk");
        HomePage hp = new HomePage(selenium);

       Chapter2 ch2 = hp.clickChapter2();
        Assert.assertTrue(ch2.isButtonPresent("but1"));
    }





}
