package pages;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SignupPage {
	WebDriver driver;
	Random rand = new Random();

	public SignupPage(WebDriver thedriver) {
		this.driver = thedriver;
	}
    // pom (page object model)
	// Locators

	By firstname = By.name("firstname");
	By lastname = By.id("AccountFrm_lastname");
	By email = By.id("AccountFrm_email");
	By telephone = By.id("AccountFrm_telephone");
	By fax = By.id("AccountFrm_fax");
	By company = By.id("AccountFrm_company");
	By address1 = By.id("AccountFrm_address_1");
	By address2 = By.id("AccountFrm_address_2");
	By city = By.id("AccountFrm_city");
	By country = By.id("AccountFrm_country_id");
	By state = By.id("AccountFrm_zone_id");
	By postcode = By.id("AccountFrm_postcode");
	By loginname = By.id("AccountFrm_loginname");
	By password = By.id("AccountFrm_password");
	By confirm = By.id("AccountFrm_confirm");
	By agree = By.id("AccountFrm_agree");
	By continueBtn = By.cssSelector("button[title='Continue']");

	// this is to fill the form still we didn't do any test

	public void fillForm(String f, String l, String mail, String phone, String user, String pass, String firstName)
			throws InterruptedException {

		driver.findElement(firstname).sendKeys(f);
		driver.findElement(lastname).sendKeys(l);
		driver.findElement(email).sendKeys(mail);
		driver.findElement(telephone).sendKeys(phone);
		driver.findElement(fax).sendKeys("9624545755");
		driver.findElement(company).sendKeys("abc");
		driver.findElement(address1).sendKeys("Amman tlaaelAli");
		driver.findElement(address2).sendKeys("Amman ShafaBadran");
		driver.findElement(city).sendKeys("Amman");

		Select countrySelect = new Select(driver.findElement(country));
		int countryCount = driver.findElement(country).findElements(By.tagName("option")).size();
		countrySelect.selectByIndex(rand.nextInt(1, countryCount));
/*
 * الواحد هاي ع اساس ما ابلش من صفر الي هي خيار الاختيار ونبدا من واحد
 * ولانه اذا ما اختار بلد ما رح يختار مدينه */
		
		  Thread.sleep(2000);
		  
		Select stateSelect = new Select(driver.findElement(state));
		int stateCount = driver.findElement(state).findElements(By.tagName("option")).size();
		stateSelect.selectByIndex(rand.nextInt(1, stateCount));

		driver.findElement(postcode).sendKeys("3817");
		driver.findElement(loginname).sendKeys(user);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(confirm).sendKeys(pass);
		driver.findElement(agree).click();
		driver.findElement(continueBtn).click();
	}

//this is a return function that will return only ( true or false since it's a boolean ) and its like assert function
	public boolean isSignupSuccess() {
		return driver.getPageSource().contains("Your Account Has Been Created!");
	}

}
