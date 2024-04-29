package com.example;

import org.openqa.selenium.By;
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
    public static void main( String[] args ) throws InterruptedException
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com");

        WebElement laptop = driver.findElement(By.linkText("Laptops"));
        laptop.click();
        Thread.sleep(3000);
        WebElement macbook = driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/div[3]/div/div/h4/a"));
        macbook.click();
        Thread.sleep(3000);

        WebElement addtocart = driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a"));
        addtocart.click();
        
        Thread.sleep(3000);
        driver.switchTo().alert().accept();

        WebElement cart = driver.findElement(By.id("cartur"));
        cart.click();
        Thread.sleep(3000);
        WebElement title = driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/tr/td[2]"));
        System.out.println(title.getText());
        WebElement price = driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/tr/td[3]"));
        System.out.println(price.getText());

    }
}
