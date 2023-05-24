package com.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.Base;
import com.pages.AccountSuccessPage;
import com.pages.HomePage;
import com.pages.RegisterPage;
import com.utilities.Utilis;

public class RegisterTest extends Base {
	public WebDriver driver;
	RegisterPage registerPage;
	AccountSuccessPage accountSuccessPage;

	public RegisterTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {

		driver = initializeBrowser(prop.getProperty("browserName"));
		HomePage homepage = new HomePage(driver);
		// homepage.clickOnMyAccount();
		// driver.findElement(By.xpath("//span[text()='My Account']")).click();

		// RegisterPage registerPage = homepage.selectRegisterOption();
		// driver.findElement(By.linkText("Register")).click();

		registerPage = homepage.navigateToRegisterPage();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void verifyRegisterWithMandatory() {

		accountSuccessPage = registerPage.registerWithMandatoryFields(dataProp.getProperty("firstName"),
				dataProp.getProperty("lastName"), Utilis.generateEmailTimeStamp(),
				dataProp.getProperty("telephoneNumber"), prop.getProperty("validPassword"),
				prop.getProperty("validPassword"));

		// RegisterPage registerPage=new RegisterPage(driver);
//		registerPage.enterFirstName(dataProp.getProperty("firstName"));
//		registerPage.enterLastName(dataProp.getProperty("lastName"));
//		registerPage.enterEmailAddress(Utilis.generateEmailTimeStamp());
//		registerPage.enterTelephoneNumber(dataProp.getProperty("telephoneNumber"));
//		registerPage.enterPassword(prop.getProperty("validPassword"));
//		registerPage.enterConfirmPassword(prop.getProperty("validPassword"));
//		registerPage.selectPrivacyField();
//		accountSuccessPage = registerPage.clickOnContinueButton();

		// driver.findElement(By.id("input-firstname")).sendKeys(dataProp.getProperty("firstName"));
		// driver.findElement(By.id("input-lastname")).sendKeys(dataProp.getProperty("lastName"));
		// driver.findElement(By.id("input-email")).sendKeys(Utilis.generateEmailTimeStamp());
		// driver.findElement(By.id("input-telephone")).sendKeys(dataProp.getProperty("telephoneNumber"));
		// driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
		// driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validPassword"));
		// driver.findElement(By.name("agree")).click();
		// driver.findElement(By.xpath("//input[@value='Continue']")).click();

		// AccountSuccessPage accountSuccessPage=new AccountSuccessPage(driver);
		// String actualMesg = accountSuccessPage.retrieveAccSuccPageHeading();
		// String actualMesg =
		// driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
		// String expectMesg="Your Account Has Been Created!";

		Assert.assertEquals(accountSuccessPage.retrieveAccSuccPageHeading(),
				dataProp.getProperty("accountSuccessfullyCreatedHeading"), "Account Success Page is not Displayed..");

	}

	@Test(priority = 2)
	public void verifyRegisterWithAll() {

		accountSuccessPage = registerPage.registerWithAllFields(dataProp.getProperty("firstName"),
				dataProp.getProperty("lastName"), Utilis.generateEmailTimeStamp(),
				dataProp.getProperty("telephoneNumber"), prop.getProperty("validPassword"),
				prop.getProperty("validPassword"));

		// RegisterPage registerPage=new RegisterPage(driver);
//		registerPage.enterFirstName(dataProp.getProperty("firstName"));
//		registerPage.enterLastName(dataProp.getProperty("lastName"));
//		registerPage.enterEmailAddress(Utilis.generateEmailTimeStamp());
//		registerPage.enterTelephoneNumber(dataProp.getProperty("telephoneNumber"));
//		registerPage.enterPassword(prop.getProperty("validPassword"));
//		registerPage.enterConfirmPassword(prop.getProperty("validPassword"));
//		registerPage.selectYesNewsLetterOption();
//		registerPage.selectPrivacyField();
//		registerPage.clickOnContinueButton();

//		driver.findElement(By.id("input-firstname")).sendKeys(dataProp.getProperty("firstName"));
//		driver.findElement(By.id("input-lastname")).sendKeys(dataProp.getProperty("lastName"));
//		driver.findElement(By.id("input-email")).sendKeys(Utilis.generateEmailTimeStamp());
//		driver.findElement(By.id("input-telephone")).sendKeys(dataProp.getProperty("telephoneNumber"));

//		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
//		driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validPassword"));

		// driver.findElement(By.xpath("(//input[@name='newsletter'])[1]")).click();

//		driver.findElement(By.name("agree")).click();
//		driver.findElement(By.cssSelector("input[value='Continue']")).click();

		// String actualMesg =
		// driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
		// String expectMesg="Your Account Has Been Created!";

		// Assert.assertEquals(actualMesg,dataProp.getProperty("accountSuccessfullyCreatedHeading"),"Account
		// Success Page is not Displayed..");

		// AccountSuccessPage accountSuccessPage=new AccountSuccessPage(driver);
		// String actualMesg = accountSuccessPage.retrieveAccSuccPageHeading();
		Assert.assertEquals(accountSuccessPage.retrieveAccSuccPageHeading(),
				dataProp.getProperty("accountSuccessfullyCreatedHeading"), "Account Success Page is not Displayed..");

	}

	@Test(priority = 3)
	public void verifyWithExistEmail() throws InterruptedException {

		accountSuccessPage = registerPage.registerWithAllFields(dataProp.getProperty("firstName"),
				dataProp.getProperty("lastName"), dataProp.getProperty("validEmail"),
				dataProp.getProperty("telephoneNumber"), prop.getProperty("validPassword"),
				prop.getProperty("validPassword"));

		// RegisterPage registerPage=new RegisterPage(driver);
//		registerPage.enterFirstName(dataProp.getProperty("firstName"));
//		registerPage.enterLastName(dataProp.getProperty("lastName"));
//		registerPage.enterEmailAddress(dataProp.getProperty("validEmail"));
//		registerPage.enterTelephoneNumber(dataProp.getProperty("telephoneNumber"));
//		registerPage.enterPassword(prop.getProperty("validPassword"));
//		registerPage.enterConfirmPassword(prop.getProperty("validPassword"));
//		registerPage.selectYesNewsLetterOption();
//		registerPage.selectPrivacyField();
//		registerPage.clickOnContinueButton();

//		driver.findElement(By.id("input-firstname")).sendKeys(dataProp.getProperty("firstName"));
//		driver.findElement(By.id("input-lastname")).sendKeys(dataProp.getProperty("lastName"));
//		driver.findElement(By.id("input-email")).sendKeys(dataProp.getProperty("validEmail"));
//		driver.findElement(By.id("input-telephone")).sendKeys(dataProp.getProperty("telephoneNumber"));
//		
//		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
//		driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validPassword"));
//		
//		driver.findElement(By.xpath("(//input[@name='newsletter'])[1]")).click();
//		
//		driver.findElement(By.name("agree")).click();
//		driver.findElement(By.cssSelector("input[value='Continue']")).click();
//		
		// String actualWarning = driver.findElement(By.xpath("//div[@class='alert
		// alert-danger alert-dismissible']")).getText();
		// String actualWarning = registerPage.retrieveDuplicateEmailAddressWarning();
		// System.out.println(actualWarning);
		// Thread.sleep(2000);
		Assert.assertTrue(
				registerPage.retrieveDuplicateEmailAddressWarning().contains(prop.getProperty("duplicateEmailWarning")),
				"Message not Displayed");

//		String actualMesg = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
//		String expectMesg="Your Account Has Been Created!";
//		
//		Assert.assertEquals(actualMesg,expectMesg,"Account Success Page is not Displayed..");

	}

	@Test(priority = 4)
	public void verifyWithoutFillDetails() {

		// RegisterPage registerPage=new RegisterPage(driver);
		registerPage.clickOnContinueButton();

		Assert.assertTrue(registerPage.displaySattusOfWarningMessages(dataProp.getProperty("privacyPolicyWarning"),
				dataProp.getProperty("firstNameWarning"), dataProp.getProperty("lastNameWarning"),
				dataProp.getProperty("emailWarning"), dataProp.getProperty("telephoneWarning"),
				dataProp.getProperty("passwordWarning")));

		// driver.findElement(By.cssSelector("input[value='Continue']")).click();

		// String actualPrivacyWarning =
		// driver.findElement(By.xpath("//div[@class='alert alert-danger
		// alert-dismissible']")).getText();
		// String actualPrivacyWarning = registerPage.retrievePrivacyPolicyWarning();
//		Assert.assertTrue(
//				registerPage.retrievePrivacyPolicyWarning().contains(dataProp.getProperty("privacyPolicyWarning")),
//				"Privacy Message not Displayed");

		// String actFirstNameWarn = driver.findElement(By.xpath("//div[text()='First
		// Name must be between 1 and 32 characters!']")).getText();
		// String actFirstNameWarn = registerPage.retrieveFirstNameWarning();
//		Assert.assertEquals(registerPage.retrieveFirstNameWarning(), dataProp.getProperty("firstNameWarning"),
//				"First Name is Not displayed");

		// String actLastNameWarn =
		// driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).getText();
		// String actLastNameWarn = registerPage.retrieveLastNameWarning();
//		Assert.assertEquals(registerPage.retrieveLastNameWarning(), dataProp.getProperty("lastNameWarning"),
//				"Last Name is Not displayed");

		// String actEmailWarn =
		// driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")).getText();
		// String actEmailWarn = registerPage.retrieveEmailWarning();
//		Assert.assertEquals(registerPage.retrieveEmailWarning(), dataProp.getProperty("emailWarning"),
//				"Email is Not displayed");

		// String actTelephoneWarn =
		// driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText();
		// String actTelephoneWarn = registerPage.retrieveTelephoneWarning();
//		Assert.assertEquals(registerPage.retrieveTelephoneWarning(), dataProp.getProperty("telephoneWarning"),
//				"Telephone is Not displayed");

		// String actPassWarn =
		// driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText();
		// String actPassWarn = registerPage.retrievePasswordWarning();
//		Assert.assertEquals(registerPage.retrievePasswordWarning(), dataProp.getProperty("passwordWarning"),
//				"Password is Not displayed");

	}

}
