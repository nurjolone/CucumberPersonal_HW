Feature: positive test to signUp for coming classes

  Scenario: positive test case
    Given user in main page clicks applyNowBtn
    Then user provides firstName and last name
      | firstName | Jhone |
      | lastName  | Snow  |
    And user provids email and phone number and clicks ChooseYourCampBtn
      | email | jhoneSnow@kingofthron.com |
      | phone | 7770707007                |
    Then user Selects curseType and starting date
      | curseType    | Software Development Engineer in Test |
      | startingDate | December 18th                         |
    And user clicks on campusBtn and clicks referralPromoBtn
    Then user picks Referrals as Referral and provides code as PromoCode and clicks PaymentBtn
      | referral  | Other      |
      | promoCode | 7770070707 |
    And user selects BudgetPlan and selects StandardPlan and clicks SubmitBtn
    And user validates confirmation with Msg second message msg2 third msg3 forth msg4|
        | msg  | THANK YOU!                                                                                            |
        | msg2 | A confirmation has been sent to your e-mail.                                                          |
        | msg3 | Our team will process your application and you will receive a link to sign your enrollment agreement. |
        | msg4 |If you have any questions, don’t hesitate to reach out.                                                |




