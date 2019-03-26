package en.qa.test1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Tests {
  WebDriver wd;

  @BeforeMethod
  public void setup() throws Exception{
    System.setProperty("webdriver.chrome.driver", "C:\\Tools\\chromedriver.exe");
    wd = new ChromeDriver();
    wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    wd.get("https://market.yandex.ru/");
  }
  @Test
  public void mainpageTest(){
    String pageTitle = wd.findElement(By.xpath("//a/span[contains(text(), 'Маркет')]")).getText();
    Assert.assertEquals(pageTitle, "Маркет");
  }
  @Test
  public void searchResultTest(){
    wd.findElement(By.id("header-search")).sendKeys("Купить гардероб");
    wd.findElement(By.xpath("//span[@class='button2__text']/parent::button")).click();
    String results = wd.findElement(By.xpath("//div[contains(text(), 'найдено')]")).getText();
    Assert.assertEquals(results, "блаблабла");
  }
  @Test
  public void mainPageTest(){
    wd.findElement(By.xpath("//span[text() = 'Яндекс']/parent::a")).click();
    boolean titleMainPage = wd.findElement(By.className("home-logo__default")).isDisplayed();
    Assert.assertEquals(titleMainPage, true);
  }

  @AfterMethod
  public void tearDown(){
    wd.quit();
    wd = null;
  }


}