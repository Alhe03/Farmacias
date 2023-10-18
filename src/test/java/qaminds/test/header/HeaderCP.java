package qaminds.test.header;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import qaminds.pages.Pages;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;
import static org.assertj.core.api.Assertions.assertThat;
import qaminds.test.BaseTest;

import java.time.Duration;

@Slf4j
public class HeaderCP extends BaseTest{
    @Test ()
    public void validateCP(){
        log.info("Step 1: Navigate to farmacias ");
        navigateTo("www.farmaciasguadalajara.com/");

        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));// implemente este porque no supe implemetar el waithelper
        log.info("Step 2:");
        Pages.returnHomePage(getDriver()).clickButtonCP();
        //getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Pages.returnHomePage(getDriver()).InputCP("44900");

        log.info("Step 3:");
       // Pages.returnHomePage(getDriver()).clickButtonSearch();

        //log.info("Valida");
        //assertThat(Pages.returnListProductPage(getDriver()).isDisplayContainerResult())
        //        .as("No se encontro")
         //       .isTrue();

    }
}
