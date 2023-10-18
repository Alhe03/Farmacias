package qaminds.utilis;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotHelpers {
    private static String directory="";;

    public ScreenshotHelpers(WebDriver driver){
        String currentWorkingDirectory = System.getProperty("user.dir");
        directory = String.format("%s/src/test/resources/screenshot/%s", currentWorkingDirectory, new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date()));
    }
    public String screenshot(WebDriver driver) {
        String fileName = String.format("screenshot_%s.png", new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date()));
        File dirScreenshot = new File(directory);
        if (!dirScreenshot.exists()) {
            dirScreenshot.mkdirs();
        }
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File newScreenshotFile = new File(dirScreenshot, fileName);
        try {
            Files.copy(screenshotFile.toPath(), newScreenshotFile.toPath());
        }catch (IOException e){
            throw new RuntimeException(e);
        }
        return newScreenshotFile.toURI().toString();
    }
}
