package automtationpractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SiteMapTestcases {
WebDriver driver = new ChromeDriver();
	
	@BeforeMethod
	public void Basic() {
		System.setProperty("webdriver.chrome.driver","E:\\Work\\chromedriver.exe");
        String baseUrl = "http://automationpractice.com/index.php?controller=sitemap";
        driver.get(baseUrl);
	}
	
	@AfterMethod
	public void close() {
		driver.close();
	}
	
	@Test(priority = 1)
	public void WhenClickOnSiteMapLinksItShouldRedirectsHimToTheProperDestination() {
		driver.findElement(By.cssSelector("body.sitemap.hide-right-column.lang_en:nth-child(2) div.columns-container div.container div.row:nth-child(3) div.center_column.col-xs-12.col-sm-9 div.row:nth-child(2) div.col-xs-12.col-sm-6:nth-child(1) div.sitemap_block.box ul:nth-child(2) li:nth-child(1) > a:nth-child(1)")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String url = driver.getCurrentUrl();
		Assert.assertEquals("http://automationpractice.com/index.php?controller=new-products",url);
	}
	
	@Test(priority = 2)
	public void WhenClickOnTopSellerSideMenuItShouldOpensProducPage() {
		driver.findElement(By.className("product-name")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String url = driver.getCurrentUrl();
		Assert.assertEquals("http://automationpractice.com/index.php?id_product=7&controller=product",url);
	}
	
}
