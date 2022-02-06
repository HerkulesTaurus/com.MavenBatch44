package odev;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

// ...Exercise4...
public class ElifExercise5 {

    static WebDriver driver;
    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // Navigate to website  https://testpages.herokuapp.com/styled/index.html
        driver.get("https://testpages.herokuapp.com/styled/index.html");
    }

    @Test
    public void tets(){

        // Under the  ORIGINAL CONTENTS
        // click on Alerts

        // print the URL
        System.out.println(driver.getCurrentUrl());

        // navigate back
        driver.navigate().back();

        // print the URL
        String actualUrl= driver.getCurrentUrl();
        System.out.println(actualUrl);

        // Click on Basic Ajax

        // print the URL
        // enter value-> 20 and Enter
        // and then verify Submitted Values is displayed open page
        // close driver
    }

        @AfterClass
        public static void teardown(){
            // driver.close();
        }



}
