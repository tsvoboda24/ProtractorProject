import org.openqa.selenium.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class PagesProtractor {
    private static final String PROTRACTOR_URL = "http://www.way2automation.com/protractor-angularjs-practice-website.html";
    public static WebElement element = null;
    public static WebDriver driver = null;

    //Creates WebDriver at given URL
    public static void WebDriver() {
        setChromeDriverProperty();
        driver = new ChromeDriver();
        driver.get(PROTRACTOR_URL);
        driver.manage().window().maximize();
        JavascriptExecutor jse6 = (JavascriptExecutor) driver;
        jse6.executeScript("window.scrollBy(0,250)", "");

    }

    //Creates an Implicit wait for element to be on page
    public static void waitForElement10sec(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    //Closes first tab and ensures your on the second tab that was opened
    public static void correctTab(WebDriver driver) {
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(0));
        driver.close();
        driver.switchTo().window(tabs2.get(1));
    }

    public static WebElement errorLoginMessageBox(WebDriver driver) {
        element = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[2]"));
        return element;
    }

    public static WebElement logOutButton(WebDriver driver) {
        element = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/p[2]/a"));
        return element;
    }


    public static WebElement registrationBox(WebDriver driver) {
        element = driver.findElement(By.linkText("Registration"));
        return element;
    }

    public static WebElement webTablesBox(WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[2]/div[2]/div/ul/li[7]/a/figure/img"));
        return element;
    }

    public static WebElement userNameField(WebDriver driver) {
        //element = driver.findElement(By.xpath("//*[@id='username']"));
        element = driver.findElement(By.id("username"));
        return element;
    }

    public static WebElement passwordField(WebDriver driver) {
        element = driver.findElement(By.id("password"));
        return element;
    }

    public static WebElement userNameDescriptionField(WebDriver driver) {
        element = driver.findElement(By.name("formly_1_input_username_0"));
        return element;
    }

    public static WebElement loginButton(WebDriver driver) {
        element = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/form/div[3]/button"));
        return element;
    }

    public static WebElement confirmRemoveOKButton(WebDriver driver) {
        element = driver.findElement(By.xpath("/html/body/div[3]/div[3]/button[2]"));
        return element;
    }

    //Finds username on page and return the row location of username, or zero if user is not found
    public static Integer findUserName(WebDriver driver, String username) {
        //finds number of rows in table
        int notFound = 0;
        WebElement table = driver.findElement(By.xpath("/html/body/table/tbody"));
        List<WebElement> rows_table = table.findElements(By.tagName("tr"));
        int row_count = rows_table.size();
        //returns place that user is within the table or returns 0
        for (int j = 1; j <= row_count; j++) {
            String checkUser = driver.findElement(By.xpath("/html/body/table/tbody/tr[" + j + "]/td[3]")).getText();
            if (checkUser.equals(username)) {
                return j; }
            }
        return notFound;
    }
    //Calls finduser to determine what user to remove, and then removes user
    public static WebElement removeUserButton(WebDriver driver, String user){
        if (findUserName(driver,user) != 0){
            int row = findUserName(driver, user);
            int removeColumn = 11;
           element = driver.findElement(By.xpath("/html/body/table/tbody/tr[" + row + "]/td[" + removeColumn + "]/button/i"));
        }
        return element;
    }

    //find chrome webdriver locally
    private static void setChromeDriverProperty(){
        System.setProperty("webdriver.chrome.driver", "/Users/theresasvoboda/Documents/selenium/chromedriver");
    }

}
