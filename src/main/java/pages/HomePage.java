package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.ExcelReader;
import utils.TxtWriter;

public class HomePage {
    private WebDriver driver;

    String xpath = "//title[contains(text(),'Beymen')]";

    private WebElement pageTitle;
    WebElement searchField;
    WebElement stockCartIcon;
    WebElement sizeButton;
    WebElement addToCartButton;
    WebElement productNameElement;
    WebElement productPriceElement;
    WebElement myCard;
    WebElement priceElement;
    WebElement quantity;
    WebElement quantityOption2;
    WebElement deleteProduct;
    WebElement cartElement;
    String productName;
    String productPrice;
    int defaultQuantity;
    int changedQuantity;
    TxtWriter txtWriter;


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }


    public boolean isPageOpened() {
        WebElement pageTitle = driver.findElement(By.xpath(xpath));
        return pageTitle.isDisplayed();
    }

    public void searchFor(String query) {
        searchField = driver.findElement(By.id("o-searchSuggestion__input"));
        searchField.sendKeys(query);

    }

    public void clearSearchField() {
        searchField = driver.findElement(By.id("o-searchSuggestion__input"));
        searchField.clear();
    }


    public void searchFieldClick() {
        searchField = driver.findElement(By.className("o-header__search--btn"));
        searchField.click();
    }

    public void searchFromExcel(String filePath, String sheetName, int rowNum, int colNum) {
        String searchText = ExcelReader.readCellValue(filePath, sheetName, rowNum, colNum);
        if (searchText != null && !searchText.isEmpty()) {
            searchField.sendKeys(searchText);
        } else {
            System.out.println("Veri bulunamadı veya boş.");
        }
    }

    public void addToCard() {
        infoOfProduct();
        stockCartIcon = driver.findElement(By.xpath("//*[@id='productList']/div[3]"));
        stockCartIcon.click();
        sizeButton = driver.findElement(By.xpath("//div[@class='m-variation']/span[2]"));
        sizeButton.click();
        addToCartButton = driver.findElement(By.xpath("//button[@id='addBasket']"));
        addToCartButton.click();
    }

    public void infoOfProduct() {
        String path = "C:\\Users\\Ünal\\Desktop\\BeymenProduct.txt";
        productNameElement = driver.findElement(By.xpath("//*[@id='productList']/div[3]/div/div/div[2]/h3/a[2]/span"));
        productName = productNameElement.getText();

        productPriceElement = driver.findElement(By.xpath("//*[@id='productList']/div[3]/div/div/div[2]/div/span[2]"));
        productPrice = productPriceElement.getText();
        txtWriter.writeProductToFile(productName, path);
        txtWriter.writeProductToFile(productPrice, path);
    }


    public void myCardClick() {
        myCard = driver.findElement(By.xpath("//a[@class='o-header__userInfo--item bwi-cart-o -cart']"));
        myCard.click();
    }


    public void assertPrice() {
        priceElement = driver.findElement(By.xpath("//span[@class='priceBox__salePrice']"));
        String priceText = priceElement.getText();

        assert productPrice.equals(priceText) : "Prices are not equal: " + productPrice + ", First Price: " + priceText;
        System.out.println("Prices are equal");
    }

    public void addQuantity() {
        quantity = driver.findElement(By.id("quantitySelect0-key-0"));
        defaultQuantity = Integer.parseInt(quantity.getText().split(" ")[0]);
        quantityOption2 = quantity.findElement(By.xpath("//option[@value='2']"));
        quantityOption2.click();
        changedQuantity = Integer.parseInt(quantity.getText().split(" ")[0]);

        assert changedQuantity > defaultQuantity : "Not bigger, first quantity: " + defaultQuantity + ", New Quantity: " + changedQuantity;

    }

    public void clearShoppingCart() {
        deleteProduct = driver.findElement(By.id("WebElement quantityOption2;"));
        deleteProduct.click();

        cartElement = driver.findElement(By.id("emtyCart"));
        if (!cartElement.getText().contains("Sepetinizde ürün bulunmamaktadır")) {
            System.out.println("Cart not empty.");
        } else {
            System.out.println("Cart empty.");
        }

    }


}