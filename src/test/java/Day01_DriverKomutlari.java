import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day01_DriverKomutlari {

    @Test
    public void test1() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //driver'ı tam ekran yaptık
        driver.manage().window().maximize();
        //webelementlerin yüklenmesini 10 sn bekleyebilirsin
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.google.com");

        //herhangi bir web sayfasına gider
        driver.navigate().to("http://amazon.com");

        //bir önceki sayfaya gider.
        driver.navigate().back();

        //ileri gider
        driver.navigate().forward();

        //sayfayı yeniler
        driver.navigate().refresh();

        //driver'ı kapatmak icin kullanılır
        driver.quit();

        //acık olan sekmeyi kapatmak icin kullanılır
        driver.close();
    }
}
