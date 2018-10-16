package pagesPOM.actions_test;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestActions {

    WebDriver driver;

    DragAndDrop objdragdrop;
    MultiSelectActions objMultiple;


    @Before
    public void setup()
    {
        String extpath = "C:\\install\\driverBrowse\\chromedriver_win32\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",extpath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    public void test_actions_drag()
    {


        driver.get("http://www.keenthemes.com/preview/metronic/templates/admin/ui_tree.html");
        driver.manage().window().maximize();

        objdragdrop = new DragAndDrop(driver);
        objdragdrop.moveToPlace();

    }

    @Test
    public void test_multiple()
    {
        driver.navigate().to("https://demos.devexpress.com/aspxeditorsdemos/ListEditors/MultiSelect.aspx");
        driver.manage().window().maximize();

        objMultiple = new MultiSelectActions(driver);
         objMultiple.setModeSelect();  //nie działa problem
      //  objMultiple.selecMultiElements();



    }







}
