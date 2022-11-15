package StepDefinitions;

import Pages.DialogContent;
import Utilities.GeneralWebDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import static Utilities.GeneralWebDriver.driver;

public class n11_Task {
    DialogContent dc=new DialogContent();

    String thirdProductName;
    @Given("Navigate to basqar")
    public void navigateToBasqar() {

        WebDriver driver = GeneralWebDriver.getDriver();
        driver.get("https://www.n11.com/");
        driver.manage().window().maximize();
    }

    @When("Verify you are on n11 home page")
    public void verifyYouAreOnTheHomePage() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.n11.com/");
        dc.findAndClick("acceptCookies");

    }

    @And("Click login")
    public void clickLogin() {
        dc.findAndClick("girisYap");

    }

    @And("Login with valid user name and password")
    public void loginWithValidUserNameAndPassword() {

      //  dc.findAndClick("later");
        dc.findAndSend("email", "nurhayativirzivir@gmail.com");
        dc.findAndSend("password", "9UkG8v!vq4vJhe");
        dc.findAndClick("loginButton");
    }

    @And("Type Samsung into Search Box and click Search button")
    public void typeSamsungIntoSearchBoxAndClickSearchButton() {
        dc.findAndSend("searchBox", "Samsung");
        dc.findAndClick("searchButton");
    }

    @And("Verify the search results")
    public void verifyTheSearchResults() {
        dc.findAndContainsText("verifySearchResult", "samsung");
    }

    @And("Click second page of the search results and verify the page displayed is the second page")
    public void clickSecondPageOfTheSearchResultsAndVerifyThePageDisplayedIsTheSecondPage() {
        WebElement page2Button = driver.findElement(By.xpath("//*[@id=\"contentListing\"]/div/div[2]/div[2]/div[2]/a[2]"));
        Actions at = new Actions(driver);
        int counter=0;

        while (!GeneralWebDriver.getDriver().getCurrentUrl().equals("https://www.n11.com/arama?q=Samsung&ipg=5")) {
            at.sendKeys(Keys.PAGE_DOWN).build().perform(); counter++;
            if ((counter==6)) {
                GeneralWebDriver.Bekle(3); counter=0; }
        }

        while (counter <5) {
            at.sendKeys(Keys.PAGE_DOWN).build().perform(); counter++; }

         page2Button.click();
        Assert.assertTrue(GeneralWebDriver.getDriver().getCurrentUrl().contains("2"));
    }

    @And("Click Add Favorites to the third product in second page")
    public void clickAddFavoritesToTheThirdProductInSecondPage() {
       dc.findAndClick("favorite");
       thirdProductName=driver.findElement(By.xpath("(//*[@class='productName'])[3]")).getText();
    }

    @And("Click My Favorites link on top")
    public void clickMyFavoritesLinkOnTop() {
        dc.findAndClick("myFavorites");
    }

    @And("Verify that it is the product that has been just added to favorites")
    public void verifyThatItIsTheProductThatHasBeenJustAddedToFavorites() {
        dc.findAndClick("myFavProduct");
        dc.findAndContainsText("myFavProductAssert", thirdProductName);
    }

    @And("Click Delete to remove product from My Favorites")
    public void clickDeleteToRemoveProductFromMyFavorites() {
        dc.findAndClick("delete");
    }

    @Then("Verify that the product is not in My Favorites link anymore")
    public void verifyThatTheProductIsNotInMyFavoritesLinkAnymore() {
        dc.findAndContainsText("message", "Ürününüz listeden silindi.");
    }
}
