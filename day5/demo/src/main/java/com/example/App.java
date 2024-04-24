package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class App 
{
    public static void main( String[] args )
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("https://demoblaze.com");
        WebElement gmailLink=driver.findElement(By.linkText("Laptops"));
        gmailLink.click();
        Thread.sleep(80000);
        WebElement lap = driver.findElement(By.linkText("MacBook air"));
      lap.click();
      Thread.sleep(80000);
      WebElement add = driver.findElement(By.linkText("Add to cart"));
      add.click();
    
      WebElement cartIcon = driver.findElement(By.id("cartur"));
      cartIcon.click();
      System.out.print(cartIcon.getText());
      }
}
