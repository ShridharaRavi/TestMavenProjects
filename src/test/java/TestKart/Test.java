package TestKart;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class Test {
	
	
	@org.testng.annotations.Test
	public void m1() throws InterruptedException
	{

		System.setProperty("webdriver.chrome.driver", "E:\\chrome driver\\chromedriver83\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver,5);
		//System.out.println(elements.size());
		String[] itemsNeeded = {"Brocolli","Cauliflower","Carrot"};
		addItems(driver,itemsNeeded);
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='promoCode']")));
		driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[@class='promoBtn']")).click();
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='promoInfo']")));
		System.out.println(driver.findElement(By.xpath("//span[@class='promoInfo']")).getText());
		Thread.sleep(2000l);
		driver.close();
		
	}
	public static  void addItems(WebDriver driver,String[] itemsNeeded )
	{   
		java.util.List<WebElement> elements= driver.findElements(By.xpath("//h4[@class='product-name']"));
		 int k=0;
			for(int i=0;i<elements.size();i++)
			{
				//System.out.println(elements.get(i).getText());
				
				String items= elements.get(i).getText();
				String[] itemsformatted = items.split("-");
				String formatedname = itemsformatted[0].trim();
				//System.out.println(itemsformatted[0]);
				java.util.List<String> itemsneeded = Arrays.asList(itemsNeeded);
				if(itemsneeded.contains(formatedname))
				{    k++;
					driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
					
					if(k==itemsNeeded.length)
					{
							break; 
					}
				}
				
				
			}
		
	}

}
