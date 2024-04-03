package org.example;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;

import java.time.Duration;

public class BeymenTest extends BaseTest {
    private HomePage homePage;
    Duration duration = Duration.ofSeconds(30);
    private WebDriverWait         wait = new WebDriverWait(driver, duration);

    private final String URL = "https://www.beymen.com/";

    String filePath = "C:\\Users\\Ünal\\Desktop\\TestBeymen\\TestBeymen.xlsx";
    String sheetName = "Sheet1";





    @BeforeEach
    public void setUp() {
        super.setUp();
        homePage = new HomePage(driver);
        driver.manage().window().maximize();
    }

    @Test
    public void testPageOpen() {
        driver.get(URL);
        try {
            wait.until(driver -> driver.getCurrentUrl().equals(URL));
            Assertions.assertFalse(homePage.isPageOpened(), "Page is opened");
        } catch (TimeoutException e) {
            Assertions.fail("Timeout waiting for page to load");
        }
    }

    @Test
    public void testSearchFunctionality() {
        driver.get(URL);

        homePage.searchFromExcel(filePath,sheetName,1,1);

        homePage.clearSearchField();

        homePage.searchFromExcel(filePath,sheetName,1,2);

        homePage.searchFieldClick();

        homePage.addToCard();

        homePage.myCardClick();

        homePage.assertPrice();

        homePage.addQuantity();

        homePage.clearShoppingCart();

    }


    @AfterEach
    public void tearDown() {
        super.tearDown();
    }
}