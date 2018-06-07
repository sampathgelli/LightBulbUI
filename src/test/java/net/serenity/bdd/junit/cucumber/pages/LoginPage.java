package net.serenity.bdd.junit.cucumber.pages;


import net.serenity.bdd.junit.cucumber.model.LoginData;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebElement;
import java.util.List;

public class LoginPage extends GenericPageObject{

    @FindBy(id = "form-username")
    public WebElementFacade txtUserName;

    @FindBy(id = "form-password")
    public WebElementFacade txtPassword;

    @FindBy(css = ".userInfoPreferences .btn.btn-default")
    public WebElementFacade linkPreferences;

    @FindBy(css = ".btn.btn-default--blue")
    public WebElementFacade btnLogin;

    @FindBy(xpath = "//label[contains(text(),'All Australia Systems')]")
    public WebElementFacade chkboxAllAustraliaSystems;

    @FindBy(css = ".optionContainer .toggleBtn")
    public WebElementFacade toggleLocation;


    @FindBy(xpath = "//a[text()='Dashboard']")
    public WebElementFacade tabDashboard;

    @FindBy(xpath = "//div[@style='display: block;']//td[text()='Transactive Trans-Tasman - Australia']")
    public WebElementFacade transTasmanAUChannel;

    @FindBy(css = ".Grid-container .grid-main .Grid-header-content")
    public WebElementFacade gridTransactionList;

    @FindBy(css=".Grid-container .grid-main .Grid-header-content .grid-header-cell .grid-header-text")
    public WebElementFacade gridTransactionHeaderList;


    //".Grid-container .grid-main .Grid-header-content .grid-header-cell .grid-header-text"

    //td[@class='sc-bGbJRg cUyooZ'][text()='Transactive Trans-Tasman - Australia']

	public void openHomePage_PO(){
		open();
	}

    public void performSearch(LoginData dp){
		System.out.println("Logging in using:"+  dp.toString());
        txtUserName.clear();
        txtUserName.type(dp.getStrUserName());
        txtPassword.clear();
        txtPassword.type(dp.getStrPassword());
        btnLogin.click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        btnLogin.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //waitFor(linkPreferences);
        waitForTextToAppear("Refresh");
        linkPreferences.click();
        waitFor(toggleLocation);
        waitForTextToAppear("All Australia Systems");
        waitFor(chkboxAllAustraliaSystems);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        chkboxAllAustraliaSystems.click();
        //tabDashboard.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tabDashboard.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        transTasmanAUChannel.click();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("****************************************************************************************************************************");

            //System.out.println(gridTransactionList.fi(org.openqa.selenium.By.tagName("div")).size());
        System.out.println(gridTransactionList.thenFindAll(org.openqa.selenium.By.cssSelector(".grid-header-cell .grid-header-text")).size());
        //List<WebElement> results =gridTransactionList.thenFindAll(org.openqa.selenium.By.cssSelector(".grid-header-cell .grid-header-text"));
        List<WebElement> results =gridTransactionList.findElements(org.openqa.selenium.By.cssSelector(".grid-header-cell .grid-header-text"));
        System.out.println("Tesr ........... "+results.get(8).getText());
        //System.out.println(results.get(3).toString());
        int columnNumber=0;
        for(int i=0;i<results.size();i++) {

            withAction().moveToElement(results.get(i)).perform();
            System.out.println(results.get(i).getText());
            if(results.get(i).getText().equalsIgnoreCase("Channel GUID"))
                columnNumber=i;
        }
        //for(int i=0;i<=gridTransactionList.thenFindAll(org.openqa.selenium.By.cssSelector(".grid-header-cell .grid-header-text")).size();i++)
            //System.out.println("The Text is :: "+gridTransactionList.thenFindAll(org.openqa.selenium.By.cssSelector(".grid-header-cell .grid-header-text")).get(i).getText());
        System.out.println(getDriver().findElements(org.openqa.selenium.By.cssSelector(".Grid-container .grid-main .Grid-header-content .grid-header-cell .grid-header-text")).size());
        //System.out.println(gridTransactionHeaderList.fi);
            //log("The grid is :: "+gridTransactionList.thenFindAll(org.openqa.selenium.By.tagName("div")).size());
        System.out.println("****************************************************************************************************************************");
        //public void
	}


    public void log(String description, String... remarks) {
        System.out.println("\n+Description: " + description + " | Remarks: " + remarks.toString());
        String html =
                "<h4 style=\"font-style:italic;color:black\">" + description + "</h4>" +
                        "<div><p>Remarks:</p>" +
                        "<ul style=\"margin-left:5%; font-weight:200; color:#434343; font-size:10px;\">";

        for (String li : remarks) html += "<li>" + li + "</li>";

        html += "<ul></div>";

        description(html);
    }

   /* And a dummy step to be added into the Report*/
    @Step
    public void description(String htmlString) {
        System.out.println("\n");
    }

}
