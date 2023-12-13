package com.WithDataTable_codeFish_Hw.steps;

import com.WithDataTable_codeFish_Hw.pages.MainPage_WithDataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import utils.BrowserUtils;
import utils.DriverHelper;

import java.util.Date;
import java.util.Map;

public class Step_Definitions {
    WebDriver driver = DriverHelper.getDriver();
    MainPage_WithDataTable  main = new MainPage_WithDataTable(driver);


    @Given("user in main page clicks applyNowBtn")
    public void user_in_main_page_clicks_apply_now_btn() {
        main.applyBtnClick(driver);
    }
    @Then("user provides firstName and last name")
    public void user_provides_first_name_and_last_name(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
        Map<String,String> firstAndLastName= dataTable.asMap();
        BrowserUtils.scrollWithByAmount(driver,200,300);
        main.fillOutFirstAndLastName(driver,firstAndLastName.get("firstName"),firstAndLastName.get("lastName"));

    }
    @Then("user provids email and phone number and clicks ChooseYourCampBtn")
    public void user_provids_email_and_phone_number_and_clicks_choose_your_camp_btn(io.cucumber.datatable.DataTable dataTable) {
        Map<String,String> emailAndPhoneNumber= dataTable.asMap();
        main.fillOutEmailPhoneAndClicksChooseYourBtn(driver,emailAndPhoneNumber.get("email"),
                emailAndPhoneNumber.get("phone"));
    }
    @Then("user Selects curseType and starting date")
    public void user_selects_curse_type_and_starting_date(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
        Map<String,String> curseTypeAndStartingDate= dataTable.asMap();
        main.courseAndDateSelect(curseTypeAndStartingDate.get("curseType"),
                curseTypeAndStartingDate.get("startingDate"));
    }
    @Then("user clicks on campusBtn and clicks referralPromoBtn")
    public void user_clicks_on_campus_btn_and_clicks_referral_promo_btn() {
        main.onCampusBtnAndReferralBtn(driver);

    }
    @Then("user picks Referrals as Referral and provides code as PromoCode and clicks PaymentBtn")
    public void user_picks_referrals_as_referral_and_provides_code_as_promo_code_and_clicks_payment_btn(io.cucumber.datatable.DataTable dataTable) {
        Map<String,String> refferalsAndPromoCode= dataTable.asMap();
        main.referralSelectAndInputPromo(driver,refferalsAndPromoCode.get("referral"),
                refferalsAndPromoCode.get("promoCode"));
    }
    @Then("user selects BudgetPlan and selects StandardPlan and clicks SubmitBtn")
    public void user_selects_budget_plan_and_selects_standard_plan_and_clicks_submit_btn() {
        main.budgetPlanBtnAndStandardBtn(driver);

    }
    @Then("user validates confirmation with Msg second message msg2 third msg3 forth msg4|")
    public void user_validates_confirmation_with_msg_second_message_msg2_third_msg3_forth_msg4(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
        Map<String,String> allMessagesValidations= dataTable.asMap();
        main.validateAllMesages(allMessagesValidations.get("msg"),
                allMessagesValidations.get("msg2"),allMessagesValidations.get("msg3"),
                allMessagesValidations.get("msg4"));

    }


}
