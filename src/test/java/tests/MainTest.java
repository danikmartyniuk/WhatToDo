package tests;

import org.testng.annotations.Test;
import utils.FilesWriter;

import java.io.IOException;

public class MainTest extends BaseTest {

    @Test (description = "Цитата дня", priority = 1)
    public void getQuote () throws IOException {
        FilesWriter.writeToFile("Цитата дня: " + quotesSteps.getTopQuote());
    }

    @Test (description = "Интересный факт", priority = 2)
    public void getFact () throws IOException {
        FilesWriter.writeToFile("Интересный факт: " + factsSteps.getFact());
    }

    @Test (description = "Последние новости", priority = 5)
    public void getNews () throws IOException {
        FilesWriter.writeToFile("Последние новости:\n" + newsSteps.getRecentNews());
    }

    @Test (description = "Задача из проекта Эйлера", priority = 4)
    public void getProblemToSolve () throws IOException {
        FilesWriter.writeToFile("Математическая задача: " + eulerSteps.getProblem());
    }

    @Test (description = "Задание", priority = 3)
    public void getThingToDo () throws IOException {
        FilesWriter.writeToFile("Что Вам стоит сделать: " + ideasSteps.getIdea());
    }

    @Test (description = "Ссылка на фильм", priority = 7)
    public void getFilm () throws IOException {
        FilesWriter.writeToFile("Ссылка на просмотр фильма: " + filmsSteps
                .openSearch()
                .getFilm(new String[]{"детектив", "триллер"}, "2010"));
    }

    @Test (description = "Поиск книги", priority = 8)
    public void getBook () throws IOException {
        FilesWriter.writeToFile("Популярная книга: " + booksSteps.getBook("f"));
    }

    @Test (description = "Новая музыка", priority = 6)
    public void getMusic () throws IOException {
        FilesWriter.writeToFile("Новая популярная музыка:\n" + musicSteps.getMusic());
    }

}
