package automtationpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactTestcases {

	WebDriver driver = new ChromeDriver();
	
	@BeforeMethod
	public void Basic() {
		System.setProperty("webdriver.chrome.driver","E:\\Work\\chromedriver.exe");
        String baseUrl = "http://automationpractice.com/index.php?controller=contact";
        driver.get(baseUrl);
	}
	
	@AfterMethod
	public void close() {
		driver.close();
	}
	
	//Functional
	@Test(priority = 1)
	public void FillConatctFormWithValidInputs() {
		
		driver.findElement(By.tagName("select")).click();
		driver.findElement(By.xpath("//option[contains(text(),'Customer service')]")).click();
	
		driver.findElement(By.id("email")).sendKeys("xyz@abc.ygb");
		
		driver.findElement(By.id("id_order")).sendKeys("5");
		
		WebElement uploadElement = driver.findElement(By.id("fileUpload"));
		uploadElement.sendKeys("C:\\Users\\aliab\\Desktop\\217827632_157909576436008_4337991535278657260_n.jpg");
		
		driver.findElement(By.tagName("textarea")).sendKeys("This is Awesome Website For Automation Testing");
		
		driver.findElement(By.id("//button[@id='submitMessage']")).click();
		
		Boolean validation = driver.findElement(By.cssSelector("body.contact.hide-left-column.hide-right-column.lang_en:nth-child(2) div.columns-container div.container div.row:nth-child(3) div.center_column.col-xs-12.col-sm-12 > p.alert.alert-success")).isDisplayed(); 
		Assert.assertTrue(validation);
	}
	
	//Validation
	@Test(priority = 2)
	public void FillConatctFormWithValidInputsAndInvalidEmailAddress() {
		
		driver.findElement(By.tagName("select")).click();
		driver.findElement(By.xpath("//option[contains(text(),'Customer service')]")).click();
	
		driver.findElement(By.id("email")).sendKeys("xyz");
		
		driver.findElement(By.id("id_order")).sendKeys("5");
		
		WebElement uploadElement = driver.findElement(By.id("fileUpload"));
		uploadElement.sendKeys("C:\\Users\\aliab\\Desktop\\217827632_157909576436008_4337991535278657260_n.jpg");
		
		driver.findElement(By.tagName("textarea")).sendKeys("This is Awesome Website For Automation Testing");
		
		driver.findElement(By.id("//button[@id='submitMessage']")).click();
		
		Boolean validation = driver.findElement(By.xpath("//p[contains(text(),'There is 1 error')]")).isDisplayed(); 
		Assert.assertTrue(validation);
	}
	
	@Test(priority = 3)
	public void FillConatctFormWithValidInputsAndInvalidOrderPrefernce() {
		
		driver.findElement(By.tagName("select")).click();
		driver.findElement(By.xpath("//option[contains(text(),'Customer service')]")).click();
	
		driver.findElement(By.id("email")).sendKeys("xyz@abc.ygb");
		
		driver.findElement(By.id("id_order")).sendKeys("This is invalid");
		
		WebElement uploadElement = driver.findElement(By.id("fileUpload"));
		uploadElement.sendKeys("C:\\Users\\aliab\\Desktop\\217827632_157909576436008_4337991535278657260_n.jpg");
		
		driver.findElement(By.tagName("textarea")).sendKeys("This is Awesome Website For Automation Testing");
		
		driver.findElement(By.id("//button[@id='submitMessage']")).click();
		
		Boolean validation = driver.findElement(By.cssSelector("body.contact.hide-left-column.hide-right-column.lang_en:nth-child(2) div.columns-container div.container div.row:nth-child(3) div.center_column.col-xs-12.col-sm-12 > p.alert.alert-success")).isDisplayed(); 
		Assert.assertTrue(validation);
	}
	
	@Test(priority = 4)
	public void FillConatctFormWithValidInputsAndEmptyMessage() {
		
		driver.findElement(By.tagName("select")).click();
		driver.findElement(By.xpath("//option[contains(text(),'Customer service')]")).click();
	
		driver.findElement(By.id("email")).sendKeys("xyz@abc.ygb");
		
		driver.findElement(By.id("id_order")).sendKeys("5");
		
		WebElement uploadElement = driver.findElement(By.id("fileUpload"));
		uploadElement.sendKeys("C:\\Users\\aliab\\Desktop\\217827632_157909576436008_4337991535278657260_n.jpg");
		
		driver.findElement(By.tagName("textarea")).sendKeys("");
		
		driver.findElement(By.id("//button[@id='submitMessage']")).click();
		
		Boolean validation = driver.findElement(By.cssSelector("body.contact.hide-left-column.hide-right-column.lang_en:nth-child(2) div.columns-container div.container div.row:nth-child(3) div.center_column.col-xs-12.col-sm-12 > p.alert.alert-success")).isDisplayed(); 
		Assert.assertTrue(validation);
	}
	
	
}
