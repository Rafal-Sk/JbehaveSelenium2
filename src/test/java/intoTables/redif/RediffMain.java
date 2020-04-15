package intoTables.redif;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class RediffMain {

    //https://www.guru99.com/handling-dynamic-selenium-webdriver.html

    WebDriver driver;


    @Before
    public void setup()
    {
        String extpath = "C:\\install\\driverBrowse\\chromedriver_win32\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",extpath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void cleanUP()  {

        try {
            Thread.sleep(5000);
        }
        catch (InterruptedException e)
        {
            System.out.println("Blad x wyjatkiem Threadd sleep");
        }
        driver.quit();

    }


    @Test
    public void testSerachforPraseID()
    {
       driver.get("https://money.rediff.com/gainers/bsc/daily/groupa");

       String pobierzows = driver.findElement(By.xpath("//*[@class='dataTable']/tbody/tr[2]/td[1]")).getText();
       System.out.println("result "+pobierzows);

        System.out.println("---------------ROWS RECORDS---------------------");
       //pobierz cały rekord

        String pobierzrows2 = driver.findElement(By.xpath("//*[@class='dataTable']/tbody/tr/td[1]")).getText();
        System.out.println("result "+pobierzrows2); // nie pobiera wszystkie bo string pobiera jeden rekord wiec korzzystaj z tabeli lub kolekcji

        System.out.println("---------------ROWS RECORDS COLLECTIONS---------------------");

        List rows2 = driver.findElements(By.xpath("//*[@class='dataTable']/tbody/tr/td[1]"));
        //or List<WebElement>
        List<WebElement> rows3= driver.findElements(By.xpath("//*[@class='dataTable']/tbody/tr/td[1]"));

        System.out.println("Size listy rows2 "+rows2.size());
        System.out.println("Size listy rows3 "+rows3.size());

        System.out.println("Size listy rows3 "+rows2.size());


      /*  for ( WebElement tempw : rows3)
            System.out.println("xc "+tempw);
            */
        System.out.println("Index rows3 nr 3 "+rows3.get(3).getText());

     //----------------------------------------------------------
    // Jeden sposób pobierania danych przy pomocy Array
        String arrayS[] = new String[rows3.size()];

        for(int i=0; i< rows3.size(); i++)
            arrayS[i] = rows3.get(i).getText();

        for (String di: arrayS)
            System.out.println(di);

    //-----------------------------------------------------------
    // Drugi sposób pobierania danych przy pomocy List<String>
        System.out.println("-----------------------LIST < String > list = new ArrayList<String>()--------------------------------");
        List<String> list = new ArrayList<String>();

        for(int i=0; i<rows3.size(); i++)
            list.add(rows3.get(i).getText());


        // ma wyciac pierwsze słowa - w trakcie - mysle skozystaj z BufferString

       StringBuffer dre= new StringBuffer();


        int index;
        String result;

        for (String d: list) {
        //index = d.indexOf(" ");
        //result = index == -1 || index == d.length() - 1 ? "" : d.substring(index + 2);
         ///   result = null;

            //    result = d;

            if(d.contains(" ") )
            {

                System.out.println(d);
              //  result = d.substring(0, d.indexOf(" ")).toString();
                dre.append(d.substring(0,d.indexOf(" ")) + "\n");
            }
            else
            {
                dre.append(d + "\n");
            }

        }




        System.out.println("Wynik = sTringBuffer test=====================================");
        System.out.println(dre.toString());






    }






}
