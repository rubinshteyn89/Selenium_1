import static org.junit.Assert.assertEquals;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Day2 {
	
	//WebDriver X = new FirefoxDriver();
	WebDriver X = new ChromeDriver();
	
	public void chrome() {
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
	
	}

	public Day2(){
		System.out.println("Driver Constructed");
		
	}
	//Log out & shut down driver.
	public void afterTest() throws Exception {
		Thread.sleep(2000);
		WebElement logOut = X.findElement(By.xpath("//a[@href='/auth/logout']"));
		String logOutText = logOut.getText();
		logOut.click();
		System.out.println("Clicking " + logOutText);
		
		X.quit();
		System.out.println("Shutting Down Driver.");
	}

	//Login
	public void beforeTest() throws Exception {
		Actions a = new Actions(X);
		X.get("http://www.tie3.mypalmbeachpost.com/news/entertainment/sushi-impresses-at-juno-beachs-china-tokyo/nXspN");
		X.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(5000);
		System.out.println("Getting URL.");
		//X.findElement(By.xpath("//*[@id='cmJanrainAuthLinks']/p[2]/a")).click();
		WebElement signIn = X.findElement(By.xpath("//*[@id='cmJanrainAuthLinks']/p[2]/a"));
		String signInBTN = signIn.getText();
		System.out.println(signInBTN + " found.");
		a.moveToElement(signIn).click().perform();

	}
	
	public void LogIn(){	
		
		WebElement txtUsername = X.findElement(By.id("capture_signIn_traditionalSignIn_emailAddress"));
		WebElement txtPassword = X.findElement(By.id("capture_signIn_traditionalSignIn_password"));
		WebElement btnLogin = X.findElement(By.id("capture_signIn_traditionalSignIn_signInButton"));
		txtUsername.sendKeys("cmgtester1@coxinc.com");
		txtPassword.sendKeys("cmgtest3r");
		btnLogin.click();
		System.out.println("Logged in.");
	}
	
	
	
	
	public static void main(String[] args) throws Exception {
		// run operations ...  DOES NOT WORK W/ FIREFOX...???
		Day2 run = new Day2();
		run.beforeTest();
		run.LogIn();
		run.afterTest();
		

	}

}
