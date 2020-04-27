package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class FilmsPage extends BasePage {

    private static final By NAVIGATOR_LINK = By.xpath("//a[contains(text(),'Навигатор')]");
    private static final By GENRES_LIST = By.id("genreListTitle");
    private static final By GENRE_ITEM = By.xpath("//li[contains(@class,'genre_')]");
    private static final By DECADE = By.name("m_act[decade]");
    private static final By SHOW_BUTTON = By.xpath("//input[@value='поиск']");
    private static final By FILM = By.xpath("//a[contains(@href,'/level/1/film')]");

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

    public FilmsPage setGenre (String[] genres) {
        driver.findElement(GENRES_LIST).click();
        for (String genre : genres) {
            for (int j = 0; j < driver.findElements(GENRE_ITEM).size(); j++) {
                if (genre.equals(driver.findElements(GENRE_ITEM).get(j).getText())) {
                    driver.findElements(GENRE_ITEM).get(j).click();
                }
            }
        }
        driver.findElement(GENRES_LIST).click();
        return this;
    }

    public FilmsPage setDecadence (String decade) {
        new Select(driver.findElement(DECADE)).selectByValue(decade);
        return this;
    }

    public FilmsPage showFilms () {
        driver.findElement(By.id("is_serial")).click();
        driver.findElement(By.id("is_mult")).click();
        driver.findElement(SHOW_BUTTON).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("itemList")));
        return this;
    }

    public String getLinkToFilm () {
        int random = 0;
        while (random % 2 == 0) {
            random = (int) (Math.random() * 100);
        }
        String nameOfFilm = driver.findElements(FILM).get(random).getText();
        System.out.println(nameOfFilm);
        driver.navigate().to("https://www.google.com/");
        driver.findElement(By.xpath("//input[@title='Поиск']")).sendKeys(nameOfFilm + " смотреть онлайн бесплатно", Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("rso")));
        driver.findElements(By.className("r")).get(0).click();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        return driver.getCurrentUrl();
    }
}
