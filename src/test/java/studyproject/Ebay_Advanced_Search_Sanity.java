package studyproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Ebay_Advanced_Search_Sanity {
    WebDriver driver;

    @BeforeClass
    public void BeforeClassSetup() {
        System.out.println("Before Class settings done");
        System.out.println("Execution starts : EBayHome_Sanity");
    }

    @AfterClass
    public void afterClassSetup() {

        System.out.println("After Class settings done");
        System.out.println("Execution Ends : EBayHome_Sanity");

    }

    @BeforeMethod
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.ebay.com/sch/ebayadvsearch");
        Thread.sleep(2000);
    }

    @AfterMethod
    public void tearDown() {

        driver.close();
    }

    @Test
    public void empty_advanced_search_test() throws Exception {

        WebElement searchButton = driver.findElement(By.cssSelector("#searchBtnLowerLnk"));
        String expectedUrl = "https://www.ebay.com/n/all-categories";
        String expectedTitle = "Shop by Category | eBay";

        Assert.assertTrue(searchButton.isEnabled(), "Test whether the search button is enabled");
        searchButton.click();
        Thread.sleep(2000);

        String newUrl = driver.getCurrentUrl();
		String newTitle = driver.getTitle();

		System.out.println(newUrl);
		System.out.println(newTitle);

        Assert.assertEquals(newUrl, expectedUrl, "Verify url of the new page");
		Assert.assertEquals(newTitle, expectedTitle, "Verify title of the new page");

    }
}
