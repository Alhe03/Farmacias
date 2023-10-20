package qaminds.pages.home;


import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

@Slf4j
public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "panelLinkSelected")
    private WebElement buttonCP;

    @FindBy(id= "guestShipZoneaddress")
    private WebElement inputCP;

    @FindBy(id="contentImage_1_HeaderStoreLogo_Content")
    private WebElement laberLogo;

    public void InputCP(String cp){
        log.debug("First click on InputCP in HomePage");
        inputCP.click();

        log.debug("Write CP");
        inputCP.sendKeys(cp);
        inputCP.sendKeys(Keys.RETURN);
    }


    public void clickButtonCP(){
        wait.until(ExpectedConditions.visibilityOf(buttonCP)).click();
    }

    public boolean isVisibleMenu(){return wait.until(ExpectedConditions.visibilityOf(buttonCP)).isDisplayed();}

    public HomePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
    }
}
