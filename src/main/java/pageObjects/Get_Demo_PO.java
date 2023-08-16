package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Global_Vars;

import java.time.Duration;

public class Get_Demo_PO extends Base_PO {
    private @FindBy(xpath = "//li[@class='breadcrumb-item active']")
    WebElement request_A_Demo_Header_Text;
    private @FindBy(xpath = "//input[@name='firstname']")
    WebElement firstName_TextField;
    private @FindBy(xpath = "//input[@name='lastname']")
    WebElement lastName_TextField;
    private @FindBy(xpath = "//input[@name='email']")
    WebElement emailAddress_TextField;
    private @FindBy(xpath = "//input[@name='phone']")
    WebElement phone_TextField;
    private @FindBy(xpath = "//input[@name='company']")
    WebElement company_Name_TextField;
    private @FindBy(xpath = "//select[@name='number_of_texting_lines']")
    WebElement number_ofTexting_Lines_TextField;
    private @FindBy(xpath = "//select[@name='ats_crm']")
    WebElement ats_Crm_TextField;
    private @FindBy(xpath = "//select[@name='how_can_textus_help_your_organization_']")
    WebElement how_Can_TextUs_Help_TextField;
    private @FindBy(xpath = "//textarea[@name='sales_notes']")
    WebElement comment_TextField;
    private @FindBy(xpath = "//input[@type='submit']")
    WebElement get_Started_Button;
    private @FindBy(xpath = "//label[@class='hs-main-font-element']")
    WebElement complete_all_Required_Fields_Message;
    private @FindBy(xpath = "//label[@class='hs-error-msg hs-main-font-element']")
    WebElement email_Must_Be_Correct_Message;
    public Get_Demo_PO() {
        //Using logic inside constructor of Base_PO
        super();
    }

    public void NavigateTo_Request_A_Demo_Page() {
        //this navigateToURL method is housed inside base-page. (the reason we can use this is this page extends into base page)
        navigateTo_URL(Global_Vars.BASE_URL + "/request-a-demo/");
    }

    public void enter_FirstName(String firstName) {
        sendKeys(firstName_TextField, firstName);
    }

    public void enter_lastName(String lastName) {
        sendKeys(lastName_TextField, lastName);
    }

    public void enter_Email_Address(String email) {
        sendKeys(emailAddress_TextField, email);
    }

    public void enter_Phone(String phone) {
        sendKeys(phone_TextField, phone);
    }

    public void enter_Company_Name(String name) {
        sendKeys(company_Name_TextField, name);
    }

    public void enter_Comment(String comment) {
        sendKeys(comment_TextField, comment);
    }


    //Selecting an option by index
    public void select_Amount_Needing_Texting() {
        Select dropdown = new Select(number_ofTexting_Lines_TextField);
        dropdown.selectByIndex(1);
    }

    //Selecting an option by value
    public void select_Ats_Crm_inUse() {
        Select dropdown = new Select(ats_Crm_TextField);
        dropdown.selectByValue("Avionte");
    }

    //Selecting an option by visible text
    public void select_How_TextUs_Can_Help_Org() {
        Select dropdown = new Select(how_Can_TextUs_Help_TextField);
        dropdown.selectByVisibleText("I am looking to get in touch with candidates, prospects, or leads");
    }

    public void clickOn_Get_Started() {
        get_Started_Button.click();
    }

    public void waitFor_Error_Message_andValidate_Text() {
        waitFor(email_Must_Be_Correct_Message);
        String email_Must_Be_correct =email_Must_Be_Correct_Message.getText();
        Assert.assertEquals(email_Must_Be_correct, "Email must be formatted correctly.");

    }
}

