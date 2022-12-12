package pom_Classes;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class NeoStox_PasswordPage {


	@FindBy(id = "txt_accesspin") private WebElement passWordField;
	@FindBy(xpath = "//a[text()='Submit']") private WebElement submitButton;
	public NeoStox_PasswordPage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void enterPassword(WebDriver driver,String pass)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		passWordField.sendKeys(pass);
		Reporter.log("Entering password", true);
	}
	public void clickOnSubmitButton(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		submitButton.click();
		Reporter.log("Clicking on submit Button", true);
	}

}
