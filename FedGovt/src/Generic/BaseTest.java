package Generic;



	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.ie.InternetExplorerDriver;
	import org.openqa.selenium.remote.DesiredCapabilities;
	import org.testng.ITestResult;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;

import Generic.IAutoconst.IAutoConst;

	public class BaseTest implements IAutoConst {
		public WebDriver driver;
		static
		{
			System.setProperty(CHROME_KEY, CHROME_VALUE);
			System.setProperty(GECKO_KEY, GECKO_VALUE);
			System.setProperty(IE_KEY, IE_VALUE);
		}
		@BeforeMethod
		public void openApplication()
		{
			String appURL=AutoUtil.getProperty(CONFIG_PATH, "appURL");
			String sITO=AutoUtil.getProperty(CONFIG_PATH, "ITO");
			long ITO=Long.parseLong(sITO);
			driver=new ChromeDriver();
			driver.get(appURL);
			driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.SECONDS);
			
		}
		
		@AfterMethod
		public void closeApplication(ITestResult r)
		{
			String testName=r.getName();
			int status=r.getStatus();
			if(status==2)
			{
				AutoUtil.getPhoto(driver, PHOTO_PATH, testName);
			}
			driver.close();
		}
	}


