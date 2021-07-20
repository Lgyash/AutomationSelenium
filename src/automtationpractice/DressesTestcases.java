package automtationpractice;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DressesTestcases {
WebDriver driver = new ChromeDriver();
	
	@BeforeMethod
	public void Basic() {
		System.setProperty("webdriver.chrome.driver","E:\\Work\\chromedriver.exe");
        String baseUrl = "http://automationpractice.com/index.php?id_category=9&controller=category";
        driver.get(baseUrl);
	}
	
	@AfterMethod
	public void close() {
		driver.close();
	}
	
	//Functional
	
	@Test(priority = 1)
	public void EditTheCatalogFilterAndSubmit() {
		driver.findElement(By.cssSelector("#layered_id_attribute_group_1")).click();
		driver.findElement(By.cssSelector("#layered_id_attribute_group_13")).click();
		driver.findElement(By.xpath("//input[@id='layered_id_feature_5']")).click();
		driver.findElement(By.cssSelector("#layered_id_feature_11")).click();
		driver.findElement(By.cssSelector("#layered_id_feature_17")).click();
		driver.findElement(By.cssSelector("#layered_quantity_1")).click();
		driver.findElement(By.cssSelector("#layered_condition_new")).click();
		WebElement releasElement = driver.findElement(By.cssSelector("body.category.category-5.category-tshirts.hide-right-column.lang_en:nth-child(2) div.columns-container div.container div.row:nth-child(3) div.column.col-xs-12.col-sm-3 div.block:nth-child(1) div.block_content:nth-child(2) div.layered_price:nth-child(9) ul.col-lg-12.layered_filter_ul div.layered_slider_container:nth-child(3) div.layered_slider.ui-slider.ui-slider-horizontal.ui-widget.ui-widget-content.ui-corner-all > a.ui-slider-handle.ui-state-default.ui-corner-all:nth-child(3)"));
		WebElement startElement = driver.findElement(By.cssSelector("body.category.category-5.category-tshirts.hide-right-column.lang_en:nth-child(2) div.columns-container div.container div.row:nth-child(3) div.column.col-xs-12.col-sm-3 div.block:nth-child(1) div.block_content:nth-child(2) div.layered_price:nth-child(9) ul.col-lg-12.layered_filter_ul div.layered_slider_container:nth-child(3) div.layered_slider.ui-slider.ui-slider-horizontal.ui-widget.ui-widget-content.ui-corner-all > a.ui-slider-handle.ui-state-default.ui-corner-all:nth-child(2)"));
	    Actions action = new Actions(driver);
		action.clickAndHold(startElement).build().perform();
		action.moveToElement(releasElement).release().build().perform();
	}
	
	@Test(priority = 2)
	public void ClickOnTheInformation() {
			driver.findElement(By.xpath("//a[contains(text(),'Delivery')]")).click();
	}
	
	@Test(priority = 3)
	public void ClickOnSpecialsProduct() {
			driver.findElement(By.xpath("//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/ul[1]/li[1]/a[1]/img[1]")).click();
			driver.findElement(By.xpath("//body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/a[1]/span[1]")).click();
	}
	
	@Test(priority = 4)
	public void WhenClickOnAddCartOnProduct() {
		driver.findElement(By.xpath("//body[1]/div[1]/div[2]/div[1]/div[3]/div[2]/ul[1]/li[1]/div[1]/div[2]/div[2]/a[1]/span[1]")).click();
		Boolean Cart = driver.findElement(By.className("layer_cart")).isDisplayed();
		Assert.assertTrue(Cart);
	}
	
	@Test(priority = 5)
	public void ClickonOurStores() {
		driver.findElement(By.xpath("//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/div[3]/div[1]/p[1]/a[1]/img[1]")).click();
		driver.findElement(By.xpath("//body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[3]/div[1]/div[1]/a[1]/span[1]")).click();
	}
	
	@Test(priority = 6)
	public void ClickOnViewedProducts() {
		driver.findElement(By.cssSelector("body.category.category-5.category-tshirts.hide-right-column.lang_en:nth-child(2) div.columns-container div.container div.row:nth-child(3) div.column.col-xs-12.col-sm-3 div.block:nth-child(5) div.block_content.products-block ul:nth-child(1) li.clearfix.first_item:nth-child(1) div.product-content h5:nth-child(1) > a.product-name")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Boolean Product = driver.findElement(By.id("product")).isDisplayed();
		Assert.assertTrue(Product);
	}
	
	@Test(priority = 7)
	public void ChangeTheViewOfTheProducts() {
		driver.findElement(By.cssSelector("body.category.category-9.category-casual-dresses.hide-right-column.lang_en:nth-child(2) div.columns-container div.container div.row:nth-child(3) div.center_column.col-xs-12.col-sm-9 div.content_sortPagiBar.clearfix:nth-child(3) div.sortPagiBar.clearfix ul.display.hidden-xs li:nth-child(3) a:nth-child(1) > i.icon-th-list")).click();
		Iterator<String> handleIterator = this.driver.getWindowHandles().iterator();
	    while (handleIterator.hasNext())
	    {
	        String handle = handleIterator.next();
	        if (!handleIterator.hasNext())
	        {
	            this.driver.switchTo().window(handle);
	        }
	    }
		Boolean Product = driver.findElement(By.id("product")).isDisplayed();
		Assert.assertTrue(Product);
	}
	
	@Test(priority = 8)
	public void TestTheSortByMethod() {
			driver.findElement(By.xpath("//select[@id='selectProductSort']")).click();
			driver.findElement(By.cssSelector("//option[contains(text(),'Price: Highest first')]")).click();
	}
	
	@Test(priority = 9)
	public void ClickOnTheProductShouldOpenTheProductPage() {
			driver.findElement(By.className("product-image-container")).click();
			Boolean product = driver.findElement(By.id("bigpic")).isDisplayed();
			Assert.assertTrue(product);	}
	
	@Test(priority = 10)
	public void WhenTheUserClickOnMoreButtonOnAnyProductItOpensProductPage() {
		driver.findElement(By.cssSelector("//span[contains(text(),'More')]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String url = driver.getCurrentUrl();
		Assert.assertEquals("http://automationpractice.com/index.php?id_product=3&controller=product",url);
	}
	
	@Test(priority = 11)
	public void WhenTheUserClickOnQuickViewItShouldNavigatesHimToSubWindowProduct() {
		driver.findElement(By.xpath("//span[contains(text(),'Quick view')]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Boolean Product = driver.findElement(By.id("product")).isDisplayed();
		Assert.assertTrue(Product);
	}
	
	@Test(priority = 12)
	public void ClickOnDressesLinks() {
		driver.findElement(By.xpath("//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/ul[1]/li[1]/a[1]")).click();
	}
	
	@Test(priority = 13)
	public void ClickOnDressesSubCategories() {
		driver.findElement(By.cssSelector("//body/div[@id='page']/div[2]/div[1]/div[3]/div[2]/div[2]/ul[1]/li[1]/div[1]/a[1]/img[1]")).click();
		Iterator<String> handleIterator0 = this.driver.getWindowHandles().iterator();
		while (handleIterator0.hasNext())
	    {
	        String handle = handleIterator0.next();
	        if (!handleIterator0.hasNext())
	        {
	            this.driver.switchTo().window(handle);
	        }
	    }
		Boolean sub = driver.findElement(By.xpath("//body/div[@id='page']/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/span[1]")).isDisplayed();
		Assert.assertTrue(sub);
	}
	
}
