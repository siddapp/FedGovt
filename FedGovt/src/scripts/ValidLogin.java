package scripts;


import org.testng.annotations.Test;

import Generic.BaseTest;
import Generic.Excel;
import page.LoginPage;

public class ValidLogin extends BaseTest{
	@Test
	public void testValidLogin()
	{
		String loginPageTitle=Excel.getData(XL_PATH, "ValidLogin", 1, 0);
		String un=Excel.getData(XL_PATH, "ValidLogin", 1, 1);
		String pw=Excel.getData(XL_PATH, "ValidLogin", 1, 2);
		String homePageTitle=Excel.getData(XL_PATH, "ValidLogin", 1, 3);
		LoginPage l=new LoginPage(driver);
		l.verifyPageIsDisplayed(driver, loginPageTitle);
		l.setUsername(un);
		l.setPassword(pw);
		l.clickLogin();
		l.verifyPageIsDisplayed(driver, homePageTitle);
	}

}

