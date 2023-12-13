package com.code_fish_hw.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class CodeFishMainPage {
    public CodeFishMainPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = "button[class='apply-btn']")
    WebElement applyBtn;
    @FindBy(css = "input[name='name']")
    WebElement firstName;
    @FindBy(css = "input[name='last_name']")
    WebElement lastName;
    @FindBy(css = "input[name='email']")
    WebElement email;
    @FindBy (css = "input[name='phone']")
    WebElement phone;
    @FindBy(css = "span[class='next-btn-p']")
    WebElement chooseYourCampBtn;
    @FindBy(css = "select[name='course']")
    WebElement curseSelect;
    @FindBy(css = "select[name='startDate']")
    WebElement startedDateSelect;
    @FindBy(xpath = "//button[.='On campus']")
    WebElement onCampusBtn;
    @FindBy (xpath = "//span[.=' Referral/Promos']")
    WebElement referralBtn;
    @FindBy(css = "select[name='sourceFrom']")
    WebElement referralSelect;
    @FindBy(css = "input[name='promoCode']")
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
    WebElement thankYouMsg;


    public void applyBtnClick(WebDriver driver){
        BrowserUtils.clickOnElement(driver,this.applyBtn);

        //BrowserUtils.clickWithActions(driver,this.applyBtn);

    }
    public void fillOutFirstAndLastName(WebDriver driver,String firstName,String lastName) throws InterruptedException {
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        Thread.sleep(2000);
        BrowserUtils.scrollWithJs(driver,email);



    }
    public void fillOutEmailPhoneAndClicksChooseYourBtn(WebDriver driver,String email,String phone){
        this.email.sendKeys(email);
        this.phone.sendKeys(phone);
       // BrowserUtils.clickWithJs(driver,chooseYourCampBtn);
        BrowserUtils.clickOnElement(driver, chooseYourCampBtn);


    }
    public void courseAndDateSelect(String curseSelect,String startedDateSelect) throws InterruptedException {
        BrowserUtils.selectBy(this.curseSelect,curseSelect,"value");
        Thread.sleep(2000);

        BrowserUtils.selectBy(this.startedDateSelect,startedDateSelect,"visibleText");

    }

    public void onCampusBtnAndReferralBtn(WebDriver driver){
        BrowserUtils.scrollWithByAmount(driver,200,300);
        BrowserUtils.clickWithJs(driver,this.onCampusBtn);

       BrowserUtils.clickWithJs(driver,this.referralBtn);

    }
    public void referralSelectAndInputPromo(WebDriver driver,String referralSelect,String promoCode){
        BrowserUtils.selectBy(this.referralSelect,referralSelect,"visibleText");
        this.promoCode.sendKeys(promoCode);
        BrowserUtils.clickWithJs(driver,this.paymentBtn);



    }
    public void budgetPlanBtnAndStandardBtn(WebDriver driver) throws InterruptedException {
        BrowserUtils.clickWithJs(driver,this.budgetPlanBtn);
        Thread.sleep(1000);
        BrowserUtils.clickWithJs(driver,this.standardPlanBtn);
        Thread.sleep(1000);
        //BrowserUtils.clickWithJs(driver,this.submitBtn);
        BrowserUtils.clickWithJs(driver,this.submitBtn);

    }

    public void validateThankYouMsg(String actual){

        Assert.assertEquals(BrowserUtils.getText(thankYouMsg),actual);
    }























}
