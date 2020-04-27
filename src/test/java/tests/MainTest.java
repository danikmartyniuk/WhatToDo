package tests;

import org.testng.annotations.Test;

public class MainTest extends BaseTest {

    @Test
    public void getQuote () {
        System.out.println(quotesSteps.getTopQuote());
    }

    @Test
    public void getFact () {
        System.out.println(factsSteps.getFact());
    }

    @Test
    public void getNews () {
        System.out.println(newsSteps.getRecentNews());
    }

    @Test
    public void getProblemToSolve () {
        System.out.println(eulerSteps.getProblem());
    }

    @Test
    public void getThingToDo () {
        System.out.println(ideasSteps.getIdea());
    }

    @Test
    public void getFilm () {
        System.out.println(filmsSteps
                .openSearch()
                .getFilm(new String[]{"детектив", "триллер"}, "2010"));
    }

    @Test
    public void getBook () {
        System.out.println(booksSteps.getBook("f"));
    }

    @Test
    public void getMusic () {

    }
}
