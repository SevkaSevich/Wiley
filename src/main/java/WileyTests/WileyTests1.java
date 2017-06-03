package WileyTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.fail;
import java.util.concurrent.TimeUnit;

/**
 * Created by SEWA on 20.05.2017.
 */
public class WileyTests1 {
    WebDriver driver = new ChromeDriver();

    @Before
    public void setup () {
        driver.get("http://www.wiley.com/WileyCDA/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void aftertest() {
        driver.quit();
    }
    @Test
    public void Test1() throws Exception {
        try {
                    driver.findElement(By.linkText("Home")).isDisplayed();
                    driver.findElement(By.linkText("Subjects")).isDisplayed();
                    driver.findElement(By.linkText("About Wiley")).isDisplayed();
                    driver.findElement(By.linkText("Contact Us")).isDisplayed();
                    driver.findElement(By.linkText("Help")).isDisplayed();
        }
        catch (Exception e) {
            fail("some of element(s) not present in Test1");
        }
    }

    @Test
    public void Test2() throws Exception {
        try {
            driver.findElement(By.linkText("Students")).isDisplayed();
            driver.findElement(By.linkText("Authors")).isDisplayed();
            driver.findElement(By.linkText("Instructors")).isDisplayed();
            driver.findElement(By.linkText("Librarians")).isDisplayed();
            driver.findElement(By.linkText("Societies")).isDisplayed();
            driver.findElement(By.linkText("Conferences")).isDisplayed();
            driver.findElement(By.linkText("Booksellers")).isDisplayed();
            driver.findElement(By.linkText("Corporations")).isDisplayed();
            driver.findElement(By.linkText("Institutions")).isDisplayed();

        }
        catch (Exception e){
            fail("some of element(s) not present in Test2");
        }
    }

    //actual url is http://eu.wiley.com/WileyCDA/Section/id-404702.html not http://www.wiley.com/WileyCDA/Section/id-404702.html
    @Test
    public void Test3() throws Exception {
        try{
            driver.findElement(By.linkText("Students")).click();
            String headerText = driver.findElement(By.cssSelector("h1")).getText();
            String url = driver.getCurrentUrl();
            if (!(url.equals("http://eu.wiley.com/WileyCDA/Section/id-404702.html")&& headerText.equals("Students")))
                fail("not correct URL or not correct header name");
        }
        catch(Exception e){
            fail("link doesn't work or no such header element");
        }
    }
}
