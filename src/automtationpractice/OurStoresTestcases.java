package automtationpractice;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OurStoresTestcases {
WebDriver driver = new ChromeDriver();
	
	@BeforeMethod
	public void Basic() {
		System.setProperty("webdriver.chrome.driver","E:\\Work\\chromedriver.exe");
        String baseUrl = "http://automationpractice.com/index.php?controller=stores";
        driver.get(baseUrl);
	}
	
	@AfterMethod
	public void close() {
		driver.close();
	}
	
	//Functional
	@Test(priority = 1)
	public void TheUserShouldBeAbleToEnterHisLocation() {
		driver.findElement(By.className("form-control")).sendKeys("11728");
		driver.findElement(By.tagName("select")).click();
		driver.findElement(By.xpath("//option[contains(text(),'50')]")).click();
		driver.findElement(By.tagName("button")).click();
		Boolean Map= driver.findElement(By.id("map")).isDisplayed();
		Assert.assertTrue(Map);
	}
	
	//Validation
	@Test(priority = 2)
	public void TheUserShouldBeAbleToEnterHisInvalidLocation() {
		driver.findElement(By.className("form-control")).sendKeys("$#%");
		driver.findElement(By.tagName("select")).click();
		driver.findElement(By.xpath("//option[contains(text(),'50')]")).click();
		driver.findElement(By.tagName("button")).click();
		Boolean Map= driver.findElement(By.className("fancybox-error")).isDisplayed();
		Assert.assertTrue(Map);
	}
	
}
