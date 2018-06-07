package net.serenity.bdd.junit.cucumber.steps;

import net.serenity.bdd.junit.cucumber.model.LoginData;
import net.serenity.bdd.junit.cucumber.model.UserDetails;
import net.serenity.bdd.junit.cucumber.pages.LoginPage;
import net.serenity.bdd.junit.cucumber.pages.RegisterPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class LoginTestSteps extends ScenarioSteps{
	
	LoginPage lp;
	RegisterPage registerPage;
	@Step
	public void openHomePage(){
		lp.openHomePage_PO();
	}

	@Step
	public void performSearch(LoginData ld) {
		lp.performSearch(ld);
	}



	public void closeBrowser() {
		getDriver().close();
    	getDriver().quit();
	}
   
}
