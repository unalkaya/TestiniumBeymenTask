package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class NewsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public NewsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void waitForArticleToLoad() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//article")));
    }


    public String getArticleTitle() {
        return driver.getTitle();
    }

    public List<WebElement> getLinksInArticle() {


        return driver.findElements(By.xpath("//article//a"));
    }
}