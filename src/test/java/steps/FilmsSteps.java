package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.FilmsPage;

public class FilmsSteps {

    FilmsPage filmsPage;

    public FilmsSteps (WebDriver driver) {
        filmsPage = new FilmsPage(driver);
    }

    @Step ("Открываем навигатор по фильмам")
    public FilmsSteps openSearch () {
        filmsPage
                .openPage()
                .openNavigator();
        return this;
    }

    @Step ("Получаем ссылку на фильм")
    public String getFilm (String[] genres, String decade) {
        return filmsPage
                .setGenre(genres)
                .setDecadence(decade)
                .showFilms()
                .getLinkToFilm();
    }
}
