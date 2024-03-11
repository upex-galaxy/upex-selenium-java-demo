package e2e.steps.Elements;

import static io.qameta.allure.SeverityLevel.*;

import org.junit.AfterClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import e2e.fixtures.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.Story;

@Epic("Elements Component")
@Feature("Text Box")
@Story("GX3-2658 Tools QA | Text Box ")

public class GX3_2658_TextBox extends TestBase {

	@BeforeEach
	public void precondition() {

		web.get("https://demoqa.com/text-box");
	}

	@Test
	@Severity(NORMAL)
	@Issue("https://upexgalaxy38.atlassian.net/browse/GX3-2658")
	@Description("Este caso de prueba va a validar que el usuario pueda rellenar el campo 'Full Name'")
	@DisplayName("2659 | TC01: Validar rellenar el campo 'Full Name' con datos correctos")
	public void TC01_FullName() throws InterruptedException {
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--headless");
		chromeOptions.addArguments("--window-size=1920,1080");

		web = new ChromeDriver(chromeOptions);

		web.get("https://demoqa.com/text-box");

		WebElement campoFullName = web.findElement(By.id("userName"));
		campoFullName.sendKeys("Braian Ezequiel");
	}

	@AfterClass
	public void tearDown() {
		web.quit();
	}
}
