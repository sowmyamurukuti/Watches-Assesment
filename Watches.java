package mypackage;

import java.io.File;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Watches {
	public static void takepicture(WebDriver driver, String filename) throws Exception {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File(".\\Screenshots\\" + filename + ".png"));
	}

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\admin\\Desktop\\New Share\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://amazon.in");
		driver.manage().window().maximize();

		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("watches");
		Thread.sleep(3000);
		String parent = driver.getWindowHandle();

		Actions action = new Actions(driver);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ENTER);

		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[2]/div/span[4]/div[1]/div[4]/div/span/div/div/div/div/div[2]/div/span/a/div/img"))
				.click();
		Thread.sleep(3000);
		driver.close();
		Set<String> childwindows = driver.getWindowHandles();
		for (String win : childwindows) {
			if (!parent.contentEquals(win)) {
				driver.switchTo().window(win);
				
				takepicture(driver, "Watch");
				Thread.sleep(3000);
				driver.close();

			}
		}
		

		driver.switchTo().window(parent);

	}
}
