package Hooks;

import PageObjects.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends BaseClass {

    @Before
    public void beforeScenario(){
        BaseClass.launchBrowser();
    }

    @After
    public void afterScenario(){
        BaseClass.quit();
    }
}