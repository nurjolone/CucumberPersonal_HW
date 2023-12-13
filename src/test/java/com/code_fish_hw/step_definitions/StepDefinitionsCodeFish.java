package com.code_fish_hw.step_definitions;

import com.code_fish_hw.pages.CodeFishMainPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import utils.BrowserUtils;
import utils.DriverHelper;

public class StepDefinitionsCodeFish {
    WebDriver driver= DriverHelper.getDriver();
    CodeFishMainPage mainPage = new CodeFishMainPage(driver);



    @Given("user in main page click ApplyNowBtn")
    public void user_in_main_page_click_apply_now_btn(){
        mainPage.applyBtnClick(driver);



    }
    @Then("user provide first name as {string} lastName as {string}")
    public void user_provide_first_name_as_last_name_as(String firstName, String lastName) throws InterruptedException {
        Thread.sleep(300);

        mainPage.fillOutFirstAndLastName(driver,firstName,lastName);
        BrowserUtils.scrollWithByAmount(driver,200,300);

    }
    @Then("email as {string} phone as {string} and clicks ChooseYourCampBtn")
    public void email_as_phone_as_and_clicks_choose_your_camp_btn(String email, String phoneNumber)
                                                                                        throws InterruptedException {
        Thread.sleep(300);
        mainPage.fillOutEmailPhoneAndClicksChooseYourBtn(driver,email,phoneNumber);

    }
    @Then("user SelectsYourCourse as {string} and  date as {string}")
    public void user_selects_your_course_as_and_date_as(String courseType, String date) throws InterruptedException {
        Thread.sleep(300);
        mainPage.courseAndDateSelect(courseType,date);

    }
    @Then("user clicks on campusBtn and clicks referralPromoBtn")
    public void user_clicks_on_campus_btn_and_clicks_referralPromoBtn() throws InterruptedException {
        Thread.sleep(300);
        mainPage.onCampusBtnAndReferralBtn(driver);

    }
    @Then("user picks Referrals as {string} and provides code as {string} and clicks PaymentBtn")
    public void user_picks_referrals_as_and_provides_code_as_and_clicks_payment_btn(String referral,
                                                                                    String promoCode) throws InterruptedException {
        Thread.sleep(300);

        mainPage.referralSelectAndInputPromo(driver,referral,promoCode);

    }
    @Then("user selects BudgetPlan and selects StandardPlan and clicks SubmitBtn")
    public void user_selects_budget_plan_and_selects_standard_plan_and_clicks_submit_btn()
                                                                                throws InterruptedException {

        mainPage.budgetPlanBtnAndStandardBtn(driver);

    }
    @Then("user validates confirmation with {string}")
    public void user_validates_confirmation_with(String confirmationMsg) {
        mainPage.validateThankYouMsg(confirmationMsg);


    }



}