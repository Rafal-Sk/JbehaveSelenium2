import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CheckingWebdriver {

    public static void main(String[] args) {


        String extpath = "C:\\install\\driverBrowse\\chromedriver_win32\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",extpath);

        ChromeDriver driver = new ChromeDriver();

        driver.get("http://demo.guru99.com/");

        WebElement element = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[5]/td[2]/input"));
        element.sendKeys("abc@gmail.com");

        WebElement button = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[6]/td[2]/input"));
        button.click();

       // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); -- niestety  nie działa  bo zamyka w ciagu 2 sekund

        driver.close();

    }
}
