package WileyTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

/**
 * Created by SEWA on 21.05.2017.
 */
public class WileyTests4 {
    WebDriver driver = new ChromeDriver();

    @Before
    public void setup() {
        driver.get("http://eu.wiley.com/WileyCDA/Section/id-WILEYEUROPE2_SEARCH_RESULT.html?query=for%20dummies");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void aftertest() {
        driver.quit();
    }

    @Test
    public void Test10() throws Exception {
        try {
            ArrayList<WebElement> books = new ArrayList<WebElement>();
            books.addAll(driver.findElements(By.xpath("//div[@class='product-title']")));
            int numOfBooks = books.size();
            Random randomGenerator = new Random();
            int randomInt = randomGenerator.nextInt(numOfBooks)-1;
            WebElement randomBook =  driver.findElements(By.xpath("//div[@class='product-title']/a")).get(randomInt);
            String nameOfRandomBook = randomBook.getText();
            randomBook.click();
            if (!nameOfRandomBook.equals(driver.findElement(By.tagName("h1")).getText()))
                fail("title and header don't match or there is no header displayed");
        }
        catch (Exception e) {
            fail("no books displayed");
        }
    }
    @Test
    public void Test11() throws Exception{
        try{
            driver.get("http://eu.wiley.com/WileyCDA/WileyTitle/productCd-1118769465.html");
            driver.findElement(By.linkText("Home")).click();
        }
        catch(Exception e){
            fail("couldn't find Home button");
        }
    }
    @Test
    public void Test12() throws Exception{
        try{
            driver.get("http://eu.wiley.com/WileyCDA/");
            driver.findElement(By.linkText("Institutions")).click();
            int numOfTabs = driver.getWindowHandles().size();
            if (!(numOfTabs==2))
                fail("didn't open a new tab");

        }
        catch(Exception e){}
    }
}
