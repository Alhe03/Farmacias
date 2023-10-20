package qaminds.test.header;

import qaminds.pages.Pages;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import qaminds.test.BaseTest;

import java.time.Duration;

@Slf4j
public class HeaderCP extends BaseTest{

    @Test ()
    public void validateCP(){
        log.info("Step 1: Navigate to farmacias ");
        navigateTo("www.farmaciasguadalajara.com/");

        log.info("Step 2:");
        Pages.returnHomePage(getDriver()).clickButtonCP();
        Pages.returnHomePage(getDriver()).InputCP("44900");

        log.info("Step 3:");
    }
}
