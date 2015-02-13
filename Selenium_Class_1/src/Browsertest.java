import java.io.*;
import java.util.regex.*;


import org.openqa.selenium.*;
import org.openqa.selenium.remote.*;
import org.openqa.selenium.chrome.*;
//import org.openqa.selenium.support.ui.WebDriverWait;


public class Browsertest {
	
	public static WebDriver X;
	public static ChromeDriverService service;
	
	public Browsertest() {
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
	
	public void run() {
		System.out.println("Loading Cookie Clicker...");
		X.get("http://orteil.dashnet.org/cookieclicker/");{
			try {
				System.out.println("Waiting for Cookie Clicker...");
			    Thread.sleep(10000);      //1000 milliseconds is one second.
			    System.out.println("Loading..");
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
		}
	}
	
	public void start(){
		//Locate cookie
		WebElement bigCookie = X.findElement(By.id("bigCookie"));
		//Located.
			System.out.println("initialializing infinity click");
			
				while (true) {
			
						bigCookie.click(); 
			
					try {
				
						//X.findElement(By.id("goldenCookie")).click();
						
						WebElement stats = X.findElement(By.id("cookies"));
								//System.out.println("cookie id detected");
							
								long balance = 0;
								String s = stats.getText().replace(",","");
								Pattern p = Pattern.compile("^(\\d+_");
								Matcher m = p.matcher(s);
								System.out.println("working");
								if (m.find()) {
								balance = Long.valueOf(m.group(1));
								System.out.println("Cookies: " + balance);
								}
							}
						
					 catch  (Exception e) {
						//System.out.println("failed to run.");
					}
				}
				
	}
	
	



/*public void long running(String x) {
	
			WebElement cookies = X.findElement(By.id("cookies"));		
			String s = cookies.getText().replace(",","");
			Pattern p = Pattern.compile("^(\\d+_");
			Matcher m = p.matcher(s);
			
			if (m.find()){ 
				return Long.valueOf(m.group(1));
			
			}
		return -1;
	}

*/	
	
	public static void main(String[] args) throws Exception {
			System.out.println("Starting...");
			Browsertest t = new Browsertest();
			t.beforeTest();
			
			t.run();
			t.start();
			//t.running();
			//t.during();		
	}
}
