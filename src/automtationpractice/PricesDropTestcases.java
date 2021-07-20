package automtationpractice;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PricesDropTestcases {

WebDriver driver = new ChromeDriver();
	
	@BeforeMethod
	public void Basic() {
		System.setProperty("webdriver.chrome.driver","E:\\Work\\chromedriver.exe");
        String baseUrl = "http://automationpractice.com/index.php?controller=prices-drop";
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
	
	@Test(priority = 2)
	public void TestTheSortByMethod() {
			driver.findElement(By.xpath("//select[@id='selectProductSort']")).click();
			driver.findElement(By.cssSelector("body.prices-drop.hide-right-column.lang_en:nth-child(2) div.columns-container div.container div.row:nth-child(3) div.center_column.col-xs-12.col-sm-9 div.content_sortPagiBar:nth-child(2) div.sortPagiBar.clearfix form.productsSortForm div.select.selector1 div.selector:nth-child(2) select.selectProductSort.form-control:nth-child(2) > option:nth-child(2)")).click();
	}
	
	@Test(priority = 3)
	public void ClickOnTheProductShouldOpenTheProductPage() {
			driver.findElement(By.className("product-image-container")).click();
			Boolean product = driver.findElement(By.id("bigpic")).isDisplayed();
			Assert.assertTrue(product);	}
	
	@Test(priority = 4)
	public void WhenClickOnAddCartOnProduct() {
		driver.findElement(By.xpath("//body[1]/div[1]/div[2]/div[1]/div[3]/div[2]/ul[1]/li[1]/div[1]/div[2]/div[2]/a[1]/span[1]")).click();
		Boolean Cart = driver.findElement(By.id("layer_cart")).isDisplayed();
		Assert.assertTrue(Cart);
	}
	
	@Test(priority = 5)
	public void WhenTheUserClickOnMoreButtonOnAnyProductItOpensProductPage() {
		driver.findElement(By.cssSelector("body.prices-drop.hide-right-column.lang_en:nth-child(2) div.columns-container div.container div.row:nth-child(3) div.center_column.col-xs-12.col-sm-9 ul.product_list.grid.row:nth-child(3) li.ajax_block_product.col-xs-12.col-sm-6.col-md-4.first-in-line.last-line.first-item-of-tablet-line.first-item-of-mobile-line.last-mobile-line:nth-child(1) div.product-container div.right-block div.button-container:nth-child(4) a.button.lnk_view.btn.btn-default:nth-child(2) > span:nth-child(1)")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String url = driver.getCurrentUrl();
		Assert.assertEquals("http://automationpractice.com/index.php?id_product=7&controller=product",url);
	}
	
	@Test(priority = 6)
	public void WhenTheUserClickOnQuickViewItShouldNavigatesHimToSubWindowProduct() {
		driver.findElement(By.cssSelector("body.prices-drop.hide-right-column.lang_en:nth-child(2) div.columns-container div.container div.row:nth-child(3) div.center_column.col-xs-12.col-sm-9 ul.product_list.grid.row:nth-child(3) li.ajax_block_product.col-xs-12.col-sm-6.col-md-4.first-in-line.last-line.first-item-of-tablet-line.first-item-of-mobile-line.last-mobile-line.hovered:nth-child(1) div.product-container div.left-block div.product-image-container a.quick-view > span:nth-child(1)")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Boolean Product = driver.findElement(By.id("product")).isDisplayed();
		Assert.assertTrue(Product);
	}
	
	@Test(priority = 7)
	public void ChangeTheViewOfTheProducts() {
		driver.findElement(By.cssSelector("body.prices-drop.hide-right-column.lang_en:nth-child(2) div.columns-container div.container div.row:nth-child(3) div.center_column.col-xs-12.col-sm-9 div.content_sortPagiBar:nth-child(2) div.sortPagiBar.clearfix ul.display.hidden-xs li:nth-child(3) a:nth-child(1) > i.icon-th-list")).click();
		Boolean list = driver.findElement(By.className("list")).isDisplayed();
		Assert.assertTrue(list);
	}
	
}
