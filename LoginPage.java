package mypackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
private WebDriver driver;
public LoginPage( WebDriver driver2) {
	driver=driver2;
	
}
//targets
private By username= By.className("username");
private By password= By.className("password");
private By signinbtn=By.className("login");
//Actions
private void setUsername()
{
	driver.findElement(username).sendKeys("mercury");
}
	private void setPassword()
	{
		driver.findElement(password).sendKeys("mercury");
		
	}
	private void clickOnSignin()
	{
		driver.findElement(signinbtn).click();
	}
	public void login()
	{
		this.setUsername();
		this.setPassword();
		this.clickOnSignin();
		
	}
}

