package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.QuotesPage;

public class QuotesSteps {

    QuotesPage quotesPage;

    public QuotesSteps (WebDriver driver) {
        quotesPage = new QuotesPage(driver);
    }

    @Step ("Получаем случайную цитату")
    public String getTopQuote () {
        return quotesPage
                .openPage()
                .getFullQuote(quotesPage.getQuote(), quotesPage.getAuthor());
    }
}
