package com.WithDataTable_codeFish_Hw.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/with_data_table_hw_codeFish",
        glue = "com/WithDataTable_codeFish_Hw/steps",
        dryRun = false,
        plugin = {"pretty","html:target/uiReport.html","rerun:target/uiFailedTests.txt"}
)

public class RunnerWithDataTable {
}
