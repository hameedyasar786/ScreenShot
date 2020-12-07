package screenShotSession;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class ScreenShot {
	static WebDriver driver;
	
	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver","C:\\Driver\\chromedriver.exe");
		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50,TimeUnit.SECONDS);
		
		driver.get("http://facebook.com/");
		takeScreenshot("Facebook_LoginPage");
		
	}
	public static void takeScreenshot(String fileName) throws IOException {
		//1. takes screenshot and store it as a file format:
		File file=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		//2. now copy the screenshot to desired location using copyfile method:
		FileUtils.copyFile(file,new File("C:\\Selenium Automation\\TakeScreenShot\\src\\screenShotSession\\"
		+fileName+".jpg"));
		
	}

}
