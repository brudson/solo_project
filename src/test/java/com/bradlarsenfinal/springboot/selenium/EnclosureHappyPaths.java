package com.bradlarsenfinal.springboot.selenium;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class EnclosureHappyPaths {
	
	private WebDriver driver;
	
	@Before public void setup(){
		
		System.setProperty("webdriver.chrome.driver", "src/main/java/com/bradlarsenfinal/pageObjectFramework/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		
	}
	
	@Test
	public void getTitle(){
		driver.get("http://localhost:8080/#/home");
		
		String actualTitle = driver.getTitle();
		
		assertEquals("Brads Project", actualTitle);
	}
	
	@Test
	public void enclosure(){
		
		driver.get("http://localhost:8080/#/enclosure");
		
		String actualUrl = driver.getCurrentUrl();
		
		assertEquals("http://localhost:8080/#/enclosure", actualUrl);
		
	}
	
	@Test
	public void enclosureUpdate() throws InterruptedException{
		
		driver.get("http://localhost:8080/#/enclosure");
		
		Thread.sleep(1000);
		
		driver.findElement(By.id("viewEnclosures")).click();
		
		Thread.sleep(1000);
		
		driver.findElement(By.id("updateBtn")).click();
		
		Thread.sleep(1000);
		
		String actualUrl = driver.getCurrentUrl();
		
		assertEquals("http://localhost:8080/#/editEnclosure", actualUrl);
		
	}
	
	@Test
	public void newEnclosure() throws InterruptedException{
		driver.get("http://localhost:8080/#/enclosure");
		
		driver.findElement(By.name("name")).sendKeys("Testing Enclosures");
		driver.findElement(By.name("animal")).sendKeys("Testing Enclosures");
		driver.findElement(By.name("numberOfAnimals")).sendKeys("100");
		driver.findElement(By.name("condition")).sendKeys("Testing Enclosures");
		driver.findElement(By.name("feedingTime")).sendKeys("3:33 PM");
		
		Thread.sleep(1000);
	
		driver.findElement(By.id("submitEnclosure")).click();
		
	}
	
	@After
	public void tearDown() throws Exception{
		
		driver.close();
		driver.quit();
		
	}
}