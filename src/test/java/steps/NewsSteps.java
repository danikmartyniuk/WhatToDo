package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.NewsPage;

public class NewsSteps {

    NewsPage newsPage;

    public NewsSteps (WebDriver driver) {
        newsPage = new NewsPage(driver);
    }

    @Step ("Получаем три последние новости")
    public String getRecentNews () {
        return newsPage
                .openPage()
                .getTopNews();
    }
}
