package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Random;

public class QuotesPage extends BasePage {

    private static final By QUOTE = By.tagName("b");
    private static final By AUTHOR = By.tagName("em");
    private static final int QUOTE_INDEX = new Random().nextInt(100);

    public QuotesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public QuotesPage openPage() {
        driver.get("https://www.forbes.ru/forbeslife/dosug/262327-na-vse-vremena-100-vdokhnovlyayushchikh-tsitat");
        isPageOpened();
        return this;
    }

    @Override
    public void isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("shares")));
    }

    public String getQuote () {
        return driver.findElements(QUOTE).get(QUOTE_INDEX).getText();
    }

    public String getAuthor () {
        return driver.findElements(AUTHOR).get(QUOTE_INDEX).getText();
    }

    public String getFullQuote (String q, String a) {
        return q + " - " + a;
    }
}
