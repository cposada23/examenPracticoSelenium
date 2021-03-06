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

public class BCSearchTours {
    private static BCSearchTours bcSearchTours;
    private static String url;
    private WebDriver driver;
    private Utils utils;
    HomePage homePage;
    ResultsPage resultsPage;
    DetailPage detailPage;
    ConfirmPage confirmPage;
    Faker faker;
    private static Logger logger = LogManager.getLogger(BCGuestShop.class.getName());

    private BCSearchTours(String url, String browser) {
        this.url = url;
        faker = new Faker();
        utils = new Utils();
        utils.openApplication(browser, url);
        this.driver = utils.getDriver();
    }

    public static BCSearchTours getInstance(String url, String browser){
        if(bcSearchTours == null) {
            bcSearchTours = new BCSearchTours(url, browser);
        }
        return bcSearchTours;
    }

    public void searchDubaiTours() throws Exception {
        try{
            homePage = PageFactory.initElements(driver, HomePage.class);
            homePage.clickOnTours();
            homePage.enterLocation(Constants.LOCATION);
            homePage.clickOnSearch();
            Thread.sleep(2000);

        } catch (Exception e) {
            logger.error("Error searching Dubai tours " + e.getMessage());
            driver.quit();
            throw e;
        }
    }

    public void chooseOneTour() throws Exception {
        logger.info("Choosinngggg oneneee  touurrrr");
        try {
            resultsPage = PageFactory.initElements(driver, ResultsPage.class);
            resultsPage.chooseOneTour();
        }catch (Exception e) {
            logger.error("Error choosing one tour " + e.getMessage());
            driver.quit();
            throw e;
        }
    }
    public void goToBookin() throws Exception {
        logger.info("Booking tour");
        try {
            detailPage = PageFactory.initElements(driver, DetailPage.class);
            detailPage.clickBookNow();
        }catch (Exception e) {
            logger.error("Error booking the tour" + e.getMessage());
            driver.quit();
            throw e;
        }
    }
}
