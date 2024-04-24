package com.example;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MoneyControl 
{
    public static void main( String[] args ) throws InterruptedException
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.moneycontrol.com");
        driver.findElement(By.xpath("/html/body/div/div[1]/span/a")).click();
        
        WebElement search= driver.findElement(By.xpath("//*[@id=\"search_str\"]"));
        search.sendKeys("Reliance Industries");
        
        driver.findElement(By.xpath("//*[@id='Capa_1']")).click();
        Thread.sleep(3000);

        WebElement Reliance=driver.findElement(By.xpath("//*[@id='mc_mainWrapper']/div[3]/div[2]/div/table/tbody/tr[1]/td[1]/p"));
        Reliance.click();

        System.out.println(driver.getTitle());

        WebElement mutual=driver.findElement(By.xpath("//*[@id='common_header']/div[1]/div[3]/nav/div/ul/li[10]/a"));
        mutual.click();
        Thread.sleep(3000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");

        WebElement SIP = driver.findElement(By.xpath("//*[@id=\"mc3_return\"]/div[1]/ul/li[2]/a"));
        SIP.click();
    }
}
