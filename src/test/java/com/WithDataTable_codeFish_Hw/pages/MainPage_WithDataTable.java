package com.WithDataTable_codeFish_Hw.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class MainPage_WithDataTable {
    public MainPage_WithDataTable(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//button[@class='apply-btn']//p")
    WebElement applyBtn;
    @FindBy(xpath = "//input[@name='name']")
    WebElement firstName;
    @FindBy(xpath = "//input[@name='last_name']")
    WebElement lastName;
    @FindBy(xpath = "//input[@name='email']")
    WebElement email;
    @FindBy (xpath = "//input[@name='phone']")
    WebElement phone;
    @FindBy(xpath = "//span[@class='next-btn-p']")
    WebElement chooseYourCampBtn;
    @FindBy(xpath = "//select[@name='course']")
    WebElement curseSelect;
    @FindBy(xpath = "//select[@name='startDate']")
    WebElement startedDateSelect;
    @FindBy(xpath = "//button[.='On campus']")
    WebElement onCampusBtn;
    @FindBy (xpath = "//span[.=' Referral/Promos']")
    WebElement referralBtn;
    @FindBy(xpath = "//select[@name='sourceFrom']")
    WebElement referralSelect;
    @FindBy(xpath = "//input[@name='promoCode']")
    WebElement promoCode;
    @FindBy(xpath = "//span[.=' Payment']")
    WebElement paymentBtn;
    @FindBy(xpath = "//button[.='Select']")
    WebElement budgetPlanBtn;
    @FindBy(xpath = "//button[.='Select']")
    WebElement standardPlanBtn;
    @FindBy(xpath = "//span[.=' Submit']")
    WebElement submitBtn;
    @FindBy(xpath = "//h1[.='Thank you!']")
    WebElement msg1thankYouMsg;
    @FindBy(xpath = "//p[.='A confirmation has been sent to your e-mail.']")
    WebElement msg2emailConfirmMsg;
    @FindBy(xpath = "//p[contains(.,'Our team will process your application')]")
    WebElement msg3_OTWPYA;
    @FindBy(xpath = "//p[contains(.,'If you have any questions, don’t hesitate to reach out.')]")
    WebElement msg4_IFYHAnyQuesDoNotHToReachOut;


    public void applyBtnClick(WebDriver driver) {
        BrowserUtils.clickOnElement(driver, this.applyBtn);
    }
    public void fillOutFirstAndLastName(WebDriver driver, String firstName, String lastName)  {
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        BrowserUtils.scrollWithJs(driver, email);
    }
    public void fillOutEmailPhoneAndClicksChooseYourBtn(WebDriver driver, String email, String phone) {
        this.email.sendKeys(email);
        this.phone.sendKeys(phone);

        BrowserUtils.clickOnElement(driver, chooseYourCampBtn);

    }
    public void courseAndDateSelect(WebDriver driver,String curseSelect, String startedDateSelect) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        BrowserUtils.selectBy(this.curseSelect, curseSelect, "visibleText");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        BrowserUtils.selectBy(this.startedDateSelect, startedDateSelect, "visibleText");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
    }
    public void onCampusBtnAndReferralBtn(WebDriver driver) {
        BrowserUtils.scrollWithByAmount(driver, 200, 300);
        BrowserUtils.clickWithJs(driver, this.onCampusBtn);
        BrowserUtils.clickWithJs(driver, this.referralBtn);
    }
    public void referralSelectAndInputPromo(WebDriver driver, String referralSelect, String promoCode) {
        BrowserUtils.selectBy(this.referralSelect, referralSelect, "visibleText");
        this.promoCode.sendKeys(promoCode);
        BrowserUtils.clickWithJs(driver, this.paymentBtn);
    }
    public void budgetPlanBtnAndStandardBtn(WebDriver driver) {
        BrowserUtils.clickWithJs(driver, this.budgetPlanBtn);
        BrowserUtils.clickWithActions(driver,this.standardPlanBtn);
        BrowserUtils.clickWithJs(driver,this.submitBtn);
    }
    public void validateAllMesages(WebDriver driver, String msg1, String msg2, String msg3, String msg4)  {
         driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
         Assert.assertEquals(BrowserUtils.getText(msg1thankYouMsg), msg1);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assert.assertEquals(BrowserUtils.getText(msg2emailConfirmMsg), msg2);
        Assert.assertEquals(BrowserUtils.getText(msg3_OTWPYA), msg3);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assert.assertEquals(BrowserUtils.getText(msg4_IFYHAnyQuesDoNotHToReachOut), msg4);
       if (msg4_IFYHAnyQuesDoNotHToReachOut.isDisplayed()){
           for (int i = 0; i < 10; i++) {
               System.out.println("HEY THATS WHAT'S UP !");
           }
       }
    }
}
