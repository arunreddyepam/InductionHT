package org.example.StepDefinitions;

import org.example.BDD.Account;
import org.example.BDD.BankAccount;
import org.example.BDD.CashDispenser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.testng.AssertJUnit.assertEquals;

public class BDDTask1StepDefs {
    private Account account;
    private CashDispenser dispenser;

    @Given("I have a balance of ${int} in my account")
    public void i_have_a_balance_of_$_in_my_account(Integer balance) {
        account = new BankAccount(balance);
        dispenser = new CashDispenser();
    }
    @When("I request ${int}")
    public void i_request_$(Integer amount) {
        account.withdraw(amount);
        dispenser.dispense(amount);
    }
    @Then("${int} should be dispensed")
    public void $_should_be_dispensed(Integer expectedAmount) {
        assertEquals(expectedAmount.intValue(), dispenser.getDispensedAmount());

    }
}
