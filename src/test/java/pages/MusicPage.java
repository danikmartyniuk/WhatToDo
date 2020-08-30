package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MusicPage extends BasePage {

    private static final By NEW_TRACKS = By.xpath("//span[contains(text(),'Громкие новинки месяца')]");
    private static final By TRACK_NAME = By.cssSelector(".d-track__name");
    private static final By SINGER = By.cssSelector(".d-track__artists");

    public MusicPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public MusicPage openPage() {
        driver.navigate().to("https://music.yandex.by/home");
        isPageOpened();
        return this;
    }

    @Override
    public void isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promo-autoplaylist__cover")));
    }

    public MusicPage openNewTracksPlaylist () {
        WebElement nt = driver.findElements(NEW_TRACKS).get(0);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", nt);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".page-playlist__tracks")));
        return this;
    }

    public String getTracks () {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            int index = (int) (Math.random() * 80);
            sb
                    .append(driver.findElements(TRACK_NAME).get(index).getText())
                    .append(" - ").append(driver.findElements(SINGER).get(index).getText())
                    .append("\n");
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }
}
