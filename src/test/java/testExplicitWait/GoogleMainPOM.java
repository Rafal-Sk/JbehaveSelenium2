package testExplicitWait;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// ze strony Hithub:
//https://github.com/sebkap/SeleniumWebDriver/blob/master/SeleniumWebDriver/src/pageObjects/GoogleMainPage.java

public class GoogleMainPOM {

    private final WebDriver driver;


    public GoogleMainPOM(WebDriver d)
    {
        this.driver = d;
    }

    public By googleSearchBarByIdLocator = By.id("lst-ib");

    // Lokalizacja paska wyszukiwania za pomocą wyrażenia xpath
    // (przykład działania, jednak nie zadziała w innej wersji niż PL)
    // można jednak pomyśleć o stworzeniu xpatha, który nie będzie miał tego ograniczenia
    public By googleSearchBarByXpathLocator = By.xpath("//div/input[@aria-label='Szukaj']");

    // Lokalizacja paska wyszukiwania za pomocą selektora CSS
    public By googleSearchBarByCssLocator = By.cssSelector("input.gsfi[type='text']");

    // Lokalizacja linku do gmaila za pomocą nazwy
    public By googleGmailLinkByLinkTextLocator = By.linkText("Gmail");

    // Lokalizacja linku do Grafika za pomocą części nazwy
    public By googleGrafikaLinkByPartialTextLocator = By.partialLinkText("Graf");

    // Lokalizacja paska wyszukiwania za pomocą atrybutu 'name', ale rzadko stosowana, ponieważ często elementy
    // nie mają tego atrybutu
    public By googleSearchBarByNameLocator = By.name("q");

    // Lokalizacja przycisku wyświetlającego googleApps za pomocą wartości atrybutu class elementów
    public By googleAppsButtonByClassAttributeValueLocator = By.className("gb_Nb");

    // Lokalizaca elementu za pomocą nazwy tagu (jednak przy dynamicznych stronach
    // często jest wiele tagów o tej samej nazwie)
    public By bodyOfThePageByTagNameLocator = By.tagName("body");



    // ID
    public void searchForStringUsingIdLocator(String searchPhrase) {
        driver.findElement(googleSearchBarByIdLocator).sendKeys(searchPhrase);
    }

    // Xpath
    public void searchForStringUsingXpathLocator(String searchPhrase) {
        driver.findElement(googleSearchBarByXpathLocator).sendKeys(searchPhrase);
    }

    // CssSelector
    public void searchForStringUsingCssSelectorLocator(String searchPhrase) {
        driver.findElement(googleSearchBarByCssLocator).sendKeys(searchPhrase);
    }

    // Kliknięcie na link prowadzący do Gmaila
    public void clickGmailLink() {
        driver.findElement(googleGmailLinkByLinkTextLocator).click();
    }

    // Kliknięcie na link prowadzący do wyszukiwarki grafiki
    public void clickGrafikaLink() {
        driver.findElement(googleGrafikaLinkByPartialTextLocator).click();
    }

    // Wyświetlenie aplikacji google
    public void clickGoogleAppsButton() {
        driver.findElement(googleAppsButtonByClassAttributeValueLocator).click();
    }

    // Wyświetlenie całego tesktu w tagu Body
    public void displayBody() {
        System.out.println(driver.findElement(bodyOfThePageByTagNameLocator).getText());
    }




}
