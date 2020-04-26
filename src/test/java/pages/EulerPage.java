package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EulerPage extends BasePage {

    private static final By ARCHIVES = By.xpath("//a[@accesskey='1']");
    private static final By TASK_ITEM = By.xpath("//a[contains(@href,'problem')]");
    private static final int RANDOM_NUMBER = (int) (Math.random() * 50);
    private static final By DESCRIPTION = By.cssSelector(".problem_content");

    public EulerPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public EulerPage openPage() {
        driver.get("https://projecteuler.net/");
        isPageOpened();
        return this;
    }

    @Override
    public void isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("euler_portrait")));
    }

    public EulerPage openArchive () {
        driver.findElement(ARCHIVES).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("problems_table_page")));
        return this;
    }

    public EulerPage openTask () {
        driver.findElements(TASK_ITEM).get(RANDOM_NUMBER).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(DESCRIPTION));
        return this;
    }

    public String getDescription () {
        return driver.findElement(DESCRIPTION).getText();
    }
}
