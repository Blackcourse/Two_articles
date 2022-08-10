import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class Enter {
    private AppiumDriver driver;

    @Before
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "AndroidTestDevice");
        capabilities.setCapability("platformVersion", "8.0");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", ".main.MainActivity");
        capabilities.setCapability("app", "C:\\Users\\kgavr\\OneDrive\\Desktop\\Javaapp\\Javaapp\\apks\\org.wikipedia.apk");

        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void Search() {
        waitForElementAndClick(
                By.id("org.wikipedia:id/search_container"),
                "Cannot find Search Wiki input",
                10
        );

        SendKeys(
                By.xpath("//*[contains (@text,'Search…')]"),
                "Java",
                "Cannot find search input",
                10

        );
        waitForElementAndClick(
               By.xpath("//*[@resource-id ='org.wikipedia:id/page_list_item_title'][@text='Java']"),
               "Cannot find Search Java input",
               10
        );
        waitForElementPresent(
                By.id("org.wikipedia:id/view_page_title_text"),
                "Cant find article title ",
                15
        );
        waitForElementAndClick(
                By.xpath("//android.widget.ImageView[@content-desc='More options']"),
                "Cannot find button to open article",
                15
        );
        waitForElementAndClick(
                By.xpath("//*[@text = 'Add to reading list']"),
                "Cannot find option to add article to reading list",
                10

          );
        waitForElementAndClick(
                By.xpath("//*[@text = 'Add to reading list']"),
                "Cannot find option to add article to reading list",
                10
        );

                waitForElementAndClick(
              By.id("org.wikipedia:id/onboarding_button"),
                "Cant click on Got it button",
               5
                );
        waitForElementAndClick(
                By.xpath("//*[@text='OK']"),
                "Cannot press OK",
                5
        );

        waitForElementAndClick(
                By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
               "Cannot close article, cannot find X",
               5
        );

        waitForElementAndClick(
                By.id("org.wikipedia:id/search_container"),
                "Cannot find Search Wiki input",
                10
        );

        SendKeys(
                By.xpath("//*[contains (@text,'Search…')]"),
                "Kotlin",
                "Cannot find search input",
                10

        );
        waitForElementAndClick(
                By.xpath("//*[@resource-id ='org.wikipedia:id/page_list_item_title'][@text='Kotlin (programming language)']"),
                "Cannot find Search Kotlin input",
                10
        );
        waitForElementPresent(
                By.id("org.wikipedia:id/view_page_title_text"),
                "Cant find article title ",
                15
        );
        waitForElementAndClick(
                By.xpath("//android.widget.ImageView[@content-desc='More options']"),
                "Cannot find button to open article",
                15
        );
        waitForElementAndClick(
                By.xpath("//*[@text = 'Add to reading list']"),
                "Cannot find option to add article to reading list",
                10

        );
        waitForElementAndClick(
                By.xpath("//*[@resource-id ='org.wikipedia:id/item_title'][@text='My reading list']"),
                "Cant click on Got it button",
                10
        );
        waitForElementAndClick(
                By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
                "Cannot close article, cannot find X",
                15
        );
        waitForElementAndClick(
                By.xpath("//android.widget.FrameLayout[@content-desc='My lists']"),
               "Cannot find navigation button",
               15
        );
        waitForElementAndClick(
                By.id("org.wikipedia:id/item_title"),
                "Cant click on Got it button",
                15
        );
        swipeElementToLeft(
                By.xpath("//*[(@text='Java')]"),
                "cannot find saved article"
        );
        waitForElementPresent(
                By.xpath("//*[contains (@text,'Kotlin')]"),
                "Cant find one article  ",
                15
        );
        waitForElementAndClick(
                By.xpath("//*[contains (@text,'Kotlin')]"),
                "Can not click on saved page",
                10
        );


    }

    private WebElement waitForElementPresent(By by, String error_message, long timeoutInseconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInseconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }


    private WebElement SendKeys(By by, String value, String error_message, long timeoutSeconds) {
        WebElement element = waitForElementPresent(by, error_message, timeoutSeconds);
        element.sendKeys(value);
        return element;
    }

    private WebElement waitForElementAndClick(By by, String error_message, long timeoutSeconds) {
        WebElement element = waitForElementPresent(by, error_message, timeoutSeconds);
        element.click();
        return element;
    }

    private boolean waitForelementNot(By by, String error_message, long timeoutInsecond) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInsecond);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(by)
        );
    }

    private WebElement waitAndClear(By by, String error_message, long timeoutInsecond) {
        WebElement element = waitForElementPresent(by, error_message, timeoutInsecond);
        element.clear();
        return element;
    }
    private boolean waitFormenutoRender(By by, String error_message, long timeoutInsecond) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInsecond);
        wait.withMessage(error_message + "\n");
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
        element.click();
        return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(by)
        );
    }
        protected void swipeElementToLeft(By by, String error_message) {
            WebElement element = waitForElementPresent(by,
                    error_message,
                    15);

            int left_x = element.getLocation().getX();
            int right_x = left_x + element.getSize().getWidth();
            int upper_y = element.getLocation().getY();
            int lower_y = upper_y + element.getSize().getHeight();
            int middle_y = (upper_y + lower_y) / 2;


            TouchAction action = new TouchAction(driver);
            action
                    .press(right_x, middle_y)
                    .waitAction(200)
                    .moveTo(left_x, middle_y)
                    .release().perform();

        }
    }


