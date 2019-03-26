package en.qa.test1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
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


}