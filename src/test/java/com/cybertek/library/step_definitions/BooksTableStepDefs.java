package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.BooksPage;
import com.cybertek.library.pojos.Book;
import com.cybertek.library.utilities.BrowserUtils;
import com.cybertek.library.utilities.Driver;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.List;
import java.util.Map;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BooksTableStepDefs {
    BooksPage booksPage = new BooksPage();

    @Then("books table should contain results matching {}")
    public void books_table_should_contain_results_matching(String book) {
        List<String> actualRows = BrowserUtils.getElementsText(booksPage.allRows);
        boolean found = true;

        for (String row : actualRows) {
            if (!row.toLowerCase().contains(book.toLowerCase())) {
                found = false;
            }
        }
        assertTrue(book + " was found in books table,", found);
    }

    @When("I edit the book {}")
    public void i_edit_the_book(String book) {
        BrowserUtils.waitForClickability(booksPage.search, 5).sendKeys(book);
        BrowserUtils.waitForClickability(booksPage.editBook(book), 5).click();
    }

    // register a data table type that uses a custom class
    @DataTableType
    public Book convertBook(Map<String, String> dataTable){
        Book book = new Book(dataTable.get("name"),
                dataTable.get("author"),
                dataTable.get("year"));
        return book;
    }

    @Then("I verify book information")
    public void i_verify_book_information(Book book) {

        BrowserUtils.wait(3);
        assertEquals("Book name did not match",
                book.getName(), booksPage.bookName.getAttribute("value"));
        BrowserUtils.wait(3);
        assertEquals("Book author did not match",
                book.getAuthor(), booksPage.author.getAttribute("value"));
        BrowserUtils.wait(3);
        assertEquals("Book year did not match",
                book.getYear(), booksPage.year.getAttribute("value"));
    }
}
