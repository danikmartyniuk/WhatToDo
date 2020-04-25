package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FactsPage extends BasePage {

    private static final By FACT = By.tagName("li");
    private static final int RANDOM_FACT = (int) ((Math.random() * 100) + 56);

    public FactsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public FactsPage openPage() {
        driver.navigate().to("https://www.adme.ru/zhizn-nauka/100-korotkih-i-interesnyh-faktov-o-cheloveke-996510/");
        isPageOpened();
        return this;
    }

    @Override
    public void isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".share-global")));
    }

    public String getFact () {
        return driver.findElements(FACT).get(RANDOM_FACT).getText();
    }
}
