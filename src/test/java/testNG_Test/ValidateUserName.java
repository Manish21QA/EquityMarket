package testNG_Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basePackage.Base;
import pom_Classes.NeoStox_HomePage;
import pom_Classes.NeoStox_PasswordPage;
import pom_Classes.NeoStox_SingInPage;
import utility_Method.Utility;

public class ValidateUserName extends Base {
	
	NeoStox_SingInPage signIn;
	NeoStox_PasswordPage password;
	NeoStox_HomePage home;
	
	@BeforeMethod
	public void launchBroswer() throws IOException {
		LaunchBrowser();
		signIn=new NeoStox_SingInPage(driver);
		password=new NeoStox_PasswordPage(driver);
		home=new NeoStox_HomePage(driver);
		
	}
	
	@BeforeMethod
	public void loginNeoStox() throws IOException, InterruptedException {
		
		signIn.sendMobileNum(driver, Utility.readDataForProperties("userName"));
		signIn.clickOnSignInButton(driver);
		password.enterPassword(driver, Utility.readDataForProperties("password"));
		password.clickOnSubmitButton(driver);
		Thread.sleep(1000);
		home.handlePopUp(driver);
		
	}
	
	
  @Test
  public void verifyUserName() throws IOException {
	  Assert.assertEquals(home.getActualUserName(driver), Utility.readDataForProperties("utility_Method.Utility.readDataForProperties"));
	  Utility.scrnShot(driver,home.getActualUserName(driver));
  }
  
  @AfterMethod
  public void logOutNeoStox() {
	  home.logOut(driver);
	  
  }
  
  @AfterClass()
  public void closeBroswer() {
	  driver.close();
	  
  }
}
