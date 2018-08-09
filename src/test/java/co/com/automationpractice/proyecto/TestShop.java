package co.com.automationpractice.proyecto;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "src/main/resources/features/"
        ,glue={"co/com/automationpractice/proyecto/test/steps/"}
        ,format = {"pretty", "html:target/Destination/TestVinculacionBeneficiarios","json:target/TestVinculacionBeneficiarios.json"}
        //,plugin = {"com.cucumber.listener.ExtentCucumberFormatter:"}
        ,junit = {"--filename-compatible-names"}
)
public class TestShop {
}
