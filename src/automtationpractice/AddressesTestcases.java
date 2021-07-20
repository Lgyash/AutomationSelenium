package automtationpractice;

import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddressesTestcases {
WebDriver driver = new ChromeDriver();
	
	@BeforeMethod
	public void Basic() {
		System.setProperty("webdriver.chrome.driver","E:\\Work\\chromedriver.exe");
        String baseUrl = "http://automationpractice.com/index.php?controller=addresses";
        driver.get(baseUrl);
	}
	
	@AfterMethod
	public void close() {
		driver.close();
	}
	
	
	@Test(priority = 1)
	public void UpdateAdresses() {
		driver.findElement(By.xpath("//body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[9]/a[1]/span[1]")).click();
		
		Iterator<String> handleIterator = this.driver.getWindowHandles().iterator();
	    while (handleIterator.hasNext())
	    {
	        String handle = handleIterator.next();
	        if (!handleIterator.hasNext())
	        {
	            this.driver.switchTo().window(handle);
	        }
	    }
	    
		driver.findElement(By.id("firstname")).sendKeys("Ali");
		driver.findElement(By.id("lastname")).sendKeys("Ali");
		driver.findElement(By.id("address1")).sendKeys("Egypt");
		driver.findElement(By.id("city")).sendKeys("cairo");
		driver.findElement(By.id("id_state")).click();
		driver.findElement(By.xpath("//option[contains(text(),'Alabama')]")).click();
		driver.findElement(By.id("postcode")).sendKeys("11728");
		driver.findElement(By.id("id_country")).click();
		driver.findElement(By.xpath("//option[contains(text(),'United States')]")).click();
		
		driver.findElement(By.id("phone_mobile")).sendKeys("+12655488785");
		driver.findElement(By.id("alias")).sendKeys("Domiat");
	    
		driver.findElement(By.className("button")).click();
	}
	
	@Test(priority = 2)
	public void DeleteAddress() {
		driver.findElement(By.xpath("//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[9]/a[2]")).click();
		driver.switchTo().alert().accept();
	}
}
