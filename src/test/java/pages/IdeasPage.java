package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class IdeasPage extends BasePage {

    private static final By IDEA = By.tagName("p");
    private static final int RANDOM_IDEA = (int) (Math.random() * 100) + 4;

    public IdeasPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public IdeasPage openPage() {
        driver.navigate().to("https://gurutest.ru/publication/100-veschej-kotoryie-nuzhno-uspet-sdelat-v-zhizni/");
        isPageOpened();
        return this;
    }

    @Override
    public void isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@itemprop='description']")));
    }

    public String getIdea () {
        return driver.findElements(IDEA).get(RANDOM_IDEA).getText().substring(driver.findElements(IDEA).get(3).getText().indexOf(".") + 3);
    }

}
