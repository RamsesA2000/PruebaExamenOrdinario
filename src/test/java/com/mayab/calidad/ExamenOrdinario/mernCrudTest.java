package com.mayab.calidad.ExamenOrdinario;

import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class mernCrudTest {

	private static String URL;
	private static WebDriver driver;

	  @Before
	  public void init()
	  {
		  URL = "https://mern-crud.herokuapp.com/";
		  System.setProperty("webdriver.chrome.driver", "/home/cardinal/CHROMEDRIVER/chromedriver");
		  driver = new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
	  }
	  
	  private void pause(long mils) 
	  {
		  try {
			  Thread.sleep(mils);
		  }catch(Exception e){
			  e.printStackTrace();
		  }
	  }
	  
	 @Test
	  public void LoginTestFail() 
	  {
		  driver.get(URL); 
		  WebElement element = driver.findElement(By.xpath("/html/body/div/div/div[2]/button"));
		  element.click();
		  element = driver.findElement(By.name("name"));
		  element.sendKeys("Esta es la prueba de Ramses"); 
		  element = driver.findElement(By.name("email"));
		  element.sendKeys("RaMsEs@gmail");
		  element = driver.findElement(By.name("age"));
		  element.sendKeys("19");
		  element = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/div[3]/div[2]/div"));
		  element.click();
		  element = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/div[3]/div[2]/div/div[2]/div[1]"));
		  element.click();
		  element = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/button"));
		  element.click();
		  
		  pause(4000);
		  WebElement element2 = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/div[5]/div/p"));
		  String cadena = element2.getText();	
		  assertEquals("Email must be valid.", cadena);
	  }

	 @Test
	  public void LoginTestSuccess() 
	  {
		  driver.get(URL); 
		  WebElement element = driver.findElement(By.xpath("/html/body/div/div/div[2]/button"));
		  element.click();
		  element = driver.findElement(By.name("name"));
		  element.sendKeys("Esta es la prueba de Ramses"); 
		  element = driver.findElement(By.name("email"));
		  element.sendKeys("ramsesmtzgzz@gmail.com");
		  element = driver.findElement(By.name("age"));
		  element.sendKeys("19");
		  element = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/div[3]/div[2]/div"));
		  element.click();
		  element = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/div[3]/div[2]/div/div[2]/div[1]"));
		  element.click();
		  element = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/button"));
		  element.click();
		  
		  pause(4000);
		  WebElement element2 = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/div[4]/div/p"));
		  String cadena = element2.getText();
		  assertEquals("Successfully added!", cadena);
	  }
	  
	 @Test
	  public void deleteTestSuccess(){
		  driver.get(URL); 
		  WebElement element3 = driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr[1]/td[1]"));
		  String cadena3 = element3.getText();
		  WebElement element = driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr[1]/td[5]/button[2]"));
		  element.click();
		  pause(2000);
		  element = driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/button[1]"));
		  pause(2000);
		  element.click();		  
		  pause(4000);
		  
		  System.out.println(cadena3);

		  WebElement element2 = driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr[1]/td[1]"));
		  String cadena2 = element2.getText();
		  System.out.println(cadena2);
		  assertNotEquals(cadena3, cadena2);
	  }
	  
	 @Test
	  public void deleteFail(){
		  driver.get(URL); 
		  WebElement element3 = driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr/td[1]"));
		  WebElement element = driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr[1]/td[5]/button[2]"));
		  element.click();
		  pause(2000);
		  element = driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/button[2]"));
		  pause(2000);
		  element.click();
		  
		  WebElement element2 = driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr/td[1]"));
		  assertEquals(element3, element2);
	  }
	  
	 @Test
	  public void editSuccess(){
		  driver.get(URL); 
		  WebElement element = driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr/td[5]/button[1]"));
		  element.click();
		  element = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/div[1]/div/input"));
		  pause(3000);
		  element.clear();
		  element.sendKeys("Jajaja");
		  element = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/button"));
		  element.click();
		  
		  pause(4000);
		  WebElement element2 = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/div[4]/div/p"));
		  String cadena = element2.getText();
		  assertEquals("Successfully updated!", cadena);
	  }
	  
	  @Test
	  public void editFail(){
		  driver.get(URL); 
		  WebElement element = driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr/td[5]/button[1]"));
		  element.click();
		  element = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/div[2]/div/input"));
		  pause(3000);
		  element.clear();
		  element.sendKeys("ramsesmartinez@gmail");
		  element = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/button"));
		  element.click();
		  
		  pause(4000);
		  WebElement element2 = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/div[5]/div/p"));
		  String cadena = element2.getText();
		  assertEquals("Email must be valid.", cadena);
	  } 
}
