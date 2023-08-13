package e2e.fixtures;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;
import e2e.utils.Locator;
import e2e.utils.Assertion;
import e2e.utils.Action;

public class TestBase {
    public static final String BASE_URL = "https://demoqa.com/";
    private static final DriverManager MANAGER = new DriverManager();
    public WebDriver web;
    public Locator get;
    public Assertion then;
    public Action Do;

    @BeforeEach
    public void setup() {
        web = MANAGER.setChromeDriver();
        get = new Locator(web);
        then = new Assertion();
        Do = new Action(web);
        web.get(BASE_URL);
        web.manage().window().maximize();
        web.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterEach
    public void tearDown() {
        try {
            web.quit();
        } catch (Exception log) {
            System.out.println("Error while closing browser: " + log.getMessage());
        }
    }
}
