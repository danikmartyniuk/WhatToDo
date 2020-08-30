package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import steps.*;
import utils.CapabilitiesGenerator;
import utils.FilesWriter;
import utils.TestListener;

import java.io.IOException;

@Listeners({TestListener.class})
public class BaseTest {

    WebDriver driver;

    QuotesSteps quotesSteps;
    FactsSteps factsSteps;
    NewsSteps newsSteps;
    EulerSteps eulerSteps;
    IdeasSteps ideasSteps;
    FilmsSteps filmsSteps;
    BooksSteps booksSteps;
    MusicSteps musicSteps;

    @BeforeTest
    public void setUp () throws IOException {
        FilesWriter.cleanFile("src/test/resources/results.txt");
        driver = new ChromeDriver(CapabilitiesGenerator.getChromeOptions());
        driver.manage().window().maximize();

        quotesSteps = new QuotesSteps(driver);
        factsSteps = new FactsSteps(driver);
        newsSteps = new NewsSteps(driver);
        eulerSteps = new EulerSteps(driver);
        ideasSteps = new IdeasSteps(driver);
        filmsSteps = new FilmsSteps(driver);
        booksSteps = new BooksSteps(driver);
        musicSteps = new MusicSteps(driver);
    }

    @AfterTest
    public void close () {
        driver.quit();
    }

    public WebDriver getDriver () {
        return this.driver;
    }
}
