package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.MusicPage;

public class MusicSteps {

    MusicPage musicPage;

    public MusicSteps (WebDriver driver) {
        musicPage = new MusicPage(driver);
    }

    @Step ("Получаем 5 новых песен")
    public String getMusic () {
        return musicPage
                .openPage()
                .openNewTracksPlaylist()
                .getTracks();
    }
}
