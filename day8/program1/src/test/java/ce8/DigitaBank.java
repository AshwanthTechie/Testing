package ce8;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DigitaBank {
    WebDriver driver;
    WebDriverWait wait; 
    String url;
    @BeforeMethod
    public void before(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebDriverManager.chromedriver().setup();
        driver.get("http://dbankdemo.com/bank/login");
        driver.manage().window().maximize();
    }
    @Test(priority = 0,dataProvider = "data")
    public void testng(String uname,String pword){

        WebElement unametab = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        unametab.sendKeys(uname);
        
        WebElement pwordtab = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        pwordtab.sendKeys(pword);
        
        WebElement signin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submit")));
        signin.click();
        
        url = driver.getCurrentUrl();
        
        String split_url[] = url.split("/");
        
        for(String check : split_url){
            if(check.contains("home")){
                Assert.assertEquals(check, "home");
                
            }
        }
    }
    @Test(priority = 1,dataProvider = "data")
    public void deposit(String uname,String pword){

        WebElement unametab = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        unametab.sendKeys(uname);
        
        WebElement pwordtab = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        pwordtab.sendKeys(pword);
        
        WebElement signin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submit")));
        signin.click();

        WebElement deposit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/aside/nav/div[2]/ul/li[5]/a")));
        
        Actions action = new Actions(driver);
        action.moveToElement(deposit).click().perform();
        
        WebElement deposittype = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/form/div[1]/div[2]/div/div/select/option[2]")));
        deposittype.click();
        
        WebElement depositamt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/form/div[1]/div[3]/div/input")));
        action.moveToElement(depositamt).click().sendKeys("5000").perform();
    
        WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/form/div[2]/button[1]")));
        submit.click();
    
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,700)");
        
    }
    @Test(priority = 2,dataProvider = "data")
    public void withdraw(String uname,String pword){
        WebElement unametab = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        unametab.sendKeys(uname);
        
        WebElement pwordtab = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        pwordtab.sendKeys(pword);
        
        WebElement signin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submit")));
        signin.click();

        WebElement withdraw = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/aside/nav/div[2]/ul/li[6]/a")));
        
        Actions action = new Actions(driver);
        action.moveToElement(withdraw).click().perform();
        
        WebElement withdrawtype = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/form/div[1]/div[2]/div/div/select/option[2]")));
        withdrawtype.click();
        
        WebElement withdrawamt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/form/div[1]/div[3]/div/input")));
        action.moveToElement(withdrawamt).click().sendKeys("3000").perform(); 
        
        WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/form/div[2]/button[1]")));
        submit.click();
        
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,700)");
        
    }
        @DataProvider(name ="data")
        public Object[][] fetchData() throws IOException
        {
            Object[][] data=new Object[1][2];
            data[0][0] = "S@gmail.com";
            data[0][1] = "P@ssword12"; 
            return data;
        }
}