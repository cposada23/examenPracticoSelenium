package co.com.automationpractice.proyecto.test.pages;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class HomePage {
    private static Logger logger = LogManager.getLogger(HomePage.class.getName());
    @FindBy(xpath = "/html/body/div[4]/section/div[2]/div/div[2]/ul/li[3]/a[@href='#TOURS']")
    WebElement btnTours;


    @FindBy(xpath = "//input[@id='s2id_autogen11']")
    WebElement txtSearch;


    @FindAll({@FindBy (xpath= "/html/body/div[16]/ul/li[2]/ul/li/div[@class='select2-result-label']")})
    List<WebElement> listTours;

    @FindBy(xpath = "//*[@id=\"TOURS\"]/form/div[5]/button")
    WebElement btnSearch;

    public void clickOnSearch() throws Exception{
        try {
            btnSearch.click();
        }catch (Exception e) {
            String msg = "Error clicking on search ";
            logger.error(msg);
            throw new Exception(msg + e.getMessage());
        }
    }

    public void clickOnTours() throws Exception{
        try {
            btnTours.click();
        }catch (Exception e){
            String msg = "Error clicling tours";
            logger.error(msg + e.getMessage());
            throw new Exception(msg + e.getMessage());
        }
    }

    public void enterLocation(String location) throws Exception{
        boolean isLocated = false;

        try {
            txtSearch.sendKeys(location);

            for (WebElement element : listTours) {
                String locationName = element.getText();
                if(locationName.contains(location)){
                    // Click
                    isLocated = true;
                    element.click();
                    break;
                }
            }
            if(!isLocated) {
                throw new Exception("Could not found the location " + location);
            }
        }catch (Exception e){
            String msg = "Error entering location";
            logger.error(msg + e.getMessage());
            throw new Exception(msg + e.getMessage());
        }
    }
}
