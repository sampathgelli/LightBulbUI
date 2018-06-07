package net.serenity.bdd.junit.cucumber.steps;

import net.serenity.bdd.junit.cucumber.model.UserDetails;
import net.serenity.bdd.junit.cucumber.pages.RegisterPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class RegisterTestSteps extends ScenarioSteps {

    RegisterPage registerPage;

    @Step
    public void openHomePage(){
        registerPage.openHomePage_PO();
    }

    @Step
    public void registerUser(UserDetails userDetails){
        registerPage.registerUserDet(userDetails);
    }

    @cucumber.api.java.After
    public void closeBrowser() {
        getDriver().close();
        getDriver().quit();
    }

    @Step
    public void registerUserMobile(UserDetails ud) {
        registerPage.registerUserMobile(ud);
    }

    @Step
    public void registerAddressDet(UserDetails ud) {
        registerPage.registerAddressDet(ud);
    }

    @Step
    public void registerEmail(UserDetails ud) {
        registerPage.registerEmail(ud);
    }

    @Step
    public void registerSecurity(UserDetails ud) {
        registerPage.registerSecurity(ud);
    }

    @Step
    public void registerPin(UserDetails ud) {
        registerPage.registerPin(ud);
    }

    @Step
    public void acceptConditions() {
        registerPage.acceptConditions();
    }

    @Step
    public void enterCardDetails(UserDetails ud) {
        registerPage.enterCardDetails(ud);
    }
}
