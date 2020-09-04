import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day03_isDisplayed {

    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void isDisplayed() {
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        WebElement baslik = driver.findElement(By.xpath("//*[.='Dynamic Controls']"));
        boolean gorunuyorMu =baslik.isDisplayed();
        System.out.println("Görünüyor mu: " + gorunuyorMu);
    }

    @Test
    public void isSelected() {
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        WebElement secimElementi = driver.findElement(By.xpath("//input[@type='checkbox']"));

        boolean seciliMi = secimElementi.isSelected();
        System.out.println("Seçili mi 1: " + seciliMi);

        secimElementi.click();

        boolean seciliMi2 = secimElementi.isSelected();
        System.out.println("Seçili mi 2: " + seciliMi2);
    }

    @Test
    public void isEnabled() {
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        WebElement inputKutusu = driver.findElement(By.xpath("//input[@type='text']"));
        boolean aktifMi = inputKutusu.isEnabled();
        System.out.println("Aktif mi : " + aktifMi);

        WebElement enableButonu = driver.findElement(By.xpath("//*[.='Enable']"));
        enableButonu.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {

        }
        boolean aktifMi2 = enableButonu.isEnabled();
        System.out.println("Aktif mi 2: " + aktifMi2);

    }
}
