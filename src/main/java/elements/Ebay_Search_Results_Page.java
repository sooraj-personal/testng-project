package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Ebay_Search_Results_Page {

    @FindBy(xpath = "//a[@title='Click this link to access Apple iPhone X 256GB Unlocked Smartphone - Very Good']")
    WebElement firstSearchResult;

}
