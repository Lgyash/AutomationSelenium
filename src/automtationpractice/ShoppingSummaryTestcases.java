package automtationpractice;

import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ShoppingSummaryTestcases {
WebDriver driver = new ChromeDriver();
	
	@BeforeMethod
	public void Basic() {
		System.setProperty("webdriver.chrome.driver","E:\\Work\\chromedriver.exe");
        String baseUrl = "http://automationpractice.com/index.php?controller=order";
        driver.get(baseUrl);
	}
	
	@AfterMethod
	public void close() {
		driver.close();
	}
	
	
	@Test(priority = 1)
	public void FillSummarywithbankwire() {
		driver.findElement(By.xpath("//body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[5]/div[1]/a[2]/span[1]")).click();
		driver.findElement(By.className("button")).click();
		Iterator<String> handleIterator = this.driver.getWindowHandles().iterator();
	    while (handleIterator.hasNext())
	    {
	        String handle = handleIterator.next();
	        if (!handleIterator.hasNext())
	        {
	            this.driver.switchTo().window(handle);
	        }
	    }
		driver.findElement(By.tagName("textarea")).sendKeys("this site");
		driver.findElement(By.tagName("button")).click();
		Iterator<String> handleIterator0 = this.driver.getWindowHandles().iterator();
	    while (handleIterator0.hasNext())
	    {
	        String handle = handleIterator0.next();
	        if (!handleIterator0.hasNext())
	        {
	            this.driver.switchTo().window(handle);
	        }
	    }
		driver.findElement(By.className("checkbox")).click();
		driver.findElement(By.tagName("button")).click();
		Iterator<String> handleIterator1 = this.driver.getWindowHandles().iterator();
	    while (handleIterator1.hasNext())
	    {
	        String handle = handleIterator1.next();
	        if (!handleIterator1.hasNext())
	        {
	            this.driver.switchTo().window(handle);
	        }
	    }
		driver.findElement(By.className("bankwire")).click(); 

	}
	
	@Test(priority = 2)
	public void FillSummarywithcheque() {
		driver.findElement(By.xpath("//body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[5]/div[1]/a[2]/span[1]")).click();
		driver.findElement(By.className("button")).click();
		Iterator<String> handleIterator = this.driver.getWindowHandles().iterator();
	    while (handleIterator.hasNext())
	    {
	        String handle = handleIterator.next();
	        if (!handleIterator.hasNext())
	        {
	            this.driver.switchTo().window(handle);
	        }
	    }
		driver.findElement(By.tagName("textarea")).sendKeys("this site");
		driver.findElement(By.tagName("button")).click();
		Iterator<String> handleIterator0 = this.driver.getWindowHandles().iterator();
	    while (handleIterator0.hasNext())
	    {
	        String handle = handleIterator0.next();
	        if (!handleIterator0.hasNext())
	        {
	            this.driver.switchTo().window(handle);
	        }
	    }
		driver.findElement(By.className("checkbox")).click();
		driver.findElement(By.tagName("button")).click();
		Iterator<String> handleIterator1 = this.driver.getWindowHandles().iterator();
	    while (handleIterator1.hasNext())
	    {
	        String handle = handleIterator1.next();
	        if (!handleIterator1.hasNext())
	        {
	            this.driver.switchTo().window(handle);
	        }
	    }
		driver.findElement(By.className("bankwire")).click(); 
		Iterator<String> handleIterator2 = this.driver.getWindowHandles().iterator();
	    while (handleIterator2.hasNext())
	    {
	        String handle = handleIterator2.next();
	        if (!handleIterator2.hasNext())
	        {
	            this.driver.switchTo().window(handle);
	        }
	    }
		driver.findElement(By.className("cheque")).click();
	}
	
}
