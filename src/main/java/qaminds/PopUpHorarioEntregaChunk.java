package qaminds;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PopUpHorarioEntregaChunk {
    WebDriver driver;
    public PopUpHorarioEntregaChunk(WebDriver driver){
        this.driver = driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
        wait.until(ExpectedConditions.visibilityOf(buttonClose()));
    }
    public void onClickButtonClose(){
        buttonClose().click();
    }
    private WebElement buttonClose(){
       // return driver.findElement(By.cssSelector("#fgAlertasModalContent > div > div > i"));
        return driver.findElement(By.className ("bx bx-x"));
    }

}
