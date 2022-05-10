package studyproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class EbayHome_Sanity {

    @Test
    public static void main() throws Exception {
        
        System.setProperty("webdriver.chrome,driver", "D:\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.ebay.com/");
        Thread.sleep(2000);

        driver.findElement(By.id("gh-btn")).click();
        Thread.sleep(2000);

        String newUrl=driver.getCurrentUrl();
        String newTitle=driver.getTitle();

        System.out.println(newUrl);
        System.out.println(newTitle);

        driver.close();


    }

}
