package Example;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class NewTest {
	private WebDriver driver;

	@BeforeTest
	public void beforeTest() {
		System.setProperty("phantomjs.binary.path",
				"/home/synerzip/Downloads/phantomjs-2.1.1-linux-x86_64/bin/phantomjs");
		driver = new PhantomJSDriver();
	}

	@Test
	public void loginTest() {
		driver.get("http://test.hrms.synerzip.in/symfony/web/index.php/auth/login");
		driver.findElement(By.id("txtUsername")).sendKeys("dushyant.bhalgami");
		driver.findElement(By.id("txtPassword")).sendKeys("Synerzip");
		driver.findElement(By.xpath("//*[@id='btn-login']")).click();
		String actualText = driver.findElement(By.xpath("//a[@class='panelTrigger']")).getText();
		String expectedText = "Welcome Dushyant";
		AssertJUnit.assertEquals("login is unsuccessful", expectedText, actualText);
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}
