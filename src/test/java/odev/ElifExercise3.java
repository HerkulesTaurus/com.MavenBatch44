package odev;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class ElifExercise3 {
    // ...Exercise3...
//check the gender
//check the experience
//fill the date
//choose your profession -> Automation Tester
//choose your tool -> Selenium Webdriver
//choose your continent -> Antartica
//choose your command  -> Browser Commands
//click submit button

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver","src/main/resources");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // go to url : https://www.techlistic.com/p/selenium-practice-form.html
        driver.navigate().to("https://www.techlistic.com/p/selenium-practice-form.html");
        driver.manage().deleteAllCookies();
        //fill the firstname
        driver.findElement(By.name("firstname")).sendKeys("Zortingen");
        driver.findElement(By.name("lastname")).sendKeys("Dozuruk");
        driver.findElement(By.id("sex-0")).click();
        driver.findElement(By.id("exp-1")).click();
        driver.findElement(By.id("datepicker")).sendKeys("10/04/2019");
        WebElement prf = driver.findElement(By.id("profession-1"));
        prf.click();
        prf.sendKeys(Keys.PAGE_DOWN);

        //        driver.findElement(By.xpath("//a[@class='cookie-choices-button'][2]")).click();
        //        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Oguzhan");
        //        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Yucedal");
        //        driver.findElement(By.xpath("//input[@id='sex-0']")).click();
        //        driver.findElement(By.xpath("//input[@id='exp-6']")).click();
        //        driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("15.05.2030");
        //        driver.findElement(By.xpath("//input[@id='profession-1']")).click();
        //        driver.findElement(By.xpath("//input[@id='tool-2']")).click();
        //        driver.findElement(By.xpath("//select[@id='continents']")).sendKeys("Africa");
        //        driver.findElement(By.xpath("//option[normalize-space()='Browser Commands']")).click();




    }
}
