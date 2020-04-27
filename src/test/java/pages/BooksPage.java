package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BooksPage extends BasePage {

    private static final By NON_FICTION = By.xpath("//a[contains(text(),'Нехудожественная литература')]");
    private static final By FICTION = By.xpath("//a[contains(text(),'Художественная литература')]");
    private static final By BESTSELLERS = By.xpath("//span[contains(text(),'Бестселлеры')]");
    private static final By BOOK_TITLE = By.cssSelector(".item-type-card__title");
    private static final By BOOK_AUTHOR = By.cssSelector(".item-type-card__info");
    private static final By BOOK_LINK = By.cssSelector(".item-type-card__link");

    public BooksPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public BooksPage openPage() {
        driver.get("https://oz.by/");
        isPageOpened();
        return this;
    }

    @Override
    public void isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".offers-slider__item__inner")));
    }

    public BooksPage openNonFiction (String typeOfBooks) {
        if (typeOfBooks.equals("nf")) {
            WebElement nf = driver.findElement(NON_FICTION);
            JavascriptExecutor executor = (JavascriptExecutor)driver;
            executor.executeScript("arguments[0].click();", nf);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".landing-nav-list__list")));
        } else {
            WebElement f = driver.findElement(FICTION);
            JavascriptExecutor executor = (JavascriptExecutor)driver;
            executor.executeScript("arguments[0].click();", f);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".landing-nav-list__list")));
        }
        return this;
    }

    public BooksPage openBestSellers () {
        driver.findElement(BESTSELLERS).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".viewer-type-card__wrapper")));
        return this;
    }

    public String getRandomBook () {
        int num = (int) (Math.random() * 100);
        return driver.findElements(BOOK_TITLE).get(num).getText() + ", " +
                 driver.findElements(BOOK_AUTHOR).get(num).getText()
                        .substring(0, driver.findElements(BOOK_AUTHOR).get(num).getText().indexOf(",")) +
                 "\n" + driver.findElements(BOOK_LINK).get(num * 2).getAttribute("href");
    }
}
