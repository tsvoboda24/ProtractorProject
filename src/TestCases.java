import java.util.ArrayList;

public abstract class TestCases extends PagesProtractor {

    public static void main(String[] args) throws InterruptedException{
        System.out.println(TestCaseBundle());
    }

    public static ArrayList<String> TestCaseBundle() {
        ArrayList<String> results = new ArrayList<String>();

        /* Test Case #1
        This starts new web driver and selects registration page, provides accurate information
        and confirms login is successful or throws an error message if it doesn't */
        String testCaseResults1 = "";
        WebDriver();
        waitForElement10sec(driver);
        PagesProtractor.registrationBox(driver).click();
        correctTab(driver);
        waitForElement10sec(driver);
        userNameField(driver).sendKeys("angular");
        passwordField(driver).sendKeys("password");
        userNameDescriptionField(driver).sendKeys("test");
        loginButton(driver).click();
        waitForElement10sec(driver);
        logOutButton(driver);
        if(driver.getPageSource().contains("You're logged in!!")){
            results.add("Test Case 1 was successful");
            //System.out.println("Test Case 1 was successful");
        }
        else{
            results.add( "Test case 1 has failed");
            //System.out.println("Test case 1 has failed");
        }
        driver.close();


        /* Test Case #2
        This starts new web driver and selects registration page, provides incorrect login information
        and confirms login fails or throws an error message if it doesn't show the correct message */
        WebDriver();
        waitForElement10sec(driver);
        registrationBox(driver).click();
        correctTab(driver);
        waitForElement10sec(driver);
        userNameField(driver).sendKeys("angular");
        passwordField(driver).sendKeys("password1");
        userNameDescriptionField(driver).sendKeys("test");
        loginButton(driver).click();
        waitForElement10sec(driver);
        errorLoginMessageBox(driver);
        if(driver.getPageSource().contains("Username or password is incorrect")){
            results.add("Test Case 2 was successful");
        }
        else{
            results.add("Test case 2 has failed");
        }
        driver.close();

        /* Test Case #2
        This starts new web driver and selects Webtables page, selects the remove button for admin user,
        confirms remove, checks that the user was removed */
        WebDriver();
        waitForElement10sec(driver);
        webTablesBox(driver).click();
        correctTab(driver);
        waitForElement10sec(driver);
        findUserName(driver, "admin");
        removeUserButton(driver, "admin").click();
        waitForElement10sec(driver);
        confirmRemoveOKButton(driver).click();
        if(findUserName(driver, "admin") == 0){
            //testCase3Results = "Test case #3 was successful";
            results.add("Test case 3 was successful");
        }
        else {
           // testCase3Results = "Test case #3 has failed";
            results.add("Test case 3 has failed");
        }
        driver.close();
    return results;
    }

}
