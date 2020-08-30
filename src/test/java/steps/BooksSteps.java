package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.BooksPage;

public class BooksSteps {

    BooksPage booksPage;

    public BooksSteps (WebDriver driver) {
        booksPage = new BooksPage(driver);
    }

    @Step ("Получаем случайную книгу")
    public String getBook (String typeOfBook) {
        return booksPage
                .openPage()
                .openNonFiction(typeOfBook)
                .openBestSellers()
                .getRandomBook();
    }
}
