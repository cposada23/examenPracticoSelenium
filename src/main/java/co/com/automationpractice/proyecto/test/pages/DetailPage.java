package co.com.automationpractice.proyecto.test.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DetailPage {
    private static Logger logger = LogManager.getLogger(DetailPage.class.getName());
    @FindBy(how = How.XPATH, using = "//*[@id=\"body-section\"]/div[3]/div[2]/div[2]/div/form/div[4]/button")
    WebElement btnBookNow;

    public void clickBookNow() throws Exception{
        try {
            btnBookNow.click();
        }catch (Exception e) {
            String msg = "Error clicking on search ";
            logger.error(msg);
            throw new Exception(msg + e.getMessage());
        }
    }


}
