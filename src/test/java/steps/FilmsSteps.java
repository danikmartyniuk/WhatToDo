package steps;

import org.openqa.selenium.WebDriver;
import pages.FilmsPage;

public class FilmsSteps {

    FilmsPage filmsPage;

    public FilmsSteps (WebDriver driver) {
        filmsPage = new FilmsPage(driver);
    }

    public FilmsSteps openSearch () {
        filmsPage
                .openPage()
                .openNavigator();
        return this;
    }

    public void getFilm () {
        filmsPage
                .setParameters()
                .showFilms()
                .getLinkToFilm();
    }
}
