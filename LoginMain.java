package mypackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginMain {
	
	public static void main(String[]args) {
	   System.setProperty("webdriver.chrome.driver","C:\\Users\\admin\\Desktop\\New Share\\chromedriver.exe");
			 WebDriver driver= new ChromeDriver();
			 driver.get("");
			 
			 LoginPage Login= new LoginPage(driver);
			 Login.login();
			 
	}
}
