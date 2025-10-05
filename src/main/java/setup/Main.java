package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import java.util.List;
import static org.openqa.selenium.support.locators.RelativeLocator.with;
import org.openqa.selenium.support.ui.Select;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class Main {

  static WebDriver driver;

  static {
    chromedriver().setup();
    driver = new ChromeDriver();
  }

  public static void main(String[] args) {

    driver.get("https://www.selenium.dev/selenium/web/web-form.html");

    Select dropdown = new Select(driver.findElement(By.name("my-select")));
    dropdown.selectByValue("2");
    //dropdown.selectByVisibleText("Three");

    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
    }

    driver.quit();
  }
}