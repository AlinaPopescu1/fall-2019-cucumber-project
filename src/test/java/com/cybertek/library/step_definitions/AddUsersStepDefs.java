package com.cybertek.library.step_definitions;
import com.cybertek.library.pages.DashBoardPage;
import com.cybertek.library.pages.LoginPage;
import com.cybertek.library.pages.UsersPage;
import com.cybertek.library.utilities.BrowserUtils;
import com.cybertek.library.utilities.ConfigurationReader;
import com.cybertek.library.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.List;
import java.util.Map;
import static org.junit.Assert.*;

public class AddUsersStepDefs {
    UsersPage usersPage = new UsersPage();
    LoginPage loginPage = new LoginPage();
    DashBoardPage dashBoardPage = new DashBoardPage();
    String randomEmail = "lala@gmail.com";
    String randomFullName = "Lala Peterson";
    String randomPassword = "lalalala";
    String randomAddress = "329 Merick Driver, Atlanta, Georgia";

    @Given("I access Users page as a librarian")
    public void i_access_Users_page_as_a_librarian() {
        System.out.println("Going to the login page");
        //we need a driver object
        String url = ConfigurationReader.getProperty("url");
        Driver.getDriver().get(url);
        String email = ConfigurationReader.getProperty("librarian_email");
        String password = ConfigurationReader.getProperty("librarian_password");
        loginPage.login(email, password);
        BrowserUtils.wait(3);
        dashBoardPage.users.click();
    }

    @Given("I click on Add User")
    public void i_click_on_Add_User() {
        BrowserUtils.waitForClickability(usersPage.addUser, 5);
        usersPage.addUser.click();
    }

    @Then("dialog fields must have matching placeholder")
    public void dialog_fields_must_have_matching_placeholder(Map<String, String> fields) {
        System.out.println(fields.entrySet());
        for (String key : fields.keySet()) {
            System.out.println("key = " + key);
            System.out.println("value = " + fields.get(key));
            System.out.println();
        }
        String expectedFullName = fields.get("fullname");
        String actualFullName = usersPage.fullName.getAttribute("placeholder");
        assertEquals(expectedFullName, actualFullName);

        String expectedEmail = fields.get("email");
        String actualEmail = usersPage.email.getAttribute("placeholder");
        assertEquals(expectedEmail, actualEmail);

        String expectedPassword = fields.get("password");
        String actualPassword = usersPage.password.getAttribute("placeholder");
        assertEquals(expectedPassword, actualPassword);

        String expectedAddress = fields.get("address");
        String actualAddress = usersPage.address.getAttribute("placeholder");
        assertEquals("Address placeholder must be empty",
                "", actualAddress);
        assertTrue("Address placeholder must be empty",
                usersPage.address.getAttribute("placeholder").isEmpty());

    }

    @Then("start date should be today's date")
    public void start_date_should_be_today_s_date() {
        BrowserUtils.wait(3);
        String expected = BrowserUtils.printCurrentDayMonthAndYear();
        System.out.println("expected = " + expected);
        String actual = usersPage.startDate.getAttribute("value");
        System.out.println("actual = " + actual);
        assertEquals(expected, actual);
    }

    @Then("end date should be one month from today")
    public void end_date_should_be_one_month_from_today() {
        String expected = BrowserUtils.printOneMonthFromToday();
        System.out.println("expected = " + expected);
        String actual = usersPage.endDate.getAttribute("value");
        System.out.println("actual = " + actual);
        assertEquals(expected, actual);
    }

    @When("I enter new user information with random email")
    public void i_enter_new_user_information_with_random_email() {
        usersPage.fullName.sendKeys(randomFullName);
        BrowserUtils.wait(3);
        usersPage.password.sendKeys(randomPassword);
        usersPage.email.sendKeys(randomEmail);
        usersPage.address.sendKeys(randomAddress);
    }

    @When("I click the Close link")
    public void i_click_the_Close_link() {
        usersPage.close.click();
    }

    @Then("the users table should not contain user with that email")
    public void the_users_table_should_not_contain_user_with_that_email() {
        for (int i = 0; i < usersPage.allEmails.size(); i++) {
            assertFalse(BrowserUtils.getElementsText(usersPage.allEmails).
                    contains(randomEmail));
        }
    }

    @When("I save new user information with random email")
    public void i_save_new_user_information_with_random_email() {
        BrowserUtils.wait(3);
        usersPage.saveChanges.click();
        BrowserUtils.wait(3);
    }

    @Then("the users table must contain the correct user information")
    public void the_users_table_must_contain_the_correct_user_information() {

            List<String> allRowsText = BrowserUtils.getElementsText(usersPage.allRows);

        boolean found = false;
        for (String row : allRowsText) {
            System.out.println("row = " + row);
            found = row.contains(randomFullName)
                    && row.contains(randomEmail);

            if (found) {
                break;
            }
        }
        assertTrue("User was found ", found);
    }
}

