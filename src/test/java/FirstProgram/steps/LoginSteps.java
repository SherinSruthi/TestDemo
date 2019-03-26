package FirstProgram.steps;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;








import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps {

	WebDriver driver;

	@Before()
	public void setup() throws IOException {
		System.setProperty("webdriver.chrome.driver",Paths.get(System.getProperty("user.dir")).toRealPath()+ "\\src\\test\\java\\FirstProgram\\resources\\chromedriver.exe");
		this.driver = new ChromeDriver();
		driver.manage().window().maximize();
		this.driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	}
	
	@After()
	public void tearDown() {
		driver.manage().deleteAllCookies();
		driver.close();
		driver.quit();
	}

	@Given("^User navigates to Stackoverflow website$")
	public void user_navigates_to_Stackoverflow_website() throws Throwable {
		driver.get("https://stackoverflow.com/");
	}

	@Given("^User clicks on the login button$")
	public void user_clicks_on_the_login_button() throws Throwable {
		driver.findElement(By.xpath("//a[contains(text(),'Log In')]")).click();
	}

	@Given("^User enters the valid username$")
	public void user_enters_the_valid_username() throws Throwable {
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys("sherinsruthi2@gmail.com");
	}

	@Given("^User enters the valid password$")
	public void user_enters_the_valid_password() throws Throwable {
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("sruthi007");
	}

	@When("^User clicks on login button$")
	public void user_clicks_on_login_button() throws Throwable {
		driver.findElement(By.xpath("//*[@id='submit-button']")).click();
	}

	@Then("^User should be taken to the successful login page$")
	public void user_should_be_taken_to_the_successful_login_page()
			throws Throwable {
		Thread.sleep(3000);
		WebElement askquestion = driver.findElement(By.xpath("//a[contains(text(),'Ask Question')]"));
		Assert.assertEquals(true,askquestion.isDisplayed());
		
	}

}
