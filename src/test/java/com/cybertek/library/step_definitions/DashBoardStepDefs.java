package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.DashBoardPage;
import com.cybertek.library.pages.PageBase;
import io.cucumber.java.en.Then;

import static org.junit.Assert.assertEquals;

public class DashBoardStepDefs extends PageBase {
    DashBoardPage dashBoardPage = new DashBoardPage();

    @Then("account holder name should be {string}")
    public void account_holder_name_should_be(String expectedName) {
        String actualName = dashBoardPage.accountHolderName.getText();

        assertEquals("AccHolderName did not match",
                expectedName, actualName);

    }
}
