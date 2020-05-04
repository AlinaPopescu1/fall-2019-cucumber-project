package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.HerokuPage;
import com.cybertek.library.pages.JqueryPage;
import com.cybertek.library.utilities.BrowserUtils;
import com.cybertek.library.utilities.ConfigurationReader;
import com.cybertek.library.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

public class RegistrationFormStepDefs {
    HerokuPage herokuPage = new HerokuPage();

    @Given("I am on Heroku page")
    public void i_am_on_Heroku_page() {
    String url = ConfigurationReader.getProperty("urlHeroku");
        Driver.getDriver().get(url);
    }

    @When("I click {string} link")
    public void i_click_link(String link) {
        BrowserUtils.clickWithJS(herokuPage.registrationForm);
    }

    @When("I enter {string} into date of birth input box")
    public void i_enter_into_date_of_birth_input_box(String text) {
    text = "worng_dob";
    herokuPage.dob.sendKeys(text);

    }

    @Then("Warning message is displayed: {string}")
    public void warning_message_is_displayed(String expectedMsg) {
        String actual = herokuPage.dobMessage.getText();
        assertEquals(expectedMsg,actual);

    }
    @Then("Verify that following options for programming {string} are displayed:")
    public void verify_that_following_options_for_programming_are_displayed(String language) {

    }
}
