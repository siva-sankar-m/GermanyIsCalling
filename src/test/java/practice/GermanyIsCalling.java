package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GermanyIsCalling 
{
	WebDriver driver;

	@BeforeClass
	void Preconditions() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://app.germanyiscalling.com/common/login/");
	}
	//Successful Login Testcase
	@Test(priority = 1)
	void Valid_Username_and_Password() throws InterruptedException {
		driver.findElement(By.id("username")).sendKeys("siva29042003@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Myjob@2024");
		driver.findElement(By.tagName("button")).submit();
		driver.findElement(By.id("dropdownUser1")).click();
		driver.findElement(By.xpath("//a[@href='/common/logout/']")).click();
		Thread.sleep(1000);
	}
	@Test(priority = 2)
	void Valid_Username_and_Password_with_Case_Sensitivity() throws InterruptedException {
		driver.findElement(By.id("username")).sendKeys("SIVA29042003@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Myjob@2024");
		driver.findElement(By.tagName("button")).submit();
		driver.findElement(By.id("dropdownUser1")).click();
		driver.findElement(By.xpath("//a[@href='/common/logout/']")).click();
		Thread.sleep(3000);
	}

	//UnSuccessful Login Testcase
	@Test(priority = 3)
	void Invalid_Username() throws InterruptedException {
		driver.findElement(By.id("username")).sendKeys("siva");
		driver.findElement(By.id("password")).sendKeys("Myjob@2024");
		driver.findElement(By.tagName("button")).click();
		Thread.sleep(1000);

		driver.findElement(By.id("username")).sendKeys("12335464568");
		driver.findElement(By.id("password")).sendKeys("Myjob@2024");
		driver.findElement(By.tagName("button")).click();
		Thread.sleep(1000);

		driver.findElement(By.id("username")).sendKeys("!@#$%^^&*><>");
		driver.findElement(By.id("password")).sendKeys("Myjob@2024");
		driver.findElement(By.tagName("button")).click();
		Thread.sleep(1000);

		driver.findElement(By.id("username")).sendKeys("siva1234");
		driver.findElement(By.id("password")).sendKeys("Myjob@2024");
		driver.findElement(By.tagName("button")).click();
		Thread.sleep(1000);

		driver.findElement(By.id("username")).sendKeys("siva!@#$%");
		driver.findElement(By.id("password")).sendKeys("Myjob@2024");
		driver.findElement(By.tagName("button")).click();
		Thread.sleep(1000);
	}

	@Test(priority = 4)
	void Invalid_Password() throws InterruptedException {
		
		driver.findElement(By.id("username")).sendKeys("sivasankar");
		driver.findElement(By.id("password")).sendKeys("10092024");
		driver.findElement(By.tagName("button")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.id("username")).sendKeys("sivasankar");
		driver.findElement(By.id("password")).sendKeys("Myjobistesting");
		driver.findElement(By.tagName("button")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.id("username")).sendKeys("sivasankar");
		driver.findElement(By.id("password")).sendKeys("@!@#$%^%2024");
		driver.findElement(By.tagName("button")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.id("username")).sendKeys("sivasankar");
		driver.findElement(By.id("password")).sendKeys("Myjob@---2024");
		driver.findElement(By.tagName("button")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.id("username")).sendKeys("sivasankar");
		driver.findElement(By.id("password")).sendKeys("Myjob2024");
		driver.findElement(By.tagName("button")).click();
		Thread.sleep(1000);

	}
	@Test(priority = 5)
	void Both_Username_and_Password_Invalid() throws InterruptedException {
		driver.findElement(By.id("username")).sendKeys("!@#$%^^&*><>");
		driver.findElement(By.id("password")).sendKeys("@!@#$%^%2024");
		driver.findElement(By.tagName("button")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.id("username")).sendKeys("siva1234");
		driver.findElement(By.id("password")).sendKeys("Myjob2024");
		driver.findElement(By.tagName("button")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.id("username")).sendKeys("12335464568");
		driver.findElement(By.id("password")).sendKeys("2024");
		driver.findElement(By.tagName("button")).click();
		Thread.sleep(1000);
		
		
		
	}
	@Test(priority = 6)
	void Username_or_Password_Empty() throws InterruptedException {
		driver.findElement(By.id("username")).sendKeys("");
		driver.findElement(By.id("password")).sendKeys("");
		driver.findElement(By.tagName("button")).click();
		Thread.sleep(1000);
	}
	@Test(priority = 7)
	void Username_and_Password_Too_Short() throws InterruptedException {
		driver.findElement(By.id("username")).sendKeys("abc");
		driver.findElement(By.id("password")).sendKeys("My");
		driver.findElement(By.tagName("button")).click();
		Thread.sleep(1000);
	}

}
