package tests;

import org.testng.annotations.Test;

public class MainTest extends BaseTest {

    @Test (description = "Цитата дня")
    public void getQuote () {
        System.out.println(quotesSteps.getTopQuote());
    }

    @Test (description = "Интересный факт")
    public void getFact () {
        System.out.println(factsSteps.getFact());
    }

    @Test (description = "Последние новости")
    public void getNews () {
        System.out.println(newsSteps.getRecentNews());
    }

    @Test (description = "Задача из проекта Эйлера")
    public void getProblemToSolve () {
        System.out.println(eulerSteps.getProblem());
    }

    @Test (description = "Задание")
    public void getThingToDo () {
        System.out.println(ideasSteps.getIdea());
    }

    @Test (description = "Ссылка на фильм")
    public void getFilm () {
        System.out.println(filmsSteps
                .openSearch()
                .getFilm(new String[]{"детектив", "триллер"}, "2010"));
    }

    @Test (description = "Поиск книги")
    public void getBook () {
        System.out.println(booksSteps.getBook("f"));
    }

    @Test (description = "Новая музыка")
    public void getMusic () {
        System.out.println(musicSteps.getMusic());
    }

}
