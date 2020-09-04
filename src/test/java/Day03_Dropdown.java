import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Day03_Dropdown {
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();//Driver'ı kullanılabilir hale getirdik
        driver = new ChromeDriver(); //Driver objesini olusturduk
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void dropdown1() {
        driver.get("http://amazon.com");
        WebElement dropDown = driver.findElement(By.id("searchDropdownBox"));

        Select select = new Select(dropDown);
        // seçili olan option alabiliriz.
        select.getFirstSelectedOption();

        // biz farklı bir kategori seçmek istersek ?
        // 3 farklı seçeneğimiz var
        // 1. selectByVisibleText
        select.selectByVisibleText("Baby");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

        }
        //2. selectByIndex
        select.selectByIndex(5);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

        }

        //3. selectByValue
        select.selectByValue("search-alias=computers-intl-ship");

        //dropdown icerisindeki tum secenekleri almak istersek
        List<WebElement> allOptions = select.getOptions();

        System.out.println("Number of all options : " + allOptions.size());

        for(WebElement w : allOptions) {
            System.out.println(w.getText());
        }


    }
}

