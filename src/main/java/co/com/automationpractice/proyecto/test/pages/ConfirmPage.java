package co.com.automationpractice.proyecto.test.pages;

import com.github.javafaker.Faker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ConfirmPage {
    private static Logger logger = LogManager.getLogger(ConfirmPage.class.getName());
    private Faker faker = new Faker();
    @FindBy(how = How.NAME, using = "firstname")
    WebElement txtFirstName;
    @FindBy(how = How.NAME, using = "lastname")
    WebElement txtLastName;
    @FindBy(how = How.NAME, using = "email")
    WebElement txtEmail;
    @FindBy(how = How.NAME, using = "confirmemail")
    WebElement txtConfirmEmail;

    @FindBy(how = How.NAME, using = "phone")
    WebElement txtPhone;
    @FindBy(how = How.NAME, using = "address")
    WebElement txtAddress;
    @FindBy(how = How.XPATH, using = "//*[@id=\"s2id_autogen2\"]")
    WebElement aTag;

    @FindBy(how = How.XPATH, using = "//*[@id=\"s2id_autogen1\"]/a")
    WebElement txtCountry;

    @FindBy(how = How.NAME, using = "guest")
    WebElement btnConfirm;

    public void clickConfirm() throws Exception {
        try {
            btnConfirm.click();
        }catch (Exception e) {
            throw new Exception("Error clicking on confirm " + e.getMessage());
        }
    }

    public void fillForm(String firstName, String lastName, String email, String phone, String address, String country) throws Exception{
        try {
            txtFirstName.sendKeys(firstName);
            txtLastName.sendKeys(lastName);
            txtEmail.sendKeys(email);
            txtConfirmEmail.sendKeys(email);
            txtPhone.sendKeys(phone);
            txtAddress.sendKeys(address);

            txtCountry.click();
            txtCountry.sendKeys(country);
            txtCountry.sendKeys(Keys.ENTER);

            /*LLenar los elementos de acuerdo al numero de personas*/
            for (int i = 0; i<2; i++) {
                //*[@id="bookingdetails"]/div[7]/div[2]/div/div[1]/div[1]/input
                String name = "//*[@name=\"passport[" +  (i + 1) + "][name]\"]";
                String passportnumber = "//*[@name=\"passport[" +  (i + 1) + "][passportnumber]\"]";
                String age = "//*[@name=\"passport[" +  (i + 1) + "][age]\"]";
                String guestName = "";
                String passportGuest = "";
                String guestAge = "";
                if(i == 0) {
                    guestName = firstName + " " + lastName;
                }else {
                    guestName = faker.name().fullName();
                }
                passportGuest = String.valueOf(faker.number().numberBetween(10000000, 9899999));
                guestAge = String.valueOf(faker.number().numberBetween(18 , 99));
                txtCountry.findElement(By.xpath(name)).sendKeys(guestName);
                txtCountry.findElement(By.xpath(passportnumber)).sendKeys(passportGuest);
                txtCountry.findElement(By.xpath(age)).sendKeys(guestAge);
            }

        }catch (Exception e) {
            String msg = "Error filling the form ";
            logger.error(msg);
            throw new Exception(msg + e.getMessage());
        }
    }


}
