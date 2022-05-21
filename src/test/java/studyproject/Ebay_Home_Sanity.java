package studyproject;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Ebay_Home_Sanity {

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
		driver.get("https://www.ebay.com/");
		Thread.sleep(2000);
	}

	@AfterMethod
	public void tearDown() {

		driver.close();
	}

	@Test
	public void empty_Search_test() throws Exception {

		String expectedUrl = "https://www.ebay.com/n/all-categories";
		String expectedTitle = "Shop by Category | eBay";

		Assert.assertTrue(driver.findElement(By.id("gh-btn")).isEnabled(), "Verify search button enabled");
		// Assert.assertFalse(driver.findElement(By.id("gh-btn")).isEnabled(),"Verify
		// search button disabled");
		// Assert.assertNull(expectedUrl, expectedTitle);
		// Assert.assertNotNull(expectedUrl, expectedTitle);

		driver.findElement(By.id("gh-btn")).click();
		Thread.sleep(2000);

		String newUrl = driver.getCurrentUrl();
		String newTitle = driver.getTitle();

		System.out.println(newUrl);
		System.out.println(newTitle);

		Assert.assertEquals(newUrl, expectedUrl, "Verify url of the new page");
		Assert.assertEquals(newTitle, expectedTitle, "Verify title of the new page");

		// Assert.assertNotEquals(expectedTitle, newTitle,"Desc");

	}

	@Test
	public void empty_Search_test_softassert() throws Exception {

		SoftAssert sa = new SoftAssert();

		String expectedUrl = "https://www.ebay.com/n/all-categories";
		String expectedTitle = "Shop by Category | eBay";
		sa.assertFalse(driver.findElement(By.id("gh-btn")).isEnabled(), "Verify search button disabled");
		driver.findElement(By.id("gh-btn")).click();
		Thread.sleep(2000);

		String newUrl = driver.getCurrentUrl();
		String newTitle = driver.getTitle();

		System.out.println(newUrl);
		System.out.println(newTitle);

		sa.assertEquals(newUrl, expectedUrl, "Verify url of the new page");
		sa.assertEquals(newTitle, expectedTitle, "Verify title of the new page");

		// Assert.assertNotEquals(expectedTitle, newTitle,"Desc");

		sa.assertAll();
	}
}