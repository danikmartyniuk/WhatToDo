package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FilmsPage extends BasePage {

    private static final By NAVIGATOR_LINK = By.xpath("//a[contains(text(),'Навигатор')]");

    public FilmsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public FilmsPage openPage() {
        driver.get("https://www.kinopoisk.ru/");
        isPageOpened();
        return this;
    }

    @Override
    public void isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[contains(@class,'cinema-review-snippet__image')]")));
    }

    public void openNavigator () {
        WebElement showMore = driver.findElements(By.xpath("//button[contains(text(),'Показать еще 12')]")).get(1);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", showMore);

        driver.findElement(NAVIGATOR_LINK).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ex_ratingrange")));
    }

    public FilmsPage setParameters () {
        return this;
    }

    public FilmsPage showFilms () {
        return this;
    }

    public void getLinkToFilm () {

    }
}
