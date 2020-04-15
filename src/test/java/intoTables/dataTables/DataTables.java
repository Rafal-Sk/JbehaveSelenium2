package intoTables.dataTables;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DataTables {

    //https://www.guru99.com/handling-dynamic-selenium-webdriver.html

    //https://the-internet.herokuapp.com/tables

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
       driver.get("https://the-internet.herokuapp.com/tables");

       // Tabela nr 1.
        WebElement datanr1 = driver.findElement(By.xpath("//*[@id='table1']/tbody/tr"));


        System.out.println(datanr1.getSize());
        //Pobiera całą tabelę nr 1
        List<WebElement> pob = driver.findElements(By.xpath("//*[@id='table1']/tbody/tr"));


        System.out.println(pob.size());

        List<String> list = new ArrayList<String>();

        for (int i=0; i < pob.size(); i++)
            list.add(pob.get(i).getText());


        for (String d: list)
            System.out.println(d);


        // pobiera tylko 1 kolumnę

        System.out.println("pobiera tylko 1 kolumnę");
        List<WebElement> pob1 = driver.findElements(By.xpath("//*[@id='table1']/tbody/tr/td[1]"));

        List<String> listcol = new ArrayList<String>();

        for (int i1=0; i1 < pob1.size(); i1++)
            listcol.add(pob1.get(i1).getText());


        for (String d1: listcol)
            System.out.println(d1);


        // pobieranie i obliczanie z kolumny DUE w dolarach
        System.out.println("obieranie i obliczanie z kolumny DUE w dolarach z 4 kolumny");

        List<WebElement> dolary = driver.findElements(By.xpath("//*[@id='table1']/tbody/tr/td[4]"));

        listcol = new ArrayList<String>(); // zerujemy listę List
        for (int p=0; p < dolary.size(); p++)
            listcol.add(dolary.get(p).getText());

        List<String> lwartosc = new ArrayList<String>();
        for (String d2: listcol)
            lwartosc.add(d2.substring(1,d2.length()));


        List<Double> dwartosc = new ArrayList<Double>();

        for (String d3: lwartosc) {
            System.out.println(d3);

            dwartosc.add(Double.parseDouble(d3));
        }
        double suma = 0.0f;
        System.out.println("Wartosci listy konwertowana naa double");
        for (Double dob: dwartosc) {
            System.out.println(dob);
        suma += dob;
        }

        System.out.println("Suma wynosi " +suma);

    }






}
