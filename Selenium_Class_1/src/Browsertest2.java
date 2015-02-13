import java.io.*;
import java.util.regex.*;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.*;
import org.openqa.selenium.chrome.*;
//import org.openqa.selenium.support.ui.WebDriverWait;


public class Browsertest2 {
	
	public static WebDriver X;
	public static ChromeDriverService service;
	
	public Browsertest2() {
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
	
	//public void afterTest() throws Exception {
		//service.stop();
	//}
	
	public void start() {
		System.out.println("Loading Cookie Clicker...");
		X.get("http://orteil.dashnet.org/cookieclicker/");{
			try {
				 System.out.println("Waiting for Cookie Clicker...");
			    Thread.sleep(1000);      //1000 milliseconds is one second.
			    System.out.println("Loaded.");
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
		}
	}
	
	public void run() {
	
		//Locate cookie
		WebElement bigCookie = X.findElement(By.id("bigCookie"));
		//Located.
			System.out.println("Initializing the infinity click...");
			
				while (true) {
			
						bigCookie.click(); 
						//System.out.println("Clicking....");
			
					try {
				
					 	//X.findElement(By.id("goldenCookie")).click();
						
						WebElement cookies = X.findElement(By.id("cookies"));
						
						System.out.println("finding id=cookies");
					
						String s = cookies.getText();
						String c[]=s.split(" ");
						Long x = Long.valueOf(c[0]);
						
						System.out.println(x);
						
					} catch  (Exception e) {
						//System.out.println("failed to run.");
					}
					
				}
			
	}



	public static void main(String[] args) throws Exception {
			System.out.println("Starting...");
			Browsertest2 t = new Browsertest2();
			t.beforeTest();
			t.start();
			t.run();
			//t.running();
			//t.during();		
	}

}