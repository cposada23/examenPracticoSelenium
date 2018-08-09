package co.com.automationpractice.proyecto.test.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ResultsPage {
    private static Logger logger = LogManager.getLogger(ResultsPage.class.getName());
    @FindAll({@FindBy(xpath= "//*[@id=\"body-section\"]/div[6]/div/div[3]/div/table/tbody/tr")})
    List<WebElement> listTours;

    public void chooseOneTour() throws Exception{
        try {

            int numberIOfTours = listTours.size();
            logger.info(numberIOfTours +  " tours Found");
            if(numberIOfTours > 0) {
                int random = ThreadLocalRandom.current().nextInt(0, numberIOfTours);
                logger.info("Random tour "  + random);
                String buttonDetailsXtpath = "//*[@id=\"body-section\"]/div[6]/div/div[3]/div/table/tbody/tr["+ random +"]/td/div[3]/a/button";
                WebElement element = listTours.get(random);
                element.findElement(By.xpath("./td/div[3]/a/button")).click();

            }else {
                String msg = "No tours found ";
                logger.error(msg);
                throw new Exception(msg);
            }
            //*[@id="body-section"]/div[6]/div/div[3]/div/table/tbody/tr[1]/td/div[3]/a/button
        }catch (Exception e){
            String msg = "Error printing toursss";
            logger.error(msg + e.getMessage());
            throw new Exception(msg + e.getMessage());
        }
    }
}
