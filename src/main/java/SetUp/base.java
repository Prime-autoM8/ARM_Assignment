package SetUp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class base {


        public static WebDriver driver;
        protected WebDriver getDriver() {

            System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
            if (driver == null) {
                driver = new ChromeDriver();
            }
            return driver;
        }



    }

