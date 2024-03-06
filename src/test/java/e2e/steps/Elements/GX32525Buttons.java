package e2e.steps.Elements;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import io.qameta.allure.*;
import static io.qameta.allure.SeverityLevel.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import e2e.fixtures.TestBase;

//* Tech Debt: GX3-253 = https://upexgalaxy26.atlassian.net/browse/GX3-253
@Epic("Elements Component")
@Feature("Buttons")
@Story("GX3-2525 DemoQA | Buttons ")
public class GX32525Buttons extends TestBase {

	@BeforeEach
	public void precondition() {
		web.get("https://demoqa.com/buttons");
	}

	@Test
	@Severity(NORMAL)
	@Issue("https://upexgalaxy38.atlassian.net/browse/GX3-2525")
	@Description("Este caso de prueba va a validar que el usuario pueda hace doble click")
	@DisplayName("2526 | TC01:Validar el funcionamiento del double click button")
	public void TC01_DoubleClick(TestInfo testInfo) throws InterruptedException, IOException {

		WebElement button = get.ById("doubleClickBtn");
		new Actions(web).doubleClick(button).perform();
		WebElement msjDbButton = get.ById("doubleClickMessage");

		String msj = msjDbButton.getText();
		assertEquals("You have done a double click", msj);
	}

	@AfterEach
	public void tearDown() {
		if (web != null) {
			web.quit();
		}
	}
}
