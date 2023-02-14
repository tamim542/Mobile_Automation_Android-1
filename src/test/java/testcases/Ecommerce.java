package testcases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.Base;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import pageObjects.P1_HomePage;
import pageObjects.P2_Products;
import pageObjects.P3_CheckoutPage;
import utilitties.Utilitties;

public class Ecommerce extends Base {

	@Test
	public void mySecondTest() throws IOException, InterruptedException {
		AndroidDriver<AndroidElement> driver = capabilities();
		Thread.sleep(2000);

		P1_HomePage home = new P1_HomePage(driver);
		//home.getNameField().sendKeys("appium");
		home.getNameField("appium");
		Thread.sleep(2000);

		driver.hideKeyboard();

		home.selectFemale();
		home.selectMale();

		home.dropDownClick.click();

		Utilitties util = new Utilitties(driver);
		util.scrollToText("Bangladesh");
		Thread.sleep(2000);

		home.ChooseCountryBangladesh.click();
		Thread.sleep(2000);

		home.clickOnLetsShopButton();
		Thread.sleep(2000);

		P2_Products prod = new P2_Products(driver);
		prod.addToCart.get(1).click();
		Thread.sleep(1000);
		prod.addToCart.get(0).click();

		Thread.sleep(1000);

		prod.cart.click();
		Thread.sleep(1000);

		P3_CheckoutPage cPage = new P3_CheckoutPage(driver);

		double sum = 0;
		int count = cPage.productList.size();

		for (int i = 0; i < count; i++) {
			String amount1 = cPage.productList.get(i).getText();
			double amountValue1 = getAmount(amount1);
			sum = sum + amountValue1;
		}
		System.out.println("SumOfProducts individually: " + sum);

		String total = cPage.total.getText();
		double totalValue = getAmount(total);
		System.out.println("TotalValue from the application: " + totalValue);

		Assert.assertEquals(sum, totalValue);

		driver.pressKey(new KeyEvent(AndroidKey.HOME));
		driver.quit();

	}

	public static double getAmount(String value) {
		value = value.substring(1);
		double amountValue = Double.parseDouble(value);
		return amountValue;
	}

}
