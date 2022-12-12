package pom_Classes;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;


public class NeoStox_SingInPage {
	@FindBy(id="MainContent_signinsignup_txt_mobilenumber") private WebElement mobileNumField;
	@FindBy(xpath = "(//a[text()='Sign In'])[2]") private WebElement signInButton;
	
	
	public NeoStox_SingInPage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void sendMobileNum(WebDriver driver,String mobNum)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		mobileNumField.sendKeys(mobNum);
		Reporter.log("Entering mobileNumber",true);
	}
	public void clickOnSignInButton(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		signInButton.click();
		Reporter.log("Clicking on SignIN Button",true);
	}


}
