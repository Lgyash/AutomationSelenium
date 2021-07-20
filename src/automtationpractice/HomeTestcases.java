package automtationpractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeTestcases {
	
	WebDriver driver = new ChromeDriver();
	
	@BeforeMethod
	public void Basic() {
		System.setProperty("webdriver.chrome.driver","E:\\Work\\chromedriver.exe");
        String baseUrl = "http://automationpractice.com/index.php/";
        driver.get(baseUrl);
	}
	
	@AfterMethod
	public void close() {
		driver.close();
	}
	
	@Test(priority = 1)
	public void WhenClickOnShopNowItShouldNavigateMeToPrestaShop() {
		driver.findElement(By.xpath("//body/div[@id='page']/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/div[1]/p[2]/button[1]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String url = driver.getCurrentUrl();
		Assert.assertEquals("https://www.prestashop.com/en?utm_source=v16_homeslider",url);
	}
	
	
	@Test(priority = 2)
	public void WhenClickOn3DaysPhotoItShouldNavigateMeToPrestaShop() {
		driver.findElement(By.cssSelector("body.index.hide-left-column.hide-right-column.lang_en:nth-child(2) div.columns-container div.container div.row:nth-child(1) div.center_column.col-xs-12.col-sm-12 div:nth-child(2) ul.htmlcontent-home.clearfix.row li.htmlcontent-item-1.col-xs-4 a.item-link > img.item-img")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String url = driver.getCurrentUrl();
		Assert.assertEquals("https://www.prestashop.com/en?utm_source=v16_homeslider",url);
	}
	
	@Test(priority = 3)
	public void WhenClickOnSummerCollectionPhotoItShouldNavigateMeToPrestaShop() {
		driver.findElement(By.cssSelector("body.index.hide-left-column.hide-right-column.lang_en:nth-child(2) div.columns-container div.container div.row:nth-child(1) div.center_column.col-xs-12.col-sm-12 div:nth-child(2) ul.htmlcontent-home.clearfix.row li.htmlcontent-item-2.col-xs-4 a.item-link > img.item-img")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String url = driver.getCurrentUrl();
		Assert.assertEquals("https://www.prestashop.com/en?utm_source=v16_homeslider",url);
	}
	
	@Test(priority = 4)
	public void WhenClickOnBestSellerLinkItShouldNavigateMeToBestSellerProducts() {
		driver.findElement(By.linkText("Best Sellers")).click();
		Boolean url = driver.findElement(By.id("blockbestsellers")).isDisplayed();
		Assert.assertTrue(url);
	}
	
	@Test(priority = 5)
	public void WhenClickOnImageCollectionItShouldNavigateMeToPrestaShop() {
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/ul[1]/li[1]/a[1]/img[1]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String url = driver.getCurrentUrl();
		Assert.assertEquals("https://www.prestashop.com/en",url);
	}
	
	@Test(priority = 6)
	public void WhenClickOnSeleniumFrameworkButtonItShouldNavigateMeToSeleniumWebsite() {
		driver.findElement(By.partialLinkText("Selenium Framewo")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String url = driver.getCurrentUrl();
		Assert.assertEquals("http://www.seleniumframework.com/",url);
	}
	
	@Test(priority = 7)
	public void WhenTypeInTheNewsletterItShouldSaysYouHaveSuccessfullySubscribedToThisNewsletter() {
		driver.findElement(By.cssSelector("#newsletter-input")).sendKeys("abc.pom@xyz");
		String alert = driver.findElement(By.xpath("//p[contains(text(),'Newsletter : You have successfully subscribed to t')]")).getText();
		Assert.assertEquals(" Newsletter : You have successfully subscribed to this newsletter.",alert);	
	}
	
	@Test(priority = 8)
	public void WhenTheUserClickOnSocialIconsItShouldNavigatesHimToSocialPages() {
		driver.findElement(By.xpath("//body/div[@id='page']/div[3]/footer[1]/div[1]/section[1]/ul[1]/li[1]/a[1]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String url = driver.getCurrentUrl();
		Assert.assertEquals("https://www.facebook.com/groups/525066904174158/",url);
	}
	
	@Test(priority = 9)
	public void WhenTheUserClickOnQuickViewItShouldNavigatesHimToSubWindowProduct() {
		driver.findElement(By.cssSelector("body.index.hide-left-column.hide-right-column.lang_en:nth-child(2) div.columns-container div.container div.row:nth-child(4) div.center_column.col-xs-12.col-sm-12 div.tab-content ul.product_list.grid.row.homefeatured.tab-pane.active:nth-child(1) li.ajax_block_product.col-xs-12.col-sm-4.col-md-3.last-item-of-tablet-line.first-item-of-mobile-line:nth-child(3) div.product-container div.left-block div.product-image-container a.quick-view > span:nth-child(1)")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Boolean Product = driver.findElement(By.id("product")).isDisplayed();
		Assert.assertTrue(Product);
	}
	
	@Test(priority = 10)
	public void WhenTheUserClickOnMoreButtonOnAnyProductItOpensProductPage() {
		driver.findElement(By.cssSelector("body.index.hide-left-column.hide-right-column.lang_en:nth-child(2) div.columns-container div.container div.row:nth-child(4) div.center_column.col-xs-12.col-sm-12 div.tab-content ul.product_list.grid.row.homefeatured.tab-pane.active:nth-child(1) li.ajax_block_product.col-xs-12.col-sm-4.col-md-3.last-item-of-mobile-line:nth-child(2) div.product-container div.right-block div.button-container:nth-child(4) a.button.lnk_view.btn.btn-default:nth-child(2) > span:nth-child(1)")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String url = driver.getCurrentUrl();
		Assert.assertEquals("http://automationpractice.com/index.php?id_product=2&controller=product",url);
	}
	
	@Test(priority = 10)
	public void WhenTheUserClickOnAnyLinkOfTheMenu() {
		driver.findElement(By.linkText("T-shirts")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String url = driver.getCurrentUrl();
		Assert.assertEquals("http://automationpractice.com/index.php?id_category=5&controller=category",url);
	}
	
	@Test(priority = 11)
	public void WhenTheUserClickOnCartItShouldOpenTheCartPage() {
		driver.findElement(By.xpath("//header/div[3]/div[1]/div[1]/div[3]/div[1]/a[1]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String url = driver.getCurrentUrl();
		Assert.assertEquals("http://automationpractice.com/index.php?controller=order",url);
	}
	
	@Test(priority = 12)
	public void WhenTheTypeSearchItShouldLoadResults() {
		driver.findElement(By.className("search_query")).sendKeys("Blouse");
		driver.findElement(By.xpath("//header/div[3]/div[1]/div[1]/div[2]/form[1]/button[1]")).click();
		Boolean status= driver.findElement(By.className("content_sortPagiBar")).isDisplayed();
		Assert.assertTrue(status);
	}
	
	@Test(priority = 13)
	public void WhenClickOnAnyFooterLinks() {
		driver.findElement(By.xpath("//a[contains(text(),'New products')]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String url = driver.getCurrentUrl();
		Assert.assertEquals("http://automationpractice.com/index.php?controller=new-products",url);
	}
	
	@Test(priority = 14)
	public void WhenClickOnAddCartOnProduct() {
		driver.findElement(By.xpath("//body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/ul[1]/li[2]/div[1]/div[2]/div[2]/a[1]/span[1]")).click();
		driver.findElement(By.cssSelector("body.index.hide-left-column.hide-right-column.lang_en:nth-child(2) div.header-container div.container div.row div.col-sm-4.clearfix:nth-child(3) div.shopping_cart > a:nth-child(1)")).click();
		Boolean Cart = driver.findElement(By.className("cart_block")).isDisplayed();
		Assert.assertTrue(Cart);
	}
}
