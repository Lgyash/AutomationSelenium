package automtationpractice;

import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductPageTestcases {
WebDriver driver = new ChromeDriver();
	
	@BeforeMethod
	public void Basic() {
		System.setProperty("webdriver.chrome.driver","E:\\Work\\chromedriver.exe");
        String baseUrl = "http://automationpractice.com/index.php?id_product=7&controller=product";
        driver.get(baseUrl);
	}
	
	@AfterMethod
	public void close() {
		driver.close();
	}
	
	//Functional
	
	@Test(priority = 1)
	public void OpenSocialLinksInTheProductPage() {
		driver.findElement(By.className("btn-twitter")).click();
	    Iterator<String> handleIterator = this.driver.getWindowHandles().iterator();
	    while (handleIterator.hasNext())
	    {
	        String handle = handleIterator.next();
	        if (!handleIterator.hasNext())
	        {
	            this.driver.switchTo().window(handle);
	        }
	    }
	    Boolean social= driver.findElement(By.id("react-root")).isDisplayed();
		Assert.assertTrue(social);
	}
	
	@Test(priority = 2)
	public void OpenLinksInTheProductPage() {
		driver.findElement(By.xpath("//a[@id='send_friend_button']")).click();
		driver.findElement(By.xpath("//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[3]/ul[1]/li[2]/a[1]")).click();
	}
	
	@Test(priority = 3)
	public void IncreaseTheQuantity() {
		driver.findElement(By.xpath("//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[4]/form[1]/div[1]/div[2]/p[1]/a[2]/span[1]/i[1]")).click();
	}

	@Test(priority = 4)
	public void ChangeTheSizeOfTheProduct() {
		driver.findElement(By.tagName("select")).click();
		driver.findElement(By.xpath("//option[contains(text(),'S')]")).click();
	}
	
	@Test(priority = 5)
	public void ChangeTheColorOfTheProduct() {
		driver.findElement(By.cssSelector("#color_15")).click();
	}
	
	@Test(priority = 6)
	public void AddProductToCart() {
		driver.findElement(By.cssSelector("body.product.product-7.product-printed-chiffon-dress.category-11.category-summer-dresses.hide-left-column.hide-right-column.lang_en:nth-child(2) div.columns-container div.container div.row:nth-child(3) div.center_column.col-xs-12.col-sm-12 div.primary_block.row:nth-child(1) div.pb-right-column.col-xs-12.col-sm-4.col-md-3 div.box-info-product div.box-cart-bottom div:nth-child(1) p.buttons_bottom_block.no-print button.exclusive > span:nth-child(1)")).click();
		Boolean cart= driver.findElement(By.id("layer_cart")).isDisplayed();
		Assert.assertTrue(cart);
	}
	
	@Test(priority = 7)
	public void AddProductToWishlist() {
		driver.findElement(By.id("wishlist_button")).click();
	}
}
