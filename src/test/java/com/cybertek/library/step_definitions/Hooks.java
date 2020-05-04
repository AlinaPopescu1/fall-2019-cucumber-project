package com.cybertek.library.step_definitions;
import com.cybertek.library.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hooks {
    @Before(order = 0)
    public void setUpScenario(){
        System.out.println("Setting up the browser");
        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Driver.getDriver().manage().window().maximize();
    }
    @Before(order=1)
    public void connect(){
    }
    @After
    public void tearDownScenario(Scenario scenario){
        if(scenario.isFailed()){
            //take screenshot using Selenium
            //it is in raw format, give the raw data to the file itself, not the actual file,
            //it's representation of the screenshot in binary(0 and 1)
           final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).
                    getScreenshotAs(OutputType.BYTES);

            //I can also use this line to customize my message for the scenario
            //scenario.write("Completed scenarios: " + scenario.getName());

            //attach to report
            //embed() is taking the screenshot and attach it to report
            //cucumber is the one saving it
            scenario.embed(screenshot, "image/png", scenario.getName());
        }
        Driver.closeDriver();
    }
}
