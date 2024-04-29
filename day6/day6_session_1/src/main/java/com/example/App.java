package com.example;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {
        // System.out.println( "Hello World!" );
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://economictimes.indiatimes.com/et-now/results");
        WebElement mutualfund = driver.findElement(By.xpath("//*[@id=\"topnav\"]/div[10]/a"));
        mutualfund.click();

        Thread.sleep(5000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");

        WebElement amc = driver.findElement(By.xpath("//*[@id=\"amcSelection\"]"));
        Select amcSelect = new Select(amc);
        amcSelect.selectByVisibleText("Canara Robeco");

        Thread.sleep(2000);

        WebElement scheme = driver.findElement(By.xpath("//*[@id=\"schemenm\"]"));
        Select schemeSelect = new Select(scheme);
        schemeSelect.selectByVisibleText("Canara Robeco Bluechip Equity Direct-G");

        WebElement getDetail = driver.findElement(By.xpath("//*[@id=\"anchor3\"]"));
        getDetail.click();
        
        ArrayList<String> windowhandles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowhandles.get(1));

        WebElement type = driver.findElement(By.xpath("//*[@id=\"installment_type\"]/li/i"));
        type.click();
        driver.findElement(By.xpath("//*[@id=\"installment_type\"]/li/ul/li[1]")).click(); //sip

        WebElement amount = driver.findElement(By.xpath("//*[@id='installment_amt']/li"));
        amount.click();

        driver.findElement(By.xpath("//*[@id=\"installment_amt\"]/li/ul/li[3]")).click();

        WebElement period = driver.findElement(By.xpath("//*[@id=\"installment_period\"]/li"));
        period.click();
        driver.findElement(By.xpath("//*[@id=\"installment_period\"]/li/ul/li[4]/span")).click();
    }
}
