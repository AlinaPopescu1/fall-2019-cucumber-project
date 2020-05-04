package com.cybertek.library.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class UsersPage extends PageBase {
    //default constructor in child class
    // is calling constructor in parent class

    @FindBy(name = "tbl_users_length")
    public WebElement showRecords;

    @FindBy(xpath = "//table/tbody/tr")
    public List<WebElement> allRows;

    @FindBy(tagName = "input")
    public WebElement search;

    @FindBy(xpath = "//table/tbody/tr/td[2]")
    public List<WebElement> allUsersIds;

    @FindBy(xpath = "//table/tbody/tr/td[3]")
    public List<WebElement> allFullNames;

    @FindBy(xpath = "//table/tbody/tr/td[4]")
    public List<WebElement> allEmails;

    @FindBy(xpath = "//table/tbody/tr/td[5]")
    public List<WebElement> allGroupNames;


    @FindBy (tagName = "th")
    public List<WebElement> columnNames;

    @FindBy (css = "a.btn-lg")
    //find the a tag that contains any class with text "btn-lg"
    public WebElement addUser;

    @FindBy(css = "button.btn.default")
    //find me the element that has button
    //tag and whose class (.) contains this(btn.default)
    // -->dot instead of space
    public WebElement close;

    @FindBy (css = "button.btn.btn-primary")
    public WebElement saveChanges;

    @FindBy(xpath = "//input[@name='full_name']")
    public WebElement fullName;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement password;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement email;

    @FindBy (xpath = "//input[@name='start_date']")
    public WebElement startDate;

    @FindBy (xpath = "//input[@name='end_date']")
    public WebElement endDate;

    @FindBy (id = "address")
    public WebElement address;

    @FindBy (css = "a.page-link:not([title])")
    public List<WebElement> pageList;

    @FindBy (xpath = "//form[@id='add_user_form']")
    public WebElement form;

    @FindBy (xpath = "//div[@id='tbl_users_info']")
    public WebElement showEntries;

    @FindBy (xpath = "//td[@class='dataTables_empty']")
    public WebElement noDataMsgText;

    @FindBy (xpath = "//th[@data-name='id']")
    public WebElement userIdHeader;

    @FindBy (xpath = "//th[@data-name='email']")
    public WebElement emailHeader;

    @FindBy(id = "user_groups")
    public WebElement userGroup;

    public Select userGroupOptions(){
        return new Select(userGroup);
    }

    public Select getShowRecords() {
        return new Select(showRecords);
    }
}
