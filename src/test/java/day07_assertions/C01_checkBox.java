package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;



import java.time.Duration;

public class C01_checkBox {

    WebDriver driver;

@Before // setup Before methodunda genellikle kullanılan ısım
    public void setup(){
    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    driver.manage().window().maximize();

}



@Test
public void test01() throws InterruptedException {


    //  a. Verilen web sayfasına gidin.
    //    https://the-internet.herokuapp.com/checkboxes
    driver.get("https://the-internet.herokuapp.com/checkboxes");

    //  b. Checkbox1 ve checkbox2 elementlerini locate edin.
    WebElement checkBox1=driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
    WebElement checkBox2=driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
    //  c. Checkbox1 seçili değilse onay kutusunu tıklayın

    if (!checkBox1.isSelected()) {
        checkBox1.click();
    }
    //  d. Checkbox2 seçili değilse onay kutusunu tıklayın

    if (!checkBox2.isSelected()){
    checkBox1.click();
    }
    Thread.sleep(15);
    }




@After // teardown After methodunda genellikle kullanılan ısım
    public void teardown(){

}



}
