package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	WebDriver driver;

	@FindBy(id = "input-firstname")
	private WebElement firstNameField;

	@FindBy(id = "input-lastname")
	private WebElement lastNameField;

	@FindBy(id = "input-email")
	private WebElement emailAddressField;

	@FindBy(id = "input-telephone")
	private WebElement telephoneField;

	@FindBy(id = "input-password")
	private WebElement passwordField;

	@FindBy(id = "input-confirm")
	private WebElement passwordConfirmField;

	@FindBy(name = "agree")
	private WebElement privacyPolicyField;

	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueButton;

	@FindBy(xpath = "(//input[@name='newsletter'])[1]")
	private WebElement yesNewsLetterOption;

	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement duplicateEmailAddressWarning;

	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement privacyPolicyWarning;

	@FindBy(xpath = "//div[text()='First Name must be between 1 and 32 characters!']")
	private WebElement firstNameWarning;

	@FindBy(xpath = "//input[@id='input-lastname']/following-sibling::div")
	private WebElement lastNameWarning;

	@FindBy(xpath = "//input[@id='input-email']/following-sibling::div")
	private WebElement emailWarning;

	@FindBy(xpath = "//input[@id='input-telephone']/following-sibling::div")
	private WebElement telephoneWarning;

	@FindBy(xpath = "//input[@id='input-password']/following-sibling::div")
	private WebElement passwordWarning;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterFirstName(String firstNameText) {
		firstNameField.sendKeys(firstNameText);
	}

	public void enterLastName(String LastNameText) {
		lastNameField.sendKeys(LastNameText);
	}

	public void enterEmailAddress(String emailText) {
		emailAddressField.sendKeys(emailText);
	}

	public void enterTelephoneNumber(String telephoneText) {
		telephoneField.sendKeys(telephoneText);
	}

	public void enterPassword(String passwordText) {
		passwordField.sendKeys(passwordText);
	}

	public void enterConfirmPassword(String confirmPasswordText) {
		passwordConfirmField.sendKeys(confirmPasswordText);
	}

	public void selectPrivacyField() {
		privacyPolicyField.click();
	}

	public AccountSuccessPage clickOnContinueButton() {
		continueButton.click();
		return new AccountSuccessPage(driver);
	}

	public void selectYesNewsLetterOption() {
		yesNewsLetterOption.click();
	}

	public String retrieveDuplicateEmailAddressWarning() {
		String duplicateEmailWarningText = duplicateEmailAddressWarning.getText();
		return duplicateEmailWarningText;

	}

	public String retrievePrivacyPolicyWarning() {
		String privacyPolicyWarningText = privacyPolicyWarning.getText();
		return privacyPolicyWarningText;
	}

	public String retrieveFirstNameWarning() {
		String FirstNameWarningText = firstNameWarning.getText();
		return FirstNameWarningText;
	}

	public String retrieveLastNameWarning() {
		String LastNameWarningText = lastNameWarning.getText();
		return LastNameWarningText;
	}

	public String retrieveEmailWarning() {
		String EmailWarningText = emailWarning.getText();
		return EmailWarningText;
	}

	public String retrieveTelephoneWarning() {
		String TelephoneWarningText = telephoneWarning.getText();
		return TelephoneWarningText;
	}

	public String retrievePasswordWarning() {
		String PasswordWarningText = passwordWarning.getText();
		return PasswordWarningText;
	}

	public AccountSuccessPage registerWithMandatoryFields(String firstNameText, String LastNameText, String emailText,
			String telephoneText, String passwordText, String confirmPasswordText) {
		firstNameField.sendKeys(firstNameText);
		lastNameField.sendKeys(LastNameText);
		emailAddressField.sendKeys(emailText);
		telephoneField.sendKeys(telephoneText);
		passwordField.sendKeys(passwordText);
		passwordConfirmField.sendKeys(confirmPasswordText);
		privacyPolicyField.click();
		continueButton.click();
		return new AccountSuccessPage(driver);

	}

	public AccountSuccessPage registerWithAllFields(String firstNameText, String LastNameText, String emailText,
			String telephoneText, String passwordText, String confirmPasswordText) {
		firstNameField.sendKeys(firstNameText);
		lastNameField.sendKeys(LastNameText);
		emailAddressField.sendKeys(emailText);
		telephoneField.sendKeys(telephoneText);
		passwordField.sendKeys(passwordText);
		passwordConfirmField.sendKeys(confirmPasswordText);
		yesNewsLetterOption.click();
		privacyPolicyField.click();
		continueButton.click();
		return new AccountSuccessPage(driver);

	}

	public boolean displaySattusOfWarningMessages(String expectedPrivacyPolicyWarning, String expectedFirstNameWarning,
			String expectedLastNameWarning, String expectedEmailWarning, String expectedTelephoneWarning,
			String expectedPasswordWarning) {
		
		//String actualPrivacyPolicyWarningText = privacyPolicyWarning.getText();
		boolean privacyPolicyWarningStatus = privacyPolicyWarning.getText().contains(expectedPasswordWarning);
		
		//String actualFirstNameWarningText = firstNameWarning.getText();
		boolean firstNameWarningStatus = firstNameWarning.getText().equals(expectedFirstNameWarning);
		
		//String actualLastNameWarningText = lastNameWarning.getText();
		boolean lastNameWarningStatus = lastNameWarning.getText().equals(expectedLastNameWarning);
		
		//String actualEmailWarningText = emailWarning.getText();
		boolean emailWarningStatus = emailWarning.getText().equals(expectedEmailWarning);
		
		//String actualTelephoneWarningText = telephoneWarning.getText();
		boolean telephoneWarningStatus = telephoneWarning.getText().equals(expectedTelephoneWarning);
		
		//String actualPasswordWarningText = passwordWarning.getText();
		boolean passwordWarningStatus =  passwordWarning.getText().equals(expectedPasswordWarning);
		
		return privacyPolicyWarningStatus && firstNameWarningStatus && lastNameWarningStatus && emailWarningStatus && telephoneWarningStatus && passwordWarningStatus;
		
		
		
		
		
	}

}
