package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class App2 {
    public static void main( String[] args )
    {
        
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        
     
   WebDriver firefoxDriver = new FirefoxDriver();
     firefoxDriver.get("https://www.google.com/");

   WebDriver edgeDriver = new EdgeDriver();
  edgeDriver.get("https://www.google.com/");
  
        driver.get("https://www.shoppersstop.com/.");
        WebElement searchBox = driver.findElement(By.id("APjFqb"));
        searchBox.sendKeys("Selenium");
      
        System.out.println(driver.getTitle());
    
      }
}