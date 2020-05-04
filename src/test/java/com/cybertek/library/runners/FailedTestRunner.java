package com.cybertek.library.runners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //this class will rerun only the failed ones
        //I use maven build to configure which test
        //how does it know which file?

        glue = "com/cybertek/library/step_definitions",
        features = "@target/rerun.txt" //-->this line will tell him to check this file
)
public class FailedTestRunner {
//this does not report, to report add "html:target/default-cucumber-reports"
    //if you use the same report name as your runner file, it will
    //delete that report and create the one only if failed test
    //if you write a different name, it will create second report.
}
