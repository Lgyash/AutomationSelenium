package automtationpractice;

import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AuthenticationTestcases {
WebDriver driver = new ChromeDriver();
	
	@BeforeMethod
	public void Basic() {
		System.setProperty("webdriver.chrome.driver","E:\\Work\\chromedriver.exe");
        String baseUrl = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
        driver.get(baseUrl);
	}
	
	@AfterMethod
	public void close() {
		driver.close();
	}
	
	//Functional
	
	@Test(priority = 1)
	public void TheUserShouldBeAbleToEnterHisSignup() {
		driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys("xyz@abc.xyz");
		driver.findElement(By.cssSelector("#SubmitCreate")).click();
	    Iterator<String> handleIterator = this.driver.getWindowHandles().iterator();
	    while (handleIterator.hasNext())
	    {
	        String handle = handleIterator.next();
	        if (!handleIterator.hasNext())
	        {
	            this.driver.switchTo().window(handle);
	        }
	    }
		driver.findElement(By.xpath("//input[@id='id_gender1']")).click();
		driver.findElement(By.id("customer_firstname")).sendKeys("Ali");
		driver.findElement(By.id("customer_lastname")).sendKeys("Abdullah");
		driver.findElement(By.id("email")).sendKeys("xyz@abc.xyz");
		driver.findElement(By.id("passwd")).sendKeys("Aliali123321");

		driver.findElement(By.id("#days")).click();
		driver.findElement(By.xpath("//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/div[1]/form[1]/div[1]/div[6]/div[1]/div[1]/div[1]/select[1]/option[2]")).click();
		
		driver.findElement(By.id("months")).click();
		driver.findElement(By.xpath("//option[contains(text(),'January')]")).click();

		driver.findElement(By.id("years")).click();
		driver.findElement(By.xpath("//option[contains(text(),'2021')]")).click();
		
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
		
		driver.findElement(By.tagName("button")).click();

	
		
		Boolean signup= driver.findElement(By.xpath("//ul[@id='order_step']")).isDisplayed();
		
		Assert.assertTrue(signup);
	
	}
	
	
	//Validation
	@Test(priority = 2)
	public void TheUserShouldBeAbleToEnterHisSignupwithinvalidEmail() {
		driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys("xyz@abc.xyz");
		driver.findElement(By.cssSelector("#SubmitCreate")).click();
	    Iterator<String> handleIterator = this.driver.getWindowHandles().iterator();
	    while (handleIterator.hasNext())
	    {
	        String handle = handleIterator.next();
	        if (!handleIterator.hasNext())
	        {
	            this.driver.switchTo().window(handle);
	        }
	    }
		driver.findElement(By.xpath("//input[@id='id_gender1']")).click();
		driver.findElement(By.id("customer_firstname")).sendKeys("Ali");
		driver.findElement(By.id("customer_lastname")).sendKeys("Abdullah");
		driver.findElement(By.id("email")).sendKeys("xyz@abc");
		driver.findElement(By.id("passwd")).sendKeys("Aliali123321");

		driver.findElement(By.id("#days")).click();
		driver.findElement(By.xpath("//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/div[1]/form[1]/div[1]/div[6]/div[1]/div[1]/div[1]/select[1]/option[2]")).click();
		
		driver.findElement(By.id("months")).sendKeys("Aliali123321");
		driver.findElement(By.xpath("//option[contains(text(),'January')]")).click();

		driver.findElement(By.id("years")).sendKeys("Aliali123321");
		driver.findElement(By.xpath("//option[contains(text(),'2021')]")).click();
		
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
		
		driver.findElement(By.tagName("button")).click();

	
		
		Boolean signup= driver.findElement(By.xpath("//ul[@id='order_step']")).isDisplayed();
		
		Assert.assertFalse(signup);
	
	}


	@Test(priority = 3)
	public void TheUserShouldBeAbleToEnterHisSignupwithinvalidCity() {
		driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys("xyz@abc.xyz");
		driver.findElement(By.cssSelector("#SubmitCreate")).click();
	    Iterator<String> handleIterator = this.driver.getWindowHandles().iterator();
	    while (handleIterator.hasNext())
	    {
	        String handle = handleIterator.next();
	        if (!handleIterator.hasNext())
	        {
	            this.driver.switchTo().window(handle);
	        }
	    }
		driver.findElement(By.xpath("//input[@id='id_gender1']")).click();
		driver.findElement(By.id("customer_firstname")).sendKeys("Ali");
		driver.findElement(By.id("customer_lastname")).sendKeys("Abdullah");
		driver.findElement(By.id("email")).sendKeys("xyz@abc");
		driver.findElement(By.id("passwd")).sendKeys("Aliali123321");

		driver.findElement(By.id("#days")).click();
		driver.findElement(By.xpath("//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/div[1]/form[1]/div[1]/div[6]/div[1]/div[1]/div[1]/select[1]/option[2]")).click();
		
		driver.findElement(By.id("months")).sendKeys("Aliali123321");
		driver.findElement(By.xpath("//option[contains(text(),'January')]")).click();

		driver.findElement(By.id("years")).sendKeys("Aliali123321");
		driver.findElement(By.xpath("//option[contains(text(),'2021')]")).click();
		
		driver.findElement(By.id("firstname")).sendKeys("Ali");
		driver.findElement(By.id("lastname")).sendKeys("Ali");
		driver.findElement(By.id("address1")).sendKeys("Egypt");
		driver.findElement(By.id("city")).sendKeys("$#%#$%");
		driver.findElement(By.id("id_state")).click();
		driver.findElement(By.xpath("//option[contains(text(),'Alabama')]")).click();
		driver.findElement(By.id("postcode")).sendKeys("11728");
		driver.findElement(By.id("id_country")).click();
		driver.findElement(By.xpath("//option[contains(text(),'United States')]")).click();
		
		driver.findElement(By.id("phone_mobile")).sendKeys("+12655488785");
		driver.findElement(By.id("alias")).sendKeys("Domiat");
		
		driver.findElement(By.tagName("button")).click();

	
		
		Boolean signup= driver.findElement(By.xpath("//ul[@id='order_step']")).isDisplayed();
		
		Assert.assertFalse(signup);
	
	}
	
	@Test(priority = 4)
	public void TheUserShouldBeAbleToEnterHisSignupwithinvalidPostcode() {
		driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys("xyz@abc.xyz");
		driver.findElement(By.cssSelector("#SubmitCreate")).click();
	    Iterator<String> handleIterator = this.driver.getWindowHandles().iterator();
	    while (handleIterator.hasNext())
	    {
	        String handle = handleIterator.next();
	        if (!handleIterator.hasNext())
	        {
	            this.driver.switchTo().window(handle);
	        }
	    }
		driver.findElement(By.xpath("//input[@id='id_gender1']")).click();
		driver.findElement(By.id("customer_firstname")).sendKeys("Ali");
		driver.findElement(By.id("customer_lastname")).sendKeys("Abdullah");
		driver.findElement(By.id("email")).sendKeys("xyz@abc");
		driver.findElement(By.id("passwd")).sendKeys("Aliali123321");

		driver.findElement(By.id("#days")).click();
		driver.findElement(By.xpath("//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/div[1]/form[1]/div[1]/div[6]/div[1]/div[1]/div[1]/select[1]/option[2]")).click();
		
		driver.findElement(By.id("months")).sendKeys("Aliali123321");
		driver.findElement(By.xpath("//option[contains(text(),'January')]")).click();

		driver.findElement(By.id("years")).sendKeys("Aliali123321");
		driver.findElement(By.xpath("//option[contains(text(),'2021')]")).click();
		
		driver.findElement(By.id("firstname")).sendKeys("Ali");
		driver.findElement(By.id("lastname")).sendKeys("Ali");
		driver.findElement(By.id("address1")).sendKeys("Egypt");
		driver.findElement(By.id("city")).sendKeys("cairo");
		driver.findElement(By.id("id_state")).click();
		driver.findElement(By.xpath("//option[contains(text(),'Alabama')]")).click();
		driver.findElement(By.id("postcode")).sendKeys("$%#^$#%8");
		driver.findElement(By.id("id_country")).click();
		driver.findElement(By.xpath("//option[contains(text(),'United States')]")).click();
		
		driver.findElement(By.id("phone_mobile")).sendKeys("+12655488785");
		driver.findElement(By.id("alias")).sendKeys("Domiat");
		
		driver.findElement(By.tagName("button")).click();

	
		
		Boolean signup= driver.findElement(By.xpath("//ul[@id='order_step']")).isDisplayed();
		
		Assert.assertFalse(signup);
	
	}
	

}
