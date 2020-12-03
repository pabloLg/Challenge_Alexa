package Steps;

import Pages.AmazonPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Steps {


    private AmazonPage amazonPage;
    private ChromeDriver driver;


    @Given("the user navigates to www.amazon.com")
    public void theUserNavigatesToWwwAmazonCom() {

        try{
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Outlet\\Documents\\Alexa_challenge\\src\\main\\resources\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            driver = new ChromeDriver(options);
            driver.get("https://www.amazon.com/");
            amazonPage = new AmazonPage(driver);
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }

    @And("Searches for ‘Alexa’")
    public void searchesForAlexa() {
        amazonPage.Search("Alexa");
    }

    @And("navigates to the second page")
    public void navigatesToTheSecondPage() {
        amazonPage.GoToSecondPage();
    }

    @And("selects the third item")
    public void selectsTheThirdItem() {
        amazonPage.SelectThirdItem();
    }

    @Then("the item is available for purchase")
    public void theItemIsAvailableForPurchase() {
    }
}
