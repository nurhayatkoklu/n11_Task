package Pages;

import Utilities.GeneralWebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DialogContent extends Parent {

    public DialogContent() {
        PageFactory.initElements(GeneralWebDriver.getDriver(), this);
    }

    @FindBy(className = "btnSignIn")
    private WebElement girisYap;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "loginButton")
    private WebElement loginButton;

    @FindBy(xpath = "(//*[@class='setCookieBtn pickAll'])[2]")
    private WebElement acceptCookies;

    @FindBy(id = "rememberMe")
    private WebElement checkbox;

    @FindBy(className = "dn-slide-deny-btn")
    private WebElement later;

    @FindBy(id = "searchData")
    private WebElement searchBox;

    @FindBy(className = "searchBtn")
    private WebElement searchButton;

    @FindBy(className = "resultText")
    private WebElement verifySearchResult;

    @FindBy(xpath = "(//*[@class='followBtn'])[3]")
    private WebElement favorite;

    @FindBy(className = "btnMyFavorites")
    private WebElement myFavorites;

    @FindBy(css = "[class='listItemProductList']>li:nth-child(1)>a")
    private WebElement myFavProduct;

    @FindBy(xpath = "(//*[@class='plink'])[1]")
    private WebElement myFavProductAssert;

    @FindBy(css = "[class='deleteProFromFavorites']")
    private WebElement delete;

    @FindBy(css = "[class='message']")
    private WebElement message;


    WebElement myElement;

    public void findAndSend(String strElement, String value) {

        switch (strElement) {
            case "email":
                myElement = email;
                break;

            case "password":
                myElement = password;
                break;

            case "searchBox":
                myElement = searchBox;
                break;
        }
        sendKeysFunction(myElement, value);
    }

    public void findAndClick(String strElement) {

        switch (strElement) {

            case "girisYap":
                myElement = girisYap;
                break;

            case "loginButton":
                myElement = loginButton;
                break;

            case "acceptCookies":
                myElement = acceptCookies;
                break;

            case "checkbox":
                myElement = checkbox;
                break;

            case "later":
                myElement = later;
                break;

            case "searchButton":
                myElement = searchButton;
                break;

            case "favorite":
                myElement = favorite;
                break;

            case "myFavorites":
                myElement = myFavorites;
                break;

            case "myFavProduct":
                myElement = myFavProduct;
                break;

            case "delete":
                myElement = delete;
                break;
        }
        clickFunction(myElement);
    }

    public void findAndContainsText(String strElement, String text) {

        switch (strElement) {
            case "verifySearchResult":
                myElement = verifySearchResult;
                break;

            case "myFavProductAssert":
                myElement = myFavProductAssert;
                break;

            case "message":
                myElement = message;
                break;
        }
        verifyContainsText(myElement, text);
    }
}