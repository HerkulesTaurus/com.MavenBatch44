package day06_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_AramaTesti {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        //1. “https://www.saucedemo.com” Adresine gidin
        driver.get("https://www.saucedemo.com");

        //2. Username kutusuna “standard_user” yazdirin
        //WebElement usernameKutusu=driver.findElement(By.id("user-name")); noylede olur
        driver.findElement(By.id("user-name")).sendKeys("standard_user");



        //3. Password kutusuna “secret_sauce” yazdirin
        //WebElement passwordKutusu=driver.findElement(By.id("//input[@id='password']")); boylede olur
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("secret_sauce");



        //4. Login tusuna basin
        driver.findElement(By.id("login-button")).click();

        //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        WebElement ilkurunElementi=driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]"));
        String ilkurunISmi=ilkurunElementi.getText();
        ilkurunElementi.click();

        //6. Add to Cart butonuna basin
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        //7. Alisveris sepetine tiklayin
        driver.findElement(By.id("shopping_cart_container")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        WebElement sepettekiUrunIsmiElementi=driver.findElement(By.xpath("//div[@class='inventory_item_name']"));
        String sepettekiUrunIsmi=sepettekiUrunIsmiElementi.getText();

        if (sepettekiUrunIsmi.equals(sepettekiUrunIsmi)){
            System.out.println("Alisveris testi PASS");
        }else {
            System.out.println("Alisveris testi FAİLED");
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //9. Sayfayi kapatin

        driver.close();
    }
}
