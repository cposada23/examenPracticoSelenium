package co.com.automationpractice.proyecto.test.steps;

import co.com.automationpractice.proyecto.test.bc.BCRegisterUserShop;
import co.com.automationpractice.proyecto.test.bc.BCSearchTours;
import co.com.automationpractice.proyecto.test.utils.Constants;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ShopAsRegisterUserSteps {
    private static Logger logger = LogManager.getLogger(ShopAsGuestStep.class.getName());
    private BCSearchTours bcSearchTours = BCSearchTours.getInstance(Constants.URL, Constants.BROWSER);
    private BCRegisterUserShop bcRegisterUserShop = BCRegisterUserShop.getInstance();
    @Given("^without the need to be login i can search for tours in Dubai$")

    public void without_the_need_to_be_login_i_can_search_for_tours_in_Dubai() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logger.info("Running: Dubai as a place to search for tours");
        bcSearchTours.searchDubaiTours();
    }

    @Given("^choosing one of the tours from the list$")
    public void choosing_one_of_the_tours_from_the_list() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logger.info("Running: choosing one of the tours");
        bcSearchTours.chooseOneTour();
        bcSearchTours.goToBookin();
    }

    @Then("^i can buy as a register user$")
    public void i_can_buy_as_a_register_user() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
