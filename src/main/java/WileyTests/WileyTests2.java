package WileyTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

/**
 * Created by SEWA on 20.05.2017.
 */
public class WileyTests2 {
    WebDriver driver = new ChromeDriver();

    @Before
    public void setup() {
        driver.get("http://eu.wiley.com/WileyCDA/Section/id-404702.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void aftertest() {
        driver.quit();
    }


    //NO Government Employees present
    @Test
    public void Test4() throws Exception {
        try {
            driver.findElement(By.linkText("Authors")).isDisplayed();
            driver.findElement(By.linkText("Librarians")).isDisplayed();
            driver.findElement(By.linkText("Booksellers")).isDisplayed();
            driver.findElement(By.linkText("Instructors")).isDisplayed();
            driver.findElement(By.xpath("//span[contains(text(), 'Students')]")).isDisplayed();
            //driver.findElement(By.linkText("Government Employees")).isDisplayed();
            driver.findElement(By.linkText("Societies")).isDisplayed();
            driver.findElement(By.linkText("Corporate Partners")).isDisplayed();

        } catch (Exception e) {
            fail("some of element(s) not present in Test4");
        }
    }

    //Students item is not clickable = item has no href = item is selected
    @Test
    public void Test5() throws Exception {
        try {
            WebElement students = driver.findElement(By.xpath("//span[contains(text(), 'Students')]"));
            WebElement other = driver.findElement(By.linkText("Societies"));
            String studentStyle = students.getCssValue("color");
            String otherStyle = other.getCssValue("color");
            String href = students.getAttribute("href");
            if (otherStyle.equals(studentStyle) || href != null)
                fail("not different style(color) or Students is clickable(has href)");
        } catch (Exception e) {
            fail("didn't find elements to operate with");
        }
    }

    @Test
    public void Test6() throws Exception {
        try {
            driver.findElement(By.linkText("Home")).click();
        }
        catch (Exception e) {
            fail("couldn't find Home element or click it");
        }
    }
}
