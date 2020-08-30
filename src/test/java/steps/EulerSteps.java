package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.EulerPage;

public class EulerSteps {

    EulerPage eulerPage;

    public EulerSteps (WebDriver driver) {
        eulerPage = new EulerPage(driver);
    }

    @Step ("Получаем случайную задачу")
    public String getProblem () {
        return eulerPage
                .openPage()
                .openArchive()
                .openTask()
                .getDescription();
    }
}
