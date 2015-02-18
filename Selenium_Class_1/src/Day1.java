import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.remote.*;
//import org.openqa.selenium.chrome.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;



public class Day1 {
	//WebDriver X = new FirefoxDriver();
	WebDriver X = new ChromeDriver();
	
	public void chrome() {
	System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
	}
	
	public Day1() {
		System.out.println("Driver Constructed");
	}
	
	public void afterTest() throws Exception {
		//service.stop();
		
		X.quit();
		System.out.println("Shutting Down Driver.");
	}

	//Login
	public void beforeTest() {
		X.get("http://hrm.seleniumminutes.com/");
		System.out.println("Getting URL.");
		WebElement txtUsername = X.findElement(By.id("txtUsername"));
		WebElement txtPassword = X.findElement(By.id("txtPassword"));
		WebElement btnLogin = X.findElement(By.id("btnLogin"));
		txtUsername.sendKeys("Admin");
		txtPassword.sendKeys("Password");
		btnLogin.click();
		System.out.println("Logged in.");
	}
	
	//Verify footer text is displayed correctly under each image.
	public void Verify_QuickLaunch_1() {
		WebElement element = X.findElement(By.xpath("//td[1]/div[@class='quickLaunge']/a/img/following-sibling::*"));
		String Element_text = element.getText();
		Assert.assertEquals("Assign Leave", Element_text);
		System.out.println(Element_text + " verified.");
	}
	public void Verify_QuickLaunch_2() {
		WebElement element = X.findElement(By.xpath("//td[2]/div[@class='quickLaunge']/a/img/following-sibling::*"));
		String Element_text = element.getText();
		Assert.assertEquals("Leave List", Element_text);
		System.out.println(Element_text + " verified.");	
	}
	public void Verify_QuickLaunch_3() {
		WebElement element = X.findElement(By.xpath("//td[3]/div[@class='quickLaunge']/a/img/following-sibling::*"));
		String Element_text = element.getText();
		Assert.assertEquals("Timesheets", Element_text);
		System.out.println(Element_text + " verified.");
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
		EmpList.click();
		
	}
	
	public void Verify_EvenRows(){
		
		String [] expected = {"odd"};

		//WebElement select = X.findElement(B);
		List<WebElement> all_Odds = X.findElements(By.xpath("//tbody/tr[(position() mod 2)=0]"));
		System.out.println(all_Odds);
		for (int i = 0; i < expected.length; i++) {
			String oddRowValue = all_Odds.get(i).getAttribute("class");
			if (oddRowValue.equals(expected[i])) {
				System.out.println(oddRowValue + "passed.");
			} else {
				System.out.println(oddRowValue + "failed.");
			}
		}
	}
	public void Verify_OddRows(){
		WebElement select = X.findElement(By.xpath("//tbody/tr[(position() mod 2)=1]"));
		List<WebElement> all_Odds = select.findElements(By.className("odd"));
		System.out.println(all_Odds);
		}
		
		
		
		
	

	public static void main(String[] args) throws Exception {

		Day1 run = new Day1();
		run.beforeTest();
		
		/*run.Verify_QuickLaunch_1();
		run.Verify_QuickLaunch_2();
		run.Verify_QuickLaunch_3();
		*/
		run.pim_EmpList();
		run.Verify_EvenRows();
		

		run.afterTest();
		
	}

}

