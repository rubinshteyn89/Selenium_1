import static org.junit.Assert.assertEquals;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;



public class Day1 {
	WebDriver X = new FirefoxDriver();
	//WebDriver X = new ChromeDriver();
	
	public void chrome() {
	System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
	}
	
	public Day1() {
		System.out.println("Driver Constructed");
	}
	
	public void afterTest() throws Exception {
		WebElement Welcome = X.findElement(By.id("welcome"));
		String welcomeText = Welcome.getText();
		Welcome.click();
		System.out.println("Clicking " + welcomeText);
		
		WebElement Logout = X.findElement(By.xpath(".//*[@id='welcome-menu']/ul/li[3]/a"));
		Logout.click();
		System.out.println("Logging out.");
		
		X.quit();
		System.out.println("Shutting Down Driver.");
	}

	//Login
	public void beforeTest() {
		X.get("http://hrm.seleniumminutes.com/");
		X.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Getting URL.");
		WebElement txtUsername = X.findElement(By.id("txtUsername"));
		WebElement txtPassword = X.findElement(By.id("txtPassword"));
		WebElement btnLogin = X.findElement(By.id("btnLogin"));
		txtUsername.sendKeys("Admin");
		txtPassword.sendKeys("Password");
		btnLogin.click();
		System.out.println("Logged in.");
	}
	
	public void pim_EmpList() {
		
		Actions action = new Actions(X);
		
		WebElement PIM = X.findElement(By.id("menu_pim_viewPimModule"));
		String pimText = PIM.getText();
		System.out.println("Moving Mouse to " + pimText);
		action.moveToElement(PIM).perform();
		
		WebElement EmpList = X.findElement(By.id("menu_pim_viewEmployeeList"));
		String EmpListText = EmpList.getText();
		System.out.println(EmpListText + " Clicked.");
		action.moveToElement(EmpList).click().perform();
		
	}
	
	public void manageReviews() {
		
		Actions a = new Actions(X);
		
		WebElement Performance = X.findElement(By.id("menu__Performance"));
		String performanceText = Performance.getText();
		System.out.println("Moving Mouse to " + performanceText);
		
		a.moveToElement(Performance).perform();
		WebElement ManagerReviews = X.findElement(By.id("menu_performance_ManageReviews"));
		String mrText = ManagerReviews.getText();
		System.out.println("Moving Mouse to " + mrText);
		a.moveToElement(ManagerReviews).perform();
		WebElement ManagerReviews_sub = X.findElement(By.xpath(".//*[@id='menu_performance_searchPerformancReview']"));
		String mrText_sub = ManagerReviews_sub.getText();
		System.out.println("Clicking " + mrText_sub);
		a.moveToElement(ManagerReviews_sub).click().perform();
		

		
	}
	
	public void Verify_EvenRows(){
	
		List<WebElement> all_Evens = X.findElements(By.xpath("//tbody/tr[(position() mod 2)=0]"));
		for (WebElement row: all_Evens) {
			String row_type = row.getAttribute("class");
			assertEquals("Row style did not match the expected 'even' style.", "even", row_type);
			//System.out.println(row_type + " - verified.");
		}
			
	}

	public void Verify_OddRows(){
		
		List<WebElement> all_Odd = X.findElements(By.xpath("//tbody/tr[(position() mod 2)=1]"));
		for (WebElement row: all_Odd) {
			String row_type = row.getAttribute("class");
			assertEquals("Row style did not match the expected 'odd' style.", "odd", row_type);
			//System.out.println(row_type + " - verified.");
		}
			
	}
	
	
	public void Scrolling_JS(){
		JavascriptExecutor jse = (JavascriptExecutor) X;
		jse.executeScript("document.getElementById('resultTable').scrollIntoView()");
		
	}
	
	public static void main(String[] args) throws Exception {

		Day1 run = new Day1();
		run.beforeTest();
		run.manageReviews();
		run.Scrolling_JS();
		run.pim_EmpList();
		run.Verify_EvenRows();
		run.Verify_OddRows();
		

		run.afterTest();
		
	}

}

