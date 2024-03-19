package qa.guru.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import qa.guru.allure.pages.GitHubMainPage;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class SelenideTest {

    GitHubMainPage gitHubMainPage = new GitHubMainPage();
    private final String repo = "eroshenkoam/allure-example";

    @Test
    public void testIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        gitHubMainPage.openMainPageByUrl()
                .openSearch()
                .setValueToSearch(repo)
                .openRepoFromSearchResults(repo);

        $("#issues-tab").click();
        $(withText("#80")).should(Condition.exist);
    }

}
