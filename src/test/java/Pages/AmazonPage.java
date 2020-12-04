package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import java.util.List;
import org.openqa.selenium.NoSuchElementException;

public class AmazonPage extends BasePage {

    public AmazonPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.XPATH, using = "//*[@id='twotabsearchtextbox']")
    public WebElement inputSearch;

    @FindBy(how = How.XPATH, using = "//span/div/div/ul/li/a[text()=\"2\"]")
    public WebElement secondPage;

    public String searchItems = "//*[@id=\"search\"]/div[1]/div[2]/div/span[3]/div[2]/div/div/span/div/div/div[2]/div[2]/div/div[1]/div/div/div[1]/h2/a/span";

    @FindBy(how = How.XPATH, using = "//*[@id='search']/div[1]/div[2]/div/span[3]/div[2]/div/div/span/div/div")
    public WebElement thirdElement;

    @FindBy(how = How.XPATH, using = "//*[@id='add-to-cart-button']")
    public WebElement addToCart;


    public void Search(String alexa) {
        inputSearch.sendKeys(alexa);
        inputSearch.sendKeys(Keys.ENTER);
    }

    public void GoToSecondPage() {
        secondPage.click();
    }

    public void SelectThirdItem() {
        List<WebElement> list = driver.findElements(By.xpath(searchItems));
        list.get(2).click();
    }

    public boolean VerifyItemPurchase() {

        try{
            addToCart.click();
            return true;
        }
        catch (NoSuchElementException e )
        {
            return false;
        }
    }
}