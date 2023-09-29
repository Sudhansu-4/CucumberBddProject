package StepDefination;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;
import pages.AddNewCustomerPage;
import pages.CustomerSearchPage;
import pages.LoginPage;


public class BaseClass {
   public WebDriver driver;
   public LoginPage loginPage;
   public AddNewCustomerPage customerPage;
   public CustomerSearchPage customerSearch;
   public static Logger log;
   
    public String generateEmailId(){
        return (RandomStringUtils.randomAlphanumeric(5));

    }
}
