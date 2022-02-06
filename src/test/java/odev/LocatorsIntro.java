package odev;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class LocatorsIntro {

    public static void main(String[] args) {

        // 1. Bir class oluşturun: LocatorsIntro
        // 2. Main method oluşturun ve aşağıdaki görevi tamamlayın.
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //    a. http://a.testaddressbook.com adresine gidiniz.
        driver.get("http://a.testaddressbook.com");

        //    b. Sign in butonuna basin
        driver.findElement(By.id("sign-in")).click();

        //    c. email textbox,password textbox, and signin button elementlerini locate ediniz..
        WebElement emailTextBox=driver.findElement(By.id("session_email"));
        WebElement passwordTextBox=driver.findElement(By.id("session_password"));
        WebElement signInButton=driver.findElement(By.name("commit"));

        //    d. Kullanıcı adını ve şifreyi aşağıya girin ve oturum aç (sign in)buttonunu tıklayın:
        //    i. Username : testtechproed@gmail.com
        emailTextBox.sendKeys("testtechproed@gmail.com");
        //    ii.Password : Test1234!
        passwordTextBox.sendKeys("Test1234!"+ Keys.ENTER);
        //signInButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //    e. Expected user id nin testtechproed@gmail.com oldugunu dogrulayin(verify).
        String expectedUserId=driver.findElement(By.xpath("//span[@class='navbar-text']")).getText();
        String actualUserId="testtechproed@gmail.com";
        System.out.println(expectedUserId.equals(actualUserId) ? "Id test is PASSED" : "Id test is FAİLED/n actual user Id :"+actualUserId);

        //    f. “Addresses” ve “Sign Out” textlerinin görüntülendiğini( displayed) doğrulayin(verify).
        WebElement addresses=driver.findElement(By.xpath("//*[@id='navbar']/div[1]/a[2])"));

        if (addresses.isDisplayed()){
            System.out.println("Adresses test PASS");
        }else{
            System.out.println("Adresses test FAİLED");
        }

        WebElement signOut=driver.findElement(By.xpath("//*[@id='navbar']/div[1]/a[3]"));

        if (signOut.isDisplayed()){
            System.out.println("SignOut test PASS");
        }else{
            System.out.println("SignOut test FAİLED");
        }

        // 3. Sayfada kac tane link oldugunu bulun.
        List<WebElement> sayfadakiLinkSayisi = driver.findElements(By.tagName("a"));
        System.out.println("sayfada link sayisi:"+sayfadakiLinkSayisi.size());

        // 4.Linklerin yazisini nasil yazdirabiliriz
        sayfadakiLinkSayisi.stream().forEach(t-> System.out.println("linklerin yazisi:"+t.getText()));
        // 5. driver i kapatin

        driver.close();


    }
}
