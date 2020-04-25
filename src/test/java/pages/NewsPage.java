package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NewsPage extends BasePage {

    private static final By RECENT_NEWS = By.cssSelector(".entry__link io-block-link");

    public NewsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public NewsPage openPage() {
        driver.get("https://www.tut.by/");
        isPageOpened();
        return this;
    }

    @Override
    public void isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("latest")));
    }

    public void getTopNews () {
        System.out.println(driver.findElements(RECENT_NEWS).size());
//        String[] news = new String[3];
//        for (int i = 0; i < news.length; i++) {
//            news[i] = driver.findElements(RECENT_NEWS).get(16 + i).getAttribute("href");
//        }
//        System.out.println(Arrays.toString(news));
    }
}
