package automtationpractice;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PersonalInfo {
WebDriver driver = new ChromeDriver();
	
	@BeforeMethod
	public void Basic() {
		System.setProperty("webdriver.chrome.driver","E:\\Work\\chromedriver.exe");
        String baseUrl = "http://automationpractice.com/index.php?controller=identity";
        driver.get(baseUrl);
	}
	
	@AfterMethod
	public void close() {
		driver.close();
	}
	
	
	@Test(priority = 1)
	public void UpdateInfo() {
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
		
		driver.findElement(By.tagName("button")).click();

	}
	
	//Validation
	@Test(priority = 2)
	public void UpdateInfowithInvalidEmail() {
		driver.findElement(By.xpath("//input[@id='id_gender1']")).click();
		driver.findElement(By.id("customer_firstname")).sendKeys("Ali");
		driver.findElement(By.id("customer_lastname")).sendKeys("Abdullah");
		driver.findElement(By.id("email")).sendKeys("xyz");
		driver.findElement(By.id("passwd")).sendKeys("Aliali123321");

		driver.findElement(By.id("#days")).click();
		driver.findElement(By.xpath("//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/div[1]/form[1]/div[1]/div[6]/div[1]/div[1]/div[1]/select[1]/option[2]")).click();
		
		driver.findElement(By.id("months")).click();
		driver.findElement(By.xpath("//option[contains(text(),'January')]")).click();

		driver.findElement(By.id("years")).click();
		driver.findElement(By.xpath("//option[contains(text(),'2021')]")).click();
		
		driver.findElement(By.tagName("button")).click();

	}
	
}
