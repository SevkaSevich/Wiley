package WileyTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

/**
 * Created by SEWA on 21.05.2017.
 */
public class WileyTests3 {
    WebDriver driver = new ChromeDriver();

    @Before
    public void setup() {
        driver.get("http://www.wiley.com/WileyCDA/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void aftertest() {
        driver.quit();
    }

    @Test
    public void Test7() throws Exception {
        try {
            driver.findElement(By.id("id31")).click();
            Alert alert = driver.switchTo().alert();
            if (!alert.getText().equals("Please enter email address"))
                fail("not correct alert message");
        } catch (Exception e) {
            fail("didn't find arrow button or no alert appeared");
        }
    }

    @Test
    public void Test8() throws Exception {
        try {
            driver.findElement(By.id("EmailAddress")).sendKeys("notvalidemailaddress");
            driver.findElement(By.id("id31")).click();
            Alert alert = driver.switchTo().alert();
            if (!alert.getText().equals("Invalid email address."))
                fail("not correct alert message");
        } catch (Exception e) {
            fail("didn't find arrow button or no alert appeared");
        }
    }

    @Test
    public void Test9() throws Exception {
        try {
            driver.findElement(By.id("query")).sendKeys("for dummies");
            driver.findElement(By.xpath("//input[@type='submit']")).click();
            Boolean listElement = driver.findElement(By.id("search-results")).isDisplayed();
            if (!listElement)
                fail("no list of items present");
        } catch (Exception e) {
            fail("didn't find items to operate with");
        }
    }

}
