package co.com.automationpractice.proyecto.test.steps;

import co.com.automationpractice.proyecto.test.bc.BCGuestShop;
import co.com.automationpractice.proyecto.test.pages.HomePage;
import co.com.automationpractice.proyecto.test.utils.Constants;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ShopAsGuestStep {
    private static Logger logger = LogManager.getLogger(ShopAsGuestStep.class.getName());
    private BCGuestShop bcGuestShop = BCGuestShop.getInstance(Constants.URL, Constants.BROWSER);
    @Given("^Dubai as a place to search for tours$")
    public void dubai_as_a_place_to_search_for_tours() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logger.info("Running: Dubai as a place to search for tours");
        bcGuestShop.searchDubaiTours();
    }

    @Given("^choosing one of the tours$")
    public void choosing_one_of_the_tours() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logger.info("Running: choosing one of the tours");
        bcGuestShop.chooseOneTour();
        bcGuestShop.goToBookin();
    }

    @Then("^i can buy as a gest$")
    public void i_can_buy_as_a_gest() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
//        bcGuestShop.chooseOneTour();
        bcGuestShop.fillGuestForm();

    }
}
