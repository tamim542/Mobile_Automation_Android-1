package pageObjects;

import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

/*
 * Page Package
 * Page Class:
 * 	1. Locations
 * 	2. Operations (methods)
 */

public class P1_HomePage {

	@SuppressWarnings("rawtypes")
	public P1_HomePage(AppiumDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
	public MobileElement nameField;

	@AndroidFindBy(xpath = "//*[@text='Female']")
	public MobileElement femaleOption;

	@AndroidFindBy(xpath = "//*[@text='Male']")
	public MobileElement maleOption;

	@AndroidFindBy(id = "android:id/text1")
	public MobileElement dropDownClick;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
	public MobileElement letsShop;

	@AndroidFindBy(xpath = "//*[@text='Bangladesh']")
	public MobileElement ChooseCountryBangladesh;

	public MobileElement getNameField() {
		System.out.println("Trying to find the Name Field");
		return nameField;
	}
	
	public MobileElement getNameField(String value) {
		nameField.sendKeys(value);
		return nameField;
	}
	
	public void selectFemale() {
		femaleOption.click();
	}
	
	public void selectMale() {
		femaleOption.click();
	}
	
	public void clickOnLetsShopButton() {
		letsShop.click();
	}

}
