package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.FactsPage;

public class FactsSteps {

    FactsPage factsPage;

    public FactsSteps (WebDriver driver) {
        factsPage = new FactsPage(driver);
    }

    @Step ("Получаем случайный интересный факт")
    public String getFact () {
        return factsPage
                .openPage()
                .getFact();
    }
}
