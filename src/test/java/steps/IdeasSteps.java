package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.IdeasPage;

public class IdeasSteps {

    IdeasPage ideasPage;

    public IdeasSteps (WebDriver driver) {
        ideasPage = new IdeasPage(driver);
    }

    @Step ("Получаем случайное задание")
    public String getIdea () {
        return ideasPage
                .openPage()
                .getIdea();
    }
}
