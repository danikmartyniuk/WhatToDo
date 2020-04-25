package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import steps.FactsSteps;
import steps.NewsSteps;
import steps.QuotesSteps;
import utils.CapabilitiesGenerator;
import utils.TestListener;

@Listeners({TestListener.class})
public class BaseTest {

    WebDriver driver;
    QuotesSteps quotesSteps;
    FactsSteps factsSteps;
    NewsSteps newsSteps;

    @BeforeTest
    public void setUp () {
        driver = new ChromeDriver(CapabilitiesGenerator.getChromeOptions());
        driver.manage().window().maximize();

        quotesSteps = new QuotesSteps(driver);
        factsSteps = new FactsSteps(driver);
        newsSteps = new NewsSteps(driver);
    }

    @AfterTest
    public void close () {
        driver.quit();
    }

    public WebDriver getDriver () {
        return this.driver;
    }
}
