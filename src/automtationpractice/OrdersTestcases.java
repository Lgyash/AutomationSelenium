package automtationpractice;


import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OrdersTestcases {
WebDriver driver = new ChromeDriver();
	
	@BeforeMethod
	public void Basic() {
		System.setProperty("webdriver.chrome.driver","E:\\Work\\chromedriver.exe");
        String baseUrl = "http://automationpractice.com/index.php?controller=history";
        driver.get(baseUrl);
	}
	
	@AfterMethod
	public void close() {
		driver.close();
	}
	
	
	@Test(priority = 1)
	public void OpenOrderDetails() {
		driver.findElement(By.xpath("//body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[7]/a[1]/span[1]")).click();
		driver.findElement(By.className("button")).click();
		Boolean order= driver.findElement(By.className("info-order")).isDisplayed();
		Assert.assertTrue(order);
	}
	
	@Test(priority = 2)
	public void ReOrder() {
		driver.findElement(By.xpath("//tbody/tr[1]/td[7]/a[2]")).click();
		Iterator<String> handleIterator = this.driver.getWindowHandles().iterator();
	    while (handleIterator.hasNext())
	    {
	        String handle = handleIterator.next();
	        if (!handleIterator.hasNext())
	        {
	            this.driver.switchTo().window(handle);
	        }
	    }
		Boolean reorder= driver.findElement(By.xpath("//ul[@id='order_step']")).isDisplayed();
		Assert.assertTrue(reorder);
	}

}
