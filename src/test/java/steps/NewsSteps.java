package steps;

import org.openqa.selenium.WebDriver;
import pages.NewsPage;

public class NewsSteps {

    NewsPage newsPage;

    public NewsSteps (WebDriver driver) {
        newsPage = new NewsPage(driver);
    }

    public void getRecentNews () {
        newsPage
                .openPage()
                .getTopNews();
    }
}
