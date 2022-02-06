package odev;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class ElifExercise4 {
WebDriver driver;
        // ...Exercise4...
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/main/resources");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // Navigate to  https://testpages.herokuapp.com/styled/index.html
        driver.navigate().to("https://testpages.herokuapp.com/styled/index.html");

        // Click on  Calculate under Micro Apps
        driver.findElement(By.id("calculatetest")).click();

        // Type any number in the first input
        WebElement firstBox  = driver.findElement(By.id("number1"));
        firstBox.sendKeys("25");

        // Type any number in the second input
        WebElement secondBox = driver.findElement(By.id("number2"));
        secondBox.sendKeys("60");

        // Click on Calculate
        WebElement calculate=driver.findElement(By.id("calculate"));
        calculate.click();

        // Get the result
        String answer =driver.findElement(By.id("answer")).getText();

        // Print the result
        System.out.println("answer" + answer);

    }
}
