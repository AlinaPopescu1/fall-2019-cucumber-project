package com.cybertek.library.step_definitions;
import com.cybertek.library.pages.UsersPage;
import com.cybertek.library.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Array;
import java.util.*;

import static org.junit.Assert.*;

public class UsersTableStepDefs {
    UsersPage usersPage = new UsersPage();

    @When("I search for {string}")
    public void i_search_for(String searchString) {
        System.out.println("I search for " + searchString);
        BrowserUtils.wait(2);
        usersPage.search.sendKeys(searchString);
        BrowserUtils.wait(2);
    }

    @Then("table should contain rows with {string}")
    public void table_should_contain_rows_with(String expectedString) {
        System.out.println("Table should contain rows with " + '"' + expectedString + '"');
        int size = usersPage.allUsersIds.size();
        for (int i = 0; i < size; i++) {
            String id = usersPage.allUsersIds.get(i).getText().toLowerCase();
            String name = usersPage.allFullNames.get(i).getText().toLowerCase();
            String email = usersPage.allEmails.get(i).getText().toLowerCase();

            System.out.println("ROW: " + (i + 1));
            System.out.println(id + "\t" + name + "\t" + email);

            boolean found = id.contains(expectedString) ||
                    name.contains(expectedString) ||
                    email.contains(expectedString);
            assertTrue(found);
        }
    }

    @Then("table should have following column names:")
    public void table_should_have_following_column_names(List<String> expColNames) {
        List<String> actualColNames = BrowserUtils.getElementsText(usersPage.columnNames);
        BrowserUtils.wait(5);
        assertEquals(expColNames, actualColNames);

    }

    @Then("table should contain this data:")
    public void table_should_contain_this_data
            (Map<String, String> user) {
        System.out.println(user.entrySet());

        String name = user.get("Full Name");
        System.out.println("name = " + name);
        String email = user.get("Email");
        System.out.println("email = " + email);
        String userID = user.get("User ID");
        System.out.println("userID = " + userID);

        //get all rows
        // verify that at least one of the rows
        // contains all of the user info

        List<WebElement> allRows = usersPage.allRows;
        List<String> allRowsText = BrowserUtils.getElementsText(allRows);

        boolean found = false;
        for (String row : allRowsText) {
            System.out.println("row = " + row);
            found = row.contains(userID) &&
                    row.contains(name) &&
                    row.contains(email);

            if (found) {
                break;
            }
        }
        assertTrue(user + " was not found = ", found);
    }

    @Then("each user ID should be unique")
    public void each_user_ID_should_be_unique() {

        usersPage.getShowRecords().selectByVisibleText("500");
        BrowserUtils.wait(1);

        List<String> IdsText =
                BrowserUtils.getElementsText(usersPage.allUsersIds);
        System.out.println(IdsText.size());

        Set<String> set = new HashSet<>(IdsText);
        System.out.println(set);

        assertEquals(IdsText.size(), set.size());

    }

    @When("I search for any valid email")
    public void i_search_for_any_valid_email() {
        usersPage.getShowRecords().selectByVisibleText("5");
        String validEmail = usersPage.allEmails.get(0).getText();
        usersPage.search.sendKeys(validEmail);

    }

    @Then("the users table must display {int} records")
    public void the_users_table_must_display_records(Integer recordNumber) {
        BrowserUtils.wait(3);
        String expected = usersPage.showEntries.getText();
        System.out.println("expected = " + expected);
        String actual = "Showing " + recordNumber + " to " + recordNumber + " of " + recordNumber + " entries";
        System.out.println("actual = " + actual);
        assertEquals(actual, expected);
    }

    @When("I search for any invalid email")
    public void i_search_for_any_invalid_email() {
        String invalidEmail = "invalidemail";
        usersPage.search.sendKeys(invalidEmail);
    }

    @Then("the users table must display message {string}")
    public void the_users_table_must_display_message(String noDataMsg) {
        assertEquals(usersPage.noDataMsgText.getText(), noDataMsg);
    }

    @Then("users table should be sorted by {string} in {string} order")
    public void users_table_should_be_sorted_by_in_order(String header, String order) {

        header = "User ID";
        switch (order) {
            case "ascending":
                List<String> ids = BrowserUtils.getElementsText(usersPage.allUsersIds);
                System.out.println("ids.toString() = " + ids.toString());
                List<String> sorted = new ArrayList<>();
                sorted.addAll(ids);
                Collections.sort(sorted);
                System.out.println("sorted.toString() = " + sorted.toString());
                assertEquals(ids, sorted);
                break;
            case "descending":
                List<String> idsDesc = BrowserUtils.getElementsText(usersPage.allUsersIds);
                System.out.println(header + " = " + idsDesc.toString());
                List<String> sortedDesc = new ArrayList<>();
                sortedDesc.addAll(idsDesc);
                System.out.println(header + " = " + sortedDesc.toString());
                assertEquals(idsDesc, sortedDesc);
                break;
            default:
                System.out.println("No such order " + order);
        }
    }


    @When("I click on the {string} column")
    public void i_click_on_the_column(String column) {
        if (column.equals("User ID")) {
            usersPage.userIdHeader.click();
        } else if (column.equals("Email")) {
            usersPage.emailHeader.click();
        }
    }

    @Then("User group default value should be {string}")
    public void user_group_default_value_should_be(String expected) {
        String actual = usersPage.userGroupOptions().getFirstSelectedOption().getText();
        assertEquals(expected, actual);
    }

    @Then("User Group should have following options:")
    public void user_Group_should_have_following_options(List<String> expected) {
        List<String> actual = BrowserUtils.getElementsText(usersPage.userGroupOptions().getOptions());

        assertEquals(expected, actual);
    }

    @When("I select User group {string}")
    public void i_select_User_group(String user) {
        usersPage.userGroupOptions().selectByVisibleText(user);
    }

    @Then("Groups columns in user table should only contain {string}")
    public void groups_columns_in_user_table_should_only_contain(String user) {

        for (int i = 0; i < usersPage.allGroupNames.size(); i++) {
            assertTrue(usersPage.allGroupNames.get(i).getText().contains(user));
        }
    }
}



