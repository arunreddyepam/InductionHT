package org.example.hooks;

import org.example.context.TestContextNew;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    private final TestContextNew context;

    public Hooks(TestContextNew context) {
        this.context = context;
    }

    @Before
    public void beforeScenario(Scenario scenario) {
        System.out.println(">> Starting Scenario: " + scenario.getName());
    }

    @After
    public void afterScenario(Scenario scenario) {
        System.out.println(">> Finished Scenario: " + scenario.getName()
                + " | Status: " + scenario.getStatus());
        context.quitDriver();
    }
}
