package net.serenity.bdd.junit.cucumber;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features", plugin = {
		"pretty", "html:target/cucumber", "json:target/json/cucumber.json" }, tags = { "@Smoke","@prod" }    )
public class Runner {

}
