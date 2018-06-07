package net.serenity.bdd.junit.cucumber.stepDef;


import cucumber.api.java.en.And;
import net.serenity.bdd.junit.cucumber.model.LoginData;
import net.serenity.bdd.junit.cucumber.model.UserDetails;
import net.serenity.bdd.junit.cucumber.steps.LoginTestSteps;
import net.serenity.bdd.junit.cucumber.steps.RegisterTestSteps;
import net.thucydides.core.annotations.Steps;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginTestStepDef extends GenericDeclarationClass {
	
	//Data Models from feature file
	//LoginData ld= new LoginData();
    UserDetails ud = new UserDetails();
	
	@Steps
	//LoginTestSteps LT_steps;
	RegisterTestSteps RT_steps;
	
    @Given("^the application url$")
    public void the_application_url() throws Throwable {
        RT_steps.openHomePage();
    }

    @When("^click on register$")
    public void click_on_register() throws Throwable {
        throw new PendingException();
    }

    @Then("^I should see dashboard$")
    public void i_should_see_dashboard() throws Throwable {
        throw new PendingException();
    }

    @And("^setAllData as country as \"([^\"]*)\" title as \"([^\"]*)\" gender as \"([^\"]*)\" firstname as \"([^\"]*)\" lastName as \"([^\"]*)\" prefMethod as \"([^\"]*)\" mobile number as \"([^\"]*)\"     type as \"([^\"]*)\" addressline as \"([^\"]*)\" second addressline as \"([^\"]*)\" suburb as \"([^\"]*)\" state as \"([^\"]*)\" postcode as \"([^\"]*)\" email as \"([^\"]*)\" confirm email as \"([^\"]*)\" birth day as \"([^\"]*)\" birth month as \"([^\"]*)\" birth year as \"([^\"]*)\" maiden name as \"([^\"]*)\" pin as \"([^\"]*)\" holdername as \"([^\"]*)\" cardnumber as \"([^\"]*)\" expiry date as \"([^\"]*)\" expiry year as \"([^\"]*)\" CVV as \"([^\"]*)\"$")
    public void setalldata_as_country_as_something_title_as_something_gender_as_something_firstname_as_something_lastname_as_something_prefmethod_as_something_mobile_number_as_something_type_as_something_addressline_as_something_second_addressline_as_something_suburb_as_something_state_as_something_postcode_as_something_email_as_something_confirm_email_as_something_birth_day_as_something_birth_month_as_something_birth_year_as_something_maiden_name_as_something_pin_as_something_holdername_as_something_cardnumber_as_something_expiry_date_as_something_expiry_year_as_something_cvv_as_something(String country, String title, String gender, String firstname, String lastname, String preferredmethod, String mobilenumber, String addresstype, String addressline, String secondline, String suburb, String state, String postcode, String email, String confirmemail, String birthday, String month, String year, String maidenname, String pin, String cardholdername, String cardnumber, String expmonth, String expyear, String cvv) throws Throwable {
        ud.setAllData(country, title, gender, firstname, lastname,"perfname", preferredmethod, mobilenumber, addresstype, addressline, secondline, suburb, state, postcode, email, confirmemail, birthday, month, year, maidenname, pin, cardholdername, cardnumber, expmonth, expyear, cvv);
    }

    @And("^register to the appliation with the user country as \"([^\"]*)\" title as \"([^\"]*)\" gender as \"([^\"]*)\" firstname as \"([^\"]*)\" lastName as \"([^\"]*)\"$")
    public void register_to_the_appliation_with_the_user_country_as_something_title_as_something_gender_as_something_firstname_as_something_lastname_as_something(String country, String title, String gender, String firstname, String lastname) throws Throwable {
        //ud.setAll(country,title,gender,firstname,lastname,"perfname");
        RT_steps.registerUser(ud);
    }

    @And("^phone details as \"([^\"]*)\" mobile number as \"([^\"]*)\"$")
    public void phone_details_as_something_mobile_number_as_something(String preferredmethod, String mobilenumber) throws Throwable {
        RT_steps.registerUserMobile(ud);
    }

    @And("^enter address type as \"([^\"]*)\" addressline as \"([^\"]*)\" second addressline as \"([^\"]*)\" suburb as \"([^\"]*)\" state as \"([^\"]*)\" postcode as \"([^\"]*)\"$")
    public void enter_address_type_as_something_addressline_as_something_second_addressline_as_something_suburb_as_something_state_as_something_postcode_as_something(String addresstye, String addressline, String secondline, String suburb, String state, String postcode) throws Throwable {
        RT_steps.registerAddressDet(ud);
    }

    @And("^enter email as \"([^\"]*)\" confirm email as \"([^\"]*)\"$")
    public void enter_email_as_something_confirm_email_as_something(String email, String confirmemail) throws Throwable {
        RT_steps.registerEmail(ud);
    }

    @And("^enter the birth day as \"([^\"]*)\" birth month as \"([^\"]*)\" birth year as \"([^\"]*)\" maiden name as \"([^\"]*)\"$")
    public void enter_the_birth_day_as_something_birth_month_as_something_birth_year_as_something_maiden_name_as_something(String birthday, String month, String year, String maidenname) throws Throwable {
        RT_steps.registerSecurity(ud);
    }

    @And("^enter the pin as \"([^\"]*)\"$")
    public void enter_the_pin_as_something(String pin) throws Throwable {
        RT_steps.registerPin(ud);
    }

    @And("^Accept conditions$")
    public void accept_conditions() throws Throwable {
        RT_steps.acceptConditions();
    }

    @And("^enter card holdername as \"([^\"]*)\" cardnumber as \"([^\"]*)\" expiry date as \"([^\"]*)\" expiry year as \"([^\"]*)\" CVV as \"([^\"]*)\"$")
    public void enter_card_holdername_as_something_cardnumber_as_something_expiry_date_as_something_expiry_year_as_something_cvv_as_something(String cardholdername, String cardnumber, String expmonth, String expyear, String cvv) throws Throwable {
        RT_steps.enterCardDetails(ud);
    }

    @And("^complete captcha$")
    public void complete_captcha() throws Throwable {
        throw new PendingException();
    }

/*
    @When("^I login to payments console using username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
    public void i_search_for_something(String username, String password) throws Throwable {
    	ld.setAll(username,password);
        LT_steps.performSearch(ld);
    }
*/

	@Before
	public void afterTest(){
		RT_steps.closeBrowser();
	}

}
