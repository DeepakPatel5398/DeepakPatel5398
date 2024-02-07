package Extract;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CellPhoneTest {
	WebDriver driver;
	@BeforeTest
	public void setup() { 
		
		System.setProperty("webdriver.chrome.driver","D:\\deepak\\Masai\\chromeDriver files\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/register?returnUrl=%2Fothers");
	    driver.manage().window().maximize();
	
	}
	
	@Test(priority = 3)
	   public void product1() throws IOException{
		
	  //mouse-hovering to electronics 
	  Actions act = new Actions(driver); 
	  WebElement electronics = driver.findElement(By.xpath("(//a[@href='/electronics'])[1]"));
	  act.moveToElement(electronics).build().perform();
	  
	  //mouse-hovering to cell phones
	  WebElement cellphones = driver.findElement(By.xpath("(//a[@href='/cell-phones'])[1]"));
	  act.moveToElement(cellphones).build().perform(); 
	  cellphones.click();
	 

	  
	 
	  driver.findElement(By.linkText("HTC One M8 Android L 5.0 Lollipop")).click();
	  
	  WebElement ADDTOCART = driver.findElement(By.cssSelector("button#add-to-cart-button-18"));
	  JavascriptExecutor jse = (JavascriptExecutor)driver;
	  jse.executeScript("arguments[0].scrollIntoView", ADDTOCART);
	  ADDTOCART.click();
		 
	  //scroll
	  WebElement ShopingCart = driver.findElement(By.id("topcartlink"));
	  JavascriptExecutor jse1 = (JavascriptExecutor)driver;
	  jse1.executeScript("arguments[0].srcollIntoView", ShopingCart);
	  ShopingCart.click();
	  

		 
	  //scripts to take screenshot 
	  TakesScreenshot capture = (TakesScreenshot)driver;
	  File file1 = capture.getScreenshotAs(OutputType.FILE);
	  File file2 = new File("D:\\deepak\\scrnshot\\image101.png");
	  FileUtils.copyFile(file1, file2);
	  
	  }
	  
	@Test(priority = 2)
	   public void product2() throws IOException {
		
		// mouse-hovering
	  Actions act = new Actions(driver); WebElement electronics =
	  driver.findElement(By.xpath("(//a[@href='/electronics'])[1]"));
	  act.moveToElement(electronics).build().perform();
	  
	  WebElement cellphones = driver.findElement(By.xpath("(//a[@href='/cell-phones'])[1]"));
	  act.moveToElement(cellphones).build().perform(); 
	  cellphones.click();
	 
     
	  //scroll to element
	  WebElement HTC_mb = driver.findElement(By.linkText("HTC One Mini Blue"));
	  JavascriptExecutor exe=(JavascriptExecutor)driver;
	  exe.executeScript("arguments[0].scrollIntoView();", HTC_mb);
	  HTC_mb.click();
	  
	  
	  WebElement buton = driver.findElement(By.id("add-to-wishlist-button-19"));
	  buton.click();
	  
	  WebElement wishList = driver.findElement(By.className("wishlist-label"));
	  exe.executeScript("arguments[0].scrollIntoView();", wishList);	  
	  wishList.click();
	  

	  
	  
	  TakesScreenshot screen= (TakesScreenshot)driver; 
	  File file1 = screen.getScreenshotAs(OutputType.FILE);
	  File file2 = new File("D:\\deepak\\scrnshot\\image102.png");
	  FileUtils.copyFile(file1, file2);
	 
	}
	 
	
	@Test(priority = 1)
	public void product3() throws IOException {
		
		//mouse-hovering to electronics and cell-phones
		Actions act = new Actions(driver);
    	WebElement electronics = driver.findElement(By.xpath("(//a[@href='/electronics'])[1]"));
       act.moveToElement(electronics).build().perform();
        
        WebElement cellphones = driver.findElement(By.xpath("(//a[@href='/cell-phones'])[1]"));
	    act.moveToElement(cellphones).build().perform();
	   
	    cellphones.click();
	   
	    
	    //scroll to particular element
	    WebElement NokiaLumia = driver.findElement(By.xpath("(//a[@href='/nokia-lumia-1020'])[1]"));
	    JavascriptExecutor javascript = (JavascriptExecutor)driver;
	    javascript.executeScript("arguments[0].scrollIntoView();", NokiaLumia);
	    NokiaLumia.click();
	    
	    
	    JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
	    jsExecutor.executeScript("window.scrollBy(0, 250)");
	    WebElement compareproduct = driver.findElement(By.xpath("//button[@class='button-2 add-to-compare-list-button']"));
	    compareproduct.click();
	    
		WebElement comparelist = driver.findElement(By.xpath("//a[@href='/compareproducts']"));
		jsExecutor.executeScript("arguments[0].scrollIntoView();", comparelist);
		comparelist.click();
		
	
		//scripts to take screenshot
		TakesScreenshot scrnsot=(TakesScreenshot)driver;
		File file1 = scrnsot.getScreenshotAs(OutputType.FILE);
		File file2 = new File("D:\\deepak\\scrnshot\\image103.png");
	    FileUtils.copyFile(file1, file2);
	    
		}
	
	@AfterTest
	public void teradown() {
		
		driver.close();
	}

}
