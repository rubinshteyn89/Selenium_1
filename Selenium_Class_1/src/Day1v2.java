import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.testng.Assert;

public class Day1v2 {
	//Define Driver variable
	WebDriver X = new FirefoxDriver();
	
	public Day1v2() {
		System.out.println("Driver Constructed.");
	}
	//Navigate to HRM main page
	public void Get_HRM() {
		X.get("http://hrm.seleniumminutes.com/");
		System.out.println("Getting URL.");
	}
	//Login
	public void Input_Login() {
		WebElement txtUsername = X.findElement(By.id("txtUsername"));
		WebElement txtPassword = X.findElement(By.id("txtPassword"));
		WebElement btnLogin = X.findElement(By.id("btnLogin"));
		txtUsername.sendKeys("Admin");
		txtPassword.sendKeys("Password");
		btnLogin.click();
		System.out.println("Logged in.");
	}
	
	//Verify footer text is displayed correctly under each image.
	public void Verify_1() {
		WebElement element = X.findElement(By.xpath("//td[1]/div[@class='quickLaunge']/a/img/following-sibling::*"));
		String Element_text = element.getText();
		Assert.assertEquals("Assign Leave", Element_text);
		System.out.println(Element_text + " verified.");
	}
	public void Verify_2() {
		WebElement element = X.findElement(By.xpath("//td[2]/div[@class='quickLaunge']/a/img/following-sibling::*"));
		String Element_text = element.getText();
		Assert.assertEquals("Leave List", Element_text);
		System.out.println(Element_text + " verified.");	
	}
	public void Verify_3() {
		WebElement element = X.findElement(By.xpath("//td[3]/div[@class='quickLaunge']/a/img/following-sibling::*"));
		String Element_text = element.getText();
		Assert.assertEquals("Timesheets", Element_text);
		System.out.println(Element_text + " verified.");
	}
	
	//Shut Down
	public void afterTest(){
		X.quit();
		System.out.println("Shutting Down.");
	}
	
	//Main Class
	public static void main(String[] args) throws Exception {
		
		Day1v2 test = new Day1v2();
		
		test.Get_HRM();
		test.Input_Login();
		test.Verify_1();
		test.Verify_2();
		test.Verify_3();
		test.afterTest();
	}

}
