package exercise.uipath;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;




public class Sample {
	
//	@org.testng.annotations.Test
	@Test
//try 
	public static void uipath() throws InterruptedException {


		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe"   );
		ChromeDriver  driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://acme-test.uipath.com/account/login");
		driver.findElementById("email").sendKeys("kumar.testleaf@gmail.com");
		driver.findElementById("password").sendKeys("leaf@12");
		driver.findElementById("buttonLogin").click();
		
		
	WebElement vendor = driver.findElementByXPath("(//button[@class='btn btn-default btn-lg'])[4]");
	Actions move = new Actions(driver);
	move.moveToElement(vendor).perform();
	
	driver.findElementByLinkText("Search for Vendor").click();
	
	driver.findElementById("vendorName").sendKeys("Blue Lagoon");
	driver.findElementById("buttonSearch").click();
	
	WebElement table = driver.findElementByXPath("//table [@class='table']" );
	
	
	
	List<WebElement> allrows = table.findElements(By.tagName("tr"));
	System.out.println(allrows.size());
	

		
		
		WebElement sec_row = allrows.get(1);
		
		
		List<WebElement> name = sec_row.findElements(By.tagName("td"));
		String tn = name.get(4).getText();
		System.out.println(tn);
		
		driver.findElementByLinkText("Log Out").click();
		
		driver.close();
		
		
			
		}
		
	
	
	
	
	
	
	
	
	
		
		

	}



