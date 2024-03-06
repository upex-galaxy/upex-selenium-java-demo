package e2e.steps.Elements;

import static org.junit.Assert.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class GX3_2525_Buttons {
	WebDriver driver = new FirefoxDriver();

	@BeforeEach
	public void precondition() {
		String endpoint = "https://demoqa.com/buttons";
		driver.get(endpoint);
	}

	@DisplayName("2526 | TC01:Validar el funcionamiento del double click button")
	@Test
	public void TC01() {
		WebElement button = driver.findElement(By.id("doubleClickBtn"));
		new Actions(driver).doubleClick(button).perform();
		WebElement msjDbButton = driver.findElement(By.id("doubleClickMessage"));

		String msj = msjDbButton.getText();
		assertEquals("You have done a double click", msj);
	}

	@AfterEach
	public void tearDown() {
		driver.quit();
	}
}