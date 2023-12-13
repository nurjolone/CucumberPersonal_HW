package utils;

import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class BrowserUtils {

    public static void selectBy (WebElement element,String value , String methodName) {
        Select select = new Select(element);
        switch (methodName){
            case "visibleText":
                select.selectByVisibleText(value);
                break;
            case "value":
                select.selectByValue(value);
                break;
            case "index":
                select.selectByIndex(Integer.parseInt(value));
                break;
            default:
                System.out.println("Method name is not available ,please use visibleText ,value or Index");

        }
    }
    public static List<WebElement> getAllOptionsSelect(WebElement element){
        Select select = new Select(element);
        List<WebElement> options = select.getOptions();
        return options;
    }
    public static void getURL(WebDriver driver,String url){
        driver.get(ConfigReader.readProperty(url));
    }

    public static String getText(WebDriver driver, WebElement element){
        new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.
                and(ExpectedConditions.visibilityOf(element),ExpectedConditions.textToBePresentInElement(element,"")));


        return element.getText().trim();
    }
    public static String getText(WebElement element){
        return element.getText().trim();
    }
    public static String getTitle(WebDriver driver){
        return driver.getTitle();
    }


    public static void switchDriverByID (WebDriver driver,String currentPageID){
        Set<String> windowHandles = driver.getWindowHandles();
        for (String id : windowHandles){
            driver.switchTo().window(id);
        }
    }
    public static void  getScreenshot(WebDriver driver){
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String location = System.getProperty("user.dir") + "/src/main/screenshots/";
        File directory = new File(location);
        if(!directory.exists()){
            directory.mkdir();
        }
        try {
            FileUtils.copyFile(file,new File(location + System.currentTimeMillis() + ".png"));
        }catch (IOException e){
            throw  new RuntimeException();
        }
    }
    public static void  clickOnElement (WebDriver driver,WebElement element){
        new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(element));
        element.click();

    }
    public static  String  getTitleWithJs(WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return  js.executeScript("return document.title").toString();
    }

    public static  void clickWithJs(WebDriver driver,WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()",element);
    }
    public static void scrollWithJs(WebDriver driver,WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", element);
    }

    public static void switchWindowByTitle (WebDriver driver,String title ){
        Set<String> windowHandles = driver.getWindowHandles();

        for (String id : windowHandles){
            driver.switchTo().window(id);

            if(driver.getTitle().contains(title)){
                break;
            }
        }
    }

    public static void acceptAlert(WebDriver driver){
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    public static String getTextAlert (WebDriver driver){
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }


    public static void dismissAlert(WebDriver driver){
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }
    public static void sendKeysAlert(WebDriver driver,String keys){
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(keys);
    }
    //These methos below are overloaded
    public static void switchToIframe (WebDriver driver, String nameOrId){
        driver.switchTo().frame(nameOrId);
    }
    public static void switchToIframe(WebDriver driver,WebElement element){
        driver.switchTo().frame(element);
    }
    public static void switchToParentFrameOrDefault(WebDriver driver, String frame){
        switch (frame){
            case"parent":
                driver.switchTo().parentFrame();
                break;
            case "default":
                driver.switchTo().defaultContent();
            default:
                System.out.println("Please use proper name conventions for iframes switches");
        }

    }
    public static void scrollWithPoint(WebDriver driver,WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Point point = element.getLocation();
        int xCoordinate = point.getX();
        int yCoordinate= point.getY();
        js.executeScript("window.scrollTo(" + xCoordinate + "," + yCoordinate + ")");

    }
    public static void scrollWithByAmount(WebDriver driver, int x, int y){
        Actions actions = new Actions(driver);
        actions.scrollByAmount(x,y).build().perform();
    }

    public static void dragAndDrop(WebDriver driver, WebElement source, WebElement target){
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source,target).build().perform();

    }
    public static void clickWithActions (WebDriver driver, WebElement element){
        Actions actions =new Actions(driver);
        actions.click(element).build().perform();
    }
    public static void hoverOver(WebDriver driver,WebElement target){
        Actions actions = new Actions(driver);
        actions.moveToElement(target).build().perform();
    }

    public static void takeScreenshotCucumber(Scenario scenario, WebDriver driver){
        Date curentDate = new Date();
        String screenshotFileName= curentDate.toString().replace(":","-");
        if (scenario.isFailed()){
            File screenShotFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(screenShotFile,new File("src/test/java/screenshots"+screenShotFile +
                        ".png"));
            }catch (IOException e){
                throw  new RuntimeException(e);
            }

        }
    }





}
