package Test;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PhaseOneProjAmazon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			
			WebDriver driver = new ChromeDriver();
			
			driver.get("https://www.amazon.de/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
			
			WebElement Searchbar = driver.findElement(By.id("nav-search-bar-form"));
			
			Searchbar.sendKeys("samsung");
			Searchbar.sendKeys("ENTER");
			
			//WebElement SearchButton = driver .findElement(By.id("nav-search-submit-button" ) );
			//SearchButton.click0);
			List<WebElement> ProductsList = driver.findElements(By.xpath("//div[@class-'a-section ']//span[starts-with (text ( ), 'Samsung *)]"));
			List<WebElement> Prices = driver.findElements(By.xpath("//div[@data-component-type-'s-search-result']//span[@class='a-price']"));
			System.out.println("Total Products found " +ProductsList. size());
			for (int i=0;i<ProductsList.size();i++) {
			System.out.println(ProductsList.get(i).getText()+" "+Prices.get(i).getText());
				}
	
			String ParentWH = driver.getWindowHandle();
			String ExpectedVal = ProductsList.get(0).getText();
			
			
			ProductsList.get(0).click();
			
			
			Set<String> AllWindowHandler = driver.getWindowHandles();
			for (String window : AllWindowHandler ) {
			System.out.println(window);
			
			
			if(window.equals(ParentWH)) {
			driver.switchTo().window(window);
			
				}
			}
			
			WebElement ProductTitle = driver.findElement (By.id ("productTitle"));
			String ProductTit = ProductTitle.getText();
			
			if(ProductTit.equals(ExpectedVal)) {
			System.out.println("Title is matching!!");
			}else {
			System.out.println("Title isn't matching!!");
			}
			driver.quit();
	}

			}
