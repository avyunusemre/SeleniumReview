import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day03_HardAssert {

    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Ignore
    @Test
    public void test() {
        driver.get("http://amazon.com");
        String baslik = driver.getTitle();

        if(baslik.contains("Car")) {
            System.out.println("Geçiyor: " + baslik);
        }else {
            System.out.println("Geçmiyor: " + baslik);
        }

        boolean iceriyorMu = baslik.contains("Car");
        Assert.assertTrue(iceriyorMu);
    }

    @Test
    public void test2() {
        driver.get("http://amazon.com");
        String baslik = driver.getTitle();

        //sayfa baslığında GOOGLE kelimesi olmasın
        boolean iceriyorMu = baslik.contains("GOOGLE");
        Assert.assertFalse(iceriyorMu);
    }

    @Test
    public void test3() {
        driver.get("http://amazon.com");
        String baslik = driver.getTitle();

        Assert.assertEquals("Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more",baslik);
    }

}
