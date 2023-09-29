package StepDefination;


import io.cucumber.java.*;
import io.cucumber.java.en.*;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.AddNewCustomerPage;
import pages.CustomerSearchPage;
import pages.LoginPage;
import utility.BrowserDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class StepDef extends BaseClass {

    @Before
    public void setup() {

        log = LogManager.getLogger("StepDef");
        driver = BrowserDriver.FIREFOX(); // Use FIREFOX() method from BrowserDriver class
        log.info("setup method executed...");
        driver.manage().window().maximize();
    }
   /* @Before(order=0)
    public void setup2(){
        driver = BrowserDriver.FIREFOX(); // Use FIREFOX() method from BrowserDriver class
        driver.manage().window().maximize();
        //here we can use more than one before annotation by order or by condition, instead of using if we use
        // tag then it will become conditional hooks
    }*/

    @Given("User Launch FireFox browser")
    public void user_launch_firefox_browser() {

        loginPage = new LoginPage(driver);
        customerPage = new AddNewCustomerPage(driver);
        customerSearch = new CustomerSearchPage(driver);
        log.info("user launch the firefox browser...");
    }

    @When("User open URL {string}")
    public void user_open_url(String url) {
        driver.get(url);
        log.info("user ioprn the url...");
    }

    @When("User enters Email as {string} and password as {string}")
    public void user_enters_email_as_and_password_as(String email, String password) {
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        log.info("email address and password entered...");
    }

    @When("Click on Login")
    public void click_on_login() {
        loginPage.clickLogin();
        BrowserDriver.waitForElementClickable(driver, 5L, loginPage.logout);
        log.info("login button clicked...");
    }

    @Then("Page title should be {string}")
    public void page_title_should_be(String expectedTitle) {
        String actualTitle = driver.getTitle();
        if (actualTitle.equals(expectedTitle)) {
            log.warn("Test passed: Login Feature : Page title matched");
            Assert.assertTrue(true);
        } else Assert.assertTrue(false);
        log.warn("Test failed: Login Feature : Page title not matched");
        // Assert.assertEquals(expectedTitle, actualTitle);
    }

    @When("User click on logout link")
    public void user_click_on_logout_link() throws InterruptedException {

        Thread.sleep(5000);

        loginPage.clickLogout();
        log.info("User clicked on logout linked");
        Thread.sleep(5000);

    }

    @Then("Close browser")
    public void close_browser() {
        log.info("browser closed");
        //driver.close();
        //driver.quit();
    }
    /////////////////////Add New Customers/////////////////////////////////////////


    @Then("User can view Dashboard")
    public void user_can_view_Dashboard() {
        String actualTitle = customerPage.getPageTitle();
        String expectedTitle = "Dashboard / nopCommerce administration";

        if (actualTitle.equals(expectedTitle)) {
            log.info("user can view dashboard test passed.");
            Assert.assertTrue(true);

        } else {
            Assert.assertTrue(false);
            log.warn("user can view dashboard test failed.");

        }
    }

    @When("User click on customers Menu")
    public void user_click_on_customers_Menu() throws InterruptedException {
        Thread.sleep(2000);
        customerPage.clickOnCustomerMenu();
        log.info("clicked on customer menu...");
    }

    @When("click on customers Menu Item")
    public void click_on_customers_Menu_Item() throws InterruptedException {
        Thread.sleep(2000);
        customerPage.clickOnCustomerMenuItem();
        log.info("clicked on customer menu item...");
    }

    @When("click on Add new Button")
    public void click_on_Add_new_Button() throws InterruptedException {
        Thread.sleep(2000);
        customerPage.clickOnAddNewButton();
        log.info("clicked add new button...");
        Thread.sleep(2000);
    }

    @Then("User can view Add new customers page")
    public void user_can_view_Add_new_customers_page() {
        String actualTitle = customerPage.getPageTitle();
        String expectedTitle = "Add a new customer / nopCommerce administration";

        if (actualTitle.equals(expectedTitle)) {
            log.info("User can view Add new customer page- passed");

            Assert.assertTrue(true);//pass
        } else {
            log.info("User can view Add new customer page- failed");

            Assert.assertTrue(false);//fail
        }
    }

    @When("User enter customer info")
    public void user_enter_customer_info() throws InterruptedException {
        Thread.sleep(2000);
        // customerPage.enterEmail("test52@gmail.com");
        customerPage.enterEmail(generateEmailId() + "@gmail.com");
        customerPage.enterPassword("test1");
        Thread.sleep(2000);
        customerPage.enterFirstName("Sudhansu");
        customerPage.enterLastName("Ray");
        Thread.sleep(2000);
        customerPage.enterGender("Male");
        Thread.sleep(2000);
        customerPage.enterDob("6/15/1999");
        Thread.sleep(2000);
        customerPage.enterCompanyName("Evolutyz");
        Thread.sleep(2000);
        customerPage.clickOnTaxExamptCheckBox();
        Thread.sleep(2000);
        // customerPage.enterNewsLetter();
        Thread.sleep(2000);
        // customerPage.enterCustomerRoles("Vendors");
        Thread.sleep(2000);
        customerPage.enterVenderManger("Vendor 2");
        Thread.sleep(2000);
        customerPage.clickOnActiveCheckBox();
        Thread.sleep(2000);
        customerPage.enterAdminComment("Admin comment");
        Thread.sleep(2000);
        log.info("customer information entered...");

    }

    @When("click on Save button")
    public void click_on_Save_button() {
        customerPage.clickOnSaveBtn();
        log.info("clicked on save button...");
    }

    @Then("User can view confirmation message {string}")
    public void user_can_view_confirmation_message(String expectedConfirmationMessage) {
        String bodyTagText = driver.findElement(By.tagName("Body")).getText();
        if (bodyTagText.contains(expectedConfirmationMessage)) {
            Assert.assertTrue(true);//pass
            log.info("User can view confirmation message - passed");

        } else {
            log.warn("User can view confirmation message - failed");

            Assert.assertTrue(false);//fail

        }
    }
    ///////////////////////////////////////Serch Customer By Email///////////////////////////////////////

    @When("Enter customer Email")
    public void enter_customer_Email() throws InterruptedException {
        Thread.sleep(2000);
        customerSearch.enterEmailAdd("victoria_victoria@nopCommerce.com");
        log.info("Entered address entered...");
        Thread.sleep(2000);
    }

    @When("When click on Search Button")
    public void when_click_on_Search_Button() throws InterruptedException {
        Thread.sleep(2000);
        customerSearch.clickOnSearchButton();
        log.info("clicked on search button...");
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
    }

    @Then("User should found in search table")
    public void user_should_found_in_search_table() {
        String expectedEmail = "victoria_victoria@nopCommerce.com";

        //Assert.assertTrue(customerSearch.searchCustomerByEmail(expectedEmail)==true);

        if (customerSearch.searchCustomerByEmail(expectedEmail) == true) {
            Assert.assertTrue(true);
            log.info("user should found Email in the Search table-passed");
        } else {
            log.info("user should found Email in the Search table-passed");
            Assert.assertTrue(false);
        }
    }

    //////////////////////////////Search Customer By Name//////////////////////////

    @When("Enter Customer FirstName")
    public void enter_Customer_FirstName() throws InterruptedException {
        Thread.sleep(1000);
        customerSearch.SearchByFirstName("Victoria");
    }

    @When("Enter Customer LastName")
    public void enter_Customer_LastName() {
        customerSearch.SearchByLastName("Terces");
    }


    @Then("User should found Name in the search table")
    public void user_should_found_Name_in_the_search_table() {
        String expectedName = "Victoria Terces";


        if (customerSearch.searchCustomerByName(expectedName) == true) {
            Assert.assertTrue(true);
        } else
            Assert.assertTrue(false);
    }

    @After
    public void teardown(Scenario sc) {
        if (sc.isFailed() == true) {
            String fileWithPath = "D:\\blogger\\blogapp\\SeleniumCucumberTest\\Screenshot\\test1.png";
            TakesScreenshot scrShot = ((TakesScreenshot) driver);

            File srcFile = scrShot.getScreenshotAs(OutputType.FILE);

            File destFile = new File(fileWithPath);

            try {
                FileUtils.copyFile(srcFile, destFile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        driver.quit();
    }
   /* @After(order=2)
    public void tesardown2(){
        driver.quit();
        //similarly we can use more than one after annotation but here which order is higher should run first.
    }*/
   /* @BeforeStep
    public void beforeStepMethodDemo(){
        System.out.println("This is before step...");
    }
     @AfterStep
     public void afterStepMethodDemo(){
         System.out.println("This is after step...");
       }*/
}

