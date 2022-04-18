package com.cydeo.stepDefinitions;

import com.cydeo.utilities.DB_utils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class hooks {

    @Before
    public void setup(){
        DB_utils.createConnection("jdbc:mysql://34.230.35.214:3306/library2", "library2_client",
                "6s2LQQTjBcGFfDhY");
    }





    @After
    public void tearDownScenario(Scenario scenario){

        //if the scenario fails, this method will return true boolean falue

        if(scenario.isFailed()){
            byte [] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());

        }


        DB_utils.destroy();



        Driver.closeDriver();

        //System.out.println("====Closing browser using cucumber @After");
        // System.out.println("====Scenario ended/ Take screenshot if failed!");
    }


}
