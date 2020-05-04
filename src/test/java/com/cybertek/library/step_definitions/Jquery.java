package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.JqueryPage;
import com.cybertek.library.utilities.BrowserUtils;
import com.cybertek.library.utilities.ConfigurationReader;
import com.cybertek.library.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.interactions.Actions;

public class Jquery {
    JqueryPage jqueryPage = new JqueryPage();
    Actions actions = new Actions(Driver.getDriver());

    @Given("I am on Jquery page")
    public void i_am_on_Jquery_page() {
        String url = ConfigurationReader.getProperty("jquery");
        Driver.getDriver().get(url);
    }

    @When("I perform drag and drop action")
    public void i_perform_drag_and_drop_action() {
    Driver.getDriver().switchTo().frame(jqueryPage.iframe);
    new Actions(Driver.getDriver()).dragAndDrop
            (jqueryPage.sourceDrag, jqueryPage.targetDrop).build().perform();

    }

//    @Then("I should see the color is {string} and the text is {string}")
//    public void i_should_see_the_color_is_and_the_text_is(String beforeColor, String expText) {
//        beforeColor = jqueryPage.targetDrop.getCssValue("background-color");
//        assertEquals(jqueryPage.targetDrop.getText(),expText);
//
//        assertNotEquals(jqueryPage.targetDrop.getCssValue("background-color"),);
//    }


}
