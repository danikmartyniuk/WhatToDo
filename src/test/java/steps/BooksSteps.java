package steps;

import org.openqa.selenium.WebDriver;
import pages.BooksPage;

public class BooksSteps {

    BooksPage booksPage;

    public BooksSteps (WebDriver driver) {
        booksPage = new BooksPage(driver);
    }

    public String getBook (String typeOfBook) {
        return booksPage
                .openPage()
                .openNonFiction(typeOfBook)
                .openBestSellers()
                .getRandomBook();
    }
}
