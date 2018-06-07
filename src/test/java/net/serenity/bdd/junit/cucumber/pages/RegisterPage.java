package net.serenity.bdd.junit.cucumber.pages;

import net.serenity.bdd.junit.cucumber.model.UserDetails;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage extends GenericPageObject {

    @FindBy(name = "countryOfResidence")
    WebElementFacade country;

    @FindBy(name = "nameDetailsTitle")
    WebElementFacade title;

    @FindBy(name = "nameDetailsGender")
    WebElementFacade gender;

    @FindBy(name = "nameDetailsFirstName")
    WebElementFacade firstName;

    @FindBy(name = "nameDetailsLastName")
    WebElementFacade lastName;

    @FindBy(name = "phoneDetailsPhoneType")
    WebElementFacade phoneType;

    @FindBy(name = "phoneDetailsNumber")
    WebElementFacade phoneNumber;

    @FindBy(name = "streetAddressDetailsAddressType")
    WebElementFacade addrType;

    @FindBy(name = "streetAddressDetailsAddressLineOne")
    WebElementFacade addrline1;

    @FindBy(name = "streetAddressDetailsAddressLineTwo")
    WebElementFacade addrLine2;

    @FindBy(name = "streetAddressDetailsState")
    WebElementFacade state;

    @FindBy(name="streetAddressDetailsSuburb")
    WebElementFacade suburb;

    @FindBy(name = "streetAddressDetailsPostCode")
    WebElementFacade postalCode;

    @FindBy(name = "email")
    WebElementFacade email;

    @FindBy(name = "emailVerification")
    WebElementFacade confirmEmail;

    @FindBy(name = "pin")
    WebElementFacade pin;

    @FindBy(name = "confirmedPin")
    WebElementFacade pinVerify;


    @FindBy(name = "birthDay")
    WebElementFacade birthDay;

    @FindBy(name = "birthMonth")
    WebElementFacade birthMonth;

    @FindBy(name = "birthYear")
    WebElementFacade birthYear;


    @FindBy(name = "securityMotherMaidenName")
    WebElementFacade maidenName;


    @FindBy(css = "input[id='termsAndConditions']+*")
    WebElementFacade termsAndConditions;

    @FindBy(id = "card-name")
    WebElementFacade cardHolderName;

    @FindBy(css = "input[type='tel']")
    WebElementFacade cardNumber;

    @FindBy(id = "expiry-month")
    WebElementFacade expMonth;


    @FindBy(id = "expiry-year")
    WebElementFacade expYear;

    @FindBy(id = "expiry-year")
    WebElementFacade cvv;

    //gw-proxy-securityCode

    @FindBy(css = "#recaptcha-anchor .recaptcha-checkbox-checkmark")
    WebElementFacade captcha;



    public void openHomePage_PO(){
        open();
    }

    public void registerUserDet(UserDetails userDetails){

        waitFor(country);
        country.selectByVisibleText(userDetails.getStrCountry().trim());
        waitFor(title);
        title.selectByVisibleText(userDetails.getStrTitle());
        waitFor(gender);
        gender.selectByVisibleText(userDetails.getStrGender());
        waitFor(firstName);
        firstName.clear();
        firstName.type(userDetails.getStrFirstName());
        waitFor(lastName);
        lastName.clear();
        lastName.type(userDetails.getStrLastName());
    }

    public void registerUserMobile(UserDetails ud) {
        waitFor(phoneType);
        phoneType.selectByVisibleText(ud.getStrPreferredmethod());
        phoneNumber.clear();
        phoneNumber.type(ud.getStrMobilenumber());
    }

    public void registerAddressDet(UserDetails ud) {
        waitFor(addrType);
        addrType.selectByVisibleText(ud.getStrAddresstype());
        addrline1.clear();
        addrline1.type(ud.getStrAddressline());
        addrLine2.clear();
        addrLine2.type(ud.getStrSecondline());
        suburb.clear();
        suburb.type(ud.getSuburb());
        state.selectByVisibleText(ud.getState());
        postalCode.clear();
        postalCode.type(ud.getPostcode());


    }

    public void registerEmail(UserDetails ud) {
        email.clear();
        email.type(ud.getEmail());
        confirmEmail.clear();
        confirmEmail.type(ud.getEmail());
    }

    public void registerSecurity(UserDetails ud) {
        birthDay.selectByVisibleText(ud.getBirthday());
        birthMonth.selectByVisibleText(ud.getMonth());
        birthYear.selectByVisibleText(ud.getYear());
        maidenName.clear();
        maidenName.type(ud.getMaidenname());
    }

    public void registerPin(UserDetails ud) {
        pin.clear();
        pin.type(ud.getPin());
        pinVerify.clear();
        pinVerify.type(ud.getPin());
    }

    public void acceptConditions() {
//        JavascriptExecutor js = (JavascriptExecutor) getDriver();

        //moveTo(By.cssSelector("input[id='termsAndConditions']+*"));
        waitFor(termsAndConditions);
        ;
        //termsAndConditions.click();
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView();arguments[1].click();", getDriver().findElement(By.cssSelector("input[id='termsAndConditions']+*")), getDriver().findElement(By.cssSelector("input[id='termsAndConditions']+*")));

    }

    public void enterCardDetails(UserDetails ud) {
        cardHolderName.clear();
        cardHolderName.type(ud.getCardholdername());
        getDriver().switchTo().frame(getDriver().findElement(By.cssSelector(".gw-proxy-number")));
        cardNumber.type(ud.getCardnumber());
        getDriver().switchTo().defaultContent();
        expMonth.selectByVisibleText(ud.getExpmonth());
        expYear.selectByVisibleText(ud.getExpyear());
        getDriver().switchTo().frame(getDriver().findElement(By.cssSelector(".gw-proxy-securityCode")));
        cardNumber.type(ud.getCvv());
        getDriver().switchTo().defaultContent();
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView();arguments[1].click();", getDriver().findElement(By.cssSelector("#recaptcha-anchor .recaptcha-checkbox-checkmark")), getDriver().findElement(By.cssSelector("#recaptcha-anchor .recaptcha-checkbox-checkmark")));
        captcha.click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
