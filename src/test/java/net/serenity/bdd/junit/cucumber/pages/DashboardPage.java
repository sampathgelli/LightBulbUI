package net.serenity.bdd.junit.cucumber.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class DashboardPage extends GenericPageObject {
    @FindBy(css = ".userInfoPreferences .btn")
    public WebElementFacade linkPreferences;


}
