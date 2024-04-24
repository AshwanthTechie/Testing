package ce8;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
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

public class demoblaze {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void start(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebDriverManager.chromedriver().setup();
        driver.get("https://www.demoblaze.com/");
        driver.manage().window().maximize();
    }
    @Test(priority = 0)
    public void cart(){
        WebElement laptop = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[5]/div/div[1]/div/a[3]")));
        laptop.click();
    
        WebElement categories = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[5]/div/div[1]/div/a[3]")));
        Actions action = new Actions(driver);
        action.moveToElement(categories).click().perform();
                
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    
    
        WebElement shitbox1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[5]/div/div[2]/div/div[3]/div/a/img")));
        shitbox1.click();
        
        WebElement addtocart = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[5]/div/div[2]/div[2]/div/a")));
        addtocart.click();
    
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
        
        WebElement cart = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/nav/div/div/ul/li[4]/a")));
        cart.click();
        
        WebElement cell = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[6]/div/div[1]/div/table/tbody/tr/td[2]")));
        String prodname = cell.getText();
        Assert.assertEquals(prodname, "MacBook air");
    }
    @Test(priority = 1,dataProvider = "data")
    public void login(String uname,String pword){
        WebElement login = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/nav/div[1]/ul/li[5]/a")));
        login.click();
    
        WebElement unametab = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername"))); 
        unametab.sendKeys(uname);
        
        WebElement pwordtab = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginpassword")));
        pwordtab.sendKeys(pword);
        
        WebElement signin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div/div/div[3]/button[2]")));
        signin.click();

        WebElement close = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div/div/div[3]/button[1]")));
        close.click();

        WebElement check = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/nav/div[1]/ul/li[7]/a")));
        String user = check.getText();
        Assert.assertEquals(user, "Welcome Testalpha");
    }

    @DataProvider(name ="data")
        public Object[][] fetchData() throws IOException
        {
            Object[][] data=new Object[1][2];
            data[0][0] = "Testalpha";
            data[0][1] = "Test@123"; 
            return data;
        }

}
