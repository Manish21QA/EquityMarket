package utility_Method;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	public static String readDataForProperties(String key) throws IOException {
		//create object of properties class
		Properties property=new Properties();
		
		//create object of FileInputStream and pass porperty file path
		FileInputStream myFile=new FileInputStream("C:\\Users\\Yogesh_Ashtankar\\eclipse-workspace\\EquityMarket\\NeoStox.properties");
		property.load(myFile);
	
		String value = property.getProperty(key);
		
		return value;
	}
	

	public static void scrnShot(WebDriver driver, String TCid) throws IOException {
		
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destination = new File("E:\\SoftwareTesting LecturesData\\selenium_For_Automation\\ScreenShotMethod\\"+TCid+".jpg");
		
		FileHandler.copy(source, destination);
	}

	public static void scorllIntoView(WebDriver driver, WebElement element) {
		JavascriptExecutor js= (JavascriptExecutor)driver ;
		js.executeScript("arguments[0].scrollIntoView()", element );
		
	}
	
	public static void WaitFor(WebDriver driver,int time) {
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(time));
	}


}
