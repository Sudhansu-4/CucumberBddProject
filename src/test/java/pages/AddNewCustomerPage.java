package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddNewCustomerPage {
      WebDriver driver;

      public AddNewCustomerPage(WebDriver driver){
          this.driver=driver;
          PageFactory.initElements(driver, this);
      }
       @FindBy(xpath="//a[@href='#']//p[contains(text(),'Customers')]")
       WebElement lnkCustomer_menu;

      @FindBy(xpath="//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]")
      WebElement lnkCustomer_MenuItem;

      @FindBy(xpath="//a[@class='btn btn-primary']")
      WebElement btnAddNew;

      @FindBy(xpath="//input[@id='Email']")
      WebElement txtEmail;

      @FindBy(xpath="//input[@id='Password']")
      WebElement txtPassword;

      @FindBy(xpath="//input[@id='FirstName']")
      WebElement firstName;

      @FindBy(xpath="//input[@id='LastName']")
      WebElement lastName;

      @FindBy(id="Gender_Male")
      WebElement MaleGender;

      @FindBy(id="Gender_Female")
      WebElement FemaleGender;

      @FindBy(xpath="//input[@id='DateOfBirth']")
      WebElement txtDob;

      @FindBy(id="Company")
      WebElement CompanyName;

      @FindBy(id="IsTaxExempt")
      WebElement taxExmptChkBox;

      @FindBy(xpath="//*[@id='customer-info']/div[2]/div[9]/div[2]/div/div[1]/div")
      WebElement newsLetterDrpDwn;

      @FindBy(xpath="//*[@id='SelectedCustomerRoleIds']")
      WebElement customerRolesDrpDown;

      @FindBy(xpath="//select[@id='VendorId']")
      WebElement drpDownVendrMgr;

      @FindBy(xpath="//input[@id='Active']")
      WebElement activeCheckBox;

      @FindBy(xpath="//textarea[@id='AdminComment']")
      WebElement adminComment;

      @FindBy(xpath="//button[@name='save']")
      WebElement btnSave;

      public String getPageTitle(){
          return driver.getTitle();
      }

      public void clickOnCustomerMenu(){
          lnkCustomer_menu.click();
      }

      public void clickOnCustomerMenuItem(){
          lnkCustomer_MenuItem.click();
      }

      public void clickOnAddNewButton(){
          btnAddNew.click();
      }

      public void enterEmail(String email){
          txtEmail.sendKeys(email);
      }

      public void enterPassword(String pass){
          txtPassword.sendKeys(pass);
      }

      public void enterFirstName(String name){
          firstName.sendKeys(name);
      }

      public void enterLastName(String lstName){
          lastName.sendKeys(lstName);
      }

      public void enterGender(String gender){
          if(gender.equals("Male")){
              MaleGender.click();
          }else if(gender.equals("Female"))
          {
              FemaleGender.click();
          }
          else//default set Male gender
          {
              MaleGender.click();
          }
      }

      public void enterDob(String dob){
          txtDob.sendKeys(dob);
      }

      public void enterCompanyName(String coname){
          CompanyName.sendKeys(coname);
      }

      public void clickOnTaxExamptCheckBox(){
          taxExmptChkBox.click();
      }

      public void enterNewsLetter(){
          Select drp =new Select(newsLetterDrpDwn);
          //drp.deselectAll();
          drp.selectByIndex(1);
      }
      public void enterCustomerRoles(String val){
          Select dropDown=new Select(customerRolesDrpDown);
          //dropDown.deselectAll();
          dropDown.selectByValue(String.valueOf(1));
          dropDown.selectByValue(String.valueOf(4));
          dropDown.selectByValue(String.valueOf(3));
          dropDown.selectByValue(String.valueOf(5));
      }
      public void enterVenderManger(String value){
          Select drpDn=new Select(drpDownVendrMgr);
          //drpDn.deselectAll();
          drpDn.selectByVisibleText(value);
      }

      public void clickOnActiveCheckBox(){
          activeCheckBox.click();
      }

      public void enterAdminComment(String comment){
          adminComment.sendKeys(comment);
      }

      public void clickOnSaveBtn(){
          btnSave.click();
      }
}
