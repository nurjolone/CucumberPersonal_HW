package com.WithDataTable_codeFish_Hw.steps;

import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class Hook_HW_DataTable {
    WebDriver driver = DriverHelper.getDriver();

    @Before
    public void setDriver(){
        driver.get(ConfigReader.readProperty("CodeFishURL"));
    }

}
