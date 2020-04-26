package steps;

import org.openqa.selenium.WebDriver;
import pages.IdeasPage;

public class IdeasSteps {

    IdeasPage ideasPage;

    public IdeasSteps (WebDriver driver) {
        ideasPage = new IdeasPage(driver);
    }

    public String getIdea () {
        return ideasPage
                .openPage()
                .getIdea();
    }
}
