package automtationpractice;

import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewProductTestcases {
WebDriver driver = new ChromeDriver();
	
	@BeforeMethod
	public void Basic() {
		System.setProperty("webdriver.chrome.driver","E:\\Work\\chromedriver.exe");
        String baseUrl = "http://automationpractice.com/index.php?controller=new-products";
        driver.get(baseUrl);
	}
	
	@AfterMethod
	public void close() {
		driver.close();
	}
	
	//Functional
	
	@Test(priority = 1)
	public void OpenAproductFromTopSellerShouldNavigateToTheProductPage() {
		driver.findElement(By.xpath("//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/ul[1]/li[1]/div[1]/h5[1]/a[1]")).click();
		 Iterator<String> handleIterator = this.driver.getWindowHandles().iterator();
		    while (handleIterator.hasNext())
		    {
		        String handle = handleIterator.next();
		        if (!handleIterator.hasNext())
		        {
		            this.driver.switchTo().window(handle);
		        }
		    }
		    
		    Boolean newproduct= driver.findElement(By.className("page-product-box")).isDisplayed();
			Assert.assertEquals("http://automationpractice.com/index.php?id_product=7&controller=product",newproduct);

	}
}
