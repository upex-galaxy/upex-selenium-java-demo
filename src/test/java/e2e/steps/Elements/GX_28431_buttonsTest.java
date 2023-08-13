package e2e.steps.Elements;

import java.util.List;

import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.WebElement;
import e2e.fixtures.TestBase;

@RunWith(JUnit4.class)
public class GX_28431_buttonsTest extends TestBase {

    @BeforeEach
    public void precondition() {
        web.get(BASE_URL + "/buttons");
    }

    @DisplayName("28432 | TC01: Validate button 'Double Click Me'")
    @Test
    public void TC01() throws InterruptedException {
        WebElement doubleClickMeBttn = get.ById("doubleClickBtn");
        Do.dbClick(doubleClickMeBttn);
        String doubleClickMessage = get.ById("doubleClickMessage").getText();
        then.shouldBeEqual(doubleClickMessage, "You have done a double click");
    }

    @DisplayName("28432 | TC02: Validate button 'Right Click Me'")
    @Test
    public void TC02() throws InterruptedException {
        WebElement rightClickMeBttn = get.ById("rightClickBtn");
        Do.rightClick(rightClickMeBttn);
        String rightClickMessage = get.ById("rightClickMessage").getText();
        then.shouldBeEqual(rightClickMessage, "You have done a right click");
    }

    @DisplayName("28432 | TC03: Validate button 'Click Me'")
    @Test
    public void TC03() throws InterruptedException {
        List<WebElement> clickButtons = get.Selectors("[type='button']:not(.navbar-toggler)");
        clickButtons.get(2).click();

        String clickButtonText = get.ById("dynamicClickMessage").getText();
        then.shouldBeEqual(clickButtonText, "You have done a dynamic click");
    }
}