package tests;

import base.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.JsonDataReader;

public class LoginTest extends BaseTest {

	@DataProvider(name = "loginData")
	public Object[][] getData() throws Exception {
		System.out.println("In getData");
		JsonDataReader.LoginData[] data = JsonDataReader.getLoginData();
		System.out.println("222");
		Object[][] testData = new Object[data.length][2];

		for (int i = 0; i < data.length; i++) {
			testData[i][0] = data[i].username;
			testData[i][1] = data[i].password;
		}

		return testData;
	}

	@Test(dataProvider = "loginData")
	public void loginTest(String username, String password) throws InterruptedException {
		System.out.println(" In loginTest");
		driver.get("https://www.saucedemo.com/");
		Thread.sleep(1000);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(username, password);

		System.out.println("Login attempted with: " + username);
	}
}