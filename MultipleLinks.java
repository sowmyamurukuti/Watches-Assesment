package mypackage;

import java.util.List;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

//import com.thoughtworks.selenium.webdriven.commands.KeyEvent;

public class MultipleLinks {
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Desktop\\New Share\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://newtours.demoaut.com/mercurywelcome.php");
		String parent = driver.getWindowHandle();
		List<WebElement> all_Links = driver.findElements(By.tagName("a"));
		for (WebElement link : all_Links) {
			if (link.isDisplayed()) {
				String text = link.getText();
				System.out.println(text);
				// right click
				Actions action = new Actions(driver);
				action.contextClick(link).build().perform();
				// open in new tab
				Robot robo = new Robot();
				Thread.sleep(3000);
				robo.keyPress(KeyEvent.VK_ENTER);
				robo.keyPress(KeyEvent.VK_ENTER);

				// Getting all windows
				Set<String> childwindows = driver.getWindowHandles();
				for (String win : childwindows) {
					if (!parent.contentEquals(win)) {
						driver.switchTo().window(win);
						driver.manage().window().maximize();
						Thread.sleep(3000);
						driver.close();
					}
				}
				

			}
		}
	}
}
