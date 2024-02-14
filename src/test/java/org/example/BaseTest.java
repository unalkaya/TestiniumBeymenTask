package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import utils.DriverSetup;

public class BaseTest {

    protected WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = DriverSetup.setupDriver();
    }

    @AfterEach
    public void tearDown() {
        DriverSetup.closeDriver(driver);
    }

}
