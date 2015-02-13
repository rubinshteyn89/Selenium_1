import java.io.*;
import java.util.regex.*;


import org.openqa.selenium.*;
import org.openqa.selenium.remote.*;
import org.openqa.selenium.chrome.*;


public class Day1 {
	
	public static WebDriver X;
	public static ChromeDriverService service;
	
	public Day1() {
		System.out.println("Constructed");
	}
	
	public void beforeTest() throws Exception {
		service = new ChromeDriverService.Builder()
			.usingDriverExecutable(new File("/Users/ilya_rubinshteyn/Documents/ChromeDriver/chromedriver"))
			.usingAnyFreePort().build();
		service.start();
		X = new RemoteWebDriver(service.getUrl(),
		        DesiredCapabilities.chrome());
	}
	
	public void afterTest() throws Exception {
		service.stop();
	}
	
	public void run() {
		X.get("http://hrm.seleniumminutes.com/");
		
	}
	
	//1. Verify this locator + verify all 3 icons +
	//assertEquals("odd", driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr[(position() mod 2) =1]")).getAttribute("class"));

	//2. Verify all Odd or Even w/ For Loop
	//assertEquals("Assign Leave", driver.findElement(By.xpath("//table[@class=\"quickLaungeContainer\"]//div[@class=\"quickLaunge\"]/a/img/following-sibling::*")).getText());

	
	public static void main(String[] args) throws Exception {

		Day1 t = new Day1();
		t.beforeTest();
		System.out.println("Driver Start");
		t.run();
		System.out.println("Get HRM");
		//t.afterTest();
		//System.out.println("closing.");
		
	}

}

