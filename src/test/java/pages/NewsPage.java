package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NewsPage extends BasePage {

    private static final By RECENT_NEWS = By.xpath("//a[contains(@data-ua-hash,'news_bytime')]");

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

    public String getTopNews () {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sb.append(driver.findElements(RECENT_NEWS).get(i).getAttribute("href")).append("\n");
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }
}
