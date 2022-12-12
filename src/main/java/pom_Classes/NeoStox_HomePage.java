package pom_Classes;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class NeoStox_HomePage {
	
		@FindBy(xpath = "(//a[text()='OK'])[2]") private WebElement okButton;
		@FindBy(xpath = "(//a[text()='Close'])[5]") private WebElement closeButton;
		@FindBy(id="lbl_username") private WebElement userName;
		@FindBy(id = "lbl_curbalancetop") private WebElement acBalance;
		@FindBy(xpath = "//span[text()='Logout']") private WebElement logOutButton;
		
		//(//a[@class='neobutton'])[25]
				
		public NeoStox_HomePage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		public void handlePopUp(WebDriver driver) throws InterruptedException
		{
			if(okButton.isDisplayed())
			{
				driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
				okButton.click();
				Reporter.log("Handeling popup",true);
				Reporter.log("clicking on OK button of Popup", true);
				driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
				closeButton.click();
				Reporter.log("clicking on Close button of Popup", true);
			}
			else
			{
				Reporter.log("there is no Popup", true);
				driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
			}
		}
		public String getActualUserName(WebDriver driver)
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
			String actualUserName = userName.getText();
			Reporter.log("getting actual user name",true);
			String realUserName = actualUserName.substring(3);
			Reporter.log("Actual user name is "+realUserName, true);
			return actualUserName;
		}
		public String getAccBalance(WebDriver driver)
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
			String accBalance = acBalance.getText();
			Reporter.log("getting accBalance ", true);
			Reporter.log("Account Balance is "+accBalance,true);
			return accBalance;
		}
		public void logOut(WebDriver driver)
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
			userName.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
			logOutButton.click();
			Reporter.log("Logging out", true);
			
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		}

	}
