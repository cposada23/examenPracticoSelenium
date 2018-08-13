package co.com.automationpractice.proyecto.test.bc;

import co.com.automationpractice.proyecto.test.pages.ConfirmPage;
import co.com.automationpractice.proyecto.test.pages.DetailPage;
import co.com.automationpractice.proyecto.test.pages.HomePage;
import co.com.automationpractice.proyecto.test.pages.ResultsPage;
import co.com.automationpractice.proyecto.test.utils.Constants;
import co.com.automationpractice.proyecto.test.utils.Utils;
import com.github.javafaker.Faker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BCRegisterUserShop {
    private static BCRegisterUserShop bcRegisterUserShop;
    private static String url;
    private WebDriver driver;
    private Utils utils;
    HomePage homePage;
    ResultsPage resultsPage;
    DetailPage detailPage;
    ConfirmPage confirmPage;
    Faker faker;
    private static Logger logger = LogManager.getLogger(BCGuestShop.class.getName());

    private BCRegisterUserShop() {
        faker = new Faker();
        utils = new Utils();
        this.driver = utils.getDriver();
    }

    public static BCRegisterUserShop getInstance(){
        if(bcRegisterUserShop == null) {
            bcRegisterUserShop = new BCRegisterUserShop();
        }
        return bcRegisterUserShop;
    }

    public void fillRegisterUserForm() throws Exception {
        logger.info("Filling the form");
        try {

            Thread.sleep(2000);
            driver.quit();
        }catch (Exception e){
            logger.error("Error filling the form as a register user " + e.getMessage());
            driver.quit();
            throw e;
        }
    }
}
