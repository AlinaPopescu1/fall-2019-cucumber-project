package com.cybertek.library.pages;
import com.cybertek.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HerokuPage extends HerokuPageBase{

        public HerokuPage() {
            PageFactory.initElements(Driver.getDriver(), this);
        }

        @FindBy(linkText = "Registration Form")
        public WebElement registrationForm;

        @FindBy(xpath = "//input[@name='birthday']")
        public WebElement dob;

        @FindBy(xpath = "//form/div[8]/div/small[2]")
        public WebElement dobMessage;

        @FindBy (xpath = "//input/following-sibling::label")
        public List<WebElement> languages;

    }

