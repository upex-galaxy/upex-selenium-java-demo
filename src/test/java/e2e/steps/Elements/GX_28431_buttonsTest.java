package e2e.steps.Elements;

import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.WebElement;
import e2e.fixtures.TestBase;

@RunWith(JUnit4.class)
public class GX_28431_buttonsTest extends TestBase {

    @BeforeEach
    public void precondition() {
        web.get(BASE_URL + "buttons");
    }

    @DisplayName("28432 | TC01: Validate button 'Double Click Me'")
    @Test
    public void TC01() throws InterruptedException {
        WebElement doubleClickMeBttn = get.ById("doubleClickBtn");
        Do.dbClick(doubleClickMeBttn);
        String doubleClickMessage = get.ById("doubleClickMessage").getText();
        then.shouldBeEqual(doubleClickMessage, "You have done a double click");
    }
}