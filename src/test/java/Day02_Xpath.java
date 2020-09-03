import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Day02_Xpath {

    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();//Driver'ı kullanılabilir hale getirdik
        driver = new ChromeDriver(); //Driver objesini olusturduk
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test1() {
        driver.get("http://a.testaddressbook.com/");
        WebElement signIn = driver.findElement(By.linkText("Sign in"));
        signIn.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {

        }
        List<WebElement> links = driver.findElements(By.tagName("a"));

        for(WebElement w : links) {
            System.out.println(w.getText());
        }

        WebElement emailBox = driver.findElement(By.cssSelector("#session_email"));
        emailBox.sendKeys("testtechproed@gmail.com");

        WebElement passwordBox = driver.findElement(By.cssSelector("#session_password"));
        passwordBox.sendKeys("Test1234!");

        WebElement signInButton = driver.findElement(By.cssSelector(".btn.btn-primary"));
        signInButton.submit();

        List<WebElement> tumElementler = driver.findElements(By.xpath("//*"));//sayfadaki webelementlerin hepsini böyle buluruz

        WebElement tumYazılar = driver.findElement(By.tagName("body"));
        System.out.println(tumYazılar.getText());
    }

    @AfterClass
    public static void tearDown() {
        //driver.quit();
    }
}
