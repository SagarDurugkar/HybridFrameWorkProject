package com.testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.Base;
import com.pages.AccountPage;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.utilities.Utilis;

public class LoginTest extends Base {

	LoginPage loginPage;
	public WebDriver driver;

	public LoginTest() {
		super();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@BeforeMethod
	public void setUp() {

		driver = initializeBrowser(prop.getProperty("browserName"));

		HomePage homePage = new HomePage(driver);

		// driver.findElement(By.xpath("//span[text()='My Account']")).click();
		// driver.findElement(By.linkText("Login")).click();
//		 homePage.clickOnMyAccount();
//		 loginPage = homePage.selectLoginOption();
		loginPage = homePage.navigateToLoginPage();
	}

	@Test(priority = 1, dataProvider = "validCredSupplier")
	public void verifyLoginW(String email, String password) {

		// driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validEmail"));
		// driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));

		// LoginPage loginPage = new LoginPage(driver);

		// loginPage.enterEmailAddress(email);
		// driver.findElement(By.id("input-email")).sendKeys(email);

		// loginPage.enterPassword(password);
		// driver.findElement(By.id("input-password")).sendKeys(password);

		AccountPage accountPage = loginPage.login(email, password);

		// AccountPage accountPage = loginPage.clickOnLoginButton();
		// driver.findElement(By.xpath("//input[@value='Login']")).click();

		// Assert.assertTrue(driver.findElement(By.linkText("Edit your account
		// information")).isDisplayed(),"Edit Your Accout Information Option is not
		// displayed");
		// AccountPage accountPage = new AccountPage(driver);
		Assert.assertTrue(accountPage.getDisplayStatusOfEditYourAccInfoOption(),
				"Edit Your Accout Information Option is not displayed");

	}

	@DataProvider(name = "validCredSupplier")
	public Object[][] supplyTestData() {

		// Object[][] data=
		// {{"amotooricap9@gmail.com","12345"},{"amotooricap1@gmail.com","12345"},{"amotooricap3@gmail.com","12345"}};
		Object[][] data = Utilis.getDataFromExcel("Login");
		return data;
	}

	@Test(priority = 2)
	public void verifyLoginInvalidCred() {

		loginPage.login(Utilis.generateEmailTimeStamp(), dataProp.getProperty("invalidPassword"));

		// LoginPage loginPage = new LoginPage(driver);

		// loginPage.enterEmailAddress(Utilis.generateEmailTimeStamp());
		// driver.findElement(By.id("input-email")).sendKeys(Utilis.generateEmailTimeStamp());
		// driver.findElement(By.id("input-email")).sendKeys("amfsgshjs@gmail.com");

		// loginPage.enterPassword(dataProp.getProperty("invalidPassword"));
		// driver.findElement(By.id("input-password")).sendKeys(dataProp.getProperty("invalidPassword"));

		// loginPage.clickOnLoginButton();
		// driver.findElement(By.cssSelector("input[value='Login']")).click();

//		String actualWarningMesg = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]"))
//				.getText();
		// String actualWarningMesg =
		// loginPage.retrieveEmailPassNotMatchingWarningmesgText();

		// String expectWarningMesg="Warning: No match for E-Mail Address and/or
		// Password.";
		// String expectWarningMesg =
		// dataProp.getProperty("emailPasswordNoMatchWarning");

		Assert.assertTrue(
				loginPage.retrieveEmailPassNotMatchingWarningmesgText()
						.contains(dataProp.getProperty("emailPasswordNoMatchWarning")),
				"Expected Warning Message is not Displayed");

	}

	@Test(priority = 3)
	public void verifyInvalidEmail() {

		loginPage.login(Utilis.generateEmailTimeStamp(), prop.getProperty("validPassword"));
		// LoginPage loginPage = new LoginPage(driver);
		// loginPage.enterEmailAddress(Utilis.generateEmailTimeStamp());
		// driver.findElement(By.id("input-email")).sendKeys(Utilis.generateEmailTimeStamp());
		// driver.findElement(By.id("input-email")).sendKeys("amfsgshjs@gmail.com");

		// loginPage.enterPassword(prop.getProperty("validPassword"));
		// driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));

		// loginPage.clickOnLoginButton();
		// driver.findElement(By.cssSelector("input[value='Login']")).click();

//		String actualWarningMesg = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]"))
//				.getText();

		// String expectWarningMesg="Warning: No match for E-Mail Address and/or
		// Password.";

//		String actualWarningMesg = loginPage.retrieveEmailPassNotMatchingWarningmesgText();
//		
//		String expectWarningMesg = dataProp.getProperty("emailPasswordNoMatchWarning");
//
//		Assert.assertTrue(actualWarningMesg.contains(expectWarningMesg), "Expected Warning Message is not Displayed");

//		String expectWarningMesg = dataProp.getProperty("emailPasswordNoMatchWarning");
//
//		Assert.assertTrue(actualWarningMesg.contains(expectWarningMesg), "Expected Warning Message is not Displayed");

		Assert.assertTrue(
				loginPage.retrieveEmailPassNotMatchingWarningmesgText()
						.contains(dataProp.getProperty("emailPasswordNoMatchWarning")),
				"Expected Warning Message is not Displayed");

	}

	@Test(priority = 4)
	public void verifyInvalidPass() {

		// driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validEmail"));
		// driver.findElement(By.id("input-email")).sendKeys("amfsgshjs@gmail.com");
		// driver.findElement(By.id("input-password")).sendKeys(dataProp.getProperty("invalidPassword"));
		// driver.findElement(By.id("input-password")).sendKeys("1234567890");

		// driver.findElement(By.cssSelector("input[value='Login']")).click();
		// LoginPage loginPage = new LoginPage(driver);

		loginPage.login(prop.getProperty("validEmail"), dataProp.getProperty("invalidPassword"));
//		loginPage.enterEmailAddress(prop.getProperty("validEmail"));
//		loginPage.enterPassword(dataProp.getProperty("invalidPassword"));
//		loginPage.clickOnLoginButton();

//		String actualWarningMesg = loginPage.retrieveEmailPassNotMatchingWarningmesgText();
//
//		String expectWarningMesg = dataProp.getProperty("emailPasswordNoMatchWarning");
//
//		Assert.assertTrue(actualWarningMesg.contains(expectWarningMesg), "Expected Warning Message is not Displayed");

		Assert.assertTrue(
				loginPage.retrieveEmailPassNotMatchingWarningmesgText()
						.contains(dataProp.getProperty("emailPasswordNoMatchWarning")),
				"Expected Warning Message is not Displayed");

//		String actualWarningMesg = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]"))
//				.getText();

		// String expectWarningMesg="Warning: No match for E-Mail Address and/or
		// Password.";
//		String expectWarningMesg = dataProp.getProperty("emailPasswordNoMatchWarning");
//
//		Assert.assertTrue(actualWarningMesg.contains(expectWarningMesg), "Expected Warning Message is not Displayed");

	}

	@Test(priority = 5)
	public void verifyWithoudCred() {

		// driver.findElement(By.id("input-email")).sendKeys("");
		// driver.findElement(By.id("input-email")).sendKeys("amfsgshjs@gmail.com");
		// driver.findElement(By.id("input-password")).sendKeys("");

		// LoginPage loginPage = new LoginPage(driver);
		loginPage.clickOnLoginButton();

		// driver.findElement(By.cssSelector("input[value='Login']")).click();

		// String actualWarningMesg =
		// driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]"))
		// .getText();

		// String expectWarningMesg="Warning: No match for E-Mail Address and/or
		// Password.";
		// String expectWarningMesg =
		// dataProp.getProperty("emailPasswordNoMatchWarning");

		// Assert.assertTrue(actualWarningMesg.contains(expectWarningMesg), "Expected
		// Warning Message is not Displayed");

//		String actualWarningMesg = loginPage.retrieveEmailPassNotMatchingWarningmesgText();
//		String expectWarningMesg = dataProp.getProperty("emailPasswordNoMatchWarning");
//		Assert.assertTrue(actualWarningMesg.contains(expectWarningMesg), "Expected Warning Message is not Displayed");

		Assert.assertTrue(
				loginPage.retrieveEmailPassNotMatchingWarningmesgText()
						.contains(dataProp.getProperty("emailPasswordNoMatchWarning")),
				"Expected Warning Message is not Displayed");

	}

}
