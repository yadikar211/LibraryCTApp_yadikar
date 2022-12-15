package com.SkyBlue.LibraryCT.steps;

import com.SkyBlue.LibraryCT.pages.BookPage;
import com.SkyBlue.LibraryCT.pages.LoginPage;
import com.SkyBlue.LibraryCT.utility.BrowserUtil;
import com.SkyBlue.LibraryCT.utility.DB_Util;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;

public class US04 {


    LoginPage login = new LoginPage();
    BookPage bookPage = new BookPage();
    String bookName;






    @When("I open book {string}")
    public void i_open_book(String bookName) {

        System.out.println("bookName = " + bookName);
        BrowserUtil.waitForClickablility(bookPage.search, 5).sendKeys(bookName);
        this.bookName = bookName;
    }





    @Then("book information must match the Database")
    public void book_information_must_match_the_database() {


        String actualName = bookPage.bookName.getAttribute("value");
        String actualAuthor = bookPage.author.getAttribute("value");
        String actualYear = bookPage.year.getAttribute("value");


        //String query = "select author,name,year from books where name ='"+ bookName +"'";
        String query = "select author,name,year from books where name ='Chordeiles minor'";



        DB_Util.runQuery(query);

        Map<String,String> bookInfo = DB_Util.getRowMap(1);


        String expectedName = bookInfo.get("name");

        String expectedAuthor =bookInfo.get("author");

        String expectedYear = bookInfo.get("year");



        Assert.assertEquals(expectedName,actualName);

        Assert.assertEquals(expectedYear,actualYear);

        Assert.assertEquals(expectedAuthor,actualAuthor);

    }


}
