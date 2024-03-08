package e2e.steps.Elements;

import static io.qameta.allure.SeverityLevel.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import e2e.fixtures.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.Story;

@Epic("Elements Component")
@Feature("Buttons")
@Story("GX3-2525 DemoQA | Buttons ")
public class GX3_2525_Buttons extends TestBase {

	@BeforeEach
	public void precondition() {
		web.get("https://demoqa.com/buttons");
	}

	@Test
	@Severity(NORMAL)
	@Issue("https://upexgalaxy38.atlassian.net/browse/GX3-2525")
	@Description("Este caso de prueba va a validar que el usuario pueda hacer doble clic en el botón 'Double Click Me' y debe aparecer el mensaje de 'You have done a double click' ")
	@DisplayName("2526 | TC01:Validar el funcionamiento del botón 'double click button'")
	public void TC01_DoubleClick(TestInfo testInfo) throws InterruptedException, IOException {

		WebElement buttonDatos = web.findElement(By.cssSelector(".fc-button.fc-cta-consent.fc-primary-button"));
		buttonDatos.click();

		WebElement button = web.findElement(By.id("doubleClickBtn"));
		new Actions(web).doubleClick(button).perform();

		Thread.sleep(1000);

		WebElement messageElement = web.findElement(By.id("doubleClickMessage"));
		String message = messageElement.getText();

		assertEquals("You have done a double click", message);
	}

	@Test
	@Severity(NORMAL)
	@Issue("https://upexgalaxy38.atlassian.net/browse/GX3-2525")
	@Description("Este caso de prueba va a validar que el usuario pueda hacer click derecho en el botón de 'Right Click'")
	@DisplayName("2526 | TC02: Validar el funcionamiento del botón 'Right Click'")
	public void TC02_RightClick(TestInfo testInfo) throws InterruptedException, IOException {

		Thread.sleep(222);

		WebElement buttonDatos = web.findElement(By.cssSelector(".fc-button.fc-cta-consent.fc-primary-button"));
		new Actions(web).click(buttonDatos).perform();

		WebElement button = get.ById("rightClickBtn");
		new Actions(web).contextClick(button).perform();

		Thread.sleep(20);

		WebElement messageElement = web.findElement(By.id("rightClickMessage"));
		String message = messageElement.getText();

		assertEquals("You have done a right click", message);
	}

	@Test
	@Severity(NORMAL)
	@Issue("https://upexgalaxy38.atlassian.net/browse/GX3-2525")
	@Description("Este caso de prueba va a validar que el usuario pueda hacer clic en el botón 'Click Me' y aparezca el mensaje 'You have done a dynamic click'")
	@DisplayName("2526 | TC03: Validar el funcionamiento del botón 'Click'")
	public void TC03_Click(TestInfo testInfo) throws InterruptedException, IOException {
		Thread.sleep(222);

		WebElement buttonDatos = web.findElement(By.cssSelector(".fc-button.fc-cta-consent.fc-primary-button"));
		buttonDatos.click();

		List<WebElement> buttons = web.findElements(By.cssSelector("button.btn.btn-primary"));
		WebElement button = buttons.get(2);
		button.click();

		Thread.sleep(1000);

		WebElement messageElement = web.findElement(By.id("dynamicClickMessage"));
		String message = messageElement.getText();

		assertEquals("You have done a dynamic click", message);
	}

	@AfterEach
	public void tearDown() {
		if (web != null) {
			web.quit();
		}
	}
}
