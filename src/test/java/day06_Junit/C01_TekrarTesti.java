package day06_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;

public class C01_TekrarTesti {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //1-C01_TekrarTesti isimli bir class olusturun

        //2- https://www.google.com/ adresine gidin
        driver.get("https://www.google.com");

        //3- cookies uyarisini kabul ederek kapatin--->cookies leri kapatma <---------
        //driver.findElement(By.xpath("//div[text()='Ich stimme zu']")).click();

        //4-Sayfa basliginin “Google” ifadesi icerdigini test edin
        String actualPageTitle=driver.getTitle();
        String arananKelime="Google";

        if (actualPageTitle.contains(arananKelime)){
            System.out.println("Title testi PASS");
        }else{
            System.out.println("Title testi FAİLED");
        }

        //5-Arama cubuguna “Nutella” yazip aratin
        WebElement searchBox=driver.findElement(By.xpath("//input[@name='q']"));
        searchBox.sendKeys("nutella"+ Keys.ENTER);

        //6-Bulunan sonuc sayisini yazdirin
        WebElement sonucSayisiElementi=driver.findElement(By.xpath("//div[@id='result-stats']"));
        System.out.println(sonucSayisiElementi.getText());

        //7-Sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        String sonucSayisiString = sonucSayisiElementi.getText();
        String sonucKelimeleri[]=sonucSayisiString.split(" ");
        // System.out.println(Arrays.toString(sonucKelimeleri)); yazdırma
        String sonucNutellaSayisiString = sonucKelimeleri[1]; // 78.900.000 verır 1. index deki deger
        sonucNutellaSayisiString= sonucNutellaSayisiString.replace(".", "");

        int nutellaAramaSonucu=Integer.parseInt(sonucNutellaSayisiString);

        if (nutellaAramaSonucu>10000000){
            System.out.println("Nutella arama testi PASSED");
        }else{
            System.out.println("Nutella arama testi FAİLED");
        }

        //8-Sayfayi kapatin
        driver.close();



    }
}
