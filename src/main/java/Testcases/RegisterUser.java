package Testcases;

import java.sql.Savepoint;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import base.BaseClass;

public class RegisterUser extends BaseClass {
	public RegisterUser() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(name = "name")
	WebElement SignupNameTextFieldElement;

	@FindBy(xpath = "(//input[@name='email'])[2]")
	WebElement SignupEmailTextFieldElement;	 

	@FindBy(name = "form_type")
	WebElement SignupSaveButtonElement;

	@FindBy(xpath = "//b[text()='Enter Account Information']")
	WebElement signUpTitlElement;

	@FindBy(id = "	id_gender1")
	WebElement 	id_gender1redioButton;

	@FindBy(id = "password")
	WebElement PasswordTextField;

	@FindBy(id = "uniform-newsletter")
	WebElement NewShelterCheckBoxElement;

	@FindBy(id = "uniform-optin")
	WebElement 	UniformoptinCheckBoxElement;

	@FindBy(name = "first_name")
	WebElement SignupFristNameFieldElement;	

	@FindBy(name = "last_name")
	WebElement SignupLastNameFieldElement;	

	@FindBy(name = "company")
	WebElement SignupComponyFieldElement;	

	@FindBy(name ="address1")
	WebElement AdressFieldElement;

	@FindBy(name = "state")
	WebElement StateFieldElement;	

	@FindBy(name = "city")
	WebElement CityNameFieldElement;	

	@FindBy(name = "zipcode")
	WebElement ZipcodeFieldElement;	

	@FindBy(name = "mobile_number")
	WebElement MobileNumberFieldElement;

	@FindBy(xpath = "//[@type='submit']")
	WebElement CreateAccoutButton;	

	@FindBy(id = "country")
	WebElement CountryDropDown;

	@FindBy(xpath = "	@FindBy(id = \"country\")")
	WebElement	AccountConfirmationMessage;

	@FindBy(xpath = "//a[text()='Continue']")
	WebElement continueButtonElement;

	@FindBy(xpath = "//a[normalize-space()='Delete Account']")
	WebElement DeleteAccoutButtonElement;

	@FindBy(xpath = "	//a[normalize-space()='Home']")
	WebElement HomePageElement;

	public void AddNewUser() throws InterruptedException {
		Actions actions=new  Actions(driver);
		String A = driver.getTitle();
		Assert.assertEquals(A, "Automation Exercise - Signup / Login");

		SignupNameTextFieldElement.sendKeys("Rishabh Patil");
		SignupEmailTextFieldElement.sendKeys("rishipatil89085@gmail.com");

		WebElement f = SignupSaveButtonElement;
		Thread.sleep(2000);
		actions.moveToElement(f).click().build().perform();
		boolean B = signUpTitlElement.isDisplayed();
		Assert.assertEquals(B, true);

		//Account Information	
		id_gender1redioButton.click();
		PasswordTextField.sendKeys("Rishi@10089");

		//Checkbox
		NewShelterCheckBoxElement.click();
		UniformoptinCheckBoxElement.click();

		//Adress Textbox
		SignupFristNameFieldElement.sendKeys("rishi");
		SignupLastNameFieldElement.sendKeys("patil");
		AdressFieldElement.sendKeys("jaysingpur, tal shirol, Dis-Kolhapur");

		// Country Dropdown
		Select set=new Select(CountryDropDown);
		set.selectByIndex(1);
		StateFieldElement.sendKeys("Maharastra");
		CityNameFieldElement.sendKeys("Jaysingpur");
		ZipcodeFieldElement.sendKeys("416101");
		MobileNumberFieldElement.sendKeys("8668741969");
		CreateAccoutButton.click();
		boolean c = AccountConfirmationMessage.isDisplayed();
		Assert.assertEquals(c, true);

		continueButtonElement.click();

		//Delete Account
		boolean D = HomePageElement.isDisplayed();
		Assert.assertEquals(D, true);
		DeleteAccoutButtonElement.click();
	}

}
