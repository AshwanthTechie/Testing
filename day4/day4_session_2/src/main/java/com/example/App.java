package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.edgedriver().setup();
        WebDriverManager.firefoxdriver().setup();
        WebDriver chrome = new ChromeDriver();
        chrome.get("http://www.google.com");
        WebDriver edge = new EdgeDriver();
        edge.get("http://www.google.com");
        WebDriver firefox = new FirefoxDriver();
        firefox.get("http://www.google.com");
    }
}
