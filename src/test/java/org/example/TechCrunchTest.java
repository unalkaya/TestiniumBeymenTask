package org.example;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import pages.HomePage;
import pages.NewsPage;

import java.util.List;

public class TechCrunchTest extends BaseTest{
    private HomePage homePage;
    private NewsPage newsPage;

    @BeforeEach
    public void setUp() {
        super.setUp();
        homePage = new HomePage(driver);
        newsPage = new NewsPage(driver);
    }

    @Test
    public void getLatest(){
        homePage.navigateTo("https://techcrunch.com/");
        List<WebElement> latestNewsArticles = homePage.getLatestNewsArticles();

        for (WebElement article : latestNewsArticles) {
            // Verify authors
            List<WebElement> authors = article.findElements(By.xpath(".//span[contains(@class, 'river-byline__authors')]"));

            String verificationMessage;
            String author= "";

            if(authors.isEmpty()){
                verificationMessage = "No Authors";
            }else{
                verificationMessage = "Has an Author";
                author = authors.get(0).getText();
            }
            System.out.println(verificationMessage + "   " + author );

            // Verify images
            List<WebElement> images = article.findElements(By.xpath(".//img"));
            if(images.isEmpty()){
                verificationMessage = "No İmage";
            }else{
                verificationMessage = "Has an image";
            }
            System.out.println(verificationMessage);
        }
    }

    @Test
    public void latestNewsClick(){

        homePage.navigateTo("https://techcrunch.com/");


        WebElement firstNewsItem = homePage.getFirstNewsLink();
        String expectedNewsTitle = firstNewsItem.getText();
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", firstNewsItem);

        newsPage.waitForArticleToLoad();


        String actualTitle= newsPage.getArticleTitle();


        if(actualTitle.contains(expectedNewsTitle)){
            System.out.println("The browser matches the news title.");

        }else{
            System.out.println("The browser title does not match the news title.");
        }
    }


    @Test
    public void latestLinks() {

        homePage.navigateTo("https://techcrunch.com/");

        List<WebElement> linksInNewsContent = newsPage.getLinksInArticle();
        System.out.println("Verifying the links within the news content:");
        if (!linksInNewsContent.isEmpty()) {
            System.out.println("Found " + linksInNewsContent.size() + " links within the news content.");
            for (WebElement link : linksInNewsContent) {
                System.out.println("Link: " + link.getAttribute("href"));
            }
        } else {
            System.out.println("No links found within the news content.");
        }
    }

    @AfterEach
    public void tearDown() {
        super.tearDown();
    }
}