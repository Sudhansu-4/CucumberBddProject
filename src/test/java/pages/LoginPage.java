package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;


    @FindBy(id="Email")
    WebElement email;

    @FindBy(id="Password")
    WebElement password;

    @FindBy(xpath="//button[@type='submit']")
    WebElement LoginBtn;

    @FindBy(linkText="Logout")
    public
    WebElement logout;
   public LoginPage(WebDriver driver){
       this.driver = driver;
       PageFactory.initElements(driver, this);
   }
    public void enterEmail(String emailAdd) {
       email.clear();
        email.sendKeys(emailAdd);
    }
    public void enterPassword(String pwd) {
       password.clear();
        password.sendKeys(pwd);
    }
    public void clickLogin() {
        LoginBtn.click();
    }
    public void clickLogout() {
        logout.click();
       System.out.println("hello");
    }

}
