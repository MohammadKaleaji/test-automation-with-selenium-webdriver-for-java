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

    // Enter the user name
    WebElement userName = driver.findElement(By.id("my-text-id"));
    userName.sendKeys("Kaleaji");

    // Enter the password
    WebElement password = driver.findElement(By.name("my-password"));
    password.sendKeys("123456");

    // Enter the text area
    WebElement textArea = driver.findElement(By.name("my-textarea"));
    textArea.sendKeys("I am learning Selenium Webdriver!");
    
    // Select the dropdown
    Select dropdown = new Select(driver.findElement(By.name("my-select")));
    dropdown.selectByValue("3");
    
    // Check the checkbox
    WebElement checkbox = driver.findElement(By.id("my-check-1"));
    if (checkbox.isSelected()) {
      checkbox.click(); // Uncheck the checkbox if it is already checked
    }

    // Uncheck the checkbox
    WebElement checkbox2 = driver.findElement(By.id("my-check-2"));
    if (!checkbox2.isSelected()) {
      checkbox2.click(); // Check the checkbox if it is not checked
    }

    // Check the radio button
    WebElement radioButton = driver.findElement(By.id("my-radio-2"));
    if (!radioButton.isSelected()) {
      radioButton.click(); // Check the radio button if it is not checked
    }

    try {
      Thread.sleep(8000);
    } catch (InterruptedException e) {
    }

    // Click the submit button
    WebElement submitButton = driver.findElement(By.tagName("button"));
    submitButton.click();

    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
    }

    // Quit the driver
    driver.quit();
  }
}