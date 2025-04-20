import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class myTest {

	WebDriver driver = new EdgeDriver();

	String THEWEBSITE = "https://www.saucedemo.com/";

	String UserName = "standard_user";
	String Password = "secret_sauce";

	@BeforeTest
	public void mySetup() {

		driver.manage().window().maximize();
		driver.get(THEWEBSITE);

	}

	@Test(priority = 1)
	public void login() throws InterruptedException {

		WebElement UserNameInput = driver.findElement(By.id("user-name"));

		WebElement PasswordInput = driver.findElement(By.id("password"));

		WebElement LoginButton = driver.findElement(By.id("login-button"));

		UserNameInput.sendKeys(UserName);
		PasswordInput.sendKeys(Password);
		LoginButton.click();

	}
	
	@Test(priority = 2)
	//نضيف عدة عناصر
	public void AddAllItems() throws InterruptedException {
		
		
		List<WebElement> AddToCartButtons = driver.findElements(By.className("btn"));
		
		for(int i = 0;i<AddToCartButtons.size();i++) {
			
			AddToCartButtons.get(i).click();
			
			
		}
		Thread.sleep(2000);


		}

	@Test(priority = 3)
	//نحذف عدة عناصر
	public void RemoveAllItems() throws InterruptedException {

		List<WebElement> RemoveToCartButtons = driver.findElements(By.className("btn_secondary"));

		for (int i = 0; i < RemoveToCartButtons.size(); i++) {

			RemoveToCartButtons.get(i).click();

		}

	}

	@Test(priority = 4 , enabled = false)
	// نطبع اول حرف من كل عنوان للعنصر
	public void Task1() {

		List<WebElement> FirstLetter = driver.findElements(By.className("inventory_item_name"));

		for (int j = 0; j < FirstLetter.size(); j++) {

			String itemName = FirstLetter.get(j).getText();
			System.out.println(itemName.charAt(0));

		}

	}

	@Test(priority = 5 , enabled = false)
	public void IfStartWith() {
	// نطبع اي عنصر ما ببلش بحرف S
		List<WebElement> ItemsNames = driver.findElements(By.className("inventory_item_name"));

		for (int i = 0; i < ItemsNames.size(); i++) {

			String itemName = ItemsNames.get(i).getText();

			if (itemName.startsWith("S")) {
				continue;
			} else {
				System.out.println(itemName);
			}

		}

	}

	@Test(priority = 6 , enabled = false)
	public void LeftElements() {
	// نطبع العناصر يلي عشمال فقط عن طريق odd & even
		List<WebElement> ItemsNames = driver.findElements(By.className("inventory_item_name"));

		for (int i = 0; i < ItemsNames.size(); i = i+2) {

			
			System.out.println(ItemsNames.get(i).getText());

		}

	}
	
	
	@Test(priority = 7,enabled = false)
	public void Stop() {
	// يوقف بس يوصل عنصر معين
		List<WebElement> ItemsNames = driver.findElements(By.className("inventory_item_name"));

		for (int i = 0; i < ItemsNames.size(); i++) {

			if (ItemsNames.get(i).getText().equals("Sauce Labs Fleece Jacket")) {
				break;
			}
			else {
				
				System.out.println(ItemsNames.get(i).getText());
			}

		}

	}
	
	
	
	@Test(priority = 8 , enabled = false)
	// print all the items names except for the items that have the letter 't' at the end
	public void Task2() {
		List<WebElement> ItemsNames = driver.findElements(By.className("inventory_item_name"));

		for (int i = 0; i < ItemsNames.size(); i++) {

			String itemName = ItemsNames.get(i).getText();

			if (itemName.endsWith("t")) {
				continue;
			} else {
				System.out.println(itemName);
			}

		}

	}
	
	@Test(priority = 9)
	// print all the items names except for the items that have in description number '3'
	public void Task2Part2() {
		List<WebElement> ItemsNames = driver.findElements(By.className("inventory_item_name"));
		List<WebElement> ItemsDesc = driver.findElements(By.className("inventory_item_desc"));

		for (int i = 0; i < ItemsDesc.size(); i++) {

			String itemDesc = ItemsDesc.get(i).getText();
			String itemName = ItemsNames.get(i).getText();
			if (itemDesc.contains("3")) {
				continue;
			} else {
				System.out.println(itemName);
			}

		}

	}
	
	
	

		
	@Test(priority = 9, enabled = false)
	public void logout() throws InterruptedException {

		WebElement BurgerMenu = driver.findElement(By.id("react-burger-menu-btn"));

		WebElement LogOutButton = driver.findElement(By.id("logout_sidebar_link"));

		BurgerMenu.click();
		Thread.sleep(2000);
		LogOutButton.click();

		WebElement MainLogo = driver.findElement(By.className("login_logo"));
		System.out.println(MainLogo.getText());

		WebElement UserNames = driver.findElement(By.id("login_credentials"));
		System.out.println(UserNames.getText());

	}

	@AfterTest
	public void myAfterTest() throws InterruptedException {

		Thread.sleep(2000);

		driver.quit();
	}
}
