package qaminds.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import qaminds.utilis.ScreenshotHelpers;

import java.lang.reflect.Method;


@Slf4j
@Getter
@Setter

public class BaseTest {
    private WebDriver driver;
    private ScreenshotHelpers screenshotHelpers;


    @BeforeMethod
    public void beforeMethod(Method method) {
        log.debug("Entramos al BeforeTest para crear la instancia del navegador");
        try {
            WebDriverManager.chromedriver().setup();
            getDriver().manage().deleteAllCookies();
            getDriver().manage().window().maximize();
            new ScreenshotHelpers(getDriver());
        }catch (Exception ex){
            log.error("Algo paso al instanciar el navegador.", ex.getMessage());
        }
    }

    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }
    public void navigateTo(String _url) {
        String url = String.format("http://%s", _url);
        getDriver().get(url);
        if (!getDriver().getCurrentUrl().contains(_url)) {
            log.error("Error");
            throw new RuntimeException("El navegador no pudo cargar" + url);
        }
    }

}

