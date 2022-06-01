package elements;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Ebay_Advanced_Search_Page {

    @FindBy(css = "searchBtnLowerLnk")
    WebElement advSearchBtn;
    @FindBy(xpath = "//img[@id='gh-logo']")
    WebElement ebayLogo;
    @FindBy(xpath = "//input[@id='_nkw']")
    WebElement keywordsField;

    @FindBy(css = "#e1-1")
    List<WebElement> allCategorySelectBoxOptions;

}
