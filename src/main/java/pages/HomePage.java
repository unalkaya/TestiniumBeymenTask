package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateTo(String url) {
        driver.get(url);
    }

    public List<WebElement> getLatestNewsArticles() {
        return driver.findElements(By.xpath("//article[contains(@class, 'post-block')]"));
    }

   /* public boolean hasAuthor(WebElement article) {
        List<WebElement> authors = article.findElements(By.xpath(".//span[contains(@class, 'river-byline__authors')]"));
        return !authors.isEmpty();
    }*/

    public boolean hasImage(WebElement article) {
        List<WebElement> images = article.findElements(By.xpath(".//img"));
        return !images.isEmpty();
    }

    public WebElement getFirstNewsLink() {
        return driver.findElement(By.xpath("(//article[contains(@class, 'post-block')]//a[contains(@class, 'post-block__title__link')])[1]"));
    }
}