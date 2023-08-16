package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.Base_PO;
import pageObjects.Get_Demo_PO;

public class Get_A_Demo_Steps extends Base_PO {

    private Get_Demo_PO get_demo_po;

    public Get_A_Demo_Steps(Get_Demo_PO get_demo_po) {
        this.get_demo_po = get_demo_po;
        //we have injected this contact page object inside our contact_us_steps
    }

    @Given("I access the request a demo page")
    public void I_access_the_request_a_demo_page() {
        get_demo_po.NavigateTo_Request_A_Demo_Page();
    }

    @When("I enter a first name {word}")
    public void i_enter_a_first_name(String firstName) {
        get_demo_po.enter_FirstName(firstName);
    }

    @And("I enter a last name {word}")
    public void i_enter_a_last_name(String lastName) {
        get_demo_po.enter_lastName(lastName);
    }

    @And("I enter a email {word}")
    public void i_enter_a_email_address(String email) {
        get_demo_po.enter_Email_Address(email);
    }

    @And("I enter a phone number {word}")
    public void i_enter_a_phone_number(String phone) {
        get_demo_po.enter_Phone(phone);
    }

    @And("I enter a company name {word}")
    public void i_enter_a_company_name(String name) {
        get_demo_po.enter_Company_Name(name);
    }

    @And("I enter how many people need texting")
    public void i_enter_how_many_people_need_texting() {
        get_demo_po.select_Amount_Needing_Texting();
    }

    @And("I enter ats crm in use")
    public void i_enter_ats_crm_in_use() {
        get_demo_po.select_Ats_Crm_inUse();
    }

    @And("I enter how textUs can help org")
    public void I_enter_how_textus_can_help_org() {
        get_demo_po.select_How_TextUs_Can_Help_Org();

    }

    @And("I enter a comment {string}")
    public void i_enter_a_comment(String comment) {
        get_demo_po.enter_Comment(comment);
    }

    @And("I click on get started")
    public void I_click_on_get_started() {
        get_demo_po.clickOn_Get_Started();
    }

    @Then("I should be presented with an error")
    public void I_should_be_presented_with_an_error() {
        get_demo_po.waitFor_Error_Message_andValidate_Text();
    }
}
