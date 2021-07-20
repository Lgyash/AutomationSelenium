package automtationpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignInTestcases {
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
	public void InsertWishlistWithValidEmailAndPassword() {
		driver.findElement(By.id("email")).sendKeys("xyz.abc@xyz");
		driver.findElement(By.id("passwd")).sendKeys("Aliali123321");
		driver.findElement(By.tagName("button")).click();

	}
	
	//Validation
	
	@Test(priority = 2)
	public void InsertWishlistWithInValidEmailAndPassword() {
		driver.findElement(By.id("email")).sendKeys("xyz");
		driver.findElement(By.id("passwd")).sendKeys("Aliali123321");
		driver.findElement(By.tagName("button")).click();
	}
	
}
