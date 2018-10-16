package pagesPOM.guru99login;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

// zrodło ze strony https://www.guru99.com/page-object-model-pom-page-factory-in-selenium-ultimate-guide.html

public class Guru99Login {


    WebDriver driver;

    By user99GuruName = By.name("uid");

    By password99Guru = By.name("password");

    By titleText =By.className("barone");

    By login = By.name("btnLogin");


    public Guru99Login(WebDriver driver)
    {
        this.driver = driver;
    }

    //Set user name in textbox

    public void setUserName(String strUserName){

        driver.findElement(user99GuruName).sendKeys(strUserName);

    }

    //Set password in password textbox

    public void setPassword(String strPassword){

        driver.findElement(password99Guru).sendKeys(strPassword);

    }

    // click on login button
    public void clickLogin(){

        driver.findElement(login).click();

    }

    //Get the title of Login Page
    public String getLoginTitle(){

        return driver.findElement(titleText).getText();

    }

    // summary
    public void loginToGuru99(String strUserName,String strPasword)
    {
        //Fill user name
        this.setUserName(strUserName);

        //Fill user password
        this.setPassword(strPasword);

        //Click Login button
        this.clickLogin();


    }



    }
