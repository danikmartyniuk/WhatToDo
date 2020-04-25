package tests;

import org.testng.annotations.Test;

public class MainTest extends BaseTest{

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
        newsSteps.getRecentNews();
    }
}
