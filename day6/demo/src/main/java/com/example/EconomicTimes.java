package com.example;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EconomicTimes {
    public static void main(String args[]) throws InterruptedException
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.moneycontrol.com");
        driver.findElement(By.xpath("/html/body/div/div[1]/span/a")).click();

        WebElement search = driver.findElement(By.xpath("//*[@id=\"search_str\"]"));
        search.sendKeys("Reliance Industries");
        Thread.sleep(3000);

        WebElement reliance = driver.findElement(By.xpath("//*[@id=\"autosuggestlist\"]/ul/li[1]/a"));
        reliance.click();

        System.out.println(driver.getTitle());

        WebElement mutualFund = driver.findElement(By.xpath("//*[@id='common_header']/div[1]/div[3]/nav/div/ul/li[10]/a"));
        mutualFund.click();
        Thread.sleep(3000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");

        WebElement SIP = driver.findElement(By.xpath("//*[@id=\"mc3_return\"]/div[1]/ul/li[2]/a"));
        SIP.click();
    }
}
