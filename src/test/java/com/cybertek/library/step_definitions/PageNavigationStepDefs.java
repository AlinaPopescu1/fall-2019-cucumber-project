package com.cybertek.library.step_definitions;
import com.cybertek.library.pages.DashBoardPage;
import com.cybertek.library.pages.UsersPage;
import com.cybertek.library.utilities.BrowserUtils;
import com.cybertek.library.utilities.Driver;
import com.cybertek.library.utilities.LibraryConstants;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class PageNavigationStepDefs {

    DashBoardPage dashBoardPage = new DashBoardPage();
    UsersPage usersPage = new UsersPage();

    @When("I click in {string} link")
    public void i_click_in_link(String link) {
        System.out.println("I click on " +link+ " link");
     switch (link.toLowerCase()){
         case "dashboard":
             BrowserUtils.waitForClickability(dashBoardPage.dashboard,5);
             dashBoardPage.dashboard.click();
             break;
         case "users":
             BrowserUtils.waitForClickability(dashBoardPage.users,5);
             dashBoardPage.users.click();
             break;
         case "books":
             BrowserUtils.waitForClickability(dashBoardPage.books,5);
             dashBoardPage.books.click();
     }
    }

    @Then("{string} page  should be displayed")
    public void page_should_be_displayed(String page) {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(page.toLowerCase()));
        switch (page.toLowerCase()) {
            case "users":
                String actual = dashBoardPage.pageHeader.getText();
                assertEquals("User Management", actual);
                break;
            case "books":
                actual = dashBoardPage.pageHeader.getText();
                assertEquals("Book Management", actual);
                break;
        }
    }

    @Then("show records default value should be {int}")
    public void show_records_default_value_should_be(Integer selected) {
        System.out.println("selected = " + selected);
        String actual = usersPage.getShowRecords().getFirstSelectedOption().getText();
        assertEquals(actual, selected+"");
    }

    @Then("show records should have following options:")
    public void show_records_should_have_following_options(List<String> options) {
        System.out.println("options.size() = " + options.size());
        System.out.println("options = " + options);
        List<WebElement> webElements = usersPage.getShowRecords().getOptions();
        List <String> elementsText = BrowserUtils.getElementsText(webElements);
        assertEquals(options,elementsText);
    }
    @When("I select Show {int} records")
    public void i_select_Show_records(Integer option) {
        BrowserUtils.wait(1);
        usersPage.getShowRecords().selectByVisibleText(option.toString());
    }

    @Then("the users table should display {int} records")
    public void the_users_table_should_display_records(int expectedCount) {
        BrowserUtils.wait(1);
        int actual = usersPage.allRows.size();
        assertEquals(actual, expectedCount);
    }
    @When("I go/navigate to {string} page")
    //go/navigate/open is syntax, string is datatype parameter.
    //--> slash means OR like options,
    // so it's limited to those options only
    //can not type access for example. it will not accept
    public void i_go_to_page(String page) {
        switch (page.toLowerCase()) {
            case LibraryConstants.DASHBOARD:
                BrowserUtils.waitForClickability(dashBoardPage.dashboard,2);
                dashBoardPage.dashboard.click();
                break;
            case LibraryConstants.USERS:
                BrowserUtils.waitForClickability(dashBoardPage.users,2);
                dashBoardPage.users.click();
                break;
            case LibraryConstants.BOOKS:
                BrowserUtils.waitForClickability(dashBoardPage.books,2);
                dashBoardPage.books.click();
                break;
           }
        }
    }

