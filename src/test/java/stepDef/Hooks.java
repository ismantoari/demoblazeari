package stepDef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.util.Objects;

import static helper.BaseTest.quitDriver;
import static helper.BaseTest.startDriver;

public class Hooks {

    @Before
    public void beforeTest() {
        startDriver();
    }

    @After
    public void afterTest() throws InterruptedException {
        quitDriver();
    }
}