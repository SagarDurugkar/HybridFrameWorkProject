package com.testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.Base;
import com.pages.HomePage;
import com.pages.SearchPage;

public class SearchTest extends Base {
	HomePage homePage;
	SearchPage searchPage;
	public WebDriver driver;
	
	public SearchTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		
		 driver = initializeBrowser(prop.getProperty("browserName"));
		  homePage=new HomePage(driver);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority = 1)
	public void verifySearchWithValid() {
		
		searchPage = homePage.searchForAProduct(dataProp.getProperty("validProduct"));
		
		//HomePage homePage=new HomePage(driver);
		//driver.findElement(By.name("search")).sendKeys(dataProp.getProperty("validProduct"));
		//homePage.enterProdIntoSearchBoxField(dataProp.getProperty("validProduct"));
		
		//driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
		//searchPage = homePage.clickOnSearchButton();
		
		//SearchPage searchPage=new SearchPage(driver);
		//Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed());
		Assert.assertTrue(searchPage.displayStatusHPValidProduct(),"Valid Product Is Not Dislpayed on Search Results");
		
	}
	
	@Test(priority = 2)
	public void verifySearchWithInvalid() {
		
		 searchPage = homePage.searchForAProduct(dataProp.getProperty("invalidProduct"));
		
		//HomePage homePage=new HomePage(driver);
//		homePage.enterProdIntoSearchBoxField(dataProp.getProperty("invalidProduct"));
//		searchPage =homePage.clickOnSearchButton();
//		
		//SearchPage searchPage=new SearchPage(driver);
		//String actSearchMesg = searchPage.retrieveNoProductMesgText();
		//Assert.assertEquals(searchPage.retrieveNoProductMesgText(),dataProp.getProperty("noProductTextInSearchResult"),"No product message in search result is displayed");
		Assert.assertEquals(searchPage.retrieveNoProductMesgText(),"xyz","No product message in search result is displayed");
		
		//driver.findElement(By.name("search")).sendKeys(dataProp.getProperty("invalidProduct"));
		//driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
		//String actSearchMesg = driver.findElement(By.xpath("//div[@id='content']/h2/following-sibling::p")).getText();
		
		
		
	}
	
	@Test(priority = 3,dependsOnMethods = {"verifySearchWithInvalid","verifySearchWithValid"})
	public void verifySearchWithout() {
		
		//HomePage homePage=new HomePage(driver);
		searchPage =homePage.clickOnSearchButton();
		
		//SearchPage searchPage=new SearchPage(driver);
		//String actSearchMesg = searchPage.retrieveNoProductMesgText();
		Assert.assertEquals(searchPage.retrieveNoProductMesgText(),dataProp.getProperty("noProductTextInSearchResult"),"No product message in search result is displayed");
		
		//driver.findElement(By.name("search")).sendKeys("");
		//driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
		
//		String actSearchMesg = driver.findElement(By.xpath("//div[@id='content']/h2/following-sibling::p")).getText();
//		
//		Assert.assertEquals(actSearchMesg,dataProp.getProperty("noProductTextInSearchResult"),"No product message in search result is displayed");
	}
}
