package day06_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_IlkTestMethodu {

WebDriver driver;

    @Test
    public void test01(){

        // amazon.com a gidelim ve Title ın "amazon" icerdigini test edelim
        driver.get("https://www.amazon.com");
        String actualTitle=driver.getTitle();
        String arananKelime="amazon";

        if (actualTitle.contains(arananKelime)){
            System.out.println("amazon testi PASS");
        }else{
            System.out.println("amazon testi FAİLED");
        }


       // Assert.assertTrue(actualTitle.contains(arananKelime));


    }


    @Test
    public void test2() {
        // google.com a gidelim ve Title ın "google" icerdigini test edelim

        driver.get("https://www.google.com");
        //driver.findElement(By.xpath("cookies in xpath ı"));
        String actualTitle=driver.getTitle();
        String arananKelime="google";

        if (actualTitle.contains(arananKelime)){
            System.out.println("google testi PASS");
        }else{
            System.out.println("google testi FAİLED");
        }

    }

    @Before
    public void ayarlariDuzenle(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }


    @After
    public void ortaligiTopla(){
    driver.close();

    }



}








