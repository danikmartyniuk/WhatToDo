package steps;

import org.openqa.selenium.WebDriver;
import pages.QuotesPage;

public class QuotesSteps {

    QuotesPage quotesPage;

    public QuotesSteps (WebDriver driver) {
        quotesPage = new QuotesPage(driver);
    }

    public String getTopQuote () {
        return quotesPage
                .openPage()
                .getFullQuote(quotesPage.getQuote(), quotesPage.getAuthor());
    }
}
