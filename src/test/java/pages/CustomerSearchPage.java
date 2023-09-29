package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;


public class CustomerSearchPage {
    WebDriver driver;

    public CustomerSearchPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="SearchEmail")
    WebElement search_Email;

    @FindBy(id="search-customers")
    WebElement searchBtn;

    @FindBy(xpath="//div[@class='dataTables_scrollHeadInner']//table[@class='table table-bordered table-hover table-striped dataTable no-footer']")
    WebElement search_table;

     @FindBy(xpath="//table[@id='customers-grid']/tbody/tr")
     List<WebElement> tableRows;

   /* @FindBy(xpath="//table[@id='customers-grid']/tbody/tr[1]/td")
    List<WebElement> tableColumn;*/

    @FindBy(id="SearchFirstName")
    WebElement fstName;

    @FindBy(id="SearchLastName")
    WebElement ltName;

    public void enterEmailAdd(String email)
    {
        search_Email.sendKeys(email);
    }

    //action method to perform click action on search button
    public void clickOnSearchButton()
    {
        searchBtn.click();

    }
    public boolean searchCustomerByEmail(String email){
        boolean found=false;
        //total no. of rows
        int totalRows=tableRows.size();

        //total no. of columns

       // int totalColumn=tableColumn.size();

        for(int i=1;i<=totalRows;i++){//to iterate all the rows of the table
            WebElement webElementEmail=driver.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr[" + i + "]/td[2]"));
         String actualEmailAddress=webElementEmail.getText();
         if(actualEmailAddress.equals(email)){
             found=true;
         }
        }
        return found;
    }

    public void SearchByFirstName(String fstname){
        fstName.sendKeys(fstname);
    }

    public void SearchByLastName(String lastname){
        ltName.sendKeys(lastname);
    }
    public boolean searchCustomerByName(String name){
        boolean found=false;
        //total no. of rows
        int totalRows=tableRows.size();

        //total no. of columns

        // int totalColumn=tableColumn.size();

        for(int i=1;i<=totalRows;i++){//to iterate all the rows of the table
            WebElement webElementName=driver.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr[" + i + "]/td[3]"));
            String actualName=webElementName.getText();
            if(actualName.equals(name)){
                found=true;
                break;
            }
        }
        return found;
    }
}
