Feature: New student applies online to become CodeFish Student

    Scenario Outline: Steps to Apply online

    Given  user in main page click ApplyNowBtn
    Then user provide first name as '<FirstName>' lastName as '<LastName>'
    And email as '<Email>' phone as '<Phone>' and clicks ChooseYourCampBtn
    Then user SelectsYourCourse as '<CurseType>' and  date as '<Date>'
    And user clicks on campusBtn and clicks referralPromoBtn
   Then user picks Referrals as '<Referral>' and provides code as '<PromoCode>' and clicks PaymentBtn
    And user selects BudgetPlan and selects StandardPlan and clicks SubmitBtn
    And user validates confirmation with '<Msg>'

      Examples: test Data to apply For CodeFish
     | FirstName | LastName     | Email             | Phone      | CurseType | Date          | Referral | PromoCode | Msg        |
     | Sorry     | ForBothering | Sosorry@gmail.com | 7770070707 | 1         | December 18th | Other    | 2342445   | THANK YOU! |









