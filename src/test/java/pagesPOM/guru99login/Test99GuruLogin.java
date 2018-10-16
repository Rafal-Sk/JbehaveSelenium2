package pagesPOM.guru99login;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Test99GuruLogin {

    WebDriver driver;

    Guru99Login objLogin;

    Guru99homePage objHomePage;


    @Before
    public void setup()
    {
        String extpath = "C:\\install\\driverBrowse\\chromedriver_win32\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",extpath);

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://demo.guru99.com/V4/");
    }

    /**

     * This test case will login in http://demo.guru99.com/V4/

     * Verify login page title as guru99 bank

     * Login to application

     * Verify the home page using Dashboard message

     */


    @Test
    public void test_Home_Page_Appear_Correct(){

        //Create Login Page object
        objLogin = new Guru99Login(driver);

        //Verify login page title
        String loginPageTitle = objLogin.getLoginTitle();


        Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));

        //Login to application

        objLogin.loginToGuru99("mgr123","mgr!23");

        //after login  go the next page

        objHomePage = new Guru99homePage(driver);


        //Verify home page

        Assert.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("mgr123"));

    }



}
