package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.shoppersstop.com/.");
        WebElement searchBox = driver.findElement(By.id("APjFqb"));
        searchBox.sendKeys("Selenium");
      
        System.out.println(driver.getTitle());
        if(driver.getTitle().contains("Selenium")){
            System.out.println("passed");
        }
        else{
            System.out.println("failed");
            driver.navigate().back();
        }
        driver.close();
      }
}