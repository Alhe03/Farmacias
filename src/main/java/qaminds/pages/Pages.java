package qaminds.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import qaminds.pages.home.HomePage;

public class Pages {
    private static <T> T PagesFactory(WebDriver driver, Class<T> clazz){
        return PageFactory.initElements(driver, clazz);
    }
    public static HomePage returnHomePage(WebDriver driver){ return PagesFactory(driver, HomePage.class);}
}
