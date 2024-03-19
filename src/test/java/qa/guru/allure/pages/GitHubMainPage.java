package qa.guru.allure.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;


public class GitHubMainPage {

    private final SelenideElement search = $(".search-input"),
            searchOpened = $("#query-builder-test");

    public GitHubMainPage openMainPageByUrl() {
        open("https://github.com");

        return this;
    }

    public GitHubMainPage openSearch() {
        search.click();

        return this;
    }

    public GitHubMainPage setValueToSearch(String value) {
        searchOpened.sendKeys(value);
        searchOpened.submit();

        return this;
    }

    public GitHubMainPage openRepoFromSearchResults(String value) {
        $(linkText(value)).click();

        return this;
    }

}
