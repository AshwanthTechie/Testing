package ce7;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EconomicTimesTest {
    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    String maintab;
    @BeforeTest
    public void driver(){
        WebDriverManager.chromedriver().setup();
    }
    @Test(priority = 0)
    public void opensite(){
        driver.get("https://economictimes.indiatimes.com/et-now/results");
        driver.manage().window().maximize();

    }
    @Test(priority = 1)
    public void mutualfunds(){
        WebElement mutualfundsbutton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='topnav']/div[10]/a")));
        mutualfundsbutton.click();
    }
    @Test(priority = 2)
    public void AMCSearch(){
        WebElement AMC = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='sideBar']/div[4]")));
        Actions act = new Actions(driver);
        act.moveToElement(AMC).perform();
    }
    @Test(priority = 3)
    public void AMCName(){
        WebElement AMCName = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='amcSelection']/option[10]")));
        AMCName.click();
    }
    @Test(priority = 4)
    public void AMCScheme(){
        WebElement AMCScheme = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section/main/aside/div[4]/div[3]/div/select/option[6]")));
        AMCScheme.click();
    }
    @Test(priority = 5)
    public void getdetails(){
        WebElement GetDetail = wait.until(ExpectedConditions.elementToBeClickable(By.id("anchor3")));
        GetDetail.click();
    }
    @Test(priority = 6) 
    public void sip(){
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        maintab = tabs.get(0);
        driver.switchTo().window(tabs.get(1));
        WebElement sip1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/main/div[10]/section[1]/div/div[2]/div[1]/div[2]/ul")));
        WebElement sip = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/main/div[10]/section[1]/div/div[2]/div[1]/div[2]/ul/li/ul/li[1]/span")));
        Actions actions = new Actions(driver);
        actions.moveToElement(sip1).click().perform();
        sip.click();

    }
    @Test(priority = 7)
    public void amt(){
        WebElement amt1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/main/div[10]/section[1]/div/div[2]/div[1]/div[3]/ul/li")));
        WebElement amt = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='installment_amt']/li/ul/li[3]/span")));
        Actions actions = new Actions(driver);
        actions.moveToElement(amt1).click().perform();
        amt.click();
    }
    @Test(priority = 8)
    public void year(){
        WebElement year1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/main/div[10]/section[1]/div/div[2]/div[1]/div[4]/ul/li")));
        WebElement year = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/main/div[10]/section[1]/div/div[2]/div[1]/div[4]/ul/li/ul/li[4]/span")));
        Actions actions = new Actions(driver);
        actions.moveToElement(year1).click().perform();
        year.click();
    }
    @Test(priority = 9)
    public void return1(){
        WebElement Return1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/main/div[10]/section[3]/div/ul/li[2]")));
        Return1.click();
    }
    
}
