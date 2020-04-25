package steps;

import org.openqa.selenium.WebDriver;
import pages.FactsPage;

public class FactsSteps {

    FactsPage factsPage;

    public FactsSteps (WebDriver driver) {
        factsPage = new FactsPage(driver);
    }

    public String getFact () {
        return factsPage
                .openPage()
                .getFact();
    }
}
