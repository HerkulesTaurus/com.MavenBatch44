package odev;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ElifExercise2 {

        //  ...Exercise2...
//  1-driver olusturalim
//  2-java class'imiza chromedriver.exe'yi tanitalim
//  3-driver'in tum ekrani kaplamasini saglayalim
//  4-driver'a sayfanın yuklenmesini 10.000 milisaniye (10 saniye) boyunca beklesini
//    söyleyelim. Eger oncesinde sayfa yuklenirse, beklemeyi bıraksin.

        public static void main(String[] args) {

           System.setProperty("webdriver.driver.chromedriver","src/main/resources");
           WebDriver driver = new ChromeDriver();
           driver.manage().window().maximize();
           driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

           //  5-"sahibinden.com" adresine gidelim
           driver.get("https://www.sahibinden.com/");

           //  6-bu web adresinin sayfa basligini(title) ve adres(url)ini alalim
           String shbTitle = driver.getTitle();
           String shbUrl = driver.getCurrentUrl();

           //  7-title ve url'nin "Oto" kelimesinin icerip icermedigini kontrol edelim
           System.out.println("shbUrl="+shbUrl);
           System.out.println("ahbTitle"+shbTitle);


            if (shbTitle.contains("Oto")) {
                System.out.println("oto yazısı vardır");
            }else {
                System.out.println("Oto yazısı vardır");
            }

            if (shbUrl.contains("Oto")) {
                System.out.println("Oto yazısı vardır ");
            }else {
                System.out.println("Oto yazısı yoktur ");
            }

            //  8-Ardindan "gittigidiyor.com" adresine gidelim
            driver.get("https://www.gittigidiyor.com/");

            //  9-bu adresin basligini alalim ve "Sitesi" kelismesini icerip icermedigini kontrol edelim
            boolean isTrue= driver.getTitle().contains("Sitesi");
            if (isTrue) {
                System.out.println("PASS");
            }else {
                System.out.println("FAİLED ");
            }

            //  10-Bi onceki web sayfamiza geri donelim
            driver.navigate().back();

            //  11-sayfayi yenileyelim
            driver.navigate().refresh();

            //  12-Daha sonra web sayfamiza tekrar donelim ve oldugumuz sayfayi kapatalim
            driver.navigate().forward();

            //  13-En son adim olarak butun sayfalarimizi kapatmis olalim
            driver.quit();
            driver.close();

        }



}
